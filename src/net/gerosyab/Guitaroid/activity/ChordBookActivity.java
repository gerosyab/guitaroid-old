package net.gerosyab.Guitaroid.activity;

import java.util.ArrayList;
import java.util.HashMap;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import kankan.wheel.widget.adapters.NumericWheelAdapter;
import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.ChordData;
import net.gerosyab.Guitaroid.data.ChordData.Chord;
import net.gerosyab.Guitaroid.util.ChordView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ChordBookActivity extends Activity {
	private final String PREFERENCE_NAME = "ChordBookActivity";
	
	private static final int WHEEL_VISIBLE_ITEM_NUM = 4;

	TextView chordText;
	
	WheelView rootWheel, extWheel, varWheel;
	HashMap<String, ArrayList<Chord>> hashMap;
	ArrayList<Chord> array;	
	static String[] extStrArr;
	static String rootStr;
	static String extStr;
	static int varIdx;
	boolean isScroll;
	boolean [] mute = new boolean[6];
	boolean loading = false;
	boolean isDialogDismiss;
	
	Button btn;
	ChordView chordView;
	SoundThread thread;
	
	Context context;
	private SoundPool soundPool;
	public static int [] rawResIds = {0, 0, 0, 0, 0, 0};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chord_book);
		
		context = this;
		
		readPreference();
		//Dialog Starts
		if(!isDialogDismiss){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("You can hear the chord sound by touch the Chord Diagram")
			       .setCancelable(false)
			       .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                isDialogDismiss = true;
			                writePreference();
			                dialog.cancel();
			           }
			       })
			       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			AlertDialog alert = builder.create();
			alert.setTitle("Tip");
			alert.show();
			
		}
		//Dialog Ends
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
		
		soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
			
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				loading = false;
			}
		});
		
//		btn = (Button)findViewById(R.id.chordBook_soundButton);
//		btn.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				if(thread == null){
//					thread = new SoundThread();
//					thread.start();
//					thread = null;	//요거 필요할까?
//				}
//			}
//		});
		
		chordView = (ChordView)findViewById(R.id.chordBook_chordView);
		chordView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(thread == null){
					thread = new SoundThread();
					thread.start();
					thread = null;	//요거 필요할까?
				}
			}
		});
		
		isScroll = false;
		
		rootWheel = (WheelView)findViewById(R.id.chordBook_rootWheel);
		extWheel = (WheelView)findViewById(R.id.chordBook_extWheel);
		varWheel = (WheelView)findViewById(R.id.chordBook_varsWheel);
		
		chordText = (TextView)findViewById(R.id.chordBook_chordText);
		
		chordView = (ChordView)findViewById(R.id.chordBook_chordView);
		
		rootWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		extWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		varWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		
		rootWheel.setViewAdapter(new RootAdapter(this));
		extWheel.setViewAdapter(new ExtAdapter(this));
		
		rootWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					updateExts(extWheel, ChordData.EXTENSION, newValue);
					updateVars(varWheel, 0);
					updateChord(varWheel, 0);
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
				updateExts(extWheel, ChordData.EXTENSION, rootWheel.getCurrentItem());
				updateVars(varWheel, 0);
				updateChord(varWheel, 0);
			}
		});
		
		rootWheel.setCurrentItem(0);
		
		extWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					updateVars(varWheel, newValue);
					updateChord(varWheel, 0);
				}
			}
		});
		
		extWheel.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				isScroll = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				isScroll = false;
				updateVars(varWheel, extWheel.getCurrentItem());
				updateChord(varWheel, 0);
			}
		});
		
		varWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					updateChord(varWheel, newValue);
				}
			}
		});
		
		varWheel.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				isScroll = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				isScroll = false;
				updateChord(varWheel, varWheel.getCurrentItem());
			}
		});
		
		//초기값 root, ext, var 모두 첫번째 값으로 휠 초기화
		rootStr = ChordData.ROOT[0];
		hashMap = GuitaroidMain.chordData.rootMap.get(rootStr);
		extStrArr = ChordData.EXTENSION[0];
		extStr = extStrArr[0];
		array = hashMap.get(extStr);
		varIdx = 0;
		updateExts(extWheel, ChordData.EXTENSION, 0);
		updateVars(varWheel, varIdx);
		updateChord(varWheel, varIdx);
		
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
			soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);

			soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
				
				@Override
				public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
					loading = false;
				}
			});
			
			Chord chord = GuitaroidMain.chordData.getChord(rootStr, extStr, varIdx);
			
			loading = true;
			for(int i = 0; i < 6; i++){
				if(chord.position[i] != -1){
					rawResIds[i] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[i][chord.position[i]], 1);
					mute[i] = false;
				}
				else{
					mute[i] = true;
				}
			}
		}
		super.onResume();
	}
	
	private class SoundThread extends Thread{
		public void run(){
			while(loading);
			for(int i = 0; i < 6; i++){
				if(!mute[i]){
					soundPool.play(rawResIds[i], 1, 1, 0, 0, 1);
					try {
						sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	//Update the Exts
	private void updateExts(WheelView ext, String [][] exts, int index){
		rootStr = ChordData.ROOT[index];
		hashMap = GuitaroidMain.chordData.rootMap.get(rootStr);
		extStrArr = exts[index];
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this, extStrArr);
		adapter.setTextSize(18);
		ext.setViewAdapter(adapter);
		ext.setCurrentItem(0);
	}
	
	//Update the vars
	private void updateVars(WheelView var, int index){
		extStr = extStrArr[index];
		array = hashMap.get(extStr);
		NumericWheelAdapter adapter = new NumericWheelAdapter(this, 1, array.size());
		adapter.setTextSize(18);
		var.setViewAdapter(adapter);
		varIdx = 0;
		var.setCurrentItem(varIdx);
	}
	
	//Update the chord to Chord view
	private void updateChord(WheelView var, int index){
		//여기서 root + ext + var 문자열 ChordView 에넘겨줘서 코드뷰에서 포지션등 확인 해서 그려주자
		chordView.setChord(rootStr, extStr, index);
		if(extStr.equals("Major")){
			chordText.setText(rootStr);
		}
		else{
			chordText.setText(rootStr + extStr);
		}
		
		//plus 사운드 재생 처리
		Chord chord = GuitaroidMain.chordData.getChord(rootStr, extStr, varIdx);
		
		loading = true;
		for(int i = 0; i < 6; i++){
			if(chord.position[i] != -1){
//				soundPool.unload(rawResIds[i]);
				rawResIds[i] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[i][chord.position[i]], 1);
				mute[i] = false;
			}
			else{
				mute[i] = true;
			}
		}
		
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
			return ChordData.ROOT.length;
		}
		@Override
		protected CharSequence getItemText(int index) {
			return ChordData.ROOT[index];
		}
	}
	
	//Adaptor for extension
	private class ExtAdapter extends AbstractWheelTextAdapter{
		protected ExtAdapter(Context context) {
			super(context, R.layout.ext_name, NO_RESOURCE);
			setItemTextResource(R.id.extWheel_extName);
		}

		@Override
		public View getItem(int index, View convertView, ViewGroup parent) {
			return super.getItem(index, convertView, parent);
		}
		@Override
		public int getItemsCount() {
			return extStrArr.length;
		}
		@Override
		protected CharSequence getItemText(int index) {
			return extStrArr[index];
		}
	}

	void writePreference(){
		SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor edit = pref.edit();
		edit.putBoolean("isDialogDismiss", isDialogDismiss);
		edit.commit();
	}
	
	void readPreference(){
		SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		isDialogDismiss = pref.getBoolean("isDialogDismiss", false);
	}
	
}
