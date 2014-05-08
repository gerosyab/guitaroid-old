package net.gerosyab.Guitaroid.data;

import java.util.ArrayList;
import java.util.HashMap;

public class ChordData {
	public static final int ROOT_HASHMAP_CAPACITY = 20;
	public static final int EXT_HASHMAP_CAPACITY = 35;
	public static final int ROOT_NUM = 12;
	public static final int MUTE = -1;
	
	//index - C = 0, C#/Db = 1, D = 2, D#/Eb = 3, E = 4,
	//		  F = 5, F#/Gb = 6, G = 7, G#/Ab = 8, A = 9,
	//		  A#/Bb = 10, B = 11
	public static final String [] ROOT = {"C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B"};
	
	public static final String[][] EXTENSION = {
		//C
		{"Major", "/G", "/E", "m", "m/G", "m/Eb", "m/E", "7", "7/G", "7/E",
		"m7", "m7/G", "m7/Eb", "m7/E", "maj7", "maj7/G", "maj7/E", "m7-5", "sus4", "7sus4",
		"6", "m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5",
		"dim", "-5", "7-5", "9-5", "11", "13", "5"},
		
		//C#/Db
		{"Major", "/F", "/Ab", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//D
		{"Major", "/F#", "/A", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//D#/Eb
		{"Major", "/G", "/Bb", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//E
		{"Major", "/G#", "/B", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//F
		{"Major", "/A", "/C", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//F#/Gb
		{"Major", "/Bb", "/Db", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//G
		{"Major", "/B", "/D", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//G#/Ab
		{"Major", "/C", "/Eb", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//A
		{"Major", "/C#", "/E", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//A#/Bb
		{"Major", "/D", "/F", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"},
		
		//B
		{"Major", "/D#", "/F#", "7", "m", "m7", "maj7", "sus4", "7sus4", "6",
		"m6", "9", "m9", "maj9", "6/9", "7+9", "7-9", "aug", "7+5", "dim",
		"-5", "7-5", "9-5", "11", "13", "5"}
	};
	
	public class Chord {
		public String root;
		public String ext;
		public int [] position;
		
		public Chord(String r, String e, int p6, int p5, int p4, int p3, int p2, int p1){
			root = r;
			ext = e;
			position = new int [] {p6, p5, p4, p3, p2, p1};
		}
	}
	
	//HashMap 써서 코드 데이터 저장
	//코드사전이랑 버츄얼기타에서도 사용
	
	public static ArrayList<Chord> varArray;
	public static HashMap<String, ArrayList<Chord>> extMap;
	public static HashMap<String, HashMap> rootMap;
	
	public ChordData(){
		rootMap = new HashMap<String, HashMap>(ROOT_HASHMAP_CAPACITY);
		
			
		//C Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//C Major
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "Major", -1, 3, 2, 0, 1, 0));
			varArray.add(new Chord("C", "Major", -1, 3, 5, 5, 5, 0));
			varArray.add(new Chord("C", "Major", -1, 3, 5, 5, 5, 3));
			varArray.add(new Chord("C", "Major", 8, 10, 10, 9, 8, 8));
			extMap.put("Major", varArray);
			
			//C /G
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "/G", 3, 3, 2, 0, 1, 0));
			varArray.add(new Chord("C", "/G", 3, 3, 5, 5, 5, 0));
			varArray.add(new Chord("C", "/G", 3, 3, 5, 5, 5, 3));
			extMap.put("/G", varArray);
			
			//C /E
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "/E", 0, 3, 2, 0, 1, 0));
			varArray.add(new Chord("C", "/E", 0, 3, 5, 5, 5, 0));
			varArray.add(new Chord("C", "/E", 0, 3, 5, 5, 5, 3));
			extMap.put("/E", varArray);
			
			//C m
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "m", -1, 3, 1, 0, 1, -1));
			varArray.add(new Chord("C", "m", -1, 3, 5, 5, 4, 3));
			varArray.add(new Chord("C", "m", 8, 10, 10, 8, 8, 8));
			extMap.put("m", varArray);
			
			//C m/G
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "m/G", 3, 3, 1, 0, 1, -1));
			varArray.add(new Chord("C", "m/G", 3, 3, 5, 5, 4, 3));
			extMap.put("m/G", varArray);
			
			//C m/Eb
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("C", "m/Eb", -1, 6, 5, 5, 4, -1));
			extMap.put("m/Eb", varArray);
			
			//C m/E
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "m/E", 0, 3, 1, 0, 1, -1));
			varArray.add(new Chord("C", "m/E", 0, 3, 5, 5, 4, 3));
			extMap.put("m/E", varArray);
			
			//C 7
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "7", -1, 3, 2, 3, 1, 0));
			varArray.add(new Chord("C", "7", -1, 3, 5, 3, 5, 3));
			varArray.add(new Chord("C", "7", 8, 10, 8, 9, 8, 8));
			extMap.put("7", varArray);
			
			//C 7/G
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "7/G", 3, 3, 2, 3, 1, 0));
			varArray.add(new Chord("C", "7/G", 3, 3, 5, 3, 5, 3));
			extMap.put("7/G", varArray);
			
			//C 7/E
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "7/E", 0, 3, 2, 3, 1, 0));
			varArray.add(new Chord("C", "7/E", 0, 3, 5, 3, 5, 3));
			extMap.put("7/E", varArray);
			
			//C m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("C", "m7", -1, 3, 1, 3, 1, -1));
			varArray.add(new Chord("C", "m7", -1, 3, 5, 3, 4, 3));
			varArray.add(new Chord("C", "m7", -1, 3, 5, 3, 4, 6));
			varArray.add(new Chord("C", "m7", 8, 10, 8, 8, 11, 8));
			varArray.add(new Chord("C", "m7", 8, 10, 10, 8, 11, 8));
			varArray.add(new Chord("C", "m7", 8, -1, 8, 8, 8, 8));
			extMap.put("m7", varArray);
			
			//C m7/G
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "m7/G", 3, 3, 1, 3, 1, -1));
			varArray.add(new Chord("C", "m7/G", 3, 3, 5, 3, 4, 3));
			varArray.add(new Chord("C", "m7/G", 3, 3, 5, 3, 4, 6));
			extMap.put("m7/G", varArray);
			
			//C m7/Eb
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("C", "m7/Eb", -1, 6, 5, 5, -1, 6));
			extMap.put("m7/Eb", varArray);
			
			//C m7/E
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "m7/E", 0, 3, 1, 3, 1, -1));
			varArray.add(new Chord("C", "m7/E", 0, 3, 5, 3, 4, 3));
			varArray.add(new Chord("C", "m7/E", 0, 3, 5, 3, 4, 6));
			extMap.put("m7/E", varArray);
			
			//C maj7
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "maj7", -1, 3, 2, 0, 0, 0));
			varArray.add(new Chord("C", "maj7", -1, 3, 5, 4, 5, 3));
			varArray.add(new Chord("C", "maj7", -1, -1, 10, 9, 8, 7));
			varArray.add(new Chord("C", "maj7", 8, -1, 9, 9, 8, -1));
			extMap.put("maj7", varArray);
			
			//C maj7/G
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "maj7/G", 3, 3, 2, 0, 0, 0));
			varArray.add(new Chord("C", "maj7/G", 3, 3, 5, 4, 5, 3));
			extMap.put("maj7/G", varArray);
			
			//C maj7/E
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C", "maj7/E", 0, 3, 2, 0, 0, 0));
			varArray.add(new Chord("C", "maj7/E", 0, 3, 5, 4, 5, 3));
			extMap.put("maj7/E", varArray);
			
			//C m7-5
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("C", "m7-5", 8, -1, 8, 8, 7, -1));
			extMap.put("m7-5", varArray);
			
			//C sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C", "sus4", -1, 3, 3, 0, 1, -1));
			varArray.add(new Chord("C", "sus4", 3, 3, 3, 0, 1, 1));
			varArray.add(new Chord("C", "sus4", -1, 3, 5, 5, 6, 3));
			varArray.add(new Chord("C", "sus4", 3, 3, 5, 5, 6, 3));
			varArray.add(new Chord("C", "sus4", 8, 8, 10, 10, 8, 8));
			extMap.put("sus4", varArray);
			
			//C 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C", "7sus4", -1, 3, 3, 3, 1, -1));
			varArray.add(new Chord("C", "7sus4", 3, 3, 3, 3, 1, -1));
			varArray.add(new Chord("C", "7sus4", -1, 3, 5, 3, 6, 1));
			varArray.add(new Chord("C", "7sus4", 3, 3, 5, 3, 6, 1));
			varArray.add(new Chord("C", "7sus4", 8, 10, 8, 10, 8, 8));
			extMap.put("7sus4", varArray);
			
			//C 6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("C", "6", -1, 3, 2, 2, 1, 0));
			varArray.add(new Chord("C", "6", 0, 3, 2, 2, 1, 0));
			varArray.add(new Chord("C", "6", 3, 3, 2, 2, 1, 0));
			varArray.add(new Chord("C", "6", -1, 3, 5, 5, 5, 5));
			varArray.add(new Chord("C", "6", 3, 3, 5, 5, 5, 5));
			varArray.add(new Chord("C", "6", 8, -1, 10, 9, 10, 8));
			extMap.put("6", varArray);
			
			//C m6
			varArray = new ArrayList<Chord>(8);
			varArray.add(new Chord("C", "m6", -1, 3, 1, 2, 1, -1));
			varArray.add(new Chord("C", "m6", 3, 3, 1, 2, 1, -1));
			varArray.add(new Chord("C", "m6", -1, 3, -1, 5, 4, 5));
			varArray.add(new Chord("C", "m6", 3, 3, -1, 5, 4, 5));
			varArray.add(new Chord("C", "m6", -1, 3, 5, 5, 4, 5));
			varArray.add(new Chord("C", "m6", 3, 3, 5, 5, 4, 5));
			varArray.add(new Chord("C", "m6", 8, -1, 10, 8, 10, 8));
			varArray.add(new Chord("C", "m6", 8, 10, 10, 8, 10, 8));
			extMap.put("m6", varArray);
			
			//C 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "9", -1, 3, 2, 3, 3, -1));
			varArray.add(new Chord("C", "9", 3, 3, 2, 3, 3, 3));
			varArray.add(new Chord("C", "9", -1, 7, 8, 7, 8, -1));
			varArray.add(new Chord("C", "9", -1, -1, 8, 7, 8, 8));
			extMap.put("9", varArray);
			
			//C m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "m9", -1, 3, 1, 3, 3, -1));
			varArray.add(new Chord("C", "m9", 3, 3, 1, 3, 3, 3));
			varArray.add(new Chord("C", "m9", 8, 6, 8, 7, -1, -1));
			varArray.add(new Chord("C", "m9", 8, 10, 8, 8, 8, 10));
			extMap.put("m9", varArray);
			
			//C maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "maj9", -1, 3, 2, 4, 3, -1));
			varArray.add(new Chord("C", "maj9", 8, 7, 9, 7, -1, -1));
			varArray.add(new Chord("C", "maj9", -1, -1, 10, 7, 8, 7));
			extMap.put("maj9", varArray);
			
			//C 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "6/9", 0, 3, 2, 2, 3, 3));
			varArray.add(new Chord("C", "6/9", 3, 3, 2, 2, 3, 3));
			varArray.add(new Chord("C", "6/9", 8, 7, 7, 7, 8, 8));
			varArray.add(new Chord("C", "6/9", -1, -1, 10, 9, 10, 10));
			extMap.put("6/9", varArray);
			
			//C 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "7+9", -1, 3, 2, 3, 4, -1));
			varArray.add(new Chord("C", "7+9", 8, 7, 8, 8, 8, -1));
			varArray.add(new Chord("C", "7+9", 8, 10, 8, 9, 8, 11));
			extMap.put("7+9", varArray);
			
			//C 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "7-9", -1, 3, 2, 3, 2, -1));
			varArray.add(new Chord("C", "7-9", 8, 7, 8, 6, -1, -1));
			varArray.add(new Chord("C", "7-9", 8, -1, 8, 9, 8, 9));
			extMap.put("7-9", varArray);
			
			//C aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "aug", -1, 3, 2, 1, 1, -1));
			varArray.add(new Chord("C", "aug", 4, 3, 2, 1, -1, -1));
			varArray.add(new Chord("C", "aug", -1, -1, 6, 5, 5, 4));
			extMap.put("aug", varArray);
			
			//C 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "7+5", -1, 1, 2, 1, 1, -1));
			varArray.add(new Chord("C", "7+5", -1, 3, 6, 3, 5, 4));
			varArray.add(new Chord("C", "7+5", 8, -1, 8, 9, 9, 8));
			extMap.put("7+5", varArray);
			
			//C dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "dim", 2, 3, 1, 2, -1, -1));
			varArray.add(new Chord("C", "dim", -1, 3, 4, 2, 4, -1));
			varArray.add(new Chord("C", "dim", -1, -1, 1, 2, 1, 2));
			extMap.put("dim", varArray);
			
			//C -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "-5", -1, 3, 4, 5, 5, -1));
			varArray.add(new Chord("C", "-5", -1, -1, 10, 9, 7, 8));
			varArray.add(new Chord("C", "-5", 8, 9, 10, 9, -1, -1));
			extMap.put("-5", varArray);
			
			//C 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "7-5", -1, 3, 4, 3, 5, -1));
			varArray.add(new Chord("C", "7-5", -1, -1, 8, 9, 7, 8));
			varArray.add(new Chord("C", "7-5", 8, 9, 8, 9, -1, -1));
			extMap.put("7-5", varArray);
			
			//C 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C", "9-5", 2, 3, 2, 3, 3, 2));
			varArray.add(new Chord("C", "9-5", 8, 7, 8, 7, 7, 8));
			varArray.add(new Chord("C", "9-5", -1, -1, 10, 11, 11, 10));
			extMap.put("9-5", varArray);
			
			//C 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C", "11", 0, 3, 3, 3, 3, 3));
			varArray.add(new Chord("C", "11", 3, 3, 3, 3, 3, 3));
			varArray.add(new Chord("C", "11", 8, -1, 8, 7, 6, 6));
			varArray.add(new Chord("C", "11", -1, 0, 10, 10, 11, 10));
			varArray.add(new Chord("C", "11", -1, 10, 10, 10, 11, 10));
			extMap.put("11", varArray);
			
			//C 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C", "13", -1, 3, 2, 3, 3, 5));
			varArray.add(new Chord("C", "13", 3, 3, 2, 3, 3, 5));
			varArray.add(new Chord("C", "13", 8, -1, 8, 7, 5, 5));
			varArray.add(new Chord("C", "13", 8, -1, 8, 9, 10, 10));
			extMap.put("13", varArray);
			
			//C 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("C", "5", -1, 3, 5, -1, -1, -1));
			varArray.add(new Chord("C", "5", -1, 3, 5, 5, -1, -1));
			varArray.add(new Chord("C", "5", -1, -1, 5, 5, -1, -1));
			varArray.add(new Chord("C", "5", 8, 10, -1, -1, -1, -1));
			varArray.add(new Chord("C", "5", 8, 10, 10, -1, -1, -1));
			varArray.add(new Chord("C", "5", -1, 10, 10, -1, -1, -1));
			varArray.add(new Chord("C", "5", -1, -1, 10, 12, -1, -1));
			varArray.add(new Chord("C", "5", -1, -1, 10, 12, 13, -1));
			varArray.add(new Chord("C", "5", -1, -1, -1, 12, 13, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("C", extMap);
		
		//C#/Db Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//C#/Db Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "Major", -1, 4, 3, 1, 2, 1));
			varArray.add(new Chord("C#/Db", "Major", -1, 4, 6, 6, 6, -1));
			varArray.add(new Chord("C#/Db", "Major", 9, 11, 11, 10, 9, 9));
			extMap.put("Major", varArray);
			
			//C#/Db /F
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C#/Db", "/F", 1, 4, 3, 1, 2, 1));
			varArray.add(new Chord("C#/Db", "/F", -1, 8, 6, 6, 6, -1));
			extMap.put("/F", varArray);
			
			//C#/Db /Ab
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("C#/Db", "/Ab", 4, 4, 6, 6, 6, -1));
			varArray.add(new Chord("C#/Db", "/Ab", 4, 4, 3, 1, 2, 1));
			extMap.put("/Ab", varArray);
			
			//C#/Db 7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("C#/Db", "7", 4, 4, 3, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "7", -1, 4, 3, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "7", 4, 4, 6, 4, 6, 4));
			varArray.add(new Chord("C#/Db", "7", -1, 4, 6, 4, 6, 4));
			varArray.add(new Chord("C#/Db", "7", 9, 11, 9, 10, 9, 9));
			varArray.add(new Chord("C#/Db", "7", 9, -1, 9, 10, 9, -1));
			extMap.put("7", varArray);
			
			//C#/Db m
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C#/Db", "m", -1, 4, 6, 6, 5, 4));
			varArray.add(new Chord("C#/Db", "m", 9, 11, 11, 9, 9, 9));
			varArray.add(new Chord("C#/Db", "m", -1, -1, 11, 13, 14, 12));
			varArray.add(new Chord("C#/Db", "m", -1, 11, 11, 13, 14, 12));
			varArray.add(new Chord("C#/Db", "m", 4, 4, 6, 6, 5, 4));
			extMap.put("m", varArray);
			
			//C#/Db m7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("C#/Db", "m7", 4, 4, 2, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "m7", -1, 4, 2, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "m7", 4, 4, 6, 4, 5, 7));
			varArray.add(new Chord("C#/Db", "m7", -1, 4, 6, 4, 5, 4));
			varArray.add(new Chord("C#/Db", "m7", 9, 11, 11, 9, 12, 9));
			varArray.add(new Chord("C#/Db", "m7", 9, 11, 9, 9, 12, 9));
			varArray.add(new Chord("C#/Db", "m7", 9, -1, 9, 9, 9, -1));
			extMap.put("m7", varArray);
			
			//C#/Db maj7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("C#/Db", "maj7", 4, 4, 3, 1, 1, 1));
			varArray.add(new Chord("C#/Db", "maj7", -1, 4, 3, 1, 1, 1));
			varArray.add(new Chord("C#/Db", "maj7", 4, 4, 6, 5, 6, 4));
			varArray.add(new Chord("C#/Db", "maj7", -1, 4, 6, 5, 6, 4));
			varArray.add(new Chord("C#/Db", "maj7", -1, -1, 11, 10, 9, 8));
			varArray.add(new Chord("C#/Db", "maj7", 9, -1, 10, 10, 9, -1));
			extMap.put("maj7", varArray);
			
			//C#/Db sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "sus4", 4, 4, 6, 6, 7, 4));
			varArray.add(new Chord("C#/Db", "sus4", -1, 4, 6, 6, 7, 4));
			varArray.add(new Chord("C#/Db", "sus4", -1, -1, 6, 6, 7, 9));
			varArray.add(new Chord("C#/Db", "sus4", 9, 9, 11, 11, 9, 9));
			extMap.put("sus4", varArray);
			
			//C#/Db 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C#/Db", "7sus4", 4, 4, 4, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "7sus4", -1, 4, 4, 4, 2, -1));
			varArray.add(new Chord("C#/Db", "7sus4", 4, 4, 6, 4, 7, 4));
			varArray.add(new Chord("C#/Db", "7sus4", -1, 4, 6, 4, 7, 4));
			varArray.add(new Chord("C#/Db", "7sus4", 9, 11, 9, 11, 9, 9));
			extMap.put("7sus4", varArray);
			
			//C#/Db 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "6", -1, 4, 3, 3, 2, -1));
			varArray.add(new Chord("C#/Db", "6", 4, 4, 6, 6, 6, 6));
			varArray.add(new Chord("C#/Db", "6", -1, 4, 6, 6, 6, 6));
			varArray.add(new Chord("C#/Db", "6", 9, -1, 11, 10, 11, 9));
			extMap.put("6", varArray);
			
			//C#/Db m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("C#/Db", "m6", 4, 4, 2, 3, 2, -1));
			varArray.add(new Chord("C#/Db", "m6", -1, 4, 2, 3, 2, -1));
			varArray.add(new Chord("C#/Db", "m6", 4, 4, 6, 6, 5, 6));
			varArray.add(new Chord("C#/Db", "m6", -1, 4, -1, 6, 5, 6));
			varArray.add(new Chord("C#/Db", "m6", 9, 11, 11, 9, 11, 9));
			varArray.add(new Chord("C#/Db", "m6", 9, -1, 11, 9, 11, 9));
			extMap.put("m6", varArray);
			
			//C#/Db 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "9", 4, 4, 3, 4, 4, 4));
			varArray.add(new Chord("C#/Db", "9", -1, 4, 3, 4, 4, -1));
			varArray.add(new Chord("C#/Db", "9", -1, 8, 9, 8, 9, -1));
			varArray.add(new Chord("C#/Db", "9", -1, -1, 9, 8, 9, 9));
			extMap.put("9", varArray);
			
			//C#/Db m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "m9", 4, 4, 2, 4, 4, 4));
			varArray.add(new Chord("C#/Db", "m9", -1, 4, 2, 4, 4, -1));
			varArray.add(new Chord("C#/Db", "m9", 9, 7, 9, 8, -1, -1));
			varArray.add(new Chord("C#/Db", "m9", 9, 11, 9, 9, 9, 11));
			extMap.put("m9", varArray);
			
			//C#/Db maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "maj9", -1, 4, 3, 5, 4, -1));
			varArray.add(new Chord("C#/Db", "maj9", 9, 8, 10, 8, -1, -1));
			varArray.add(new Chord("C#/Db", "maj9", -1, -1, 11, 8, 9, 8));
			extMap.put("maj9", varArray);
			
			//C#/Db 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "6/9", 4, 4, 3, 3, 4, 4));
			varArray.add(new Chord("C#/Db", "6/9", -1, 4, 3, 3, 4, 4));
			varArray.add(new Chord("C#/Db", "6/9", 9, 8, 8, 8, 9, 9));
			varArray.add(new Chord("C#/Db", "6/9", -1, -1, 11, 10, 11, 11));
			extMap.put("6/9", varArray);
			
			//C#/Db 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "7+9", -1, 4, 3, 4, 5, -1));
			varArray.add(new Chord("C#/Db", "7+9", 9, 8, 9, 9, 9, -1));
			varArray.add(new Chord("C#/Db", "7+9", 9, 11, 9, 10, 9, 12));
			extMap.put("7+9", varArray);
			
			//C#/Db 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "7-9", -1, 4, 3, 4, 3, -1));
			varArray.add(new Chord("C#/Db", "7-9", 9, 8, 9, 7, -1, -1));
			varArray.add(new Chord("C#/Db", "7-9", 9, -1, 9, 10, 9, 10));
			extMap.put("7-9", varArray);
			
			//C#/Db aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "aug", -1, 4, 3, 2, 2, -1));
			varArray.add(new Chord("C#/Db", "aug", 5, 4, 3, 2, -1, -1));
			varArray.add(new Chord("C#/Db", "aug", -1, -1, 3, 2, 2, 1));
			extMap.put("aug", varArray);
			
			//C#/Db 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "7+5", -1, 2, 3, 2, 2, -1));
			varArray.add(new Chord("C#/Db", "7+5", -1, 4, 7, 4, 6, 5));
			varArray.add(new Chord("C#/Db", "7+5", 9, -1, 9, 10, 10, 9));
			extMap.put("7+5", varArray);
			
			//C#/Db dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "dim", 3, 4, 2, 3, -1, -1));
			varArray.add(new Chord("C#/Db", "dim", -1, 1, 2, 0, 2, -1));
			varArray.add(new Chord("C#/Db", "dim", -1, -1, 2, 3, 2, 3));
			extMap.put("dim", varArray);
					
			//C#/Db -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "-5", -1, 4, 5, 6, 6, -1));
			varArray.add(new Chord("C#/Db", "-5", -1, -1, 11, 10, 8, 9));
			varArray.add(new Chord("C#/Db", "-5", 9, 10, 11, 10, -1, -1));
			extMap.put("-5", varArray);
			
			//C#/Db 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "7-5", -1, 4, 5, 4, 6, -1));
			varArray.add(new Chord("C#/Db", "7-5", -1, -1, 9, 10, 8, 9));
			varArray.add(new Chord("C#/Db", "7-5", 9, 10, 9, 10, -1, -1));
			extMap.put("7-5", varArray);
			
			//C#/Db 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("C#/Db", "9-5", 3, 4, 3, 4, 4, 3));
			varArray.add(new Chord("C#/Db", "9-5", 9, 8, 9, 8, 8, 9));
			varArray.add(new Chord("C#/Db", "9-5", -1, -1, 11, 12, 12, 11));
			extMap.put("9-5", varArray);
			
						
			//C#/Db 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("C#/Db", "11", 4, 4, 4, 4, 4, 4));
			varArray.add(new Chord("C#/Db", "11", -1, 4, 4, 4, 4, 4));
			varArray.add(new Chord("C#/Db", "11", 9, -1, 9, 8, 7, 7));
			varArray.add(new Chord("C#/Db", "11", -1, 11, 11, 11, 12, 11));
			varArray.add(new Chord("C#/Db", "11", -1, -1, 11, 11, 12, 11));
			extMap.put("11", varArray);
			
						
			//C#/Db 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("C#/Db", "13", 4, 4, 3, 4, 4, 6));
			varArray.add(new Chord("C#/Db", "13", -1, 4, 3, 4, 4, 6));
			varArray.add(new Chord("C#/Db", "13", 9, -1, 9, 8, 7, 7));
			varArray.add(new Chord("C#/Db", "13", 9, -1, 9, 10, 11, 11));
			extMap.put("13", varArray);
			
			//C#/Db 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("C#/Db", "5", -1, 4, 6, -1, -1, -1));
			varArray.add(new Chord("C#/Db", "5", -1, 4, 6, 6, -1, -1));
			varArray.add(new Chord("C#/Db", "5", -1, -1, 6, 6, -1, -1));
			varArray.add(new Chord("C#/Db", "5", 9, 11, -1, -1, -1, -1));
			varArray.add(new Chord("C#/Db", "5", 9, 11, 11, -1, -1, -1));
			varArray.add(new Chord("C#/Db", "5", -1, 11, 11, -1, -1, -1));
			varArray.add(new Chord("C#/Db", "5", -1, -1, 11, 13, -1, -1));
			varArray.add(new Chord("C#/Db", "5", -1, -1, 10, 13, 14, -1));
			varArray.add(new Chord("C#/Db", "5", -1, -1, -1, 13, 14, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("C#/Db", extMap);
		
		
		//D Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//D Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "Major", -1, -1, 0, 2, 3, 2));
			varArray.add(new Chord("D", "Major", -1, 5, 7, 7, 7, 5));
			varArray.add(new Chord("D", "Major", 10, 12, 12, 11, 10, 10));
			extMap.put("Major", varArray);
			
			//D /F#
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "/F#", 2, 0, 0, 2, 3, 2));
			varArray.add(new Chord("D", "/F#", -1, -1, 4, 2, 3, 2));
			varArray.add(new Chord("D", "/F#", 2, 5, 4, 2, 3, 2));
			varArray.add(new Chord("D", "/F#", -1, 9, 7, 7, 7, -1));
			extMap.put("/F#", varArray);
			
			//D /A
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "/A", -1, 0, 0, 2, 3, 2));
			varArray.add(new Chord("D", "/A", 5, 5, 7, 7, 7, -1));
			varArray.add(new Chord("D", "/A", 5, 5, 7, 7, 7, 5));
			extMap.put("/A", varArray);
			
			//D 7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D", "7", -1, 0, 0, 2, 1, 2));
			varArray.add(new Chord("D", "7", 5, 5, 7, 5, 7, 5));
			varArray.add(new Chord("D", "7", -1, 5, 7, 5, 7, 5));
			varArray.add(new Chord("D", "7", 10, 12, 10, 11, 10, 10));
			varArray.add(new Chord("D", "7", 10, -1, 10, 11, 10, -1));
			extMap.put("7", varArray);
			
			//D m
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "m", -1, 0, 0, 2, 3, 1));
			varArray.add(new Chord("D", "m", -1, 5, 7, 7, 6, 5));
			varArray.add(new Chord("D", "m", 10, 12, 12, 10, 10, 10));
			varArray.add(new Chord("D", "m", 5, 5, 7, 7, 6, 5));
			extMap.put("m", varArray);
			
			//D m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("D", "m7", -1, 0, 0, 2, 1, 1));
			varArray.add(new Chord("D", "m7", 5, 5, 7, 5, 6, 8));
			varArray.add(new Chord("D", "m7", -1, 5, 7, 5, 6, 5));
			varArray.add(new Chord("D", "m7", 10, 12, 12, 10, 13, 10));
			varArray.add(new Chord("D", "m7", 10, 12, 10, 10, 13, 10));
			varArray.add(new Chord("D", "m7", 10, -1, 10, 10, 10, -1));
			extMap.put("m7", varArray);
			
			//D maj7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D", "maj7", -1, 0, 0, 2, 2, 2));
			varArray.add(new Chord("D", "maj7", 5, 5, 7, 6, 7, 5));
			varArray.add(new Chord("D", "maj7", -1, 5, 7, 6, 7, 5));
			varArray.add(new Chord("D", "maj7", -1, -1, 12, 11, 10, 9));
			varArray.add(new Chord("D", "maj7", 10, -1, 11, 11, 10, -1));
			extMap.put("maj7", varArray);
			
			//D sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "sus4", -1, 0, 0, 2, 3, 3));
			varArray.add(new Chord("D", "sus4", 5, 5, 7, 7, 8, 5));
			varArray.add(new Chord("D", "sus4", -1, 5, 7, 7, 8, 5));
			varArray.add(new Chord("D", "sus4", 10, 10, 12, 12, 10, 10));
			extMap.put("sus4", varArray);
			
			//D 7sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "7sus4", -1, 0, 0, 2, 1, 3));
			varArray.add(new Chord("D", "7sus4", 5, 5, 7, 5, 8, 5));
			varArray.add(new Chord("D", "7sus4", -1, 5, 7, 5, 8, 5));
			varArray.add(new Chord("D", "7sus4", 10, 12, 10, 12, 10, 10));
			extMap.put("7sus4", varArray);
			
			//D 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "6", -1, 0, 0, 2, 0, 2));
			varArray.add(new Chord("D", "6", 5, 5, 7, 7, 7, 7));
			varArray.add(new Chord("D", "6", -1, 5, 7, 7, 7, 7));
			varArray.add(new Chord("D", "6", 10, -1, 12, 11, 12, 10));
			extMap.put("6", varArray);
			
			//D m6
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D", "m6", -1, 0, 0, 2, 0, 1));
			varArray.add(new Chord("D", "m6", 5, 5, 7, 7, 6, 7));
			varArray.add(new Chord("D", "m6", -1, 5, -1, 7, 6, 7));
			varArray.add(new Chord("D", "m6", 10, 12, 12, 10, 12, 10));
			varArray.add(new Chord("D", "m6", 10, -1, 12, 10, 12, 10));
			extMap.put("m6", varArray);
			
			//D 9
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D", "9", -1, 0, 4, 2, 1, 0));
			varArray.add(new Chord("D", "9", -1, 0, 0, 2, 1, 0));
			varArray.add(new Chord("D", "9", 5, 5, 4, 5, 5, 5));
			varArray.add(new Chord("D", "9", -1, 5, 4, 5, 5, -1));
			varArray.add(new Chord("D", "9", -1, 9, 10, 9, 10, 0));
			extMap.put("9", varArray);
			
			//D m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "m9", -1, 0, 3, 2, 1, 0));
			varArray.add(new Chord("D", "m9", 5, 5, 3, 5, 5, 5));
			varArray.add(new Chord("D", "m9", -1, 5, 3, 5, 5, -1));
			varArray.add(new Chord("D", "m9", 10, 12, 10, 10, 10, 12));
			extMap.put("m9", varArray);
			
			//D maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "maj9", -1, 0, 4, 2, 2, 0));
			varArray.add(new Chord("D", "maj9", -1, 5, 4, 6, 5, -1));
			varArray.add(new Chord("D", "maj9", -1, 0, 12, 9, 10, 9));
			extMap.put("maj9", varArray);
			
			//D 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "6/9", 5, 5, 4, 4, 5, 5));
			varArray.add(new Chord("D", "6/9", -1, 5, 4, 4, 5, 5));
			varArray.add(new Chord("D", "6/9", 10, 9, 9, 9, 10, 10));
			varArray.add(new Chord("D", "6/9", -1, -1, 12, 11, 12, 12));
			extMap.put("6/9", varArray);
			
			//D 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "7+9", -1, 5, 4, 5, 6, -1));
			varArray.add(new Chord("D", "7+9", 10, 9, 10, 10, 10, -1));
			varArray.add(new Chord("D", "7+9", 10, 12, 10, 11, 10, 13));
			extMap.put("7+9", varArray);
			
			//D 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "7-9", -1, 5, 4, 5, 4, -1));
			varArray.add(new Chord("D", "7-9", 10, 9, 10, 8, -1, -1));
			varArray.add(new Chord("D", "7-9", 10, -1, 10, 11, 10, 11));
			extMap.put("7-9", varArray);
			
			//D aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "aug", -1, 5, 4, 3, 3, -1));
			varArray.add(new Chord("D", "aug", 6, 5, 4, 3, -1, -1));
			varArray.add(new Chord("D", "aug", -1, -1, 4, 3, 3, 2));
			extMap.put("aug", varArray);
			
			//D 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "7+5", -1, 3, 4, 3, 3, -1));
			varArray.add(new Chord("D", "7+5", -1, 5, 8, 5, 7, 6));
			varArray.add(new Chord("D", "7+5", 10, -1, 10, 11, 11, 10));
			extMap.put("7+5", varArray);
			
			//D dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "dim", 10, 11, 9, 10, -1, -1));
			varArray.add(new Chord("D", "dim", -1, 2, 3, 1, 3, -1));
			varArray.add(new Chord("D", "dim", -1, -1, 0, 1, 0, 1));
			extMap.put("dim", varArray);
			
			//D -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "-5", -1, 5, 6, 7, 7, -1));
			varArray.add(new Chord("D", "-5", -1, -1, 12, 11, 9, 10));
			varArray.add(new Chord("D", "-5", 10, 11, 12, 11, -1, -1));
			extMap.put("-5", varArray);
			
			//D 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "7-5", -1, 5, 6, 5, 7, -1));
			varArray.add(new Chord("D", "7-5", -1, -1, 10, 11, 9, 10));
			varArray.add(new Chord("D", "7-5", 10, 11, 10, 11, -1, -1));
			extMap.put("7-5", varArray);
			
			//D 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D", "9-5", -1, -1, 0, 1, 1, 0));
			varArray.add(new Chord("D", "9-5", 4, 5, 4, 5, 5, 4));
			varArray.add(new Chord("D", "9-5", 10, 9, 10, 9, 9, 10));
			extMap.put("9-5", varArray);
			
			//D 11
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "11", -1, 0, 0, 0, 1, 0));
			varArray.add(new Chord("D", "11", 5, 5, 5, 5, 5, 5));
			varArray.add(new Chord("D", "11", -1, 5, 5, 5, 5, 5));
			varArray.add(new Chord("D", "11", 10, -1, 10, 9, 8, 8));
			extMap.put("11", varArray);
			
			//D 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D", "13", 5, 5, 4, 5, 5, 7));
			varArray.add(new Chord("D", "13", -1, 5, 4, 5, 5, 7));
			varArray.add(new Chord("D", "13", 10, -1, 10, 9, 7, 7));
			varArray.add(new Chord("D", "13", 10, -1, 10, 11, 12, 12));
			extMap.put("13", varArray);
			
			//D 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("D", "5", -1, 5, 7, -1, -1, -1));
			varArray.add(new Chord("D", "5", -1, 5, 7, 7, -1, -1));
			varArray.add(new Chord("D", "5", -1, -1, 7, 7, -1, -1));
			varArray.add(new Chord("D", "5", 10, 12, -1, -1, -1, -1));
			varArray.add(new Chord("D", "5", 10, 12, 12, -1, -1, -1));
			varArray.add(new Chord("D", "5", -1, 12, 12, -1, -1, -1));
			varArray.add(new Chord("D", "5", -1, -1, 0, 2, -1, -1));
			varArray.add(new Chord("D", "5", -1, -1, 12, 14, -1, -1));
			varArray.add(new Chord("D", "5", -1, -1, 0, 2, 3, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("D", extMap);
		
		
		//D#/Eb Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//D#/Eb Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "Major", -1, 6, 5, 3, 4, 3));
			varArray.add(new Chord("D#/Eb", "Major", -1, 6, 8, 8, 8, -1));
			varArray.add(new Chord("D#/Eb", "Major", 11, 13, 13, 12, 11, 11));
			extMap.put("Major", varArray);

			//D#/Eb /G
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("D#/Eb", "/G", -1, -1, 5, 3, 4, 3));
			varArray.add(new Chord("D#/Eb", "/G", 3, 6, 5, 3, 4, 3));
			extMap.put("/G", varArray);
			
			//D#/Eb /Bb
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("D#/Eb", "/Bb", 6, 6, 5, 3, 4, 3));
			varArray.add(new Chord("D#/Eb", "/Bb", 6, 6, 8, 8, 8, 6));
			extMap.put("/Bb", varArray);
			
			//D#/Eb 7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("D#/Eb", "7", 6, 6, 5, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "7", -1, 6, 5, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "7", 6, 6, 8, 6, 8, 6));
			varArray.add(new Chord("D#/Eb", "7", -1, 6, 8, 6, 8, 6));
			varArray.add(new Chord("D#/Eb", "7", 11, 13, 11, 12, 11, 11));
			varArray.add(new Chord("D#/Eb", "7", 11, -1, 11, 12, 11, -1));
			extMap.put("7", varArray);
			
			//D#/Eb m
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D#/Eb", "m", -1, -1, 1, 3, 4, 2));
			varArray.add(new Chord("D#/Eb", "m", -1, 6, 8, 8, 7, 6));
			varArray.add(new Chord("D#/Eb", "m", 11, 13, 13, 11, 11, 11));
			varArray.add(new Chord("D#/Eb", "m", -1, -1, 4, 3, 4, 2));
			varArray.add(new Chord("D#/Eb", "m", 6, 6, 8, 8, 7, 6));
			extMap.put("m", varArray);
			
			//D#/Eb m7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("D#/Eb", "m7", 6, 6, 4, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "m7", -1, 6, 4, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "m7", 6, 6, 8, 6, 7, 9));
			varArray.add(new Chord("D#/Eb", "m7", -1, 6, 8, 6, 7, 6));
			varArray.add(new Chord("D#/Eb", "m7", 11, 13, 13, 11, 14, 11));
			varArray.add(new Chord("D#/Eb", "m7", 11, 13, 11, 11, 14, 11));
			varArray.add(new Chord("D#/Eb", "m7", 11, -1, 11, 11, 11, -1));
			extMap.put("m7", varArray);
			
			//D#/Eb maj7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("D#/Eb", "maj7", 6, 6, 5, 3, 3, 3));
			varArray.add(new Chord("D#/Eb", "maj7", -1, 6, 5, 3, 3, 3));
			varArray.add(new Chord("D#/Eb", "maj7", 6, 6, 8, 7, 8, 6));
			varArray.add(new Chord("D#/Eb", "maj7", -1, 6, 8, 7, 8, 6));
			varArray.add(new Chord("D#/Eb", "maj7", -1, -1, 13, 12, 11, 10));
			varArray.add(new Chord("D#/Eb", "maj7", 11, -1, 11, 12, 11, -1));
			extMap.put("maj7", varArray);
			
			//D#/Eb sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "sus4", -1, 6, 6, 3, 4, -1));
			varArray.add(new Chord("D#/Eb", "sus4", 6, 6, 8, 8, 9, 6));
			varArray.add(new Chord("D#/Eb", "sus4", -1, 6, 8, 8, 9, 6));
			varArray.add(new Chord("D#/Eb", "sus4", 11, 11, 13, 13, 11, 11));
			extMap.put("sus4", varArray);
			
			//D#/Eb 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D#/Eb", "7sus4", 6, 6, 6, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "7sus4", -1, 6, 6, 6, 4, -1));
			varArray.add(new Chord("D#/Eb", "7sus4", 6, 6, 8, 6, 9, 6));
			varArray.add(new Chord("D#/Eb", "7sus4", -1, 6, 8, 6, 9, 6));
			varArray.add(new Chord("D#/Eb", "7sus4", 11, 13, 11, 13, 11, 11));
			extMap.put("7sus4", varArray);
			
			//D#/Eb 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "6", -1, 6, 5, 5, 4, -1));
			varArray.add(new Chord("D#/Eb", "6", 6, 6, 8, 8, 8, 8));
			varArray.add(new Chord("D#/Eb", "6", -1, 6, 8, 8, 8, 8));
			varArray.add(new Chord("D#/Eb", "6", 11, -1, 13, 12, 13, 11));
			extMap.put("6", varArray);
			
			//D#/Eb m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("D#/Eb", "m6", 6, 6, 4, 5, 4, -1));
			varArray.add(new Chord("D#/Eb", "m6", -1, 6, 4, 5, 4, -1));
			varArray.add(new Chord("D#/Eb", "m6", 6, 6, 8, 8, 7, 8));
			varArray.add(new Chord("D#/Eb", "m6", -1, 6, -1, 8, 7, 8));
			varArray.add(new Chord("D#/Eb", "m6", 11, 13, 13, 11, 13, 11));
			varArray.add(new Chord("D#/Eb", "m6", 11, -1, 13, 11, 13, 11));
			extMap.put("m6", varArray);
			
			//D#/Eb 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "9", 6, 6, 5, 6, 6, 6));
			varArray.add(new Chord("D#/Eb", "9", -1, 6, 5, 6, 6, -1));
			varArray.add(new Chord("D#/Eb", "9", -1, 10, 11, 10, 11, -1));
			varArray.add(new Chord("D#/Eb", "9", -1, -1, 11, 10, 11, 11));
			extMap.put("9", varArray);
			
			//D#/Eb m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "m9", 6, 6, 4, 6, 6, 6));
			varArray.add(new Chord("D#/Eb", "m9", -1, 6, 4, 6, 6, -1));
			varArray.add(new Chord("D#/Eb", "m9", 11, 9, 11, 10, -1, -1));
			varArray.add(new Chord("D#/Eb", "m9", 11, 13, 11, 11, 11, 13));
			extMap.put("m9", varArray);
			
			//D#/Eb maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "maj9", -1, -1, 1, 0, 3, 1));
			varArray.add(new Chord("D#/Eb", "maj9", -1, 6, 5, 7, 6, -1));
			varArray.add(new Chord("D#/Eb", "maj9", -1, -1, 13, 10, 11, 10));
			extMap.put("maj9", varArray);
			
			//D#/Eb 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "6/9", -1, -1, 1, 0, 1, 1));
			varArray.add(new Chord("D#/Eb", "6/9", 6, 6, 5, 5, 6, 6));
			varArray.add(new Chord("D#/Eb", "6/9", -1, 6, 5, 5, 6, 6));
			varArray.add(new Chord("D#/Eb", "6/9", 11, 10, 10, 10, 11, 11));
			extMap.put("6/9", varArray);
			
			//D#/Eb 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "7+9", -1, -1, 1, 0, 2, 2));
			varArray.add(new Chord("D#/Eb", "7+9", -1, 6, 5, 6, 7, -1));
			varArray.add(new Chord("D#/Eb", "7+9", 11, 13, 11, 12, 11, 14));
			extMap.put("7+9", varArray);
			
			//D#/Eb 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "7-9", -1, -1, 1, 0, 2, 0));
			varArray.add(new Chord("D#/Eb", "7-9", -1, 6, 5, 6, 5, -1));
			varArray.add(new Chord("D#/Eb", "7-9", 11, -1, 11, 12, 11, 12));
			extMap.put("7-9", varArray);
			
			//D#/Eb aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "aug", -1, 2, 1, 0, 0, -1));
			varArray.add(new Chord("D#/Eb", "aug", 3, 2, 1, 0, -1, -1));
			varArray.add(new Chord("D#/Eb", "aug", -1, -1, 3, 2, 2, 1));
			extMap.put("aug", varArray);
			
			//D#/Eb 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "7+5", -1, 4, 5, 4, 4, -1));
			varArray.add(new Chord("D#/Eb", "7+5", -1, 6, 9, 6, 8, 7));
			varArray.add(new Chord("D#/Eb", "7+5", 11, -1, 11, 12, 12, 11));
			extMap.put("7+5", varArray);
			
			//D#/Eb dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "dim", 2, 3, 1, 2, -1, -1));
			varArray.add(new Chord("D#/Eb", "dim", -1, 3, 4, 2, 4, -1));
			varArray.add(new Chord("D#/Eb", "dim", -1, -1, 2, 3, 2, 3));
			extMap.put("dim", varArray);
			
			//D#/Eb -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "-5", -1, -1, 1, 2, 4, 3));
			varArray.add(new Chord("D#/Eb", "-5", -1, 6, 7, 8, 8, -1));
			varArray.add(new Chord("D#/Eb", "-5", -1, -1, 13, 12, 10, 11));
			extMap.put("-5", varArray);
			
			//D#/Eb 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "7-5", -1, -1, 1, 2, 2, 3));
			varArray.add(new Chord("D#/Eb", "7-5", -1, 6, 7, 6, 8, -1));
			varArray.add(new Chord("D#/Eb", "7-5", -1, -1, 11, 12, 10, 11));
			extMap.put("7-5", varArray);
			
			//D#/Eb 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("D#/Eb", "9-5", -1, -1, 1, 2, 2, 1));
			varArray.add(new Chord("D#/Eb", "9-5", 5, 6, 5, 6, 6, 5));
			varArray.add(new Chord("D#/Eb", "9-5", 11, 10, 11, 10, 10, 11));
			extMap.put("9-5", varArray);
			
			//D#/Eb 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("D#/Eb", "11", -1, 1, 1, 1, 2, 1));
			varArray.add(new Chord("D#/Eb", "11", -1, -1, 1, 1, 2, 1));
			varArray.add(new Chord("D#/Eb", "11", 6, 6, 6, 6, 6, 6));
			varArray.add(new Chord("D#/Eb", "11", -1, 6, 6, 6, 6, 6));
			varArray.add(new Chord("D#/Eb", "11", 11, -1, 11, 10, 9, 9));
			extMap.put("11", varArray);
			
			//D#/Eb 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("D#/Eb", "13", 6, 6, 5, 6, 6, 8));
			varArray.add(new Chord("D#/Eb", "13", -1, 6, 5, 6, 6, 8));
			varArray.add(new Chord("D#/Eb", "13", 11, -1, 11, 10, 8, 8));
			varArray.add(new Chord("D#/Eb", "13", 11, -1, 11, 12, 13, 13));
			extMap.put("13", varArray);
			
			//D#/Eb 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("D#/Eb", "5", -1, 6, 7, -1, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, 6, 7, 7, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, -1, 7, 7, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", 11, 13, -1, -1, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", 11, 13, 13, -1, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, 1, 1, -1, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, -1, 0, 2, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, -1, 1, 3, -1, -1));
			varArray.add(new Chord("D#/Eb", "5", -1, -1, 13, 15, -1, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("D#/Eb", extMap);
		
		//E Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//E Major
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("E", "Major", 0, 2, 2, 1, 0, 0));
			varArray.add(new Chord("E", "Major", 0, 7, 6, 4, 5, 4));
			varArray.add(new Chord("E", "Major", 0, 7, 9, 9, 9, 7));
			varArray.add(new Chord("E", "Major", 0, 7, 9, 9, 9, 0));
			extMap.put("Major", varArray);

			//E /G#
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("E", "/G#", 4, 7, 6, 4, 5, 4));
			varArray.add(new Chord("E", "/G#", 4, 2, 2, 1, 0, 0));
			extMap.put("/G#", varArray);
			
			//E /B
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("E", "/B", -1, 2, 2, 1, 0, 0));
			extMap.put("/B", varArray);
			
			//E 7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("E", "7", 0, 2, 2, 1, 3, 0));
			varArray.add(new Chord("E", "7", 0, 2, -1, 1, 3, 0));
			varArray.add(new Chord("E", "7", 0, 7, 6, 7, 5, 0));
			varArray.add(new Chord("E", "7", 0, 7, 9, 7, 9, 7));
			varArray.add(new Chord("E", "7", 12, 14, 12, 13, 12, 12));
			varArray.add(new Chord("E", "7", 12, -1, 12, 13, 12, 0));
			extMap.put("7", varArray);
			
			//E m
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "m", 0, 2, 2, 0, 0, 0));
			varArray.add(new Chord("E", "m", 0, -1, 5, 4, 5, 3));
			varArray.add(new Chord("E", "m", 0, 7, 9, 9, 8, 7));
			extMap.put("m", varArray);
			
			//E m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("E", "m7", 0, 2, 2, 0, 3, 0));
			varArray.add(new Chord("E", "m7", 0, 2, 0, 0, 3, 0));
			varArray.add(new Chord("E", "m7", 0, -1, 5, 4, 3, 0));
			varArray.add(new Chord("E", "m7", 0, 7, 9, 7, 8, 10));
			varArray.add(new Chord("E", "m7", 0, 7, 9, 7, 8, 7));
			varArray.add(new Chord("E", "m7", 12, -1, 12, 12, 12, -1));
			extMap.put("m7", varArray);
			
			//E maj7
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("E", "maj7", 0, 2, 1, 1, 0, 0));
			varArray.add(new Chord("E", "maj7", 0, 7, 6, 4, 4, 4));
			varArray.add(new Chord("E", "maj7", 0, 7, 9, 8, 9, 7));
			varArray.add(new Chord("E", "maj7", 12, -1, 13, 13, 12, -1));
			extMap.put("maj7", varArray);
			
			//E sus4
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "sus4", 0, 2, 2, 2, 0, 0));
			varArray.add(new Chord("E", "sus4", 0, 7, 7, 4, 5, 0));
			varArray.add(new Chord("E", "sus4", 0, -1, 9, 9, 10, 12));
			extMap.put("sus4", varArray);	
			
			//E 7sus4
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "7sus4", 0, 2, 0, 2, 0, 0));
			varArray.add(new Chord("E", "7sus4", 0, -1, 2, 4, 3, 5));
			varArray.add(new Chord("E", "7sus4", 0, 7, 9, 7, 10, 7));
			extMap.put("7sus4", varArray);	
			
			//E 6
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "6", 0, 2, 2, 1, 2, 0));
			varArray.add(new Chord("E", "6", 0, 7, 6, 6, 5, 0));
			varArray.add(new Chord("E", "6", 0, 7, 9, 9, 9, 9));
			extMap.put("6", varArray);	
			
			//E m6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("E", "m6", 0, 2, 2, 0, 2, 0));
			varArray.add(new Chord("E", "m6", 0, 7, 5, 6, 5, -1));
			varArray.add(new Chord("E", "m6", 0, 7, 9, 9, 8, 9));
			varArray.add(new Chord("E", "m6", 0, 7, -1, 9, 8, 9));
			extMap.put("m6", varArray);	
			
			//E 9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "9", 0, 2, 0, 1, 3, 2));
			varArray.add(new Chord("E", "9", 0, 7, 6, 7, 7, 0));
			varArray.add(new Chord("E", "9", 0, 11, 12, 11, 12, 0));
			extMap.put("9", varArray);
			
			//E m9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "m9", 0, 2, 2, 0, 3, 2));
			varArray.add(new Chord("E", "m9", 0, 7, 5, 7, 7, 0));
			varArray.add(new Chord("E", "m9", 0, 10, 12, 11, 12, 0));
			extMap.put("m9", varArray);	
			
			//E maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "maj9", 0, 2, 1, 1, 0, 2));
			varArray.add(new Chord("E", "maj9", 0, 7, 4, 4, 4, 4));
			varArray.add(new Chord("E", "maj9", 0, 7, 6, 8, 7, 0));
			extMap.put("maj9", varArray);	
			
			//E 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("E", "6/9", 0, 2, 2, 1, 2, 2));
			varArray.add(new Chord("E", "6/9", 0, -1, 2, 1, 2, 2));
			varArray.add(new Chord("E", "6/9", 0, 7, 6, 6, 7, 7));
			varArray.add(new Chord("E", "6/9", 0, 11, 11, 11, 12, 12));
			extMap.put("6/9", varArray);	
			
			//E 7+9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("E", "7+9", 0, 2, 2, 1, 3, 3));
			varArray.add(new Chord("E", "7+9", 0, -1, 2, 1, 3, 3));
			varArray.add(new Chord("E", "7+9", 0, 7, 6, 7, 8, 0));
			varArray.add(new Chord("E", "7+9", 0, 11, 12, 12, 12, -1));
			extMap.put("7+9", varArray);	
			
			//E 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "7-9", 0, -1, 0, 1, 0, 1));
			varArray.add(new Chord("E", "7-9", 0, 7, 6, 7, 6, -1));
			varArray.add(new Chord("E", "7-9", 0, 11, 12, 10, 0, 0));
			extMap.put("7-9", varArray);	
			
			//E aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "aug", 0, 3, 2, 1, 1, -1));
			varArray.add(new Chord("E", "aug", 4, 3, 2, 1, -1, -1));
			varArray.add(new Chord("E", "aug", 0, -1, 6, 5, 5, 4));
			extMap.put("aug", varArray);	
			
			//E 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "7+5", 0, -1, 0, 1, 1, 0));
			varArray.add(new Chord("E", "7+5", 0, 5, 6, 5, 5, -1));
			varArray.add(new Chord("E", "7+5", 0, 7, 10, 7, 9, 8));
			extMap.put("7+5", varArray);	
			
			//E dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "dim", 3, 4, 2, 3, -1, -1));
			varArray.add(new Chord("E", "dim", -1, 1, 2, 0, 2, -1));
			varArray.add(new Chord("E", "dim", 0, -1, 2, 3, 2, 3));
			extMap.put("dim", varArray);	
			
			//E -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "-5", 0, 1, 2, 1, -1, 0));
			varArray.add(new Chord("E", "-5", 2, -1, 2, 3, 5, 4));
			varArray.add(new Chord("E", "-5", 0, 7, 8, 9, 9, 0));
			extMap.put("-5", varArray);	
			
			//E 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "7-5", 0, 1, 0, 1, -1, 0));
			varArray.add(new Chord("E", "7-5", 0, 7, 8, 7, 9, -1));
			varArray.add(new Chord("E", "7-5", 11, -1, 12, 13, 11, 12));
			extMap.put("7-5", varArray);	
			
			//E 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "9-5", 0, -1, 2, 3, 3, 2));
			varArray.add(new Chord("E", "9-5", 6, 7, 6, 7, 7, 6));
			varArray.add(new Chord("E", "9-5", 0, 11, 12, 11, 11, 12));
			extMap.put("9-5", varArray);	
			
			//E 11
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "11", 0, 2, 2, 2, 3, 2));
			varArray.add(new Chord("E", "11", 0, 7, 7, 7, 7, 7));
			varArray.add(new Chord("E", "11", 0, -1, 12, 11, 10, 0));
			extMap.put("11", varArray);	
			
			//E 13
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("E", "13", 0, -1, 0, 1, 2, 2));
			varArray.add(new Chord("E", "13", 0, -1, 6, 7, 7, 9));
			varArray.add(new Chord("E", "13", 0, -1, 12, 11, 9, 9));
			extMap.put("13", varArray);	
			
			//E 5
			varArray = new ArrayList<Chord>(8);
			varArray.add(new Chord("E", "5", 0, 2, -1, -1, -1, -1));
			varArray.add(new Chord("E", "5", 0, 2, 2, -1, -1, -1));
			varArray.add(new Chord("E", "5", -1, 2, 2, -1, -1, -1));
			varArray.add(new Chord("E", "5", 12, 14, -1, -1, -1, -1));
			varArray.add(new Chord("E", "5", -1, 7, 9, -1, -1, -1));
			varArray.add(new Chord("E", "5", -1, 7, 9, 9, -1, -1));
			varArray.add(new Chord("E", "5", -1, -1, 9, 9, -1, -1));
			varArray.add(new Chord("E", "5", -1, -1, 2, 4, -1, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("E", extMap);
			
		//F Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//F Major
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "Major", 1, 3, 3, 2, 1, 1));
			varArray.add(new Chord("F", "Major", -1, -1, 3, 2, 1, 1));
			varArray.add(new Chord("F", "Major", -1, 8, 7, 5, 6, 5));
			varArray.add(new Chord("F", "Major", -1, 8, 10, 10, 10, -1));
			extMap.put("Major", varArray);

			//F /A
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("F", "/A", -1, 0, 3, 2, 1, 1));
			extMap.put("/A", varArray);	
			
			//F /C
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "/C", -1, 3, 3, 2, 1, 1));
			varArray.add(new Chord("F", "/C", 8, 8, 7, 5, 6, 5));
			varArray.add(new Chord("F", "/C", 8, 8, 10, 10, 10, 8));
			extMap.put("/C", varArray);
			
			//F 7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F", "7", 1, 3, 1, 2, 1, 1));
			varArray.add(new Chord("F", "7", 8, 8, 7, 8, 6, -1));
			varArray.add(new Chord("F", "7", -1, 8, 7, 8, 6, -1));
			varArray.add(new Chord("F", "7", 8, 8, 10, 8, 10, 8));
			varArray.add(new Chord("F", "7", -1, 8, 10, 8, 10, 8));
			varArray.add(new Chord("F", "7", 1, -1, 1, 2, 1, -1));
			extMap.put("7", varArray);
			
			//F m
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F", "m", 1, 3, 3, 1, 1, 1));
			varArray.add(new Chord("F", "m", -1, -1, 3, 1, 1, 1));
			varArray.add(new Chord("F", "m", -1, -1, 3, 5, 6, 4));
			varArray.add(new Chord("F", "m", -1, 8, 10, 10, 9, 8));
			varArray.add(new Chord("F", "m", 8, 8, 10, 10, 9, 8));
			varArray.add(new Chord("F", "m", -1, 3, 3, 5, 6, 4));
			extMap.put("m", varArray);
			
			//F m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F", "m7", 1, 3, 1, 1, 1, 1));
			varArray.add(new Chord("F", "m7", -1, 3, 3, 5, 4, 4));
			varArray.add(new Chord("F", "m7", -1, -1, 3, 5, 4, 4));
			varArray.add(new Chord("F", "m7", 8, 8, 10, 8, 9, 11));
			varArray.add(new Chord("F", "m7", -1, 8, 10, 8, 9, 8));
			varArray.add(new Chord("F", "m7", 1, -1, 1, 1, 1, -1));
			extMap.put("m7", varArray);
			
			//F maj7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F", "maj7", 1, 3, 3, 2, 1, 0));
			varArray.add(new Chord("F", "maj7", 1, -1, 3, 2, 1, 0));
			varArray.add(new Chord("F", "maj7", 0, 8, 7, 5, 5, 5));
			varArray.add(new Chord("F", "maj7", 0, 8, 10, 9, 10, 8));
			varArray.add(new Chord("F", "maj7", 1, -1, 2, 2, 1, -1));
			extMap.put("maj7", varArray);
			
			//F sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "sus4", 1, 1, 3, 3, 1, 1));
			varArray.add(new Chord("F", "sus4", -1, 8, 8, 5, 6, -1));
			varArray.add(new Chord("F", "sus4", 8, 8, 10, 10, 11, 8));
			varArray.add(new Chord("F", "sus4", -1, 8, 10, 10, 11, 8));
			extMap.put("sus4", varArray);
			
			//F 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F", "7sus4", 1, 3, 1, 3, 1, 1));
			varArray.add(new Chord("F", "7sus4", 8, 8, 8, 8, 6, -1));
			varArray.add(new Chord("F", "7sus4", -1, 8, 8, 8, 6, -1));
			varArray.add(new Chord("F", "7sus4", 8, -1, 10, 8, 11, 8));
			varArray.add(new Chord("F", "7sus4", -1, -1, 10, 8, 11, 8));
			extMap.put("7sus4", varArray);
			
			//F 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "6", 1, -1, 3, 2, 3, 1));
			varArray.add(new Chord("F", "6", -1, 8, 7, 7, 6, -1));
			varArray.add(new Chord("F", "6", 8, 8, 10, 10, 10, 10));
			varArray.add(new Chord("F", "6", -1, 8, 10, 10, 10, 10));
			extMap.put("6", varArray);
			
			//F m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F", "m6", 1, 3, 3, 1, 3, 1));
			varArray.add(new Chord("F", "m6", 1, -1, 3, 1, 3, 1));
			varArray.add(new Chord("F", "m6", 8, 8, 6, 7, 6, -1));
			varArray.add(new Chord("F", "m6", -1, 8, 6, 7, 6, -1));
			varArray.add(new Chord("F", "m6", 8, 8, 10, 10, 9, 10));
			varArray.add(new Chord("F", "m6", -1, 8, -1, 10, 9, 10));
			extMap.put("m6", varArray);

			//F 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "9", 1, 0, 1, 0, 1, 1));
			varArray.add(new Chord("F", "9", -1, -1, 3, 5, 4, 3));
			varArray.add(new Chord("F", "9", 8, 8, 7, 8, 8, 8));
			varArray.add(new Chord("F", "9", -1, 8, 7, 8, 8, -1));
			extMap.put("9", varArray);
			
			//F m9
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F", "m9", 1, 3, 1, 1, 1, 3));
			varArray.add(new Chord("F", "m9", -1, -1, 6, 5, 4, 3));
			varArray.add(new Chord("F", "m9", -1, -1, 3, 5, 4, 3));
			varArray.add(new Chord("F", "m9", 8, 8, 6, 8, 8, 8));
			varArray.add(new Chord("F", "m9", -1, 8, 6, 8, 8, -1));
			extMap.put("m9", varArray);
			
			//F maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "maj9", 1, 0, 3, 0, 1, 0));
			varArray.add(new Chord("F", "maj9", -1, 8, 5, 5, 5, 5));
			varArray.add(new Chord("F", "maj9", -1, 8, 7, 9, 8, -1));
			extMap.put("maj9", varArray);
			
			//F 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "6/9", 1, 0, 0, 0, 1, 1));
			varArray.add(new Chord("F", "6/9", -1, -1, 3, 2, 3, 3));
			varArray.add(new Chord("F", "6/9", 8, 8, 7, 7, 8, 8));
			varArray.add(new Chord("F", "6/9", -1, 8, 7, 7, 8, 8));
			extMap.put("6/9", varArray);
			
			//F 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "7+9", 1, 3, 1, 2, 1, 4));
			varArray.add(new Chord("F", "7+9", -1, -1, 3, 2, 4, 4));
			varArray.add(new Chord("F", "7+9", -1, 8, 7, 8, 9, -1));
			extMap.put("7+9", varArray);
			
			//F 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "7-9", 1, -1, 1, 2, 1, 2));
			varArray.add(new Chord("F", "7-9", -1, -1, 3, 2, 4, 2));
			varArray.add(new Chord("F", "7-9", -1, 8, 7, 8, 7, -1));
			extMap.put("7-9", varArray);
			
			//F aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "aug", -1, 4, 3, 2, 2, -1));
			varArray.add(new Chord("F", "aug", 5, 4, 3, 2, -1, -1));
			varArray.add(new Chord("F", "aug", -1, -1, 3, 2, 2, 1));
			extMap.put("aug", varArray);
			
			//F 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "7+5", 1, -1, 1, 2, 2, 1));
			varArray.add(new Chord("F", "7+5", -1, 6, 7, 6, 6, -1));
			varArray.add(new Chord("F", "7+5", -1, 8, 11, 8, 10, 9));
			extMap.put("7+5", varArray);
			
			//F dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "dim", 1, 2, 0, 1, -1, -1));
			varArray.add(new Chord("F", "dim", -1, 2, 3, 1, 3, -1));
			varArray.add(new Chord("F", "dim", -1, -1, 0, 1, 0, 1));
			extMap.put("dim", varArray);
			
			//F -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "-5", 1, 2, 3, 2, 0, -1));
			varArray.add(new Chord("F", "-5", -1, -1, 3, 4, 6, 5));
			varArray.add(new Chord("F", "-5", -1, 8, 9, 10, 10, -1));
			extMap.put("-5", varArray);
			
			//F 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "7-5", 1, 2, 1, 2, 0, -1));
			varArray.add(new Chord("F", "7-5", -1, -1, 3, 4, 4, 5));
			varArray.add(new Chord("F", "7-5", -1, 8, 9, 8, 10, -1));
			extMap.put("7-5", varArray);
			
			//F 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F", "9-5", 1, 0, 1, 0, 0, 1));
			varArray.add(new Chord("F", "9-5", -1, -1, 3, 4, 4, 3));
			varArray.add(new Chord("F", "9-5", 7, 8, 7, 8, 8, 7));
			extMap.put("9-5", varArray);
			
			//F 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F", "11", -1, 3, 3, 3, 4, 3));
			varArray.add(new Chord("F", "11", -1, -1, 3, 3, 4, 3));
			varArray.add(new Chord("F", "11", 8, 8, 8, 8, 8, 8));
			varArray.add(new Chord("F", "11", -1, 8, 8, 8, 8, 8));
			varArray.add(new Chord("F", "11", 13, 11, 13, 12, 11, 11));
			extMap.put("11", varArray);
			
			//F 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F", "13", 1, -1, 1, 2, 3, 3));
			varArray.add(new Chord("F", "13", 8, 8, 7, 8, 8, 10));
			varArray.add(new Chord("F", "13", -1, 8, 7, 8, 8, 10));
			varArray.add(new Chord("F", "13", 13, -1, 13, 12, 10, 10));
			extMap.put("13", varArray);
			
			//F 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("F", "5", 1, 3, -1, -1, -1, -1));
			varArray.add(new Chord("F", "5", 1, 3, 3, -1, -1, -1));
			varArray.add(new Chord("F", "5", -1, 3, 3, -1, -1, -1));
			varArray.add(new Chord("F", "5", 13, 15, -1, -1, -1, -1));
			varArray.add(new Chord("F", "5", 13, 15, 15, -1, -1, -1));
			varArray.add(new Chord("F", "5", -1, 15, 15, 9, -1, -1));
			varArray.add(new Chord("F", "5", -1, 8, 10, -1, -1, -1));
			varArray.add(new Chord("F", "5", -1, 8, 10, 10, -1, -1));
			varArray.add(new Chord("F", "5", -1, -1, 3, 5, -1, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("F", extMap);
			
		//F#/Gb Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//F#/Gb Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "Major", 2, 4, 4, 3, 2, 2));
			varArray.add(new Chord("F#/Gb", "Major", -1, 9, 8, 6, 7, 6));
			varArray.add(new Chord("F#/Gb", "Major", -1, 9, 11, 11, 11, -1));
			extMap.put("Major", varArray);

			//F#/Gb /Bb
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("F#/Gb", "/Bb", 6, 9, 8, 6, 7, 6));
			varArray.add(new Chord("F#/Gb", "/Bb", -1, 1, 4, 3, 2, -1));
			extMap.put("/Bb", varArray);	
			
			//F#/Gb /Db
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "/Db", -1, 4, 4, 3, 2, 2));
			varArray.add(new Chord("F#/Gb", "/Db", 9, 9, 8, 6, 7, 6));
			varArray.add(new Chord("F#/Gb", "/Db", 9, 9, 11, 11, 11, 9));
			extMap.put("/Db", varArray);
			
			//F#/Gb 7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("F#/Gb", "7", 2, 4, 2, 3, 2, 2));
			varArray.add(new Chord("F#/Gb", "7", 9, 9, 8, 9, 7, -1));
			varArray.add(new Chord("F#/Gb", "7", -1, 9, 8, 9, 7, -1));
			varArray.add(new Chord("F#/Gb", "7", 9, 9, 11, 9, 11, 9));
			varArray.add(new Chord("F#/Gb", "7", -1, 9, 11, 9, 11, 9));
			varArray.add(new Chord("F#/Gb", "7", 2, -1, 2, 3, 2, -1));
			extMap.put("7", varArray);
			
			//F#/Gb m
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F#/Gb", "m", 2, 4, 4, 2, 2, 2));
			varArray.add(new Chord("F#/Gb", "m", -1, -1, 4, 6, 7, 5));
			varArray.add(new Chord("F#/Gb", "m", -1, 9, 11, 11, 10, 9));
			varArray.add(new Chord("F#/Gb", "m", 9, 9, 11, 11, 10, 9));
			varArray.add(new Chord("F#/Gb", "m", -1, 4, 4, 6, 7, 5));
			extMap.put("m", varArray);
			
			//F#/Gb m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F#/Gb", "m7", 2, 4, 2, 2, 2, 2));
			varArray.add(new Chord("F#/Gb", "m7", -1, 4, 4, 6, 5, 5));
			varArray.add(new Chord("F#/Gb", "m7", -1, -1, 4, 6, 5, 5));
			varArray.add(new Chord("F#/Gb", "m7", 9, 9, 11, 9, 10, 12));
			varArray.add(new Chord("F#/Gb", "m7", -1, 9, 11, 9, 10, 9));
			varArray.add(new Chord("F#/Gb", "m7", 2, -1, 2, 2, 2, -1));
			extMap.put("m7", varArray);
			
			//F#/Gb maj7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F#/Gb", "maj7", 2, 4, 3, 3, 2, -1));
			varArray.add(new Chord("F#/Gb", "maj7", 9, 9, 8, 6, 6, 6));
			varArray.add(new Chord("F#/Gb", "maj7", -1, 9, 8, 6, 6, 6));
			varArray.add(new Chord("F#/Gb", "maj7", 9, 9, 11, 10, 11, 9));
			varArray.add(new Chord("F#/Gb", "maj7", -1, 9, 11, 10, 11, 9));
			varArray.add(new Chord("F#/Gb", "maj7", 2, -1, 3, 3, 2, -1));
			extMap.put("maj7", varArray);
			
			//F#/Gb sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F#/Gb", "sus4", 2, 2, 4 ,4, 2, 2));
			varArray.add(new Chord("F#/Gb", "sus4", -1, 9, 9, 6, 7, -1));
			varArray.add(new Chord("F#/Gb", "sus4", 9, 9, 11, 11, 12, 9));
			varArray.add(new Chord("F#/Gb", "sus4", -1, 9, 11, 11, 12, 9));
			extMap.put("sus4", varArray);
			
			//F#/Gb 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F#/Gb", "7sus4", 2, 4, 2, 4, 2, 2));
			varArray.add(new Chord("F#/Gb", "7sus4", 9, 9, 9, 9, 7, -1));
			varArray.add(new Chord("F#/Gb", "7sus4", -1, 9, 9, 9, 7, -1));
			varArray.add(new Chord("F#/Gb", "7sus4", 9, 9, 11, 9, 12, 9));
			varArray.add(new Chord("F#/Gb", "7sus4", -1, 9, 11, 9, 12, 9));
			extMap.put("7sus4", varArray);
			
			//F#/Gb 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F#/Gb", "6", 2, -1, 4, 3, 4, 2));
			varArray.add(new Chord("F#/Gb", "6", -1, 9, 8, 8, 7, -1));
			varArray.add(new Chord("F#/Gb", "6", 9, 9, 11, 11, 11, 11));
			varArray.add(new Chord("F#/Gb", "6", -1, 9, 11, 11, 11, 11));
			extMap.put("6", varArray);
			
			//F#/Gb m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("F#/Gb", "m6", 2, 4, 4, 2, 4, 2));
			varArray.add(new Chord("F#/Gb", "m6", 2, -1, 4, 2, 4, 2));
			varArray.add(new Chord("F#/Gb", "m6", 9, 9, 7, 8, 7, -1));
			varArray.add(new Chord("F#/Gb", "m6", -1, 9, 7, 8, 7, -1));
			varArray.add(new Chord("F#/Gb", "m6", 9, 9, 11, 11, 10, 11));
			varArray.add(new Chord("F#/Gb", "m6", -1, 9, -1, 11, 10, 11));
			extMap.put("m6", varArray);

			//F#/Gb 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F#/Gb", "9", -1, -1, 2, 1, 2, 2));
			varArray.add(new Chord("F#/Gb", "9", -1, -1, 4, 6, 5, 4));
			varArray.add(new Chord("F#/Gb", "9", 9, 9, 8, 9, 9, 9));
			varArray.add(new Chord("F#/Gb", "9", -1, 9, 8, 9, 9, -1));
			extMap.put("9", varArray);
			
			//F#/Gb m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F#/Gb", "m9", 2, 4, 2, 2, 2, 4));
			varArray.add(new Chord("F#/Gb", "m9", -1, -1, 4, 2, 5, 4));
			varArray.add(new Chord("F#/Gb", "m9", 9, 9, 7, 9, 9, 9));
			varArray.add(new Chord("F#/Gb", "m9", -1, 9, 7, 9, 9, -1));
			extMap.put("m9", varArray);
			
			//F#/Gb maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "maj9", -1, -1, 4, 1, 2, 1));
			varArray.add(new Chord("F#/Gb", "maj9", -1, 9, 6, 6, 6, 6));
			varArray.add(new Chord("F#/Gb", "maj9", -1, 9, 8, 10, 9, -1));
			extMap.put("maj9", varArray);
			
			//F#/Gb 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("F#/Gb", "6/9", 2, 1, 1, 1, 2, 2));
			varArray.add(new Chord("F#/Gb", "6/9", -1, -1, 4, 3, 4, 4));
			varArray.add(new Chord("F#/Gb", "6/9", 9, 9, 8, 8, 9, 9));
			varArray.add(new Chord("F#/Gb", "6/9", -1, 9, 8, 8, 9, 9));
			extMap.put("6/9", varArray);
			
			//F#/Gb 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "7+9", 2, 1, 2, 2, 2, -1));
			varArray.add(new Chord("F#/Gb", "7+9", 2, 4, 2, 3, 2, 5));
			varArray.add(new Chord("F#/Gb", "7+9", -1, 9, 8, 9, 10, -1));
			extMap.put("7+9", varArray);
			
			//F#/Gb 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "7-9", 2, -1, 2, 3, 2, 3));
			varArray.add(new Chord("F#/Gb", "7-9", -1, -1, 4, 3, 5, 3));
			varArray.add(new Chord("F#/Gb", "7-9", -1, 9, 8, 9, 8, -1));
			extMap.put("7-9", varArray);
			
			//F#/Gb aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "aug", -1, 5, 4, 3, 3, -1));
			varArray.add(new Chord("F#/Gb", "aug", 6, 5, 4, 3, -1, -1));
			varArray.add(new Chord("F#/Gb", "aug", -1, -1, 4, 3, 3, 2));
			extMap.put("aug", varArray);
			
			//F#/Gb 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "7+5", 2, -1, 2, 3, 3, 2));
			varArray.add(new Chord("F#/Gb", "7+5", -1, 7, 8, 7, 7, -1));
			varArray.add(new Chord("F#/Gb", "7+5", -1, 9, 12, 9, 11, 10));
			extMap.put("7+5", varArray);
			
			//F#/Gb dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "dim", 2, 3, 1, 2, -1, -1));
			varArray.add(new Chord("F#/Gb", "dim", -1, 3, 4, 2, 4, -1));
			varArray.add(new Chord("F#/Gb", "dim", -1, -1, 1, 2, 1, 2));
			extMap.put("dim", varArray);
			
			//F#/Gb -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "-5", 2, 3, 4, 3, -1, -1));
			varArray.add(new Chord("F#/Gb", "-5", -1, -1, 4, 5, 7, 6));
			varArray.add(new Chord("F#/Gb", "-5", -1, 9, 10, 11, 11, -1));
			extMap.put("-5", varArray);
			
			//F#/Gb 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "7-5", 2, 3, 2, 3, -1, -1));
			varArray.add(new Chord("F#/Gb", "7-5", -1, -1, 4, 5, 5, 6));
			varArray.add(new Chord("F#/Gb", "7-5", -1, 9, 10, 9, 11, -1));
			extMap.put("7-5", varArray);
			
			//F#/Gb 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("F#/Gb", "9-5", 2, 1, 2, 1, 1, 2));
			varArray.add(new Chord("F#/Gb", "9-5", -1, -1, 4, 5, 5, 4));
			varArray.add(new Chord("F#/Gb", "9-5", 8, 9, 8, 9, 9, 8));
			extMap.put("9-5", varArray);
			
			//F#/Gb 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F#/Gb", "11", 2, -1, 2, 1, 0, 0));
			varArray.add(new Chord("F#/Gb", "11", -1, 4, 4, 4, 5, 4));
			varArray.add(new Chord("F#/Gb", "11", -1, -1, 4, 4, 5, 4));
			varArray.add(new Chord("F#/Gb", "11", 9, 9, 9, 9, 9, 9));
			varArray.add(new Chord("F#/Gb", "11", -1, 9, 9, 9, 9, 9));
			extMap.put("11", varArray);
			
			//F#/Gb 13
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("F#/Gb", "13", 2, -1, 2, 3, 4, 4));
			varArray.add(new Chord("F#/Gb", "13", 9, 9, 8, 9, 9, 11));
			varArray.add(new Chord("F#/Gb", "13", -1, 9, 8, 9, 9, 11));
			varArray.add(new Chord("F#/Gb", "13", 9, 9, 11, 9, 9, 11));
			varArray.add(new Chord("F#/Gb", "13", -1, 9, 11, 9, 9, 11));
			extMap.put("13", varArray);
			
			//F#/Gb 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("F#/Gb", "5", 2, 4, -1, -1, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", 2, 4, 4, -1, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, 4, 4, -1, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, 9, 11, -1, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, 9, 11, 11, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, -1, 11, 11, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, -1, 4, 6, -1, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, -1, 4, 6, 7, -1));
			varArray.add(new Chord("F#/Gb", "5", -1, -1, -1, 6, 7, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("F#/Gb", extMap);
		
		//G Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//G Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "Major", 3, 2, 0, 0, 0, 3));
			varArray.add(new Chord("G", "Major", 3, 5, 5, 4, 3, 3));
			varArray.add(new Chord("G", "Major", -1, 10, 9, 7, 8, 7));
			extMap.put("Major", varArray);

			//G /B
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("G", "/B", -1, 2, 0, 0, 0, 3));
			extMap.put("/B", varArray);	
			
			//G /D
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "/D", -1, -1, 0, 0, 0, 3));
			varArray.add(new Chord("G", "/D", -1, 5, 5, 4, 3, 3));
			varArray.add(new Chord("G", "/D", 10, 10, 9, 7, 8, 7));
			extMap.put("/D", varArray);
			
			//G 7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G", "7", 3, 2, 0, 0, 0, 1));
			varArray.add(new Chord("G", "7", 3, 5, 2, 4, 2, 3));
			varArray.add(new Chord("G", "7", 10, 10, 9, 10, 8, -1));
			varArray.add(new Chord("G", "7", -1, 10, 9, 10, 8, -1));
			varArray.add(new Chord("G", "7", 3, -1, 3, 4, 3, -1));
			extMap.put("7", varArray);
			
			//G m
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G", "m", 3, 5, 5, 3, 3, 3));
			varArray.add(new Chord("G", "m", -1, -1, 5, 7, 8, 6));
			varArray.add(new Chord("G", "m", -1, 10, 12, 12, 11, 10));
			varArray.add(new Chord("G", "m", -1, 5, 5, 7, 8, 6));
			varArray.add(new Chord("G", "m", 10, 10, 12, 12, 11, 10));
			extMap.put("m", varArray);
			
			//G m7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("G", "m7", 3, 5, 5, 3, 6, 3));
			varArray.add(new Chord("G", "m7", 3, 5, 3, 3, 6, 3));
			varArray.add(new Chord("G", "m7", -1, 5, 5, 7, 6, 6));
			varArray.add(new Chord("G", "m7", -1, -1, 5, 7, 6, 6));
			varArray.add(new Chord("G", "m7", 10, 10, 12, 10, 11, 13));
			varArray.add(new Chord("G", "m7", -1, 10, 12, 10, 11, 10));
			varArray.add(new Chord("G", "m7", 3, -1, 3, 3, 3, -1));
			extMap.put("m7", varArray);
			
			//G maj7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("G", "maj7", 3, 2, 0, 0, 0, 2));
			varArray.add(new Chord("G", "maj7", -1, -1, 5, 4, 3, 2));
			varArray.add(new Chord("G", "maj7", 3, 5, 4, 4, 3, -1));
			varArray.add(new Chord("G", "maj7", 10, 10, 9, 7, 7, 7));
			varArray.add(new Chord("G", "maj7", -1, 10, 9, 7, 7, 7));
			varArray.add(new Chord("G", "maj7", -3, -1, 4, 4, 3, -1));
			extMap.put("maj7", varArray);
			
			//G sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "sus4", 3, -1, 0, 0, 1, 3));
			varArray.add(new Chord("G", "sus4", 3, 3, 5, 5, 3, 3));
			varArray.add(new Chord("G", "sus4", 10, 10, 12, 12, 13, 10));
			varArray.add(new Chord("G", "sus4", -1, 10, 12, 12, 13, 10));
			extMap.put("sus4", varArray);
			
			//G 7sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "7sus4", 3, -1, 3, 0, 1, -1));
			varArray.add(new Chord("G", "7sus4", 3, 5, 3, 5, 3, 3));
			varArray.add(new Chord("G", "7sus4", 10, 10, 10, 10, 8, -1));
			varArray.add(new Chord("G", "7sus4", -1, 10, 10, 10, 8, -1));
			extMap.put("7sus4", varArray);
			
			//G 6
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "6", 3, 2, 0, 0, 0, 0));
			varArray.add(new Chord("G", "6", 3, -1, 5, 4, 5, 3));
			varArray.add(new Chord("G", "6", -1, 10, 9, 9, 8, -1));
			extMap.put("6", varArray);
			
			//G m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("G", "m6", 3, 5, 5, 3, 5, 3));
			varArray.add(new Chord("G", "m6", 3, -1, 5, 3, 5, 3));
			varArray.add(new Chord("G", "m6", 10, 10, 8, 9, 8, -1));
			varArray.add(new Chord("G", "m6", -1, 10, 8, 9, 8, -1));
			varArray.add(new Chord("G", "m6", 10, 10, 12, 12, 11, 12));
			varArray.add(new Chord("G", "m6", -1, 10, -1, 12, 11, 12));
			extMap.put("m6", varArray);

			//G 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "9", -1, 2, 3, 2, 3, -1));
			varArray.add(new Chord("G", "9", -1, -1, 3, 2, 3, 3));
			varArray.add(new Chord("G", "9", 10, 10, 9, 10, 10, 10));
			varArray.add(new Chord("G", "9", -1, 10, 9, 10, 10, -1));
			extMap.put("9", varArray);
			
			//G m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "m9", 3, 1, 3, 2, -1, -1));
			varArray.add(new Chord("G", "m9", 3, 5, 3, 3, 3, 5));
			varArray.add(new Chord("G", "m9", 10, 10, 8, 10, 10, 10));
			varArray.add(new Chord("G", "m9", -1, 10, 8, 10, 10, -1));
			extMap.put("m9", varArray);
			
			//G maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "maj9", 3, 2, 4, 2, 3, -1));
			varArray.add(new Chord("G", "maj9", -1, -1, 5, 2, 3, 2));
			varArray.add(new Chord("G", "maj9", -1, 10, 9, 11, 10, -1));
			extMap.put("maj9", varArray);
			
			//G 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "6/9", 3, 2, 2, 2, 3, 3));
			varArray.add(new Chord("G", "6/9", -1, -1, 5, 4, 5, 5));
			varArray.add(new Chord("G", "6/9", 10, 10, 9, 9, 10, 10));
			varArray.add(new Chord("G", "6/9", -1, 10, 9, 9, 10, 10));
			extMap.put("6/9", varArray);
			
			//G 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "7+9", 3, 2, 3, 3, 3, -1));
			varArray.add(new Chord("G", "7+9", 3, 5, 3, 4, 3, 6));
			varArray.add(new Chord("G", "7+9", -1, 10, 9, 10, 11, -1));
			extMap.put("7+9", varArray);
			
			//G 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "7-9", 3, 2, 3, 1, 0, -1));
			varArray.add(new Chord("G", "7-9", 3, -1, 3, 4, 3, 4));
			varArray.add(new Chord("G", "7-9", -1, 10, 9, 10, 9, -1));
			extMap.put("7-9", varArray);
			
			//G aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "aug", -1, 2, 1, 0, 0, -1));
			varArray.add(new Chord("G", "aug", 3, 2, 1, 0, -1, -1));
			varArray.add(new Chord("G", "aug", -1, -1, 5, 4, 4, 3));
			extMap.put("aug", varArray);
			
			//G 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "7+5", 3, -1, 3, 4, 4, 3));
			varArray.add(new Chord("G", "7+5", -1, 8, 9, 8, 8, -1));
			varArray.add(new Chord("G", "7+5", -1, 10, 13, 10, 12, 11));
			extMap.put("7+5", varArray);
			
			//G dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "dim", 3, 4, 2, 3, -1, -1));
			varArray.add(new Chord("G", "dim", -1, 1, 2, 0, 2, -1));
			varArray.add(new Chord("G", "dim", -1, -1, 2, 3, 2, 3));
			extMap.put("dim", varArray);
			
			//G -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "-5", -1, -1, 5, 4, 2, 3));
			varArray.add(new Chord("G", "-5", -1, -1, 5, 6, 8, 7));
			varArray.add(new Chord("G", "-5", -1, 10, 11, 12, 12, -1));
			extMap.put("-5", varArray);
			
			//G 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "7-5", 3, 4, 3, 4, 0, -1));
			varArray.add(new Chord("G", "7-5", -1, -1, 5, 6, 6, 7));
			varArray.add(new Chord("G", "7-5", -1, 10, 11, 10, 12, -1));
			extMap.put("7-5", varArray);
			
			//G 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G", "9-5", 3, 2, 3, 2, 2, 3));
			varArray.add(new Chord("G", "9-5", -1, -1, 5, 6, 6, 5));
			varArray.add(new Chord("G", "9-5", 9, 10, 9, 10, 10, 9));
			extMap.put("9-5", varArray);
			
			//G 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G", "11", 3, -1, 3, 2, 1, 1));
			varArray.add(new Chord("G", "11", -1, 5, 5, 5, 6, 5));
			varArray.add(new Chord("G", "11", -1, -1, 5, 5, 6, 5));
			varArray.add(new Chord("G", "11", 10, 10, 10, 10, 10, 10));
			varArray.add(new Chord("G", "11", -1, 10, 10, 10, 10, 10));
			extMap.put("11", varArray);
			
			//G 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G", "13", 3, -1, 3, 2, 0, 0));
			varArray.add(new Chord("G", "13", 3, -1, 3, 4, 5, 5));
			varArray.add(new Chord("G", "13", 10, 10, 9, 10, 10, 12));
			varArray.add(new Chord("G", "13", -1, 10, 9, 10, 10, 12));
			extMap.put("13", varArray);
			
			//G 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("G", "5", 3, 5, -1, -1, -1, -1));
			varArray.add(new Chord("G", "5", 3, 5, 5, -1, -1, -1));
			varArray.add(new Chord("G", "5", -1, 5, 5, -1, -1, -1));
			varArray.add(new Chord("G", "5", -1, 10, 12, -1, -1, -1));
			varArray.add(new Chord("G", "5", -1, 10, 12, 12, -1, -1));
			varArray.add(new Chord("G", "5", -1, -1, 12, 12, -1, -1));
			varArray.add(new Chord("G", "5", -1, -1, 5, 7, -1, -1));
			varArray.add(new Chord("G", "5", -1, -1, 5, 7, 8, -1));
			varArray.add(new Chord("G", "5", -1, -1, -1, 7, 8, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("G", extMap);
		
		//G#/Ab Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//G#/Ab Major
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("G#/Ab", "Major", 4, 6, 6, 5, 4, 4));
			varArray.add(new Chord("G#/Ab", "Major", -1, 11, 10, 8, 9, 8));
			extMap.put("Major", varArray);

			//G#/Ab /C
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("G#/Ab", "/C", -1, 3, 1, 1, 1, -1));
			extMap.put("/C", varArray);	
			
			//G#/Ab /Eb
			varArray = new ArrayList<Chord>(2);
			varArray.add(new Chord("G#/Ab", "/Eb", -1, -1, 1, 1, 1, 4));
			varArray.add(new Chord("G#/Ab", "/Eb", 11, 11, 10, 8, 9, 8));
			extMap.put("/Eb", varArray);
			
			//G#/Ab 7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G#/Ab", "7", -1, -1, 1, 1, 1, 2));
			varArray.add(new Chord("G#/Ab", "7", 4, 6, 4, 5, 4, 4));
			varArray.add(new Chord("G#/Ab", "7", 11, 11, 13, 11, 13, 11));
			varArray.add(new Chord("G#/Ab", "7", -1, 11, 13, 11, 13, 11));
			varArray.add(new Chord("G#/Ab", "7", 4, -1, 4, 5, 4,-1));
			extMap.put("7", varArray);
			
			//G#/Ab m
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G#/Ab", "m", 4, 6, 6, 4, 4, 4));
			varArray.add(new Chord("G#/Ab", "m", -1, -1, 6, 8, 9, 7));
			varArray.add(new Chord("G#/Ab", "m", -1, 11, 13, 13, 12, 11));
			varArray.add(new Chord("G#/Ab", "m", -1, 6, 6, 8, 9, 7));
			varArray.add(new Chord("G#/Ab", "m", 11, 11, 13, 13, 12, 11));
			extMap.put("m", varArray);
			
			//G#/Ab m7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("G#/Ab", "m7", 4, 6, 6, 4, 7, 4));
			varArray.add(new Chord("G#/Ab", "m7", 4, 6, 4, 4, 7, 4));
			varArray.add(new Chord("G#/Ab", "m7", -1, 6, 6, 8, 7, 7));
			varArray.add(new Chord("G#/Ab", "m7", -1, -1, 6, 8, 7, 7));
			varArray.add(new Chord("G#/Ab", "m7", 11, 11, 13, 11, 12, 14));
			varArray.add(new Chord("G#/Ab", "m7", -1, 11, 13, 11, 12, 11));
			varArray.add(new Chord("G#/Ab", "m7", 4, -1, 4, 4, 4, -1));
			extMap.put("m7", varArray);
			
			//G#/Ab maj7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G#/Ab", "maj7", -1, -1, 6, 5, 4, 3));
			varArray.add(new Chord("G#/Ab", "maj7", 4, 6, 5, 5, 4, -1));
			varArray.add(new Chord("G#/Ab", "maj7", 11, 11, 10, 8, 8, 8));
			varArray.add(new Chord("G#/Ab", "maj7", -1, 11, 10, 8, 8, 8));
			varArray.add(new Chord("G#/Ab", "maj7", 4, -1, 4, 5, 4, -1));
			extMap.put("maj7", varArray);
			
			//G#/Ab sus4
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "sus4", -1, -1, 1, 1, 2, 4));
			varArray.add(new Chord("G#/Ab", "sus4", 4, 4, 6, 6, 4, 4));
			varArray.add(new Chord("G#/Ab", "sus4", -1, -1, 6, 8, 9, 9));
			extMap.put("sus4", varArray);
			
			//G#/Ab 7sus4
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "7sus4", -1, -1, 1, 1, 2, 2));
			varArray.add(new Chord("G#/Ab", "7sus4", 4, 6, 4, 6, 4, 4));
			varArray.add(new Chord("G#/Ab", "7sus4", -1, -1, 6, 8, 7, 9));
			extMap.put("7sus4", varArray);
			
			//G#/Ab 6
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "6", -1, -1, 1, 1, 1, 1));
			varArray.add(new Chord("G#/Ab", "6", 4, -1, 6, 5, 6, 4));
			varArray.add(new Chord("G#/Ab", "6", -1, 11, 10, 10, 9, -1));
			extMap.put("6", varArray);
			
			//G#/Ab m6
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G#/Ab", "m6", -1, -1, 1, 1, 0, 1));
			varArray.add(new Chord("G#/Ab", "m6", 4, 6, 6, 4, 6, 4));
			varArray.add(new Chord("G#/Ab", "m6", 4, -1, 6, 4, 6, 4));
			varArray.add(new Chord("G#/Ab", "m6", 11, 11, 9, 10, 9, -1));
			varArray.add(new Chord("G#/Ab", "m6", -1, 11, 9, 10, 9, -1));
			extMap.put("m6", varArray);

			//G#/Ab 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G#/Ab", "9", -1, 3, 4, 3, 4, -1));
			varArray.add(new Chord("G#/Ab", "9", -1, -1, 4 ,3, 4, 4));
			varArray.add(new Chord("G#/Ab", "9", 11, 11, 10, 11, 11, 11));
			varArray.add(new Chord("G#/Ab", "9", -1, 11, 10, 11, 11, -1));
			extMap.put("9", varArray);
			
			//G#/Ab m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G#/Ab", "m9", 4, 6, 4, 4, 4, 6));
			varArray.add(new Chord("G#/Ab", "m9", -1, -1, 6, 4, 7, 6));
			varArray.add(new Chord("G#/Ab", "m9", 11, 11, 9, 11, 11, 11));
			varArray.add(new Chord("G#/Ab", "m9", -1, 11, 9, 11, 11, -1));
			extMap.put("m9", varArray);
			
			//G#/Ab maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "maj9", 4, 3, 5, 3, 4, -1));
			varArray.add(new Chord("G#/Ab", "maj9", -1, -1, 6, 3, 4, 3));
			varArray.add(new Chord("G#/Ab", "maj9", -1, 11, 10, 12, 11, -1));
			extMap.put("maj9", varArray);
			
			//G#/aB 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G#/Ab", "6/9", 4, 3, 3, 3, 4, 4));
			varArray.add(new Chord("G#/Ab", "6/9", -1, -1, 6, 5, 6, 6));
			varArray.add(new Chord("G#/Ab", "6/9", 11, 11, 10, 10, 11, 11));
			varArray.add(new Chord("G#/Ab", "6/9", -1, 11, 10, 10, 11, 11));
			extMap.put("6/9", varArray);
			
			//G#/Ab 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "7+9", 4, 3, 4, 4, 4, -1));
			varArray.add(new Chord("G#/Ab", "7+9", 4, 6, 4, 5, 4, 7));
			varArray.add(new Chord("G#/Ab", "7+9", -1, 11, 10, 11, 12, -1));
			extMap.put("7+9", varArray);
			
			//G#/Ab 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "7-9", 4, 3, 4, 2, -1, -1));
			varArray.add(new Chord("G#/Ab", "7-9", 4, -1, 4, 5, 4, 5));
			varArray.add(new Chord("G#/Ab", "7-9", -1, 11, 10, 11, 10, -1));
			extMap.put("7-9", varArray);
			
			//G#/Ab aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "aug", -1, 3, 2, 1, 1, -1));
			varArray.add(new Chord("G#/Ab", "aug", 4, 3, 2, 1, -1, -1));
			varArray.add(new Chord("G#/Ab", "aug", -1, -1, 6, 5, 5, 4));
			extMap.put("aug", varArray);
			
			//G#/Ab 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "7+5", 4, -1, 4, 5, 5, 4));
			varArray.add(new Chord("G#/Ab", "7+5", -1, 9, 10, 9, 9, -1));
			varArray.add(new Chord("G#/Ab", "7+5", -1, 11, 14, 11, 13, 12));
			extMap.put("7+5", varArray);
			
			//G#/Ab dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "dim", 1, 2, 0, 1, -1, -1));
			varArray.add(new Chord("G#/Ab", "dim", -1, 2, 3, 1, 3, -1));
			varArray.add(new Chord("G#/Ab", "dim", -1, -1, 0, 1, 0, 1));
			extMap.put("dim", varArray);
			
			//G#/Ab -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "-5", -1, -1, 6, 5, 3, 4));
			varArray.add(new Chord("G#/Ab", "-5", 4, 5, 6, 5, -1, -1));
			varArray.add(new Chord("G#/Ab", "-5", -1, 11, 12, 13, 13, -1));
			extMap.put("-5", varArray);
			
			//G#/Ab 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "7-5", -1, -1, 4, 5, 3, 4));
			varArray.add(new Chord("G#/Ab", "7-5", 4, 5, 4, 5, -1, -1));
			varArray.add(new Chord("G#/Ab", "7-5", -1, -1, 6, 7, 7, 8));
			extMap.put("7-5", varArray);
			
			//G#/Ab 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("G#/Ab", "9-5", 4, 3, 4, 3, 3, 4));
			varArray.add(new Chord("G#/Ab", "9-5", -1, -1, 6, 7, 7, 6));
			varArray.add(new Chord("G#/Ab", "9-5", 10, 11, 10, 11, 11, 10));
			extMap.put("9-5", varArray);
			
			//G#/Ab 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("G#/Ab", "11", 4, -1, 4, 3, 2, 2));
			varArray.add(new Chord("G#/Ab", "11", -1, 6, 6, 6, 7, 6));
			varArray.add(new Chord("G#/Ab", "11", -1, -1, 6, 6, 7, 6));
			varArray.add(new Chord("G#/Ab", "11", 11, 11, 11, 11, 11, 11));
			varArray.add(new Chord("G#/Ab", "11", -1, 11, 11, 11, 11, 11));
			extMap.put("11", varArray);
			
			//G#/Ab 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("G#/Ab", "13", 4, -1, 4, 3, 1, 1));
			varArray.add(new Chord("G#/Ab", "13", 4, -1, 4, 5, 6, 6));
			varArray.add(new Chord("G#/Ab", "13", 11, 11, 10, 11, 11, 13));
			varArray.add(new Chord("G#/Ab", "13", -1, 11, 10, 11, 11, 13));
			extMap.put("13", varArray);
			
			//G#/Ab 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("G#/Ab", "5", 4, 6, -1, -1, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", 4, 6, 6, -1, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, 6, 6, -1, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, 11, 13, -1, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, 11, 13, 13, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, -1, 13, 13, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, -1, 6, 8, -1, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, -1, 6, 8, 9, -1));
			varArray.add(new Chord("G#/Ab", "5", -1, -1, -1, 8, 9, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("G#/Ab", extMap);
		
		//A Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//A Major
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A", "Major", -1, 0, 2, 2, 2, 0));
			varArray.add(new Chord("A", "Major", 5, 7, 7, 6, 5, 5));
			varArray.add(new Chord("A", "Major", -1, 12, 11, 9, 10, 9));
			varArray.add(new Chord("A", "Major", 12, 12, 11, 9, 10, 9));
			extMap.put("Major", varArray);

			//A /C#
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("A", "/C#", -1, 4, 2, 2, 2, -1));
			extMap.put("/C#", varArray);	
			
			//A /E
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("A", "/E", 0, 0, 2, 2, 2, 0));
			extMap.put("/E", varArray);
			
			//A 7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A", "7", -1, 0, 2, 0, 2, 0));
			varArray.add(new Chord("A", "7", 5, 7, 5, 6, 5, 5));
			varArray.add(new Chord("A", "7", -1, 12, 11, 12, 10, 0));
			varArray.add(new Chord("A", "7", 12, 12, 11, 12, 10, 0));
			varArray.add(new Chord("A", "7", 5, -1, 5, 6, 5, -1));
			extMap.put("7", varArray);
			
			//A m
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "m", -1, 0, 2, 2, 1, 0));
			varArray.add(new Chord("A", "m", 5, 7, 7, 5, 5, 5));
			varArray.add(new Chord("A", "m", -1, 0, 7, 9, 10, 8));
			extMap.put("m", varArray);
			
			//A m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("A", "m7", -1, 0, 2, 0, 1, 3));
			varArray.add(new Chord("A", "m7", -1, 0, 2, 0, 1, 0));
			varArray.add(new Chord("A", "m7", 5, 7, 7, 5, 8, 5));
			varArray.add(new Chord("A", "m7", 5, 7, 5, 5, 8, 5));
			varArray.add(new Chord("A", "m7", -1, 0, 7, 9, 8, 8));
			varArray.add(new Chord("A", "m7", 5, -1, 5, 5, 5, -1));
			extMap.put("m7", varArray);
			
			//A maj7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A", "maj7", -1, 0, 2, 1, 2, 0));
			varArray.add(new Chord("A", "maj7", -1, 0, 7, 6, 5, 4));
			varArray.add(new Chord("A", "maj7", -1, 12, 11, 9, 9, 9));
			varArray.add(new Chord("A", "maj7", 12, 12, 11, 9, 9, 9));
			varArray.add(new Chord("A", "maj7", 5, -1, 6, 6, 5, -1));
			extMap.put("maj7", varArray);
			
			//A sus4
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "sus4", -1, 0, 2, 2, 3, 0));
			varArray.add(new Chord("A", "sus4", -1, 0, 7, 7, 5, 5));
			varArray.add(new Chord("A", "sus4", -1, 0, 7, 9, 10, 10));
			extMap.put("sus4", varArray);
			
			//A 7sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A", "7sus4", -1, 0, 2, 0, 3, 0));
			varArray.add(new Chord("A", "7sus4", -1, 0, 2, 0, 3, 3));
			varArray.add(new Chord("A", "7sus4", 5, 7, 5, 7, 5, 5));
			varArray.add(new Chord("A", "7sus4", -1, 0, 7, 7, 8, 10));
			extMap.put("7sus4", varArray);
			
			//A 6
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "6", -1, 0, 2, 2, 2, 2));
			varArray.add(new Chord("A", "6", 5, -1, 7, 6, 7, 5));
			varArray.add(new Chord("A", "6", -1, 0, 11, 11, 10, 0));
			extMap.put("6", varArray);
			
			//A m6
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "m6", -1, 0, 2, 2, 1, 2));
			varArray.add(new Chord("A", "m6", 5, 7, 7, 5, 7, 5));
			varArray.add(new Chord("A", "m6", -1, 0, 10, 11, 10, 0));
			extMap.put("m6", varArray);

			//A 9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "9", -1, 0, 2, 4, 2, 3));
			varArray.add(new Chord("A", "9", -1, 0, 5, 4, 5, 5));
			varArray.add(new Chord("A", "9", -1, 0, 5, 6, 5, 7));
			extMap.put("9", varArray);
			
			//A m9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "m9", -1, 0, 2, 4, 1, 3));
			varArray.add(new Chord("A", "m9", -1, 0, 5, 5, 5, 7));
			varArray.add(new Chord("A", "m9", -1, 12, 10, 12, 12, 0));
			extMap.put("m9", varArray);
			
			//A maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "maj9", -1, 0, 2, 1, 0, 0));
			varArray.add(new Chord("A", "maj9", 5, 4, 6, 4, 5, -1));
			varArray.add(new Chord("A", "maj9", -1, 12, 11, 13, 12, 0));
			extMap.put("maj9", varArray);
			
			//A 6/9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "6/9", -1, 0, 4, 2, 0, 0));
			varArray.add(new Chord("A", "6/9", -1, 0, 4, 4, 5, 5));
			varArray.add(new Chord("A", "6/9", -1, 0, 7, 6, 7, 7));
			extMap.put("6/9", varArray);
			
			//A 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "7+9", -1, 0, 2, 5, 2, 3));
			varArray.add(new Chord("A", "7+9", -1, 0, 5, 6, 5, 8));
			varArray.add(new Chord("A", "7+9", -1, 12, 11, 12, 13, 0));
			extMap.put("7+9", varArray);
			
			//A 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "7-9", 5, 4, 5, 3, -1, -1));
			varArray.add(new Chord("A", "7-9", 5, -1, 5, 6, 5, 6));
			varArray.add(new Chord("A", "7-9", -1, 0, 11, 12, 11, 0));
			extMap.put("7-9", varArray);
			
			//A aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "aug", -1, 4, 3, 2, 2, -1));
			varArray.add(new Chord("A", "aug", 5, 4, 3, 2, -1, -1));
			varArray.add(new Chord("A", "aug", -1, -1, 3, 2, 2, 1));
			extMap.put("aug", varArray);
			
			//A 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "7+5", -1, 0, 3, 0, 2, 1));
			varArray.add(new Chord("A", "7+5", 5, -1, 5, 6, 6, 5));
			varArray.add(new Chord("A", "7+5", -1, 10, 11, 10, 10, -1));
			extMap.put("7+5", varArray);
			
			//A dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "dim", 2, 3, 1, 2, -1, -1));
			varArray.add(new Chord("A", "dim", -1, 3, 4, 2, 4, -1));
			varArray.add(new Chord("A", "dim", -1, -1, 1, 2, 1, 2));
			extMap.put("dim", varArray);
			
			//A -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "-5", -1, 0, 1, 2, 2, -1));
			varArray.add(new Chord("A", "-5", -1, 0, 7, 6, 4, 5));
			varArray.add(new Chord("A", "-5", -1, 0, 7, 8, 10, 9));
			extMap.put("-5", varArray);
			
			//A 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "7-5", -1, 0, 1, 0, 2, -1));
			varArray.add(new Chord("A", "7-5", -1, 0, 5, 6, 4, 5));
			varArray.add(new Chord("A", "7-5", -1, 0, 7, 8, 8, 9));
			extMap.put("7-5", varArray);
			
			//A 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "9-5", -1, 0, 1, 0, 0, -1));
			varArray.add(new Chord("A", "9-5", 5, 4, 5, 4, 4, 5));
			varArray.add(new Chord("A", "9-5", -1, 0, 7, 8, 8, 7));
			extMap.put("9-5", varArray);
			
			//A 11
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "11", -1, 0, 0, 0, 0, 0));
			varArray.add(new Chord("A", "11", 1, 0, 5, 4, 3, 3));
			varArray.add(new Chord("A", "11", -1, 0, 7, 7, 8, 7));
			extMap.put("11", varArray);
			
			//A 13
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A", "13", -1, 0, 5, 4, 2, 2));
			varArray.add(new Chord("A", "13", 5, -1, 5, 6, 7, 7));
			varArray.add(new Chord("A", "13", -1, 0, 11, 12, 12, 14));
			extMap.put("13", varArray);
			
			//A 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("A", "5", 5, 7, -1, -1, -1, -1));
			varArray.add(new Chord("A", "5", 5, 7, 7, -1, -1, -1));
			varArray.add(new Chord("A", "5", -1, 7, 7, -1, -1, -1));
			varArray.add(new Chord("A", "5", -1, 0, 2, -1, -1, -1));
			varArray.add(new Chord("A", "5", -1, 0, 2, 2, -1, -1));
			varArray.add(new Chord("A", "5", -1, -1, 2, 2, -1, -1));
			varArray.add(new Chord("A", "5", -1, -1, 7, 9, -1, -1));
			varArray.add(new Chord("A", "5", -1, -1, 7, 9, 10, -1));
			varArray.add(new Chord("A", "5", -1, -1, -1, 9, 10, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("A", extMap);
		
		//A#/Bb Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//A#/Bb Major
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A#/Bb", "Major", -1, 1, 3, 3, 3, 1));
			varArray.add(new Chord("A#/Bb", "Major", 1, 1, 3, 3, 3, 1));
			varArray.add(new Chord("A#/Bb", "Major", 6, 8, 8, 7, 6, 6));
			varArray.add(new Chord("A#/Bb", "Major", -1, 13, 12, 10, 11, 10));
			varArray.add(new Chord("A#/Bb", "Major", 13, 13, 12, 10, 11, 10));
			extMap.put("Major", varArray);

			//A#/Bb /D
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("A#/Bb", "/D", -1, 5, 3, 3, 3, -1));
			extMap.put("/D", varArray);	
			
			//A#/Bb /F
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("A#/Bb", "/F", 1, 1, 3, 3, 3, -1));
			extMap.put("/F", varArray);
			
			//A#/Bb 7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A#/Bb", "7", -1, 1, 3, 1, 3, 1));
			varArray.add(new Chord("A#/Bb", "7", 1, 1, 3, 1, 3, 1));
			varArray.add(new Chord("A#/Bb", "7", 6, 8, 6, 7, 6, 6));
			varArray.add(new Chord("A#/Bb", "7", -1, -1, 8, 10, 9, 10));
			varArray.add(new Chord("A#/Bb", "7", 6, -1, 6, 7, 6, -1));
			extMap.put("7", varArray);
			
			//A#/Bb m
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "m", -1, 1, 3, 3, 2, 1));
			varArray.add(new Chord("A#/Bb", "m", 6, 8, 8, 6, 6, 6));
			varArray.add(new Chord("A#/Bb", "m", -1, -1, 8, 10, 11, 9));
			varArray.add(new Chord("A#/Bb", "m", 1, 1, 3, 3, 2, 1));
			extMap.put("m", varArray);
			
			//A#/Bb m7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("A#/Bb", "m7", 1, 1, 3, 1, 2, 4));
			varArray.add(new Chord("A#/Bb", "m7", -1, 1, 3, 1, 2, 1));
			varArray.add(new Chord("A#/Bb", "m7", 6, 8, 8, 6, 9, 6));
			varArray.add(new Chord("A#/Bb", "m7", 6, 8, 6, 6, 9, 6));
			varArray.add(new Chord("A#/Bb", "m7", -1, -1, 8, 10, 9, 9));
			varArray.add(new Chord("A#/Bb", "m7", 6, -1, 6, 6, 6, -1));
			extMap.put("m7", varArray);
			
			//A#/Bb maj7
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("A#/Bb", "maj7", 1, 1, 3, 2, 3, 1));
			varArray.add(new Chord("A#/Bb", "maj7", -1, 1, 3, 2, 3, 1));
			varArray.add(new Chord("A#/Bb", "maj7", 6, 8, 7, 7, 6, -1));
			varArray.add(new Chord("A#/Bb", "maj7", 13, 13, 12, 10, 10, 10));
			varArray.add(new Chord("A#/Bb", "maj7", -1, 13, 12, 10, 10, 10));
			varArray.add(new Chord("A#/Bb", "maj7", 6, -1, 7, 7, 6, -1));
			extMap.put("maj7", varArray);
			
			//A#/Bb sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "sus4", 1, 1, 3, 3, 4, 1));
			varArray.add(new Chord("A#/Bb", "sus4", -1, 1, 3, 3, 4, 1));
			varArray.add(new Chord("A#/Bb", "sus4", -1, -1, 3, 3, 4, 6));
			varArray.add(new Chord("A#/Bb", "sus4", 6, 6, 8, 8, 6, 6));
			extMap.put("sus4", varArray);
			
			//A#/Bb 7sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "7sus4", 1, 1, 3, 1, 4, 1));
			varArray.add(new Chord("A#/Bb", "7sus4", -1, 1, 3, 1, 4, 1));
			varArray.add(new Chord("A#/Bb", "7sus4", 6, 8, 6, 8, 6, 6));
			varArray.add(new Chord("A#/Bb", "7sus4", -1, -1, 8, 10, 9, 11));
			extMap.put("7sus4", varArray);
			
			//A#/Bb 6
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "6", 1, 1, 3, 3, 3, 3));
			varArray.add(new Chord("A#/Bb", "6", -1, 1, 3, 3, 3, 3));
			varArray.add(new Chord("A#/Bb", "6", 6, -1, 8, 7, 8, 6));
			varArray.add(new Chord("A#/Bb", "6", -1, -1, 8, 10, 8, 10));
			extMap.put("6", varArray);
			
			//A#/Bb m6
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A#/Bb", "m6", 1, 1, 3, 0, 2, 3));
			varArray.add(new Chord("A#/Bb", "m6", -1, 1, 3, 0, 2, 3));
			varArray.add(new Chord("A#/Bb", "m6", 6, 8, 8, 6, 8, 6));
			varArray.add(new Chord("A#/Bb", "m6", 6, -1, 8, 6, 8, 6));
			varArray.add(new Chord("A#/Bb", "m6", -1, -1, 8, 10, 8, 9));
			extMap.put("m6", varArray);

			//A#/Bb 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "9", 1, 1, 0, 1, 1, 1));
			varArray.add(new Chord("A#/Bb", "9", -1, 1, 0, 1, 1, -1));
			varArray.add(new Chord("A#/Bb", "9", -1, 5, 6, 5, 6, -1));
			varArray.add(new Chord("A#/Bb", "9", 6, -1, 6, 7, 6, 8));
			extMap.put("9", varArray);
			
			//A#/Bb m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "m9", 6, 4, 6, 5, -1, -1));
			varArray.add(new Chord("A#/Bb", "m9", 6, 8, 6, 6, 6, 8));
			varArray.add(new Chord("A#/Bb", "m9", 13, 13, 11, 13, 13, 13));
			varArray.add(new Chord("A#/Bb", "m9", -1, 13, 11, 13, 13, -1));
			extMap.put("m9", varArray);
			
			//A#/Bb maj9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "maj9", 1, 1, 0, 2, 1, 1));
			varArray.add(new Chord("A#/Bb", "maj9", -1, 1, 0, 2, 1, 1));
			varArray.add(new Chord("A#/Bb", "maj9", 6, 5, 7, 5, -1, -1));
			varArray.add(new Chord("A#/Bb", "maj9", -1, -1, 8, 5, 6, 5));
			extMap.put("maj9", varArray);
			
			//A#/Bb 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "6/9", 1, 1, 0, 0, 1, 1));
			varArray.add(new Chord("A#/Bb", "6/9", -1, 1, 0, 0, 1, 1));
			varArray.add(new Chord("A#/Bb", "6/9", 6, 5, 5, 5, 6, 6));
			varArray.add(new Chord("A#/Bb", "6/9", -1, -1, 8, 7, 8, 8));
			extMap.put("6/9", varArray);
			
			//A#/Bb 7+9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "7+9", 1, 1, 0, 1, 2, 1));
			varArray.add(new Chord("A#/Bb", "7+9", -1, 1, 0, 1, 2, 1));
			varArray.add(new Chord("A#/Bb", "7+9", 6, 5, 6, 6, 6, -1));
			varArray.add(new Chord("A#/Bb", "7+9", 6, 8, 6, 7, 6, 9));
			extMap.put("7+9", varArray);
			
			//A#/Bb 7-9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "7-9", 1, 1, 0, 1, 0, 1));
			varArray.add(new Chord("A#/Bb", "7-9", -1, 1, 0, 1, 0, 1));
			varArray.add(new Chord("A#/Bb", "7-9", 6, 5, 6, 4, -1, -1));
			varArray.add(new Chord("A#/Bb", "7-9", 6, -1, 6, 7, 6, 7));
			extMap.put("7-9", varArray);
			
			//A#/BbA aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "aug", -1, 5, 4, 3, 3, -1));
			varArray.add(new Chord("A#/Bb", "aug", 6, 5, 4, 3, -1, -1));
			varArray.add(new Chord("A#/Bb", "aug", -1, -1, 4, 3, 3, 2));
			extMap.put("aug", varArray);
			
			//A#/Bb 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "7+5", -1, 1, 4, 1, 3, 2));
			varArray.add(new Chord("A#/Bb", "7+5", 6, -1, 6, 7, 7, 6));
			varArray.add(new Chord("A#/Bb", "7+5", -1, 11, 12, 11, 11, -1));
			extMap.put("7+5", varArray);
			
			//A#/Bb dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "dim", 3, 4, 2, 3, -1, -1));
			varArray.add(new Chord("A#/Bb", "dim", -1, 1, 2, 0, 2, -1));
			varArray.add(new Chord("A#/Bb", "dim", -1, -1, 2, 3, 2, 3));
			extMap.put("dim", varArray);
			
			//A#/Bb -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "-5", -1, 1, 2, 3, 3, -1));
			varArray.add(new Chord("A#/Bb", "-5", -1, -1, 8, 7, 5, 6));
			varArray.add(new Chord("A#/Bb", "-5", 6, 7, 8, 7, -1, -1));
			extMap.put("-5", varArray);
			
			//A#/Bb 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "7-5", -1, 1, 2, 1, 3, -1));
			varArray.add(new Chord("A#/Bb", "7-5", -1, -1, 6, 7, 5, 6));
			varArray.add(new Chord("A#/Bb", "7-5", -1, -1, 8, 9, 9, 10));
			extMap.put("7-5", varArray);
			
			//A#/Bb 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("A#/Bb", "9-5", 0, 1, 0, 1, 1, 0));
			varArray.add(new Chord("A#/Bb", "9-5", 6, 5, 6, 5, 5, 4));
			varArray.add(new Chord("A#/Bb", "9-5", -1, -1, 8, 9, 9, 8));
			extMap.put("9-5", varArray);
			
			//A#/Bb 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("A#/Bb", "11", 1, 1, 1, 1, 1, 1));
			varArray.add(new Chord("A#/Bb", "11", -1, 1, 1, 1, 1, 1));
			varArray.add(new Chord("A#/Bb", "11", -6, -1, 6, 5, 1, 1));
			varArray.add(new Chord("A#/Bb", "11", -1, 8, 8, 8, 9, 8));
			varArray.add(new Chord("A#/Bb", "11", -1, -1, 8, 8, 9, 8));
			extMap.put("11", varArray);
			
			//A#/Bb 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("A#/Bb", "13", 1, 1, 0, 1, 1, 3));
			varArray.add(new Chord("A#/Bb", "13", -1, 1, 0, 1, 1, 3));
			varArray.add(new Chord("A#/Bb", "13", 6, -1, 6, 5, 3, 3));
			varArray.add(new Chord("A#/Bb", "13", 6, -1, 6, 7, 8, 8));
			extMap.put("13", varArray);
			
			//A#/Bb 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("A#/Bb", "5", 6, 8, -1, -1, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", 6, 8, 8, -1, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, 8, 8, -1, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, 1, 3, -1, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, 1, 3, 3, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, -1, 3, 3, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, -1, 8, 10, -1, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, -1, 8, 10, 11, -1));
			varArray.add(new Chord("A#/Bb", "5", -1, -1, -1, 10, 11, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("A#/Bb", extMap);		
		
		//B Chord
		{
			extMap = new HashMap<String, ArrayList<Chord>>(EXT_HASHMAP_CAPACITY);
			
			//B Major
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "Major", -1, 2, 4, 4, 4, 2));
			varArray.add(new Chord("B", "Major", 7, 9, 9, 8, 7, 7));
			varArray.add(new Chord("B", "Major", -1, -1, 9, 11, 12, 11));
			extMap.put("Major", varArray);

			//B /D#
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("B", "/D#", -1, 6, 4, 4, 4, -1));
			extMap.put("/D#", varArray);	
			
			//B /F#
			varArray = new ArrayList<Chord>(1);
			varArray.add(new Chord("B", "/F#", 2, 2, 4, 4, 4, -1));
			extMap.put("/F#", varArray);
			
			//B 7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("B", "7", 2, 2, 1, 2, 0, 2));
			varArray.add(new Chord("B", "7", -1, 2, 1, 2, 0, 2));
			varArray.add(new Chord("B", "7", 2, 2, 4, 2, 4, 2));
			varArray.add(new Chord("B", "7", -1, 2, 4, 2, 4, 2));
			varArray.add(new Chord("B", "7", 7, 9, 7, 8, 7, 7));
			varArray.add(new Chord("B", "7", 7, -1, 7, 8, 7, -1));
			extMap.put("7", varArray);
			
			//B m
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "m", -1, 2, 4, 4, 3, 2));
			varArray.add(new Chord("B", "m", 7, 9, 9, 7, 7, 7));
			varArray.add(new Chord("B", "m", -1, -1, 9, 11, 12, 10));
			varArray.add(new Chord("B", "m", 2, 2, 4, 4, 3, 2));
			extMap.put("m", varArray);
			
			//B m7
			varArray = new ArrayList<Chord>(7);
			varArray.add(new Chord("B", "m7", 2, 2, 0, 2, 0, 2));
			varArray.add(new Chord("B", "m7", -1, 2, 0, 2, 0, 2));
			varArray.add(new Chord("B", "m7", 2, 2, 4, 2, 3, 5));
			varArray.add(new Chord("B", "m7", -1, 2, 4, 2, 3, 2));
			varArray.add(new Chord("B", "m7", 7, 9, 9, 7, 10, 7));
			varArray.add(new Chord("B", "m7", 7, 9, 7, 7, 10, 7));
			varArray.add(new Chord("B", "m7", 7, -1, 7, 7, 7, -1));
			extMap.put("m7", varArray);
			
			//B maj7
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("B", "maj7", 2, 2, 4, 3, 4, 2));
			varArray.add(new Chord("B", "maj7", -1, 2, 4, 3, 4, 2));
			varArray.add(new Chord("B", "maj7", 7, 9, 8, 8, 7, -1));
			varArray.add(new Chord("B", "maj7", -1, -1, 9, 8, 7, 6));
			varArray.add(new Chord("B", "maj7", 7, -1, 8, 8, 7, -1));
			extMap.put("maj7", varArray);
			
			//B sus4
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "sus4", 2, 2, 4, 4, 5, 2));
			varArray.add(new Chord("B", "sus4", -1, 2, 4, 4, 5, 2));
			varArray.add(new Chord("B", "sus4", -1, -1, 4, 4, 5, 7));
			varArray.add(new Chord("B", "sus4", 7, 7, 9, 9, 7, 7));
			extMap.put("sus4", varArray);
			
			//B 7sus4
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("B", "7sus4", 2, 2, 2, 2, 0, 0));
			varArray.add(new Chord("B", "7sus4", -1, 2, 2, 2, 0, 0));
			varArray.add(new Chord("B", "7sus4", 2, 2, 4, 2, 5, 2));
			varArray.add(new Chord("B", "7sus4", -1, 2, 4, 2, 5, 2));
			varArray.add(new Chord("B", "7sus4", 7, 9, 7, 9, 7, 7));
			extMap.put("7sus4", varArray);
			
			//B 6
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("B", "6", 2, 2, 1, 1, 0, -1));
			varArray.add(new Chord("B", "6", -1, 2, 1, 1, 0, -1));
			varArray.add(new Chord("B", "6", 2, 2, 4, 4, 4, 4));
			varArray.add(new Chord("B", "6", -1, 2, 4, 4, 4, 4));
			varArray.add(new Chord("B", "6", 7, -1, 9, 8, 9, 7));
			extMap.put("6", varArray);
			
			//B m6
			varArray = new ArrayList<Chord>(6);
			varArray.add(new Chord("B", "m6", 2, 2, 0, 1, 0, 2));
			varArray.add(new Chord("B", "m6", -1, 2, 0, 1, 0, 2));
			varArray.add(new Chord("B", "m6", 2, 2, 4, 4, 3, 4));
			varArray.add(new Chord("B", "m6", -1, 2, -1, 4, 3, 4));
			varArray.add(new Chord("B", "m6", 7, 9, 9, 7, 9, 7));
			varArray.add(new Chord("B", "m6", 7, -1, 9, 7, 9, 7));
			extMap.put("m6", varArray);

			//B 9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "9", 2, 2, 1, 2, 2, 2));
			varArray.add(new Chord("B", "9", -1, 2, 1, 2, 2, -1));
			varArray.add(new Chord("B", "9", -1, 6, 7, 6, 7, -1));
			varArray.add(new Chord("B", "9", -1, -1, 7, 6, 7, 7));
			extMap.put("9", varArray);
			
			//B m9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "m9", 2, 2, 0, 2, 2, 2));
			varArray.add(new Chord("B", "m9", -1, 2, 0, 2, 2, -1));
			varArray.add(new Chord("B", "m9", 7, 5, 7, 6, -1, -1));
			varArray.add(new Chord("B", "m9", 7, 9, 7, 7, 7, 9));
			extMap.put("m9", varArray);
			
			//B maj9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "maj9", -1, 2, 1, 3, 2, -1));
			varArray.add(new Chord("B", "maj9", 7, 6, 8, 6, -1, -1));
			varArray.add(new Chord("B", "maj9", -1, -1, 9, 6, 7, 6));
			extMap.put("maj9", varArray);
			
			//B 6/9
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "6/9", 2, 2, 1, 1, 2, 2));
			varArray.add(new Chord("B", "6/9", -1, 2, 1, 1, 2, 2));
			varArray.add(new Chord("B", "6/9", 7, 6, 6, 6, 7, 7));
			varArray.add(new Chord("B", "6/9", -1, -1, 9, 8, 9, 9));
			extMap.put("6/9", varArray);
			
			//B 7+9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "7+9", -1, 2, 1, 2, 3, -1));
			varArray.add(new Chord("B", "7+9", 7, 6, 7, 7, 7, -1));
			varArray.add(new Chord("B", "7+9", 7, 9, 7, 8, 7, 10));
			extMap.put("7+9", varArray);
			
			//B 7-9
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "7-9", -1, 2, 1, 2, 1, -1));
			varArray.add(new Chord("B", "7-9", 7, 6, 7, 5, -1, -1));
			varArray.add(new Chord("B", "7-9", 7, -1, 7, 8, 7, 8));
			extMap.put("7-9", varArray);
			
			//B aug
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "aug", -1, 2, 1, 0, 0, -1));
			varArray.add(new Chord("B", "aug", 3, 2, 1, 0, -1, -1));
			varArray.add(new Chord("B", "aug", -1, -1, 5, 4, 4, 3));
			extMap.put("aug", varArray);
			
			//B 7+5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "7+5", -1, 0, 1, 0, 0, 3));
			varArray.add(new Chord("B", "7+5", -1, 2, 5, 2, 4, 3));
			varArray.add(new Chord("B", "7+5", 7, -1, 7, 8, 8, 7));
			extMap.put("7+5", varArray);
			
			//B dim
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "dim", 1, 2, 0, 1, -1, -1));
			varArray.add(new Chord("B", "dim", -1, 2, 3, 1, 3, -1));
			varArray.add(new Chord("B", "dim", -1, -1, 0, 1, 0, 1));
			extMap.put("dim", varArray);
			
			//B -5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "-5", -1, 2, 3, 4, 4, -1));
			varArray.add(new Chord("B", "-5", -1, -1, 9, 8, 6, 7));
			varArray.add(new Chord("B", "-5", -1, -1, 9, 10, 12, 11));
			extMap.put("-5", varArray);
			
			//B 7-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "7-5", -1, 2, 3, 2, 4, -1));
			varArray.add(new Chord("B", "7-5", -1, -1, 7, 8, 6, 7));
			varArray.add(new Chord("B", "7-5", -1, -1, 9, 10, 10, 11));
			extMap.put("7-5", varArray);
			
			//B 9-5
			varArray = new ArrayList<Chord>(3);
			varArray.add(new Chord("B", "9-5", 1, 2, 1, 2, 2, 1));
			varArray.add(new Chord("B", "9-5", 7, 6, 7, 6, 6, 7));
			varArray.add(new Chord("B", "9-5", -1, -1, 9, 10, 10, 9));
			extMap.put("9-5", varArray);
			
			//B 11
			varArray = new ArrayList<Chord>(5);
			varArray.add(new Chord("B", "11", 2, 2, 2, 2, 2, 2));
			varArray.add(new Chord("B", "11", -1, 2, 2, 2, 2, 2));
			varArray.add(new Chord("B", "11", 7, -1, 7, 6, 5, 5));
			varArray.add(new Chord("B", "11", -1, 9, 9, 9, 10, 9));
			varArray.add(new Chord("B", "11", -1, -1, 9, 9, 10, 9));
			extMap.put("11", varArray);
			
			//B 13
			varArray = new ArrayList<Chord>(4);
			varArray.add(new Chord("B", "13", 2, 2, 1, 2, 2, 4));
			varArray.add(new Chord("B", "13", -1, 2, 1, 2, 2, 4));
			varArray.add(new Chord("B", "13", 7, -1, 7, 6, 4, 4));
			varArray.add(new Chord("B", "13", 7, -1, 7, 8, 9, 9));
			extMap.put("13", varArray);
			
			//B 5
			varArray = new ArrayList<Chord>(9);
			varArray.add(new Chord("B", "5", 7, 9, -1, -1, -1, -1));
			varArray.add(new Chord("B", "5", 7, 9, 9, -1, -1, -1));
			varArray.add(new Chord("B", "5", -1, 9, 9, -1, -1, -1));
			varArray.add(new Chord("B", "5", -1, 2, 4, -1, -1, -1));
			varArray.add(new Chord("B", "5", -1, 2, 4, 4, -1, -1));
			varArray.add(new Chord("B", "5", -1, -1, 4, 4, -1, -1));
			varArray.add(new Chord("B", "5", -1, -1, 9, 11, -1, -1));
			varArray.add(new Chord("B", "5", -1, -1, 9, 11, 12, -1));
			varArray.add(new Chord("B", "5", -1, -1, -1, 11, 12, -1));
			varArray.add(new Chord("B", "5", -1, -1, -1, 4, 7, -1));
			extMap.put("5", varArray);
		}
		rootMap.put("B", extMap);		
	}

	public static Chord getChord(String root, String ext, int varIdx){
		HashMap<String, ArrayList<Chord>> temp = rootMap.get(root);
		Chord chord = temp.get(ext).get(varIdx);
		return chord;
	}
	
	public static Chord getChord(String name){
		String root, ext;
		if(name.charAt(1) == '#'){
			root = name.substring(0, 5);
			ext = name.substring(5);
		}
		else{
			root = name.substring(0, 1);
			ext = name.substring(1);
		}

		HashMap<String, ArrayList<Chord>> temp = rootMap.get(root);
		Chord chord = temp.get(ext).get(0);
		return chord;
	}
}
