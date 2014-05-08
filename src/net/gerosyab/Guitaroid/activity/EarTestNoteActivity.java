package net.gerosyab.Guitaroid.activity;

import java.util.Random;

import net.gerosyab.Guitaroid.R;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EarTestNoteActivity extends SuperActivity {
	private static final int WHEEL_VISIBLE_ITEM_NUM = 4;
	TextView earTestText;
	Button soundBtn, tryBtn, newTestBtn, replayBtn;
	WheelView rootWheel, extWheel;
	
	Context context;
	private SoundPool soundPool;
	public static int [] rawResIds = {0, 0};
	
	boolean isScroll;
	
	public static final String [] NOTE = {"C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B"};
	public static final int[] NOTE_RESOURCE_TABLE = {
		R.raw.acoustic_5_3, R.raw.acoustic_5_4, R.raw.acoustic_4_0, R.raw.acoustic_4_1, R.raw.acoustic_4_2, R.raw.acoustic_4_3,
		R.raw.acoustic_4_4, R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3, R.raw.acoustic_2_0,
		R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4, R.raw.acoustic_1_0, R.raw.acoustic_1_1,
		R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4, R.raw.acoustic_1_5, R.raw.acoustic_1_6, R.raw.acoustic_1_7,
		R.raw.acoustic_1_8
	};
	
	Random random;
	
	int note_num;
	
	String noteStr, resultStr;
	
	Toast toast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ear_test_note);
		
		context = this;
		
		random = new Random(System.currentTimeMillis());
		
		soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		
		rawResIds[1] = soundPool.load(context, NOTE_RESOURCE_TABLE[12], 1);
		
//		toast = toast.makeText(context, "", Toast.LENGTH_SHORT);
		
		//Generate Test
//		note_num = random.nextInt(12);
		note_num = random.nextInt(NOTE_RESOURCE_TABLE.length);
//		resultStr = NOTE[note_num];
		resultStr = NOTE[note_num % 12];

//		rawResIds[0] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[1][3 + note_num], 1);
		rawResIds[0] = soundPool.load(context, NOTE_RESOURCE_TABLE[note_num], 1);
		
		isScroll = false;
		
		earTestText = (TextView)findViewById(R.id.ear_test_note_text);
		soundBtn = (Button)findViewById(R.id.ear_test_note_soundButton);
		replayBtn = (Button)findViewById(R.id.ear_test_note_replayButton);
		tryBtn = (Button)findViewById(R.id.ear_test_note_TryBtn);
		newTestBtn = (Button)findViewById(R.id.ear_test_note_NewTestBtn);
		
		soundBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundPool.play(rawResIds[1], 1, 1, 0, 0, 1);
			}
		});
		
		replayBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				soundPool.play(rawResIds[0], 1, 1, 0, 0, 1);
				replayBtn.setText("Click to Replay");
			}
		});
		
		tryBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isScroll){
					if((noteStr).equals(resultStr)){
						sendToastMessage("Correct!!");
						earTestText.setText(resultStr);
					}
					else{
						sendToastMessage(noteStr + "\nWrong!! Try again!!");
					}
				}
			}

		});
		
		newTestBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				replayBtn.setText("Hear the Sound : ?");
				earTestText.setText(" ? ");
				
//				note_num = random.nextInt(12);
				note_num = random.nextInt(NOTE_RESOURCE_TABLE.length);
//				resultStr = NOTE[note_num];
				resultStr = NOTE[note_num % 12];

//				rawResIds[0] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[1][3 + note_num], 1);
				rawResIds[0] = soundPool.load(context, NOTE_RESOURCE_TABLE[note_num], 1);
				
				isScroll = false;
			}
		});
		
		
		rootWheel = (WheelView)findViewById(R.id.ear_test_note_rootWheel);
		
		rootWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		
		rootWheel.setViewAdapter(new RootAdapter(context));
		
		rootWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					noteStr = NOTE[rootWheel.getCurrentItem()];
				}
			}
		});
		
		rootWheel.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				isScroll = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				isScroll = false;
				noteStr = NOTE[rootWheel.getCurrentItem()];
			}
		});
		
		rootWheel.setCurrentItem(0);
		
		//�ʱⰪ root, ext, var ��� ù��° ������ �� �ʱ�ȭ
		noteStr = NOTE[0];
	}
	
	
	@Override
	protected void onPause() {
		if(soundPool != null){
			soundPool.release();
			soundPool = null;
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if(soundPool == null){
			soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
			
			rawResIds[1] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[1][3], 1);
			
			if(resultStr != null){
				rawResIds[0] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[1][3 + note_num], 1);
			}
		}
		super.onResume();
	}
	

	//Adaptor for root
	private class RootAdapter extends AbstractWheelTextAdapter{
		protected RootAdapter(Context context) {
			super(context, R.layout.root_name, NO_RESOURCE);
			setItemTextResource(R.id.rootWheel_rootName);
		}

		@Override
		public View getItem(int index, View convertView, ViewGroup parent) {
			return super.getItem(index, convertView, parent);
		}
		@Override
		public int getItemsCount() {
			return NOTE.length;
		}
		@Override
		protected CharSequence getItemText(int index) {
			return NOTE[index];
		}
	}
}


