package net.gerosyab.Guitaroid.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ChordSelector extends Activity {
//	public final static int REQUEST_CHORD_PROGRESS = 2;
	public static final String RESULT = "RESULT";
	
	private static final int WHEEL_VISIBLE_ITEM_NUM = 4;
	TextView chordText;
	
	WheelView rootWheel, extWheel;
	HashMap<String, ArrayList<Chord>> hashMap;
	ArrayList<Chord> array;	
	static String[] extStrArr;
	static String rootStr;
	static String extStr;
	boolean isScroll;
	boolean [] mute = new boolean[6];
	boolean loading = false;
	
	Button btn, ok, cancel;
	ChordView chordView;
	SoundThread thread;
	
	Context context;
	private SoundPool soundPool;
	public static int [] rawResIds = {0, 0, 0, 0, 0, 0};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chord_selector);
		
		context = this;
		
		soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
		
		soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
			
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				loading = false;
			}
		});
		
		btn = (Button)findViewById(R.id.chordSelector_soundButton);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(thread == null){
					thread = new SoundThread();
					thread.start();
					thread = null;	//요거 필요할까?
				}
			}
		});
		
		ok = (Button)findViewById(R.id.chordSelector_OkBtn);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!isScroll){
					Intent result = new Intent();
					result.putExtra(RESULT, rootStr + extStr);
					setResult(RESULT_OK, result);
					finish();
				}
			}
		});
		
		
		cancel = (Button)findViewById(R.id.chordSelector_CancelBtn);
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent result = new Intent();
				setResult(RESULT_CANCELED, result);
				finish();
			}
		});
		
		
		chordView = (ChordView)findViewById(R.id.chordSelector_chordView);
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
		
		rootWheel = (WheelView)findViewById(R.id.chordSelector_rootWheel);
		extWheel = (WheelView)findViewById(R.id.chordSelector_extWheel);
		
		chordText = (TextView)findViewById(R.id.chordSelector_chordText);
		
		chordView = (ChordView)findViewById(R.id.chordSelector_chordView);
		
		rootWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		extWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		
		rootWheel.setViewAdapter(new RootAdapter(this));
		extWheel.setViewAdapter(new ExtAdapter(this));
		
		rootWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					updateExts(extWheel, ChordData.EXTENSION, newValue);
					updateChord(0);
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
				updateChord(0);
			}
		});
		
		rootWheel.setCurrentItem(0);
		
		extWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					updateChord(newValue);
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
				updateChord(extWheel.getCurrentItem());
			}
		});
		
		
		//초기값 root, ext, var 모두 첫번째 값으로 휠 초기화
		rootStr = ChordData.ROOT[0];
		hashMap = GuitaroidMain.chordData.rootMap.get(rootStr);
		extStrArr = ChordData.EXTENSION[0];
		extStr = extStrArr[0];
		array = hashMap.get(extStr);
		updateExts(extWheel, ChordData.EXTENSION, 0);
		updateChord(0);
		
		
		
	}

	@Override
	public void onBackPressed() {
		Intent result = new Intent();
		setResult(RESULT_CANCELED, result);
		super.onBackPressed();
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
			
			Chord chord = GuitaroidMain.chordData.getChord(rootStr + extStr);
			
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
	
	//Update the chord to Chord view
	private void updateChord(int index){
		//여기서 root + ext + var 문자열 ChordView 에넘겨줘서 코드뷰에서 포지션등 확인 해서 그려주자
		extStr = extStrArr[index];
		chordView.setChord(rootStr, extStr, 0);
		if(extStr.equals("Major")){
			chordText.setText(rootStr);
		}
		else{
			chordText.setText(rootStr + extStr);
		}
		
		//plus 사운드 재생 처리
		Chord chord = GuitaroidMain.chordData.getChord(rootStr + extStr);
		
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

}
