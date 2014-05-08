package net.gerosyab.Guitaroid.activity;

import java.util.Random;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.ChordData;
import net.gerosyab.Guitaroid.data.ChordData.Chord;
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

public class EarTestChordActivity extends SuperActivity {
	private static final int WHEEL_VISIBLE_ITEM_NUM = 4;
	TextView earTestText;
	Button soundBtn, tryBtn, newTestBtn, replayBtn;
	WheelView rootWheel, extWheel;
	
	Context context;
	private SoundPool soundPool;
	public static int [] rawResIds = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	boolean isScroll;
	boolean [] mute = {false, false, false, false, false, false, false, false, false, false, false, false};  
	
	public static final String [] ROOT = {"C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B"};
	public static final String [] EXTENSION = {"Major", "m"};
	
	Random random;
	
	int root_num;
	int ext_num;
	
	Chord chord;
	
	String rootStr, extStr, resultStr;
	
	Toast toast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ear_test_chord);
		
		context = this;
		
		random = new Random(System.currentTimeMillis());
		
		soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
		
		chord = GuitaroidMain.chordData.getChord("CMajor");
		
//		toast = toast.makeText(context, "", Toast.LENGTH_SHORT);

		for(int i = 0; i < 6; i++){
			if(chord.position[i] != -1){
				rawResIds[i + 6] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[i][chord.position[i]], 1);
				mute[i + 6] = false;
			}
			else{
				mute[i + 6] = true;
			}
		}
		
		//Generate Test
		root_num = random.nextInt(12);
		ext_num = random.nextInt(2);
		
		resultStr = ROOT[root_num] + EXTENSION[ext_num];	
		
		chord = GuitaroidMain.chordData.getChord(resultStr);
		
		for(int i = 0; i < 6; i++){
			if(chord.position[i] != -1){
				rawResIds[i] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[i][chord.position[i]], 1);
				mute[i] = false;
			}
			else{
				mute[i] = true;
			}
		}
		
		isScroll = false;
		
		earTestText = (TextView)findViewById(R.id.ear_test_chord_text);
		soundBtn = (Button)findViewById(R.id.ear_test_chord_soundButton);
		replayBtn = (Button)findViewById(R.id.ear_test_chord_replayButton);
		tryBtn = (Button)findViewById(R.id.ear_test_chord_TryBtn);
		newTestBtn = (Button)findViewById(R.id.ear_test_chord_NewTestBtn);
		
		soundBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new SoundThread2().start();
			}
		});
		
		replayBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new SoundThread1().start();
				replayBtn.setText("Click to Replay");
			}
		});
		
		tryBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isScroll){
					if((rootStr + extStr).equals(resultStr)){
	
						sendToastMessage("Correct!!");
						
						if(EXTENSION[ext_num].equals("Major")){
							earTestText.setText(ROOT[root_num]);
						}
						else{
							earTestText.setText(resultStr);
						}
					}
					else{
						sendToastMessage(rootStr + extStr + "\nWrong!! Try again!!");
					}
				}
			}
		});
		
		newTestBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				replayBtn.setText("Hear the Sound : ?");
				earTestText.setText(" ? ");
				
				root_num = random.nextInt(12);
				ext_num = random.nextInt(2);
				resultStr = ROOT[root_num] + EXTENSION[ext_num];
				
				chord = GuitaroidMain.chordData.getChord(resultStr);
				
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
		});
		
		
		rootWheel = (WheelView)findViewById(R.id.ear_test_chord_rootWheel);
		extWheel = (WheelView)findViewById(R.id.ear_test_chord_extWheel);
		
		rootWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		extWheel.setVisibleItems(WHEEL_VISIBLE_ITEM_NUM);
		
		rootWheel.setViewAdapter(new RootAdapter(this));
		extWheel.setViewAdapter(new ExtAdapter(this));
		
		rootWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					rootStr = ROOT[rootWheel.getCurrentItem()];
					ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(context, EXTENSION);
					adapter.setTextSize(18);
					extWheel.setViewAdapter(adapter);
					extWheel.setCurrentItem(0);
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
				rootStr = ROOT[rootWheel.getCurrentItem()];
				ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(context, EXTENSION);
				adapter.setTextSize(18);
				extWheel.setViewAdapter(adapter);
				extWheel.setCurrentItem(0);
			}
		});
		
		rootWheel.setCurrentItem(0);
		
		extWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if(!isScroll){
					extStr = EXTENSION[newValue];
				}
			}
		});
		
		
		//�ʱⰪ root, ext, var ��� ù��° ������ �� �ʱ�ȭ
		rootStr = ROOT[0];
		extStr = EXTENSION[0];
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(context, EXTENSION);
		adapter.setTextSize(18);
		extWheel.setViewAdapter(adapter);
		extWheel.setCurrentItem(0);
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
			soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);
		
			Chord chord = GuitaroidMain.chordData.getChord("CMajor");

			for(int i = 0; i < 6; i++){
				if(chord.position[i] != -1){
					rawResIds[i + 6] = soundPool.load(context, SoundResourceTable.ACOUSTIC_RESOURCE_TABLE[i][chord.position[i]], 1);
					mute[i + 6] = false;
				}
				else{
					mute[i + 6] = true;
				}
			}
			
			if(resultStr != null){
				chord = GuitaroidMain.chordData.getChord(resultStr);
				
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
		}
		super.onResume();
	}
	
	private class SoundThread1 extends Thread{
		public void run(){
			for(int i = 0; i < 6; i++){
				if(!mute[i]){
					soundPool.play(rawResIds[i], 1, 1, 0, 0, 1);
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private class SoundThread2 extends Thread{
		public void run(){
			for(int i = 6; i < 12; i++){
				if(!mute[i]){
					soundPool.play(rawResIds[i], 1, 1, 0, 0, 1);
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
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
			return EXTENSION.length;
		}
		@Override
		protected CharSequence getItemText(int index) {
			return EXTENSION[index];
		}
	}
}
