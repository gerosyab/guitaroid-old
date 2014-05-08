package net.gerosyab.Guitaroid.util;

import net.gerosyab.Guitaroid.activity.GuitaroidMain;
import net.gerosyab.Guitaroid.data.ChordData.Chord;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ChordView extends View {
	private final String DEBUG_TAG = "ChordView";
	
	private final String [] NOTE = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	
	private final int LINE_COLOR = Color.WHITE;
	private final int DOT_COLOR = Color.WHITE;
	private final int MUTE_COLOR = Color.WHITE;
	private final int FRET_NUM_COLOR = Color.WHITE;
	private final int NUT_COLOR = Color.WHITE;
	private final int CIRCLE_COLOR = Color.GRAY;
	private final int X_COLOR = Color.GRAY;
	private final int NOTE_COLOR = Color.WHITE;
	
	private final float LINE_STROKE = 0.01f;
	private final float MUTE_STROKE = 0.02f;
	private final float NUT_STROKE = 0.03f;
	private final float X_STROKE = 0.02f;
	
	private final float FRET_NUM_TEXT_SIZE = 0.1f;
	private final float NOTE_TEXT_SIZE = 0.075f;
	
	private final float VIEW_WIDTH_SCALE = 0.85f;
	private final float VIEW_HEIGHT_SCALE = 1.0f;
	private final float VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE = 0.2f;
	private final float VIEW_UPPER_MAGIN_FOR_MUTE_SCALE = 0.175f;
	
	private final float FRET_GAP_SCALE = (VIEW_HEIGHT_SCALE - VIEW_UPPER_MAGIN_FOR_MUTE_SCALE) / 4;
	private final float STRING_GAP_SCALE = (VIEW_WIDTH_SCALE - VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE) / 5;
	
	private final float GAP_FROM_NUT = FRET_GAP_SCALE / 2;
	private final float LEFT_MARGIN = VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE / 2;
	
	private final float BOTTOM_MARGIN_FROM_NUT = 0.1f;
	private final float CIRCLE_RADIUS = 0.06f;
	private final float DOT_RADIUS = 0.03f;
	private final float X_COEFF = 0.035f;
	
	private int [] fretNum = new int[4];
	private int [] position = new int[6];
	private int barreFret;
	private int barreStart;
	private int barreEnd;
	private boolean isBarre;
	private boolean [] mute = new boolean[6];
	private String[] note = new String[6];
	
	
	private Paint paintLine;
	private Paint paintDot;
	private Paint paintMute;
	private Paint paintFretNum;
	private Paint paintNut;
	private Paint paintCircle;
	private Paint paintX;
	private Paint paintNote;
	
	
	public ChordView(Context context, AttributeSet attrs) {
		super(context, attrs);

		//Initializing Paints
		paintLine = new Paint();
		paintDot = new Paint();
		paintMute = new Paint();
		paintFretNum = new Paint();
		paintNut = new Paint();
		paintCircle = new Paint();
		paintX = new Paint();
		paintNote = new Paint();
		
		paintLine.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintDot.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintMute.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintFretNum.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintNut.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintCircle.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintX.setFlags(Paint.ANTI_ALIAS_FLAG);
		paintNote.setFlags(Paint.ANTI_ALIAS_FLAG);
		
		paintLine.setColor(LINE_COLOR);
		paintDot.setColor(DOT_COLOR);
		paintMute.setColor(MUTE_COLOR);
		paintFretNum.setColor(FRET_NUM_COLOR);
		paintNut.setColor(NUT_COLOR);
		paintCircle.setColor(CIRCLE_COLOR);
		paintX.setColor(X_COLOR);
		paintNote.setColor(NOTE_COLOR);
		
		paintLine.setStrokeWidth(LINE_STROKE);
		paintMute.setStrokeWidth(MUTE_STROKE);
		paintNut.setStrokeWidth(NUT_STROKE);
		paintX.setStrokeWidth(X_STROKE);
		
		paintLine.setStrokeJoin(Join.MITER);
		paintNut.setStrokeCap(Cap.SQUARE);

		paintDot.setStyle(Style.FILL_AND_STROKE);
		paintMute.setStyle(Style.STROKE);
		paintNut.setStyle(Style.FILL_AND_STROKE);
		paintCircle.setStyle(Style.FILL_AND_STROKE);

		paintFretNum.setTextSize(FRET_NUM_TEXT_SIZE);
		paintNote.setTextSize(NOTE_TEXT_SIZE);
		paintFretNum.setTextAlign(Paint.Align.CENTER);
		paintNote.setTextAlign(Paint.Align.CENTER);
		
		//it is just for android layout editor
		//without this, runtime error occurs...
		//NullPointerException
		note[0] = "E";
		note[1] = "A";
		note[2] = "D";
		note[3] = "G";
		note[4] = "B";
		note[5] = "E";
		//sucks...
	}

	public void setChord(String root, String ext, int varIdx){
		Chord chord = GuitaroidMain.chordData.getChord(root, ext, varIdx);
		calculateChord(chord);
		
		invalidate();
	}
	
	private void calculateChord(Chord chord){
		for(int i = 0; i < 6; i++){
			this.position[i] = chord.position[i];
			if(this.position[i] == -1){
				mute[i] = true;
			}
			else{
				mute[i] = false;
			}
		}

		getStartFret();
		
		isBarre = hasBarre();
		
		
		if(isBarre){
			barreFret = this.position[5];
			
			for(int i = 0; i < 3; i++){
				if(this.position[i] > 0 && this.position[i] == barreFret){
					barreStart = i;
					break;
				}
			}
			barreEnd = 5;
		}

		//note �� ����
		//6th String
		if(this.position[0] == -1){
			note[0] = "";
		}
		else if(this.position[0] == 0){
			note[0] = "E";
		}
		else{
			//index for "E" in NOTE String is 4
			note[0] = NOTE[(this.position[0] + 4) % NOTE.length];
		}
		
		//5th String
		if(this.position[1] == -1){
			note[1] = "";
		}
		else if(this.position[1] == 0){
			note[1] = "A";
		}
		else{
			//index for "A" in NOTE String is 9
			note[1] = NOTE[(this.position[1] + 9) % NOTE.length];
		}
		
		//4th String
		if(this.position[2] == -1){
			note[2] = "";
		}
		else if(this.position[2] == 0){
			note[2] = "D";
		}
		else{
			//index for "D" in NOTE String is 2
			note[2] = NOTE[(this.position[2] + 2) % NOTE.length];
		}
		
		//3rd String
		if(this.position[3] == -1){
			note[3] = "";
		}
		else if(this.position[3] == 0){
			note[3] = "G";
		}
		else{
			//index for "G" in NOTE String is 7
			note[3] = NOTE[(this.position[3] + 7) % NOTE.length];
		}
		
		//2nd String
		if(this.position[4] == -1){
			note[4] = "";
		}
		else if(this.position[4] == 0){
			note[4] = "B";
		}
		else{
			//index for "B" in NOTE String is 7
			note[4] = NOTE[(this.position[4] + 11) % NOTE.length];
		}
		
		//1st String
		if(this.position[5] == -1){
			note[5] = "";
		}
		else if(this.position[5] == 0){
			note[5] = "E";
		}
		else{
			//index for "E" in NOTE String is 4
			note[5] = NOTE[(this.position[5] + 4) % NOTE.length];
		}
	}
	
	private void getStartFret(){
		int minPosition = 99;
		int maxPosition = 0;
		
		for(int i = 0; i < 6; i++){
			if(this.position[i] > 0){
				if(this.position[i] < minPosition){
					minPosition = this.position[i];
				}
				if(this.position[i] > maxPosition){
					maxPosition = this.position[i];
				}
			}
		}
		
		if(maxPosition < 4){
			minPosition = 1;
		}
		
		for(int i = 0; i < 4; i++){
			fretNum[i] = minPosition + i;
		}
	}
	
	private boolean hasBarre(){
		return ((this.position[0] > 0) && (this.position[0] == this.position[5])
				|| (this.position[1] > 0) && (this.position[1] == this.position[5])
				|| (this.position[2] > 0) && (this.position[2] == this.position[5]));
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		float scale = (float) getHeight();
		int width = getWidth();
		
		canvas.translate((width / 2), 0);
		
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		canvas.scale(scale, scale);
		
		canvas.translate(-((VIEW_WIDTH_SCALE + VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE) / 2) , 0);
		
		drawFretBoard(canvas);
		drawFretNum(canvas);
		drawDot(canvas);
		drawOpenMute(canvas);
		
		if(fretNum[0] == 1){
			drawNut(canvas);
		}
//		canvas.drawRect(0, 0, 1, 1, paintLine);

		drawNote(canvas);
		
		canvas.translate(((VIEW_WIDTH_SCALE + VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE) / 2), 0);
		
		canvas.restore();
		
		canvas.translate(-(width / 2), 0);
	}
	
	private void drawFretBoard(Canvas canvas){
		//Draw Guitar Neck and FretBoard
		//�簢�� �� ����
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
						VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE, paintLine);
		
		//�簢�� ���� ��
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
						VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_HEIGHT_SCALE, paintLine);
		
		//�簢�� ������ ��
		canvas.drawLine(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
						VIEW_WIDTH_SCALE, VIEW_HEIGHT_SCALE, paintLine);
		
		//�簢�� �غ�
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_HEIGHT_SCALE,
						VIEW_WIDTH_SCALE, VIEW_HEIGHT_SCALE, paintLine);
	
		//1st Fret
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + FRET_GAP_SCALE,
						VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + FRET_GAP_SCALE, paintLine);
		
		//2nd Fret
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (FRET_GAP_SCALE * 2),
				VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (FRET_GAP_SCALE * 2), paintLine);
		
		//3rd Fret
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (FRET_GAP_SCALE * 3),
				VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (FRET_GAP_SCALE * 3), paintLine);

		//5th String
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
				VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_HEIGHT_SCALE, paintLine);
		
		//4th String
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
				VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_HEIGHT_SCALE, paintLine);
		
		//3rd String
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
				VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_HEIGHT_SCALE, paintLine);
		
		//2nd String
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
				VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_HEIGHT_SCALE, paintLine);
	

	}

	private void drawFretNum(Canvas canvas){
		canvas.drawText(Integer.toString(fretNum[0]), LEFT_MARGIN, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (FRET_NUM_TEXT_SIZE / 3), paintFretNum);
		
		canvas.drawText(Integer.toString(fretNum[1]), LEFT_MARGIN, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (FRET_NUM_TEXT_SIZE / 3), paintFretNum);
		
		canvas.drawText(Integer.toString(fretNum[2]), LEFT_MARGIN, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (FRET_NUM_TEXT_SIZE / 3), paintFretNum);
		
		canvas.drawText(Integer.toString(fretNum[3]), LEFT_MARGIN, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (FRET_NUM_TEXT_SIZE / 3), paintFretNum);
		
	}
	
	private void drawOpenMute(Canvas canvas){
		if(mute[0]){
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
		}
		else if(this.position[0] == 0){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[0], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		if(mute[1]){
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
		}
		else if(this.position[1] == 0){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[1], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		if(mute[2]){
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);

		}
		else if(this.position[2] == 0){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[2], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		if(mute[3]){
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);

		}
		else if(this.position[3] == 0){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[3], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		if(mute[4]){
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4) + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4) - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);

		}
		else if(this.position[4] == 0){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[4], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		if(mute[5]){
			canvas.drawLine(VIEW_WIDTH_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_WIDTH_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
			canvas.drawLine(VIEW_WIDTH_SCALE + X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT - X_COEFF,
							VIEW_WIDTH_SCALE - X_COEFF, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + X_COEFF, paintX);
		}
		else if(this.position[5] == 0){
			canvas.drawCircle(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[5], VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE - BOTTOM_MARGIN_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
	
	}
	
	private void drawNote(Canvas canvas){
		//6th String
		if(this.position[0] == fretNum[0]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[0], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[0] == fretNum[1]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[0], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[0] == fretNum[2]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[0], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[0] == fretNum[3]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[0], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		//5th String
		if(this.position[1] == fretNum[0]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[1], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[1] == fretNum[1]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[1], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[1] == fretNum[2]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[1], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[1] == fretNum[3]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[1], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + STRING_GAP_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		//4th String
		if(this.position[2] == fretNum[0]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[2], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT+ (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[2] == fretNum[1]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[2], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[2] == fretNum[2]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[2], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[2] == fretNum[3]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[2], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		//3rd String
		if(this.position[3] == fretNum[0]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[3], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[3] == fretNum[1]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[3], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[3] == fretNum[2]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[3], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[3] == fretNum[3]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[3], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		//2nd String
		if(this.position[4] == fretNum[0]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[4], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);	
		}
		else if(this.position[4] == fretNum[1]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[4], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[4] == fretNum[2]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[4], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[4] == fretNum[3]){
			canvas.drawCircle(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[4], VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 4), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
		//1st String
		if(this.position[5] == fretNum[0]){
			canvas.drawCircle(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[5], VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[5] == fretNum[1]){
			canvas.drawCircle(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[5], VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[5] == fretNum[2]){
			canvas.drawCircle(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[5], VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		else if(this.position[5] == fretNum[3]){
			canvas.drawCircle(VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), CIRCLE_RADIUS, paintCircle);
			canvas.drawText(note[5], VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7) + (NOTE_TEXT_SIZE / 3), paintNote);
		}
		
	}
	
	private void drawDot(Canvas canvas){
		if(fretNum[0] == 1 || fretNum[0] == 3 || fretNum[0] == 5 || fretNum[0] == 7 || fretNum[0] == 9
				|| fretNum[0] == 15 || fretNum[0] == 17 || fretNum[0] == 19 || fretNum[0] == 21){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, DOT_RADIUS, paintDot);
		}
		else if(fretNum[0] == 12){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 1.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, DOT_RADIUS, paintDot);
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + GAP_FROM_NUT, DOT_RADIUS, paintDot);
		}
		
		if(fretNum[1] == 1 || fretNum[1] == 3 || fretNum[1] == 5 || fretNum[1] == 7 || fretNum[1] == 9
				|| fretNum[1] == 15 || fretNum[1] == 17 || fretNum[1] == 19 || fretNum[1] == 21){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), DOT_RADIUS, paintDot);
		}
		else if(fretNum[1] == 12){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 1.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), DOT_RADIUS, paintDot);
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 3), DOT_RADIUS, paintDot);
		}
		
		if(fretNum[2] == 1 || fretNum[2] == 3 || fretNum[2] == 5 || fretNum[2] == 7 || fretNum[2] == 9
				|| fretNum[2] == 15 || fretNum[2] == 17 || fretNum[2] == 19 || fretNum[2] == 21){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), DOT_RADIUS, paintDot);
		}
		else if(fretNum[2] == 12){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 1.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), DOT_RADIUS, paintDot);
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 5), DOT_RADIUS, paintDot);
		}
		
		if(fretNum[3] == 1 || fretNum[3] == 3 || fretNum[3] == 5 || fretNum[3] == 7 || fretNum[3] == 9
				|| fretNum[3] == 15 || fretNum[3] == 17 || fretNum[3] == 19 || fretNum[3] == 21){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 2.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), DOT_RADIUS, paintDot);
		}
		else if(fretNum[3] == 12){
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 1.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), DOT_RADIUS, paintDot);
			canvas.drawCircle((float) (VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE + (STRING_GAP_SCALE * 3.5)), VIEW_UPPER_MAGIN_FOR_MUTE_SCALE + (GAP_FROM_NUT * 7), DOT_RADIUS, paintDot);
		}
		
	}
	
	private void drawNut(Canvas canvas){
		canvas.drawLine(VIEW_LEFT_MARGIN_FOR_FRET_NUM_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE,
				VIEW_WIDTH_SCALE, VIEW_UPPER_MAGIN_FOR_MUTE_SCALE, paintNut);
	}
}
