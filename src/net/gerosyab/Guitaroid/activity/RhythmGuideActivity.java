package net.gerosyab.Guitaroid.activity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import net.gerosyab.Guitaroid.R;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class RhythmGuideActivity extends Activity {
	public static final String DEBUG_TAG = "RhythmGuide";
	public static final String OUTPUT_FILE_NAME = "midi_output.mid";
	public static final int BUFFER_SIZE	= 1024 * 50;
	private static final int MAX_BPM = 200;
	public static final int STATUS_STOP = 0;
	public static final int STATUS_PLAY = 1;
	
	public static final int CHILD_STATUS_STOPPED_COLOR = Color.rgb(242, 63, 0);
	public static final int CHILD_STATUS_PLAYED_COLOR = Color.rgb(50, 208, 0);
	
	
    private final String[] groups = {
    		"6/8 Slow Shuffle", "Funk", "Jazz" ,
    		"Metal", "Pop", "Rock", "Swing" };
   
    private final String[][] children = {
            {"6/8 Slow Shuffle 1", "6/8 Slow Shuffle 2", "6/8 Slow Shuffle 3", "6/8 Slow Shuffle 4", "6/8 Slow Shuffle 5"},	//6/8 Slow Shuffle
            {"Funk 1", "Funk 2", "Funk 3", "Funk 4", "Funk 5", "Funk 6", "Funk 7"},	//Funk
            {"Jazz 1", "Jazz 2"},
            {"Metal 1", "Metal 2", "Metal 3"},
            {"Pop 1", "Pop 2", "Pop 3", "Pop 4"},	
            {"Rock 1", "Rock 2", "Rock 3", "Rock 4", "Rock 5", "Rock 6", "Rock 7", "Rock 8"},
            {"Swing 1", "Swing 2"}
    };

   
    private int [][] resource = {
    		{R.raw.b6_8_slow_shuffle_1, R.raw.b6_8_slow_shuffle_2, R.raw.b6_8_slow_shuffle_3, R.raw.b6_8_slow_shuffle_4, R.raw.b6_8_slow_shuffle_5}, 
    		{R.raw.funk_1, R.raw.funk_2, R.raw.funk_3, R.raw.funk_4, R.raw.funk_5, R.raw.funk_6, R.raw.funk_7},
    		{R.raw.jazz_1, R.raw.jazz_2},
    		{R.raw.metal_1, R.raw.metal_2, R.raw.metal_3},
    		{R.raw.pop_1, R.raw.pop_2, R.raw.pop_3, R.raw.pop_4},
    		{R.raw.rock_1, R.raw.rock_2, R.raw.rock_3, R.raw.rock_4, R.raw.rock_5, R.raw.rock_6, R.raw.rock_7, R.raw.rock_8},
    		{R.raw.swing_1, R.raw.swing_2},
    };
    
    private int [][] statuses = {
    		{STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP, STATUS_STOP},
    		{STATUS_STOP, STATUS_STOP},
    };
    
	WheelView wheel;
	boolean wheelScrolled;
	Context context;
	Button tapTempoBtn;
	int bpm;
	boolean isTapClicked;
	boolean isPlaying;
	long tapStartTime, tapEndTime;
	MediaPlayer mediaPlayer;
	int currentAudioSessionId;
	boolean bpmChanged;
	
	int lastClickedGroupPostion = -1, lastClickedChildPostion = -1;
	ImageView lastPlayedChildStatusImage;
	
	LayoutInflater inflater;
	ExpandableListAdapter mAdapter;
	ExpandableListView list;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rhythmguide);
		
		this.context = this;
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		bpm = 120;
		bpmChanged = false;
		isTapClicked = isPlaying = false;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		list = (ExpandableListView)findViewById(R.id.rhythmGuide_expandableListView);
		mAdapter = new CustomExpandableListAdapter();
		
		list.setAdapter(mAdapter);
		
		list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//				lastPlayedChildStatusImage = (ImageView)v.findViewById(R.id.rhythmGuide_childStatusImage);
				//어떤 차일드 아이템이 클릭되었는지 확인
				if(groupPosition == lastClickedGroupPostion && childPosition == lastClickedChildPostion){
//					lastPlayedChildStatusImage = (ImageView)v.findViewById(R.id.rhythmGuide_childStatusImage);
					if(mediaPlayer != null){
						if(mediaPlayer.isPlaying()){
							mediaPlayer.stop();
							mediaPlayer.release();
							mediaPlayer = null;
							statuses[groupPosition][childPosition] = STATUS_STOP;
							lastPlayedChildStatusImage.setImageResource(R.drawable.stop);
						}
					}
					else{
						if(bpmChanged){
							try {
								modifiedMidiFileGenerator(resource[groupPosition][childPosition]);
							} catch (IOException e) {
								e.getStackTrace();
							}
							bpmChanged = false;
						}
						mediaPlayer = MediaPlayer.create(context, Uri.parse("file://" + context.getFilesDir() + "/" + OUTPUT_FILE_NAME));
						mediaPlayer.setLooping(true);
						mediaPlayer.start();
						statuses[groupPosition][childPosition] = STATUS_PLAY;
						lastPlayedChildStatusImage = (ImageView)v.findViewById(R.id.rhythmGuide_childStatusImage);
						lastPlayedChildStatusImage.setImageResource(R.drawable.play);
					}
				}
				//이전 클릭된 곳과 다르거나 새로 클릭 된경우
				else{
					if(mediaPlayer != null){
						if(mediaPlayer.isPlaying()){
							mediaPlayer.stop();
						}
						mediaPlayer.release();
						mediaPlayer = null;
					}
					
					//맨처음 선택 아니면
					if(lastClickedGroupPostion != -1 && lastClickedChildPostion != -1){
						statuses[lastClickedGroupPostion][lastClickedChildPostion] = STATUS_STOP;
						lastPlayedChildStatusImage.setImageResource(R.drawable.stop);
					}
					
					lastClickedGroupPostion = groupPosition;
					lastClickedChildPostion = childPosition;
					
					try {
						if(modifiedMidiFileGenerator(resource[groupPosition][childPosition])){
							mediaPlayer = MediaPlayer.create(context, Uri.parse("file://" + context.getFilesDir() + "/" + OUTPUT_FILE_NAME));
							mediaPlayer.setLooping(true);
						}
					} catch (IOException e) {
						e.getStackTrace();
					}
					if(bpmChanged){
						bpmChanged = false;
					}
					mediaPlayer.start();
					statuses[groupPosition][childPosition] = STATUS_PLAY;
					lastPlayedChildStatusImage = (ImageView)v.findViewById(R.id.rhythmGuide_childStatusImage);
					lastPlayedChildStatusImage.setImageResource(R.drawable.play);
				}
				return true;
			}
		});
		
		list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
			@Override
			public void onGroupExpand(int groupPosition) {
				//재생 중 다른 카테고리 클릭, 확장시
				//기존 플레이중인 리스트 아이템에 대한 처리 필요
				//임시로 따로 저장해놓고 다시 원래 카테고리 눌렀을때는 복원 필요
				
				int len = mAdapter.getGroupCount();
				for(int i = 0; i < len; i++){
					if(i != groupPosition){
						list.collapseGroup(i);
					}
				}
			}
		});
		
        wheel = (WheelView)findViewById(R.id.rhythmGuide_bpmWheel);
        wheel.setViewAdapter(new NumericWheelAdapter(context, 1, MAX_BPM));
        wheel.setVisibleItems(5);
        wheel.setCurrentItem(bpm - 1);
        
        wheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
	            if (!wheelScrolled) {
	                bpm = wheel.getCurrentItem() + 1;
	                bpmChnaged();
	            }
			}
		});
        
        wheel.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				wheelScrolled = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				wheelScrolled = false;
				bpm = wheel.getCurrentItem() + 1;
				bpmChnaged();
			}
		});
		
		tapTempoBtn = (Button)findViewById(R.id.rhythmGuide_tapTempoBtn);
		tapTempoBtn.setText("Tap Tempo");
		tapTempoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isTapClicked){
					tapStartTime = SystemClock.uptimeMillis();
					isTapClicked = true;
					tapTempoBtn.setText("Tap once again!!");
				}
				else{
					tapEndTime = SystemClock.uptimeMillis();
					isTapClicked = false;
					tapTempoBtn.setText("Tap Tempo");
					bpm = Math.round(60000 / (tapEndTime - tapStartTime));
					if(bpm > MAX_BPM){
						bpm = MAX_BPM;
					}
					else if(bpm < 1){
						bpm = 1;
					}
					bpmChnaged();
					//bpm 254 인데 wheel은 255? 나중에 체크
					wheel.setCurrentItem(bpm - 1);
				}
			}
		});

	}
	
	@Override
	protected void onPause() {
		if(mediaPlayer != null){
			mediaPlayer.release();
			mediaPlayer = null;
		}
		
		if(lastClickedGroupPostion != -1 && lastClickedChildPostion != -1){
			statuses[lastClickedGroupPostion][lastClickedChildPostion] = STATUS_STOP;
			lastPlayedChildStatusImage.setImageResource(R.drawable.stop);
//			lastClickedGroupPostion = -1;
//			lastClickedChildPostion = -1;
		}
		
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	private void bpmChnaged(){
		if(mediaPlayer != null && mediaPlayer.isPlaying()){
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
			try {
				if(modifiedMidiFileGenerator(resource[lastClickedGroupPostion][lastClickedChildPostion])){
					mediaPlayer = MediaPlayer.create(context, Uri.parse("file://" + context.getFilesDir() + "/" + OUTPUT_FILE_NAME));
				}
			} catch (IllegalArgumentException e) {
				e.getStackTrace();
			} catch (SecurityException e) {
				e.getStackTrace();
			} catch (IllegalStateException e) {
				e.getStackTrace();
			} catch (IOException e) {
				e.getStackTrace();
			}
			mediaPlayer.setLooping(true);
			mediaPlayer.start();
		}
		else{
			bpmChanged = true;
		}

	}
	
	//BUFFER_SIZE 만큼 딱 읽어옴
	//어차피 미디파일 사이즈 크지도 않고
	//다 로컬에 저장되있는거고 변경될일도 없으니깐
	//여기서 템포만 바꾸어 미리 지정된 이름으로 지정된 곳에 파일 출력하고
	//미디어 플레이어에서 재생시에는 무조건 그 파일만 읽어들여 재생
	//bpm 변경되든, 리듬패턴용 음원이 변경되는 무조건 새로 출력되도록 처리!!
	private synchronized boolean modifiedMidiFileGenerator(int resId) throws IOException{
		InputStream is = this.getResources().openRawResource(resId);
		BufferedInputStream in = new BufferedInputStream(is);

		boolean tempoModifiedFlag = false;
		byte[] buffer = new byte[BUFFER_SIZE];
		int readByte = in.read(buffer);
		in.close();
		int threshold = readByte - 6;
		if(readByte == -1){
			return false;
		}

		int modTempo = 60000000 / bpm;

		byte b1, b2, b3;
		b1 = (byte) (modTempo / 0x10000);
		b2 = (byte) ((modTempo % 0x10000) / 0x100);
		b3 = (byte) (modTempo % 0x100);
		
		for(int index = 0; index < threshold; index++){
			if(buffer[index] == (byte)0x00){
				if(buffer[index + 1] == (byte)0xff && buffer[index + 2] == (byte)0x51 && buffer[index + 3] == (byte)0x03){
					buffer[index + 4] = b1;
					buffer[index + 5] = b2;
					buffer[index + 6] = b3;
					tempoModifiedFlag = true;
					break;
				}
			}
		}
		context.deleteFile(OUTPUT_FILE_NAME);
		FileOutputStream os = context.openFileOutput(OUTPUT_FILE_NAME, Context.MODE_WORLD_READABLE);
		BufferedOutputStream out = new BufferedOutputStream(os);
		
		out.write(buffer, 0, readByte);
		out.close();
		
		if(tempoModifiedFlag){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static String getHexString(byte b) {
		  String result = "";
		  result += Integer.toString( ( b & 0xff ) + 0x100, 16).substring( 1 );
		  return result;
	}
	
	private class CustomExpandableListAdapter extends BaseExpandableListAdapter{

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.rhythmguide_child,	null);
			}
			
			TextView child = (TextView) convertView.findViewById(R.id.rhythmGuide_childText);
			child.setText(children[groupPosition][childPosition]);
			ImageView status = (ImageView) convertView.findViewById(R.id.rhythmGuide_childStatusImage);
			if(statuses[groupPosition][childPosition] == STATUS_STOP){
				status.setImageResource(R.drawable.stop);
			}
			else if(statuses[groupPosition][childPosition] == STATUS_PLAY){
				status.setImageResource(R.drawable.play);
			}
//			if(status == nowPlayingChildStatusText)
//			ImageView favorite = (ImageView) convertView.findViewById(R.id.rhythmGuide_childFavoriteImg);
//			favorite.setOnTouchListener(new View.OnTouchListener() {
//				
//				@Override
//				public boolean onTouch(View v, MotionEvent event) {
//					Toast.makeText(context, "getChildView favorite OnTouchListener", Toast.LENGTH_SHORT).show();
//					//즐겨찾기 부분 작성 필요
//					//ACTION_DOWN 일때 이미지 누름효과용으로 교체
//					//ACTION_UP일때는 원래 이미지가 disable 인지 able 인지 따라 즐겨찾기 테이블에 추가 혹은 삭제
//					//리스트의 즐겨찾기부분도 업데이트, notifychanged 호출
//					switch(event.getAction()){
//					case MotionEvent.ACTION_DOWN:
//						
//						break;
//					case MotionEvent.ACTION_UP:
//						
//						break;
//					}
//					
//					return true;
//				}
//			});
			return convertView;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return children[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		@Override
		public int getGroupCount() {
			return groups.length;
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,	View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.rhythmguide_group,	null);
			}
			
			TextView group = (TextView) convertView.findViewById(R.id.rhythmGuide_groupText);
			group.setText(groups[groupPosition]);
			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
		
	}
}
