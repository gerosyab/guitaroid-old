package net.gerosyab.Guitaroid.data;

public class SongData {
	private static final int X = -1;
	
	public static final String [] songList = {
		/* 0 */ "Butterfly - Weezer",
		/* 1 */ "Canon",
		/* 2 */ "Falling Slowly - Once O.S.T",
		/* 3 */ "Hotel California - The Eagles",
		/* 4 */ "No Surprises - Radiohead",
		/* 5 */ "Romance",
		/* 6 */ "Shape Of My Heart - Sting",
		/* 7 */ "Wake Me Up When September Ends - Green Day",
		/* 8 */ "Wind Song - Kotaro Oshio",
		/* 9 */ "Marry Me - Train"
	};
	
	static Song song = null;
	
	public static Song loadSong(int index){
		switch(index){
		case 0:{//"Butterfly - Weezer"
			loadButterfly();
			break;
		}
		
		case 1:{//Canon
			loadCanon();
			break;
		}
		
		case 2:{//Falling Slowly - Once O.S.T
			loadFallingSlowly();
			break;
		}
		
		case 3:{//Hotel California - The Eagles
			addHotelCalifornia();
			break;
		}
		
		case 4:{//No Suprises - Radiohead
			loadNoSurprises();
			break;
		}
		
		case 5:{//Romance
			loadRomance();
			break;
		}
		
		case 6:{//Shape Of My Heart - Sting
			loadShapeOfMyHeart();
			break;
		}
		
		case 7:{//Wake Me Up When September Ends - Green Day
			loadWakeMeUpWhenSeptemberEnds();
			break;
		}
		
		case 8:{//Wind Song - Kotaro Oshio
			loadWindSong();
			break;
		}
		
		case 9:{//Marry Me - Train
			loadMarryMe();
			break;
		}
//		case 9:{
//			song = new Song();
//			song.title = "test";
//			song.position = new int[][]{
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					{X, X, X, X, 1, 1},
//					
//			};
//			song.songLength = song.position.length;
//			song.bLyric = false;
//			song.lyric = null;
//			song.lyricIndex = null;
//			song.lyricLength = 0;
//		}
		}
		return song;
	}

	/*

	private static void loadShapeOfMyHeart() {
		song = new Song();
		song.title = "Shape Of My Heart - Sting";
		song.position = new int[][]{
			{X, X, X, X, X, X},
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[]{
			"",
			"He deals the cards as a meditation",
			"And those he plays never suspect",
			"He doesn`t play for the money he wins",
			"He doesn`t play for respect",
			"",
			"He deals the cards to find the answer",
			"The sacred geometry of chance",
			"The hidden law of a probable outcome",
			"The numbers lead a dance",
			"",
			"*I know that the spades are the swords of a soldier",
			"I know that the clubs are wepons of war",
			"I know that diamonds mean money for this art",
			"But that`s not the shape of my heart",
			"",
			"He may play the jack of diamonds",
			"He may lay the queen of spades",
			"He may conceal a king in his hand",
			"While the memory of it fades",
			"",
			"* Repeat",
			"That`s not the shape, shape of my heart",
			"",
			"And if I told you that I loved you",
			"You`d maybe think there`s something wrong",
			"I`m not a man of too many faces",
			"The mask I wear is one",
			"",
			"Those who speak know nothing",
			"And find out to their cost",
			"Like those who curse their luck in too many places",
			"And those who fear are lost",
			"",
			"* Repeat",
			"that`s not the shape of my heart",
			"that`s not the shape, shape of my heart.",
		};
		song.lyricIndex = new int[]{
			0, 	
		};
		song.lyricLength = song.lyric.length;
	}

	private static void loadNoSuprise(){
		song = new Song();
		song.title = "No Suprise - Radiohead";
		song.position = new int[][]{
				{X, X, X, X, X, 5}, //0
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //15
				
				{X, X, X, X, X, 5}, //16
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //31
				
				{X, X, X, X, X, 5}, //32 A heart
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X}, //47
				
				{X, X, X, X, X, 5}, //48 landfill
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X}, //63
				
				{X, X, X, X, X, 6}, //64 kills
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 6},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, X, 5, X},
				{X, X, X, 5, X, X},
				{X, X, 7, X, X, X},
				{X, X, 6, X, X, X},
				{X, X, 7, X, X, X},
				{X, X, 6, X, X, 5},
				{X, X, X, 5, X, X}, //77
				
				{X, X, X, X, X, 5}, //78 heal
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //93
				
				{X, X, X, X, X, 5}, //94 you look 32 A heart
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X}, //109
				
				{X, X, X, X, X, 5}, //110 bring down
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X}, //125
				
				{X, X, X, X, X, 6}, //126 they
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 6},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, X, 5, X},
				{X, X, X, 5, X, X},
				{X, X, 7, X, X, X},
				{X, X, 6, X, X, X},
				{X, X, 7, X, X, X},
				{X, X, 6, X, X, 5},
				{X, X, X, 5, X, X}, //139
				
				{X, X, X, X, X, 5}, //140 us
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //155
				
				{X, X, X, X, X, 5}, //156 I'll 94 you look 32 A heart
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X}, //171
				
				{X, X, X, X, X, 5}, //172 handshake
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X}, //187
				
				{X, X, X, 3, X, X}, //188
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 1, X}, //199
				
				{X, X, X, 3, X, X}, //200
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 0}, //210
				
				{X, X, X, 3, X, X}, //211
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 1, X}, //222
				
				{X, X, X, X, X, 5}, //223 140 us
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //238 155
				
				{X, X, X, X, X, 5}, //249 140 us
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //264
				
				{X, X, X, X, X, 5}, //265 This is 156 I'll 94 you look 32 A heart
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X}, //280 171
				
				{X, X, X, X, X, 5}, //281 172 handshake
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 7, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 7, X, X}, //296 187
				
				{X, X, X, 3, X, X}, //297 188
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 1, X}, //308 199
				
				{X, X, X, 3, X, X}, //309 200
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 0}, //319 210
				
				{X, X, X, 3, X, X}, //320 211
				{X, X, X, 1, X, X},
				{X, X, X, 1, X, X},
				{X, X, 3, X, X, X},
				{X, X, 3, X, X, X},
				{X, X, 2, X, X, X},
				{X, X, 0, X, X, X},
				{X, 0, X, X, X, X},
				{X, 0, X, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 1, X}, //331 222
				
				{X, X, X, X, X, 5}, //332 223 140 us
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //347 238 155
				
				{X, X, X, X, X, 5}, //348 249 140 us
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, X, X, 5},
				{X, X, X, 5, X, X},
				{X, X, X, X, 6, X},
				{X, X, X, 5, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, X, 3}, //363 264
				
				
				
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[]{
			"",
			"A heart that's full up like a landfill",
			"A job that slowly kills you",
			"Bruises that won't heal",
			"",
			"You look so tired and unhappy",
			"Bring down the government",
			"They don't, they don't speak for us",
			"I'll take a quiet life",
			"A handshake of carbon monoxide",
			"",
			"No alarms and no surprises",
			"No alarms and no surprises",
			"No alarms and no surprises",
			"Silent, silent",
			"",
			"This is my final fit, my final bellyache with",
			"",
			"No alarms and no surprises",
			"No alarms and no surprises",
			"No alarms and no surprises please",
			"",
			"Such a pretty house, such a pretty garden",
			"",
			"No alarms and no surprises (let me out of here)",
			"No alarms and no surprises (let me out of here)",
			"No alarms and no surprises please (let me out of here)",	
		};
		song.lyricIndex = new int[]{
			0, 	
		};
		song.lyricLength = song.lyric.length;
	};
	
	//shape of my heard, no surprise will be added in next update
	*/
	private static void loadButterfly() {
		song = new Song();
		song.title = "Butterfly - Weezer";
		song.position = new int[][]{
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, X, 1, X}, // 9
			{X, X, X, X, X, 0}, // 10
			{X, X, X, X, 3, X}, // 11
			{X, X, X, X, 1, X}, // 12
			{X, X, X, X, 0, X}, // 13
			{X, X, X, 2, 3, X}, // 14
			{X, X, X, X, 0, X}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, X, 1, X}, // 9
			{X, X, X, X, X, 0}, // 10
			{X, X, X, X, 3, X}, // 11
			{X, X, X, X, 1, X}, // 12
			{X, X, X, X, 0, X}, // 13
			{X, X, X, 2, 3, X}, // 14
			{X, X, X, X, 0, X}, // 15
			
			{X, X, 0, X, X, X}, // 0
			{X, X, X, 2, X, X}, // 1
			{X, X, X, X, 3, X}, // 2
			{X, X, X, X, X, 2}, // 3 
			{X, X, X, X, 3, X}, // 4
			{X, X, X, 2, X, X}, // 5
			{X, X, X, X, 3, X}, // 6
			{X, X, X, X, X, 2}, // 7
			{3, X, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 0, X}, // 10
			{X, X, X, X, X, 3}, // 11
			{0, X, X, X, X, X}, // 12
			{X, X, X, 0, X, X}, // 13
			{X, X, X, X, 0, X}, // 14
			{X, X, X, X, X, 0}, // 15
			{X, 3, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 1, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, 0, X, X, X}, // 20
			{X, X, X, 2, X, X}, // 21
			{X, X, X, X, 3, X}, // 22
			{X, X, X, X, X, 2}, // 23
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{X, X, X, X, X, 1}, // 4
			{X, X, X, X, 0, X}, // 5
			{X, X, X, 0, X, X}, // 6
			{X, X, X, X, X, 1}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			{0, X, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 0, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, X, X, 0, X}, // 20
			{X, X, X, 0, X, X}, // 21
			{X, X, X, X, 0, X}, // 22
			{X, X, X, X, X, 0}, // 23
			{X, 3, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 1, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, X, X, 1, X}, // 20
			{X, X, X, 0, X, X}, // 21
			{X, X, X, X, 1, X}, // 22
			{X, X, X, X, X, 0}, // 23
			{X, 3, X, X, X, X}, // 24
			{X, X, X, 0, X, X}, // 25
			{X, X, X, X, 1, X}, // 26
			{X, X, X, X, X, 0}, // 27
			{X, X, X, X, 1, X}, // 28
			{X, X, X, 0, X, X}, // 29
			{X, 3, X, X, X, X}, // 30
			{X, 0, X, X, X, X}, // 31
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, X, 1, X}, // 9
			{X, X, X, X, X, 0}, // 10
			{X, X, X, X, 3, X}, // 11
			{X, X, X, X, 1, X}, // 12
			{X, X, X, X, 0, X}, // 13
			{X, X, X, 2, 3, X}, // 14
			{X, X, X, X, 0, X}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, X, 1, X}, // 9
			{X, X, X, X, X, 0}, // 10
			{X, X, X, X, 3, X}, // 11
			{X, X, X, X, 1, X}, // 12
			{X, X, X, X, 0, X}, // 13
			{X, X, X, 2, 3, X}, // 14
			{X, X, X, X, 0, X}, // 15
			
			{X, X, 0, X, X, X}, // 0
			{X, X, X, 2, X, X}, // 1
			{X, X, X, X, 3, X}, // 2
			{X, X, X, X, X, 2}, // 3 
			{X, X, X, X, 3, X}, // 4
			{X, X, X, 2, X, X}, // 5
			{X, X, X, X, 3, X}, // 6
			{X, X, X, X, X, 2}, // 7
			{3, X, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 0, X}, // 10
			{X, X, X, X, X, 3}, // 11
			{0, X, X, X, X, X}, // 12
			{X, X, X, 0, X, X}, // 13
			{X, X, X, X, 0, X}, // 14
			{X, X, X, X, X, 0}, // 15
			{X, 3, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 1, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, 0, X, X, X}, // 20
			{X, X, X, 2, X, X}, // 21
			{X, X, X, X, 3, X}, // 22
			{X, X, X, X, X, 2}, // 23
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{X, X, X, X, X, 1}, // 4
			{X, X, X, X, 0, X}, // 5
			{X, X, X, 0, X, X}, // 6
			{X, X, X, X, X, 1}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			{0, X, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 0, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, X, X, 0, X}, // 20
			{X, X, X, 0, X, X}, // 21
			{X, X, X, X, 0, X}, // 22
			{X, X, X, X, X, 0}, // 23
			{X, 3, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 1, X}, // 18
			{X, X, X, X, X, 0}, // 19
			{X, X, X, X, 1, X}, // 20
			{X, X, X, 0, X, X}, // 21
			{X, X, X, X, 1, X}, // 22
			{X, X, X, X, X, 0}, // 23
			{X, 3, X, X, X, X}, // 24
			{X, X, X, 0, X, X}, // 25
			{X, X, X, X, 1, X}, // 26
			{X, X, X, X, X, 0}, // 27
			{X, X, X, X, 1, X}, // 28
			{X, X, X, 0, X, X}, // 29
			{X, 3, X, X, X, X}, // 30
			{X, 0, X, X, X, X}, // 31
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 1, X}, // 10
			{X, X, X, X, X, 0}, // 11
			{X, X, 0, X, X, X}, // 12
			{X, X, X, 2, X, X}, // 13
			{X, X, X, X, 3, X}, // 14
			{X, X, X, X, X, 2}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{0, X, X, X, X, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 0}, // 7
			{X, 3, X, X, X, X}, // 8
			{X, X, X, X, 1, X}, // 9
			{X, X, X, X, X, 0}, // 10
			{X, X, X, X, 3, X}, // 11
			{X, X, X, X, 1, X}, // 12
			{X, X, X, X, 0, X}, // 13
			{X, X, X, 2, 3, X}, // 14
			{X, X, X, X, 0, X}, // 15
			
			{3, X, X, X, X, X}, // 0
			{X, X, X, 0, X, X}, // 1
			{X, X, X, X, 0, X}, // 2
			{X, X, X, X, X, 3}, // 3 
			{X, X, X, X, 0, X}, // 4
			{X, X, X, 0, X, X}, // 5
			{X, X, X, X, 0, X}, // 6
			{X, X, X, X, X, 3}, // 7
			{3, X, X, X, X, X}, // 8
			{X, X, X, 0, X, X}, // 9
			{X, X, X, X, 0, X}, // 10
			{X, X, X, X, X, 3}, // 11
			{X, X, X, X, 0, X}, // 12
			{X, X, X, 0, X, X}, // 13
			{X, X, X, X, 0, X}, // 14
			{X, X, X, X, X, 3}, // 15				
			{0, X, X, X, X, X}, // 16
			{X, X, X, 0, X, X}, // 17
			{X, X, X, X, 0, X}, // 18
			{X, X, X, X, X, 0}, // 19 
			{X, X, X, X, 0, X}, // 20
			{X, X, X, 0, X, X}, // 21
			{X, X, X, X, 0, X}, // 22
			{X, X, X, X, X, 0}, // 23
			{X, 3, X, X, X, X}, // 24
			{X, X, X, 0, X, X}, // 25
			{X, X, X, X, 1, X}, // 26
			{X, X, X, X, X, 0}, // 27
			{X, X, X, X, 1, X}, // 28
			{X, X, X, 0, X, X}, // 29
			{X, 0, X, X, X, X}, // 30
			{X, X, X, 2, X, X}, // 31
			{X, X, X, 0, X, X}, // 30
			{3, 2, 0, 0, 0, 3}, // 31
			
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[]{
			"",
			"Yesterday I went outside",
			"with my momma`s mason jar",
			"Caught a lovely butterfly",
			"",
			"When I woke up today",
			"Looked in on my fairy pet",
			"She had withered all away",
			"No more sighing in her breast",

			"I`m sorry for what I did",
			"I did what my body told me to",
			"I didn`t mean to do you harm",
			"Everytime I pin down",
			"What I think I want it slips away",
			"The ghost slips away",
			"",

			"Smell you on my hand for days",
			"I can`t wash away your scent",
			"If I`m a dog then you`re a bitch",
			"",
			"I guess you`re as real as me",
			"Maybe I can live with that",
			"Maybe I need fantasy",
			"Life of chasing butterfly",

			"I`m sorry for what I did",
			"I did what my body told me to",
			"I didn`t mean to do you harm",
			"Everytime I pin down",
			"What I think I want it slips away",
			"The ghost slips away",
			"",

			"I told you I would return",
			"When the Robin makes his nest",
			"But I ain`t never comin` back",
			"",
			"I`m sorry, I`m sorry, I`m sorry"
		};
		song.lyricIndex = new int[]{	//36
			0, 2, 10, 18, 26, 34, 42, 50, 58, 66, 74,
			84, 90, 96, 108, 124, 130, 138, 146, 155, 162,
			170, 178, 186, 194, 202, 210, 218, 224, 236, 252,
			258, 266, 274, 282, 296  
		};
		song.lyricLength = song.lyricIndex.length;
	}
	
	private static void loadCanon(){
		song = new Song();
		song.title = "Canon";
		song.position = new int[][]{
			{X, X, 0, X, X, X}, //0
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 2},
			{X, 0, X, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{X, 2, X, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 3, X},
			{2, X, X, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{3, X, X, X, X, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, 0, X},
			{X, 5, X, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, X},
			{3, X, X, X, X, X},
			{X, X, 5, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 3, X},
			{X, 0, X, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X}, //31
			
			{X, X, 0, X, X, 2}, //32
			{X, X, 0, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, X},
			{X, 0, X, X, X, 0},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{X, X, 2, X, X, X},
			{X, 2, X, X, 3, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, 4, X, X, X},
			{2, X, X, X, 2, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 2, X},
			{X, X, 4, X, X, X},
			{3, X, X, X, 0, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, 0, X, X, X},
			{X, 5, X, 2, X, X},
			{X, 5, X, X, X, X},
			{X, X, 4, X, X, X},
			{X, 5, X, X, X, X},
			{3, X, X, X, 0, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, 0, X},
			{X, 0, X, X, 2, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X}, //63
			
			{X, X, 0, X, 3, 2}, //64
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, X},
			{X, X, 0, X, X, X},
			{X, 0, X, X, 2, 0},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{X, X, 2, X, X, X},
			{X, 2, X, 4, 3, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, 2, X, X, X, X},
			{2, X, X, 2, 2, X},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{3, X, X, 0, 0, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, 0, X, X, X},
			{X, 5, 4, 2, X, X}, //////////////////////////////84
			{X, 5, X, X, X, X},
			{X, X, 4, X, X, X},
			{X, 5, X, X, X, X},
			{3, X, X, 0, 0, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, 0, X},
			{X, 0, X, 2, 2, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X}, //95
			
			{X, X, 0, X, 3, X}, //96
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, 2},
			{X, X, X, 2, X, X},
			{X, 0, X, X, X, 5},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, 3},
			{X, X, X, X, 2, X},
			{X, 2, X, X, X, 2},
			{X, X, 4, X, X, X},
			{X, X, X, 4, 3, X},
			{X, X, 4, X, X, X},
			{2, X, X, X, X, 2},
			{X, 4, X, X, X, X},
			{X, X, X, 2, 5, X},
//			{X, X, X, X, X, X},
			{3, X, X, X, 3, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, 0, X},
			{X, X, 0, X, X, X},
			{X, 5, X, X, 3, X},
			{X, X, 4, X, X, X},
			{X, 5, X, 2, X, X},
			{X, X, 4, X, X, X},
			{3, X, X, X, 3, X},
			{X, X, 5, X, X, X},
			{3, X, X, 4, X, X},
			{X, X, 5, X, X, X},
			{X, 0, X, X, 3, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, 2, X},
			{X, X, 2, X, X, X}, //126
			
			{X, X, 0, X, 3, X}, //127
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, 0, X, X, X},
			{X, 0, X, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 2, X, X, X},
			{X, X, 4, X, X, X},
			{X, 2, 0, X, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 0, X},
			{2, X, X, X, 2, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 5},
			{X, X, X, X, X, 7},
			{3, X, X, X, X, 3},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 3},
			{X, 5, X, X, 7, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{3, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, 0, 2, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			
			{X, 5, 0, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{X, 0, X, 2, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, 2, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 2, X, X},
			{X, X, 5, X, X, X},
			{2, X, X, 2, X, X},
			{X, X, 5, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{3, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 0, X, X},
			{X, 5, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 0, X, X, X},
			{X, X, 4, X, X, X},
			{3, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, X, 0, X},
			{X, 0, X, 2, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			
			{X, X, 0, X, X, X}, //191
			{X, X, 0, X, X, X},
			{X, X, X, 2, X, 2},
			{X, X, X, X, 3, X},
			{X, 0, X, X, 2, 0},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{X, X, X, 0, X, X},
			{X, 2, X, X, 3, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, 4, X, X, X},
			{2, X, X, X, X, 2},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 2, X, X, X},
			{3, X, X, X, X, 7},
			{X, X, 0, X, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, 0, X, X, 5},
			{X, X, 0, X, X, X},
			{X, X, X, X, 7, X},
			{X, X, X, X, 5, X},
			{3, X, X, X, X, 7},
			{X, X, 0, X, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, 0, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 6, X, X},
			{X, X, 7, X, X, X},
			
			{X, X, 0, X, X, 5}, //223
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 3},
			{X, X, X, X, X, 5},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 3},
			{X, 0, X, X, X, 5},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 3},
			{X, 2, X, X, X, 2}, //237
			{X, X, X, X, 3, X},
			{X, X, X, X, 5, X},
			{X, X, X, X, X, 2},
			{X, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{2, X, X, 2, X, X}, 
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, 2, X, X},
			
			{3, X, X, 0, X, X}, //251
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, 5, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 0, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
			{3, X, X, 0, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, 0, X, 2, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 3},
			{X, X, X, X, X, 5},
			
			{X, X, 0, X, X, 2},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 0},
			{X, X, X, X, 3, X},
			{X, 0, X, X, X, 0},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 0},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, 2, X, X, 3, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, 0, X, X, X},
			{X, X, 2, X, X, X},
			{2, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 3, X},
//			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			
			{3, X, X, 4, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, 5, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
//			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{3, X, X, 4, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 0, X},
			{X, 0, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 5, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			
			{X, X, 0, 2, 3, 2},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, X, X, X, 3, X},
			{X, 0, X, 2, 2, 0},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, X, 2},
			{X, 2, 4, 4, 3, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, X, X, 4, X, X},
			{2, X, 4, 2, 2, X},
			{X, X, X, 2, X, X},
			{X, X, 5, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			
			{3, X, 0, 0, 0, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 0, X, X},
			{X, 5, 4, 2, X, X},
			{X, 5, X, X, X, X},
			{X, X, 2, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{3, X, 0, 0, 0, X},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, 0, X, X},
			{X, X, 4, X, X, X},
			{X, 0, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 5, X, X, X},
			{X, X, 4, X, X, X},
			{X, X, 2, X, X, X},
			
			{X, 5, 4, X, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{X, X, 4, X, 3, X},
			{X, 0, X, 2, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			{X, X, X, 2, X, X},
			{X, 2, 4, X, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 5, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 3, X},
			{2, X, X, X, X, 2},
			{X, X, X, X, X, 2},
			{X, X, X, X, 5, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			
			
			{3, X, X, X, 0, X},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, 2, X},
			{X, X, 0, X, 3, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 0},
			{X, X, X, X, 3, X},
			{X, X, X, X, X, 2},
			{3, X, X, X, X, 3},
			{X, X, X, X, 3, X},
			{X, X, X, 6, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 4, X, X},
			{X, 0, X, 2, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 2, 2, 2, X},

			{X, X, 0, 2, 3, 2},
			{X, X, 0, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, 0, 2, 2, 2, 2},
			{X, X, X, X, X, 3},
			{X, X, X, X, X, 2},
			{X, X, X, X, X, 0},
			{X, 2, 4, 4, 3, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 3, X},
			{2, X, X, 2, 3, X},
			{X, X, X, X, 5, X},
			{X, X, X, X, 3, X},
			{X, X, X, X, 2, X},
			{3, X, 0, 0, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, X, X, 0},
			{X, X, 0, X, 3, 2},
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, 0},
			{X, X, X, 2, X, X},
			{3, X, 0, 0, 3, X},
			{X, X, X, 5, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 5, X, X},
			{X, 0, 2, 2, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			
			{X, 5, X, X, X, X},
			{X, X, 0, X, X, X},
			{X, X, X, 7, X, X},
			{X, X, X, X, 7, 5},
			{X, 0, X, X, 7, 5},
			{X, X, X, X, 8, 7},
			{X, X, X, X, 7, 5},
			{X, X, X, X, 5, 3},
			{X, 2, X, 4, 3, 2},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, 3, 2},
			{X, X, 4, X, 3, 2},
			{X, X, X, X, 5, 3},
			{X, X, X, X, 3, 2},
			{X, X, X, X, 2, 0},
			{3, X, X, X, 3, X},
			{X, X, X, 5, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 5, X, X},
			{X, 5, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, 0, X, X, X},
			{3, X, 0, 0, 3, X},
			{X, X, X, 5, X, X},
			{X, X, X, 4, X, X},
			{X, X, X, 5, X, X},
			{X, 0, X, 2, X, X},
			{X, X, 2, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			
			{X, X, 0, X, X, X},
			{X, X, X, 7, X, X},
			{X, X, X, X, 7, X},
			{X, X, X, X, 10, X},
			{X, 0, X, X, 10, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 10, X},
			{X, X, X, X, 8, X},
			{7, X, X, X, 7, X},
			{X, X, X, 7, X, X},
			{X, X, X, X, X, 10},
			{X, X, X, X, 7, X},
			{X, 9, X, X, 10, X},
			{X, X, X, X, 7, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{3, X, X, X, X, 7},
			{X, X, 0, X, X, X},
			{X, X, X, 7, X, X},
			{X, X, X, X, 0, X},
			{X, X, 0, X, X, 5},
			{X, X, 0, X, X, X},
			{X, X, X, 7, X, X},
			{X, X, X, X, 7, X},
			{3, X, X, X, X, 7},
			{X, X, 0, X, X, X},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, 0, 7, 6, 5, 5},
			{X, X, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 6, X, X},
			
			{X, X, 0, 2, 3, 2},
			{X, X, 0, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 3, X},
			{X, 0, X, X, X, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, 2, X},
			{X, X, 2, X, X, X},
			{X, 2, 4, 4, 3, X},
			{X, X, 4, X, X, X},
			{X, X, X, 4, X, X},
			{X, X, 4, X, X, X},
			{2, X, X, X, X, X},
			{X, 0, X, X, X, X},
			{X, X, X, 2, 1, X},
			{X, X, 0, X, X, X},
			{3, X, 0, 0, 0, X},
			{X, X, 0, X, X, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, 3, X},
			{X, 5, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, 2, X, X},
			{3, X, X, 0, 0, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, 0, X, X, X},
			{X, 0, 2, 2, 3, X},
			{X, X, X, X, 2, X},
			{X, X, X, X, 3, X},
			{X, 5, 4, 2, 3, X},
		};
		song.songLength = song.position.length;
		song.bLyric = false;
		song.lyric = null;
		song.lyricIndex = null;
		song.lyricLength = 0;
	}
	
	private static void loadFallingSlowly(){
		song = new Song();
		song.title = "Falling Slowly - Once O.S.T";
		song.position = new int[][]{
				{X, 3, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, 3, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X}, //31
				
				{X, 3, X, X, 1, X}, //32
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, 3, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X}, //63
				
				{X, 0, X, X, 1, X}, //64
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, 0, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X}, //87
				
				{1, X, X, X, 1, X}, //88
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X}, //103
				
				{X, 3, 2, 0, 1, 0}, //104
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1}, //119
				
				{X, 3, 2, 0, 1, 0}, //120
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1}, //136
				
				{X, 3, X, X, 1, X}, //137
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, 3, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X}, //168
				
				{X, 3, X, X, 1, X}, //169
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, 3, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X}, //201
				
				{X, 0, X, X, 1, X}, //202
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, 0, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 2, X, X},
				{3, X, X, X, 3, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X}, //225
				
				{1, X, X, X, 1, X}, //226
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{1, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X}, //241
				
				{X, 3, 2, 0, 1, 0}, //242
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1}, //256
				
				{X, 3, 2, 0, 1, 0}, //257
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{X, 3, 2, 0, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{X, 0, 2, 2, 1, 0},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1},
				{1, 3, 3, 2, 1, 1}, //273
				
				{X, 3, X, X, 1, X}, //274
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X}, //281
				
				{1, X, X, X, 1, X}, //282
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X}, //289
				
				{X, 3, X, X, 1, X}, //290
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X}, //297
				
				{1, X, X, X, 1, X}, //298
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 0, X, X}, //305
				
				{X, 3, 2, 0, 1, 0}, //306
				
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[]{
			"I don`t know you",
			"But I want you",
			"All the more for that",
			"",
			"Words fall through me",
			"And always fool me",
			"And I can`t react",
			"",
			"And games that never amount",
			"To more than they`re meant",
			"Will play themselves out",
			"",
			"Take this sinking boat and point it home",
			"We`ve still got time",
			"Raise your hopeful voice you have a choice",
			"You`ve made it now",
			"",
			"Falling slowly",
			"Eyes that know me",
			"And I can`t go back",
			"",
			"Moods that take me",
			"And erase me",
			"And I`m painted black",
			"",
			"You have suffered enough",
			"And warred with yourself",
			"It`s time that you won",
			"",
			"Take this sinking boat and point it home",
			"We`ve still got time",
			"Raise your hopeful voice you had a choice",
			"You`ve made it now",
			"",
			"Falling slowly",
			"Sing your melody",
			"I`ll sing alon",
			""
		};
		song.lyricIndex = new int[]{ //38
			0, 8, 16, 26, 32, 40, 48, 58, 64, 74,
			82, 100, 103, 113, 120, 129, 136, 137, 145, 153,
			163, 169, 177, 185, 196, 202, 212, 220, 234, 241,
			251, 257, 266, 273, 274, 282, 290, 300 
		};
		song.lyricLength = song.lyric.length;
	}
	
	private static void loadWakeMeUpWhenSeptemberEnds() {
		song = new Song();
		song.title = "Wake Me Up When September Ends - Green Day";
		song.position = new int[][]{
				{X, X, 5, X, X, X}, //0
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, 
				{X, X, 5, X, X, X}, 
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //11
				
				{X, X, 5, X, X, X}, //12
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //35
				
				{X, 3, X, X, X, X}, //36
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //63
				
				{X, X, 5, X, X, X}, //64
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //87
				
				{X, 3, X, X, X, X}, //88
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{2, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //116
				
				{0, X, X, X, X, X}, //117
				{X, 2, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, X, 0, X, X},
				{0, X, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, 0, X, X, X},
				{X, 2, X, X, X, X},
				{X, X, 4, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 2, X, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{2, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //145
				
				{0, X, X, X, X, X}, //146
				{X, 2, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, X, 0, X, X},
				{0, X, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, 0, X, X, X},
				{X, 2, X, X, X, X},
				{X, X, 4, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 2, X, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 5, X, X, X, X},
				{X, X, 7, X, X, X},
				{X, X, X, 7, 7, X},
				{X, X, X, 7, X, X},
				{X, 5, X, X, X, X},
				{X, X, X, 7, 7, X},
				{X, X, X, 7, X, X},
//				{X, X, X, 0, X, X}, 
				
				{X, X, 5, X, X, X}, //176
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //198
				
				{X, 3, X, X, X, X}, //199
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //226
				
				{X, X, 5, X, X, X}, //227
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //232
				
				{X, X, 5, X, X, X}, //233
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //257
				
				{X, 3, X, X, X, X}, //258
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //285
				
				{X, X, 5, X, X, X}, //286
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, 
				
				{X, 3, X, X, X, X}, //309
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{2, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //338
				
				{0, X, X, X, X, X}, //339
				{X, 2, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, X, 0, X, X},
				{0, X, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, 0, X, X, X},
				{X, 2, X, X, X, X},
				{X, X, 4, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 2, X, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{2, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //367
				
				{0, X, X, X, X, X}, //368
				{X, 2, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, X, 0, X, X},
				{0, X, X, X, X, X},
				{X, X, X, 0, 0, X},
				{X, X, 0, X, X, X},
				{X, 2, X, X, X, X},
				{X, X, 4, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 2, X, X, X, X},
				{X, X, X, 4, 3, X},
				{X, X, X, 4, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 5, X, X, X, X},
				{X, X, 7, X, X, X},
				{X, X, X, 7, 7, X},
				{X, X, X, 7, X, X},
				{X, 5, X, X, X, X},
				{X, X, X, 7, 7, X},
				{X, X, X, 7, X, X},
//				{X, X, X, 0, X, X}, //396
				
				{X, X, 5, X, X, X}, //397
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 5, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 4, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X}, //420
				
				{X, 3, X, X, X, X}, //421
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //448
				
				{X, 3, X, X, X, X}, //449
				{X, X, 5, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 5, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, 5, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, 5, 4, X},
				{X, X, X, 5, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X},
				{3, X, X, X, X, X},
				{X, X, X, 0, 3, X},
				{X, X, X, 0, X, X}, //476
				
				{3, 2, 0, 0, 3, 3}, //477
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[] {
				"",
				"Summer has come and past",
				"The innocent can never last",
				"Wake me up when September ends",
				"",
				"Like my fathers come to pass",
				"Seven years has gone so fast",
				"Wake me up when September ends",
				"",
				"Here comes the rain again",
				"Falling from the stars",
				"",
				"Drenched in my pain again",
				"Becoming who we are",
				"",
				"As my memory rests",
				"But never forgets what I lost",
				"Wake me up when September ends",
				"",
				"Summer has come and past",
				"The innocent can never last",
				"Wake me up when September ends",
				"",
				"Ring out the bells again",
				"Like we did when spring began",
				"Wake me up when September ends",
				"",
				"Here comes the rain again",
				"Falling from the stars",
				"",
				"Drenched in my pain again",
				"Becoming who we are",
				"",
				"As my memory rests",
				"But never forgets what I lost",
				"Wake me up when September ends",
				"",
				"Wake me up when September ends",
				""
		};
		song.lyricIndex = new int []{ //39
			0, 12, 23, 36, 54, 64, 75, 88, 106, 117, 131,
			142, 146, 160, 171, 174, 186, 198, 216, 232, 243,
			256, 274, 284, 296, 308, 326, 337, 351, 362, 366,
			380, 391, 394, 406, 418, 436, 446, 464
		};
		song.lyricLength = song.lyric.length;	
	}
	
	private static void loadRomance() {
		song = new Song();
		song.title = "Romance";
		song.position = new int[][]{
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 10},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{X, 0, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{7, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{7, X, X, X, X, 11},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			
			{X, 2, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			
			{X, X, 2, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, 2, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{3, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, 0, 0, 0},

			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 10},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{X, 0, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{7, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{7, X, X, X, X, 11},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			
			{X, 2, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			
			{X, X, 2, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, 2, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{3, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, 0, 0, 0},
			
			{0, X, X, X, X, 4},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{X, X, X, X, X, 4},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{X, X, X, X, X, 4},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			
			{0, X, X, X, X, 4},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			
			{2, X, X, X, 5, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			
			{2, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 3, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, 4, X, X, X},
			
			{7, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{7, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 11},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{0, X, X, X, X, 9},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 11},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 11},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 10},
			{X, X, X, X, 9, X},
			{X, X, X, 9, X, X},
			
			{X, 0, X, X, X, 9},
			{X, X, X, X, 10, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 10, X},
			{X, X, X, 9, X, X},
			{X, X, X, X, X, 9},
			{X, X, X, X, 10, X},
			{X, X, X, 9, X, X},
			
			{X, 0, X, X, X, 9},
			{X, X, X, X, 5, X},
			{X, X, X, 6, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 6, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 6, X, X},
			
			{0, X, X, X, X, 4},
			{X, X, X, X, 5, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, X, 4},
			{X, X, X, X, 5, X},
			{X, X, X, 4, X, X},
			{X, X, X, X, X, 4},
			{X, X, X, X, 5, X},
			{X, X, X, 4, X, X},
			
			{X, 2, X, X, X, 4},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 4, X},
			{X, X, X, 2, X, X},
			
			{X, X, 2, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{X, 2, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			{4, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 1, X, X},
			
			{0, X, X, 1, 0, 0},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 12},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 10},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{X, 0, X, X, X, 5},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 5, X},
			{X, X, X, 5, X, X},
			
			{7, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{7, X, X, X, X, 11},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 8},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			{X, X, X, X, X, 7},
			{X, X, X, X, 7, X},
			{X, X, X, 8, X, X},
			
			{0, X, X, X, X, 7},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 5},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{X, 0, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 1, X},
			{X, X, X, 2, X, X},
			
			{X, 2, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 3},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			{X, X, X, X, X, 2},
			{X, X, X, X, 0, X},
			{X, X, X, 2, X, X},
			
			{X, X, 2, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{X, 2, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			{3, X, X, X, X, 0},
			{X, X, X, X, 0, X},
			{X, X, X, 0, X, X},
			
			{0, X, X, 0, 0, 0}
		};
		song.songLength = song.position.length;
		song.bLyric = false;
		song.lyric = null;
		song.lyricIndex = null;
		song.lyricLength = 0;
	}
	
	private static void addHotelCalifornia() {
		song = new Song();
		song.title = "Hotel California - The Eagls";
		song.position = new int[][]{
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, 0, X, X, X, X},
				
				{4, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 0, X},
				{X, X, X, 1, X, X},
				
				{3, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 0, X, X},
				{X, X, 0, X, X, X},
				
				{2, X, X, X, X, X},
				{X, X, X, X, 1, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				
				{1, X, X, X, X, X},
				{X, X, X, 2, X, X},
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, X, 1, X},
				{X, X, X, 2, X, X},
				{X, X, 3, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 1, X},
				
				{X, 3, X, X, X, X},
				{X, X, X, X, X, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 1, X},
				{X, X, X, X, X, 0},
				{X, X, 2, 0, X, X},
				
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 1},
				{X, X, X, 2, X, X},
				{X, X, 0, X, X, X},
				
				{0, X, X, X, X, X},
				{X, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 1, 0, 0}
		};
		song.songLength = song.position.length;
		song.bLyric = false;
		song.lyric = null;
		song.lyricIndex = null;
		song.lyricLength = 0;
	}
	
	private static void loadWindSong() {
		song = new Song();
		song.title = "Wind Song - Kotaro Oshio";
		song.position = new int[][]{
				{X, X, 7, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{9, X, X, X, 7, X},
				{X, X, 8, X, X, X},
				{X, X, X, 9, X, X},
				{X, X, 8, X, X, X},
				{7, X, X, 7, X, X},
				{X, X, X, X, 5, X},
				{X, 0, X, X, 7, X},
				{X, X, X, 7, X, X},
				{3, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 0, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 5, X},
				{X, 2, X, X, 3, X},
				{X, X, 4, 2, X, X},
				{X, X, X, X, 7, X},
				{0, X, X, X, 7, X},
				{X, X, 6, 7, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, 0, X, X, X, 0},
				{X, X, 7, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{X, X, 4, X, X, 6},
				{X, X, X, 6, 5, X},
				{X, X, X, 7, X, 7},
				{X, X, X, 9, X, 9},
				{X, X, 9, X, X, 12},
				{X, X, X, 11, X, X},
				{X, X, X, X, X, 10},
				{X, X, X, X, 0, X},
				{X, X, X, 11, X, 10},
				{X, X, 9, X, X, X},
				{X, X, X, 9, X, 9},
				{X, X, 7, X, X, X},
				{X, X, 5, X, X, 7},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 7},
				{X, X, 4, X, X, 5},
				{X, X, X, X, 0, X},
				{X, X, X, 6, X, X},
				{X, X, X, X, 0, X},
				{X, X, 2, X, X, 3},
				{X, X, X, 4, X, X},
				{X, 0, X, 0, X, 2},
				{X, X, X, X, X, 0},
				{X, X, 0, X, 3, X},
				{X, X, X, 2, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, 2, X, X},
				
				{X, 0, 4, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{9, X, X, X, 7, X},
				{X, X, 8, X, X, X},
				{X, X, X, 9, X, X},
				{X, X, 8, X, X, X},
				{7, X, X, 7, X, X},
				{X, X, X, X, 5, X},
				{X, 0, X, X, 7, X},
				{X, X, X, 7, X, X},
				{3, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 0, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 5, X},
				{X, 2, X, X, 3, X},
				{X, X, 4, 2, X, X},
				{X, X, X, X, 7, X},
				{0, X, X, X, 7, X},
				{X, X, 6, 7, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, 0, X, X, X, 0},
				{X, X, 7, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{X, X, 4, X, X, 6},
				{X, X, X, 6, 5, X},
				{X, X, X, 7, X, 7},
				{X, X, X, 9, X, 9},
				{X, X, 9, X, X, 12},
				{X, X, X, 11, X, X},
				{X, X, X, X, X, 10},
				{X, X, X, X, 0, X},
				{X, X, X, 11, X, 10},
				{X, X, 9, X, X, X},
				{X, X, X, 9, X, 9},
				{X, X, 7, X, X, X},
				{X, X, 5, X, X, 7},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 7},
				{X, X, 4, X, X, 5},
				{X, X, X, X, 0, X},
				{X, X, X, 6, X, X},
				{X, X, X, X, 0, X},
				{X, X, 2, X, X, 3},
				{X, X, X, 4, X, X},
				{X, 0, X, 0, X, 2},
				{X, X, X, X, X, 0},
				{X, X, 0, X, 3, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{3, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 2},
				{2, X, X, X, X, 0},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{0, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, 2, X, X, X},
				{X, 0, X, 0, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, 2, 2, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 0, X},
				{X, X, X, X, 2, X},
				{X, X, 0, 2, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{3, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 2},
				{2, X, X, X, X, 0},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{0, X, X, X, 3, X},
				{X, X, X, X, 0, X},
				{X, X, X, 2, 2, X},
				{X, X, X, X, 3, X},
				{2, X, X, X, X, 0},
				{X, X, X, X, 2, X},
				{X, X, X, 3, 3, X},
				{X, X, X, X, X, 0},
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 2},
				{X, X, X, 3, 3, 0},
				{X, X, 0, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{9, X, X, X, 7, X},
				{X, X, 8, X, X, X},
				{X, X, X, 9, X, X},
				{X, X, 8, X, X, X},
				{7, X, X, 7, X, X},
				{X, X, X, X, 5, X},
				{X, 0, X, X, 7, X},
				{X, X, X, 7, X, X},
				{3, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 0, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 5, X},
				{X, 2, X, X, 3, X},
				{X, X, 4, 2, X, X},
				{X, X, X, X, 7, X},
				{0, X, X, X, 7, X},
				{X, X, 6, 7, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, 0, X, X, X, 0},
				{X, X, 7, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{X, X, 4, X, X, 6},
				{X, X, X, 6, 5, X},
				{X, X, X, 7, X, 7},
				{X, X, X, 9, X, 9},
				{X, X, 9, X, X, 12},
				{X, X, X, 11, X, X},
				{X, X, X, X, X, 10},
				{X, X, X, X, 0, X},
				{X, X, X, 11, X, 10},
				{X, X, 9, X, X, X},
				{X, X, X, 9, X, 9},
				{X, X, 7, X, X, X},
				{X, X, 5, X, X, 7},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 7},
				{X, X, 4, X, X, 5},
				{X, X, X, X, 0, X},
				{X, X, X, 6, X, X},
				{X, X, X, X, 0, X},
				{X, X, 2, X, X, 3},
				{X, X, X, 4, X, X},
				{X, 0, X, 0, X, 2},
				{X, X, X, X, X, 0},
				{X, X, 0, X, 3, X},
				
				{X, X, X, 2, X, X},
				{X, X, 0, 2, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{2, X, X, 2, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 5},
				{3, X, X, X, X, 5},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 3},
				{X, 1, X, X, X, 3},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				{X, 0, X, X, X, 2},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 2, X, X},
				{4, X, X, X, 0, X},
				{X, X, 2, X, X, X},
				{X, X, X, 4, X, 0},
				{X, X, X, X, 0, X},
				{3, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				{X, 0, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, 2, X},
				{X, X, 2, X, X, X},
				{X, X, 0, 2, X, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, X, X, X},
				{2, X, X, 2, 3, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, X, 5},
				{3, X, X, X, X, 5},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 3},
				{X, 1, X, X, X, 3},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				{X, 0, X, X, X, 2},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 2, X, X},
				{X, 0, X, 0, 0, 0},
				{X, X, X, 0, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, X, X, 3},
				{X, 0, X, X, X, 2},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, 2, X, X},
				{X, 0, X, 0, 0, 0},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{3, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 2},
				{2, X, X, X, X, 0},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{0, X, X, X, 3, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, 2, X, X, X},
				{X, 0, X, 0, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 3, X},
				{X, X, 0, 2, 2, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, 0, X},
				{X, X, X, X, 2, X},
				{X, X, 0, 2, X, X},
				{X, X, X, X, 2, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{3, X, X, 2, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 2},
				{2, X, X, X, X, 0},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, X, 0},
				{0, X, X, X, 3, X},
				{X, X, X, X, 0, X},
				{X, X, X, 2, 2, X},
				{X, X, X, X, 3, X},
				{2, X, X, X, X, 0},
				{X, X, X, X, 2, X},
				{X, X, X, 3, 3, X},
				{X, X, X, X, X, 0},
				{3, X, X, X, X, 2},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, X, 2},
				{X, X, X, 3, 3, 0},
				{X, X, 0, X, X, X},
				{X, X, X, 3, X, X},
				{X, X, X, X, 3, X},
				
				{X, 0, X, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{9, X, X, X, 7, X},
				{X, X, 8, X, X, X},
				{X, X, X, 9, X, X},
				{X, X, 8, X, X, X},
				{7, X, X, 7, X, X},
				{X, X, X, X, 5, X},
				{X, 0, X, X, 7, X},
				{X, X, X, 7, X, X},
				{3, X, X, X, 0, X},
				{X, X, 0, X, X, X},
				{X, X, X, 0, X, X},
				{X, X, X, X, 0, X},
				{2, X, X, 2, X, X},
				{X, X, 2, X, X, X},
				{X, X, X, X, 5, X},
				{X, 2, X, X, 3, X},
				{X, X, 4, 2, X, X},
				{X, X, X, X, 7, X},
				{0, X, X, X, 7, X},
				{X, X, 6, 7, X, X},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, 0, X, X, X, 0},
				{X, X, 7, X, X, X},
				{X, X, X, X, 10, X},
				{X, X, 0, X, 8, X},
				{X, X, 0, X, X, X},
				{X, X, X, X, 7, X},
				{X, X, 0, X, X, X},
				{X, X, 4, X, X, 6},
				{X, X, X, 6, 5, X},
				{X, X, X, 7, X, 7},
				{X, X, X, 9, X, 9},
				{X, X, 9, X, X, 12},
				{X, X, X, 11, X, X},
				{X, X, X, X, X, 10},
				{X, X, X, X, 0, X},
				{X, X, X, 11, X, 10},
				{X, X, 9, X, X, X},
				{X, X, X, 9, X, 9},
				{X, X, 7, X, X, X},
				{X, X, 5, X, X, 7},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 7},
				{X, X, 4, X, X, 5},
				{X, X, X, X, 0, X},
				{X, X, X, 6, X, X},
				{X, X, X, X, 0, X},
				{X, X, 2, X, X, 3},
				{X, X, X, 4, X, X},
				{X, 0, X, 0, X, 2},
				{X, X, X, X, X, 0},
				{X, X, 0, X, 3, X},
				
				{X, X, X, X, X, 7},
				{X, X, 5, X, X, 7},
				{X, X, X, X, 0, X},
				{X, X, X, 7, X, X},
				{X, X, X, X, X, 7},
				{X, X, 4, X, X, 5},
				{X, X, X, X, 0, X},
				{X, X, X, 6, X, X},
				{X, X, X, X, 0, X},
				{X, X, 2, X, X, 3},
				{X, X, X, 4, X, X},
				{X, 0, X, 0, X, 2},
				{X, X, X, X, X, 0},
				{X, X, 0, X, 3, X},
				{X, X, X, 2, X, X},
				{X, X, X, X, 3, X},
				{X, X, X, X, X, 0},
				{X, X, 0, 2, 3, 2},
		};
		song.songLength = song.position.length;
		song.bLyric = false;
		song.lyric = null;
		song.lyricIndex = null;
		song.lyricLength = 0;
	}
	
	private static void loadNoSurprises() {
		song = new Song();
		song.title = "No Surprises - Radiohead";
		song.position = new int[][]{
				{X, X, X, X, X, 5}, //0
				{X, X, X, 5, X, X}, //1
				{X, X, X, X, 6, X}, //2
				{X, X, X, 5, X, X}, //3
				{X, X, X, X, X, 5}, //4
				{X, X, X, 5, X, X}, //5
				{X, X, X, X, 6, X}, //6
				{X, X, X, 5, X, X}, //7
				{X, X, X, X, X, 5}, //8
				{X, X, X, 5, X, X}, //9
				{X, X, X, X, 6, X}, //10
				{X, X, X, 5, X, X}, //11
				{X, X, X, 3, X, X}, //12
				{X, X, X, 6, X, X}, //13
				{X, X, X, X, 6, X}, //14
				{X, X, X, X, X, 3}, //15
				{X, X, X, X, X, 5}, //16
				{X, X, X, 5, X, X}, //17
				{X, X, X, X, 6, X}, //18
				{X, X, X, 5, X, X}, //19
				{X, X, X, X, X, 5}, //20
				{X, X, X, 5, X, X}, //21
				{X, X, X, X, 6, X}, //22
				{X, X, X, 5, X, X}, //23
				{X, X, X, X, X, 5}, //24
				{X, X, X, 5, X, X}, //25
				{X, X, X, X, 6, X}, //26
				{X, X, X, 5, X, X}, //27
				{X, X, X, 3, X, X}, //28
				{X, X, X, 6, X, X}, //29
				{X, X, X, X, 6, X}, //30
				{X, X, X, X, X, 3}, //31
				
				{X, X, X, X, X, 5}, //32 0
				{X, X, X, 5, X, X}, //1
				{X, X, X, X, 6, X}, //2
				{X, X, X, 5, X, X}, //3
				{X, X, X, X, X, 5}, //4
				{X, X, X, 5, X, X}, //5
				{X, X, X, X, 6, X}, //6
				{X, X, X, 5, X, X}, //7
				{X, X, X, X, X, 5}, //8
				{X, X, X, 5, X, X}, //9
				{X, X, X, X, 6, X}, //10
				{X, X, X, 5, X, X}, //11
				{X, X, X, 3, X, X}, //12
				{X, X, X, 6, X, X}, //13
				{X, X, X, X, 6, X}, //14
				{X, X, X, X, X, 3}, //15
				{X, X, X, X, X, 5}, //16
				{X, X, X, 5, X, X}, //17
				{X, X, X, X, 6, X}, //18
				{X, X, X, 5, X, X}, //19
				{X, X, X, X, X, 5}, //20
				{X, X, X, 5, X, X}, //21
				{X, X, X, X, 6, X}, //22
				{X, X, X, 5, X, X}, //23
				{X, X, X, X, X, 5}, //24
				{X, X, X, 5, X, X}, //25
				{X, X, X, X, 6, X}, //26
				{X, X, X, 5, X, X}, //27
				{X, X, X, 3, X, X}, //28
				{X, X, X, 6, X, X}, //29
				{X, X, X, X, 6, X}, //30
				{X, X, X, X, X, 3}, //63 31
				
				//verse1
				{X, X, X, X, X, 5}, //64 
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //88
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //95
				
				{X, X, X, X, X, 6}, //96
				{X, X, X, X, 3, X}, //97
				{X, X, X, X, 6, X}, //98
				{X, X, X, X, 3, X}, //99
				{X, X, X, X, X, 6}, //100
				{X, X, X, X, 3, X}, //101
				{X, X, X, X, 6, X}, //102
				{X, X, X, X, 3, X}, //103
				{X, X, X, X, 6, X}, //104
				{X, X, X, X, 5, X}, //105
				{X, X, X, 5, X, X}, //106
				{X, X, 5, X, X, X}, //107
				{X, X, 5, X, X, X}, //108
				{X, X, 7, X, X, X}, //109
				{X, X, X, 5, X, X}, //110
				{X, X, X, 3, X, X}, //111
				
				{X, X, X, X, X, 5}, //112
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //120
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //127
				
				{X, X, X, X, X, 5}, //128 64 
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //145
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //152
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //159 95
				
				{X, X, X, X, X, 6}, //160 96
				{X, X, X, X, 3, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, 3, X}, //
				{X, X, X, X, X, 6}, //
				{X, X, X, X, 3, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, 3, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, 7, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //175 111
				
				{X, X, X, X, X, 5}, //176 112
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //184
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //191 127
				
				{X, X, X, X, X, 5}, //192 128  
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //209
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //223 159
				
				{X, X, X, 7, X, X}, //224
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //231
				
				{X, X, 5, X, X, X}, //232
				{X, X, 7, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 7, X, X, X}, //
				{X, X, 5, X, X, X}, //236
				
				{X, X, X, 7, X, X}, //237
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //244
				
				{X, X, 5, X, X, X}, //245
				{X, X, 5, X, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, 5, X, X, X}, //251
				
				{X, X, X, 7, X, X}, //252
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //259
				
				{X, X, 5, X, X, X}, //260
				{X, X, X, 3, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 2, X, X}, //
				{X, X, 3, X, X, X}, //264
				
				{X, X, X, X, X, 5}, //265 176
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //296
				
				{X, X, X, X, X, 5}, //297 192  
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //313 
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //105
				{X, X, X, 3, X, X}, //328 223
				
				{X, X, X, 7, X, X}, //329 224
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //336 231
				
				{X, X, 5, X, X, X}, //337 232
				{X, X, 7, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 7, X, X, X}, //
				{X, X, 5, X, X, X}, //341 236
				
				{X, X, X, 7, X, X}, //342 237
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //349 244
				
				{X, X, 5, X, X, X}, //350 245
				{X, X, 5, X, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, 5, X, X, X}, //356 251
				
				{X, X, X, 7, X, X}, //357 252
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //364 259
				
				{X, X, 5, X, X, X}, //365 260
				{X, X, X, 3, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 2, X, X}, //
				{X, X, 3, X, X, X}, //369 264
				
				{X, X, X, X, X, 5}, //370 265
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //385
				
				{X, X, X, X, 5, X}, //386
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 6}, //
				{X, X, X, X, X, 8}, //
				{X, X, X, X, X, 6}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 6, X, X}, //402
				
				{X, X, X, X, 5, X}, //403 386
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 6}, //
				{X, X, X, X, X, 8}, //
				{X, X, X, X, X, 6}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 6, X, X}, //419 402
				
				{X, X, 5, X, X, X}, //420
				{X, X, 5, X, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, X, 3}, //
				{X, X, X, X, 3, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 4, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //431
				
				{X, X, X, X, X, 5}, //432 297   
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //449
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, X, 6, X}, //135
				{X, X, X, 3, X, X}, //463 328
				
				{X, X, X, 7, X, X}, //464 329
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //471 336
				
				{X, X, 5, X, X, X}, //472 337
				{X, X, 7, X, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, 7, X, X, X}, //
				{X, X, 5, X, X, X}, //476 341
				
				{X, X, X, 7, X, X}, //477 342
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //484 349
				
				{X, X, 5, X, X, X}, //485 350
				{X, X, 5, X, X, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, 5, X, X, X}, //
				{X, X, X, X, 5, X}, //
				{X, X, 5, X, X, X}, //491 356
				
				{X, X, X, 7, X, X}, //492 357
				{X, X, X, 5, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 7, 5, X, X}, //
				{X, X, 5, 3, X, X}, //499 364
				
				{X, X, 5, X, X, X}, //500 365
				{X, X, X, 3, X, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 2, X, X}, //
				{X, X, 3, X, X, X}, //504 369
				
				{X, X, X, X, X, 5}, //505 370
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //520 385
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, X, 5}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, 5, X, X}, //
				{X, X, X, 3, X, X}, //
				{X, X, X, 6, X, X}, //
				{X, X, X, X, 6, X}, //
				{X, X, X, X, X, 3}, //536
				{X, X, 3, 5, 6, 5}, //537
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[] {
				"", //0
				"A heart that's full up like a landfill", //1
				"A job that slowly kills you", //2
				"Bruises that won't heal", //3
				"", //4
				"You look so tired and unhappy", //5
				"Bring down the government", //6
				"They don't, they don't speak for us", //7
				"", //8
				"I'll take a quiet life", //9
				"A handshake of carbon monoxide", //10
				"No alarms and no surprises", //11
				"No alarms and no surprises", //12
				"No alarms and no surprises", //13
				"Silent, silent", //14
				"", //15
				"This is my final fit", //16
				"My final bellyache with", //17
				"No alarms and no surprises", //18
				"No alarms and no surprises", //19 
				"No alarms and no surprises please", //20
				"", //21
				"Such a pretty house", //22
				"Such a pretty garden", //23
				"No alarms and no surprises", //24
				"No alarms and no surprises", //25
				"No alarms and no surprises please", //26
				"" //27
		};
		song.lyricIndex = new int []{ //28
			0, 64, 88, 105, 120, 128, 145, 160, 184, 192,
			209, 224, 237, 252, 265, 294, 297, 313, 329, 342,
			357, 378, 432, 449, 464, 477, 492, 521
			
		};
		song.lyricLength = song.lyric.length;	
	}
	
	private static void loadShapeOfMyHeart() {
		song = new Song();
		song.title = "Shape of my heart - Sting";
		song.position = new int[][]{
				{X, X, X, X, 10, X},	//0
				{X, 9, X, X, X, X},	//1
				{X, X, X, 6, X, X},	//2
				{X, X, X, X, 10, X},	//3
				{X, X, X, X, 9, X},	//4
				{X, 7, X, X, X, X},	//5
				{X, X, X, 6, X, X},	//6
				{X, X, X, X, 9, X},	//7
				{X, X, X, X, 7, X},	//8
				{X, 5, X, X, X, X},	//9
				{X, X, X, 4, X, X},	//10
				{X, X, X, X, 7, X},	//11
				{X, 4, X, X, 7, X},		//12
				{X, X, X, 4, X, X},	//13
				{X, X, X, X, 6, X},	//14
				{X, X, X, X, 10, X},	//15
				{X, 9, X, X, X, X},	//16
				{X, X, X, 6, X, X},	//17
				{X, X, X, X, 10, X},	//18
				{X, X, X, X, 9, X},	//19
				{X, 7, X, X, X, X},	//20
				{X, X, X, 6, X, X},	//21
				{X, X, X, X, 9, X},	//22
				{X, X, X, X, 7, X},	//23
				{X, 5, X, X, X, X},	//24
				{X, X, X, 4, X, X},	//25
				{X, X, X, X, 7, X},	//26
				{X, 4, X, X, 7, X},		//27
				{X, X, X, 4, X, X},	//28
				{X, X, X, X, 6, X},	//29
				{X, 4, X, X, X, X},	//30
				{X, 5, X, X, X, X},	//31
				{X, X, X, 4, X, X},	//32
				{X, X, X, X, 7, X},	//33
				{X, X, X, 6, X, X},	//34
				{X, X, X, X, X, 5},	//35
				{X, X, X, X, 7, X},	//36
				{X, X, X, 4, X, X},	//37
				{5, X, X, 4, 5, X},		//38
				{X, X, X, 2, X, X},	//39
				{X, X, X, X, 5, X},	//40
				{X, 4, X, X, X, X},	//41
				{X, X, 6, X, X, X},	//42
				{X, X, X, X, 6, X},	//43
				{X, 5, 7, X, 7, X},		//44
				{X, X, X, X, 5, X},	//45
				{X, X, X, 7, X, X},	//46
				{4, X, 4, 4, 2, X},		//47
				{X, X, X, 4, X, X},	//48
				{X, X, X, 2, X, X},	//49
				{2, 4, 4, 2, 2, 2},			//50
				
				{X, X, X, X, 10, X},	//51
				{X, 9, X, X, X, X},	//52
				{X, X, X, 6, X, X},	//53
				{X, X, X, X, 10, X},	//54
				{X, X, X, X, 9, X},	//55
				{X, 7, X, X, X, X},	//56
				{X, X, X, 6, X, X},	//57
				{X, X, X, X, 9, X},	//58
				{X, X, X, X, 7, X},	//59
				{X, 5, X, X, X, X},	//60
				{X, X, X, 4, X, X},	//61
				{X, X, X, X, 7, X},	//62
				{X, 4, X, X, 7, X},		//63
				{X, X, X, 4, X, X},	//64
				{X, X, X, X, 6, X},	//65
				{X, X, X, X, 10, X},	//66
				{X, 9, X, X, X, X},	//67
				{X, X, X, 6, X, X},	//68
				{X, X, X, X, 10, X},	//69
				{X, X, X, X, 9, X},	//70
				{X, 7, X, X, X, X},	//71
				{X, X, X, 6, X, X},	//72
				{X, X, X, X, 9, X},	//73
				{X, X, X, X, 7, X},	//74
				{X, 5, X, X, X, X},	//75
				{X, X, X, 4, X, X},	//76
				{X, X, X, X, 7, X},	//77
				{X, 4, X, X, 7, X},		//78
				{X, X, X, 4, X, X},	//79
				{X, X, X, X, 6, X},	//80
				{X, 4, X, X, X, X},	//81
				{X, 5, X, X, X, X},	//82
				{X, X, X, 4, X, X},	//83
				{X, X, X, X, 7, X},	//84
				{X, X, X, 6, X, X},	//85
				{X, X, X, X, X, 5},	//86
				{X, X, X, X, 7, X},	//87
				{X, X, X, 4, X, X},	//88
				{5, X, X, 4, 5, X},		//89
				{X, X, X, 2, X, X},	//90
				{X, X, X, X, 5, X},	//91
				{X, 4, X, X, X, X},	//92
				{X, X, 6, X, X, X},	//93
				{X, X, X, X, 6, X},	//94
				{X, 5, 7, X, 7, X},		//95
				{X, X, X, X, 7, X},	//96
				{4, X, 4, 4, 2, X},		//97
				{2, 4, 4, 2, 2, 2},			//98
				
				{X, X, X, X, 10, X},	//99
				{X, 9, X, X, X, X},	//100
				{X, X, X, 6, X, X},	//101
				{X, X, X, X, 10, X},	//102
				{X, X, X, X, 9, X},	//103
				{X, 7, X, X, X, X},	//104
				{X, X, X, 6, X, X},	//105
				{X, X, X, X, 9, X},	//106
				{X, X, X, X, 7, X},	//107
				{X, 5, X, X, X, X},	//108
				{X, X, X, 4, X, X},	//109
				{X, X, X, X, 7, X},	//110
				{X, 4, X, X, 7, X},		//111
				{X, X, X, 4, X, X},	//112
				{X, X, X, X, 6, X},	//113
				{X, X, X, X, 10, X},	//114
				{X, 9, X, X, X, X},	//115
				{X, X, X, 6, X, X},	//116
				{X, X, X, X, 10, X},	//117
				{X, X, X, X, 9, X},	//118
				{X, 7, X, X, X, X},	//119
				{X, X, X, 6, X, X},	//120
				{X, X, X, X, 9, X},	//121
				{X, X, X, X, 7, X},	//122
				{X, 5, X, X, X, X},	//123
				{X, X, X, 4, X, X},	//124
				{X, X, X, X, 7, X},	//125
				{X, 4, X, X, 7, X},		//126
				{X, X, X, 4, X, X},	//127
				{X, X, X, X, 6, X},	//128
				{X, 4, X, X, X, X},	//129
				{X, 5, X, X, X, X},	//130
				{X, X, X, 4, X, X},	//131
				{X, X, X, X, 7, X},	//132
				{X, X, X, 6, X, X},	//133
				{X, X, X, X, X, 5},	//134
				{X, X, X, X, 7, X},	//135
				{X, X, X, 4, X, X},	//136
				{5, X, X, 4, 5, X},		//137
				{X, X, X, 2, X, X},	//138
				{X, X, X, X, 5, X},	//139
				{X, 4, X, X, X, X},	//140
				{X, X, 6, X, X, X},	//141
				{X, X, X, X, 6, X},	//142
				{X, 5, 7, X, 7, X},		//143
				{X, X, X, X, 7, X},	//144
				{4, X, 4, 4, 2, X},		//145
				{2, 4, 4, 2, 2, 2},			//146
				
				{X, X, X, X, 10, X},	//147
				{X, 9, X, X, X, X},	//148
				{X, X, X, 6, X, X},	//149
				{X, X, X, X, 10, X},	//150
				{X, X, X, X, 9, X},	//151
				{X, 7, X, X, X, X},	//152
				{X, X, X, 6, X, X},	//153
				{X, X, X, X, 9, X},	//154
				{X, X, X, X, 7, X},	//155
				{X, 5, X, X, X, X},	//156
				{X, X, X, 4, X, X},	//157
				{X, X, X, X, 7, X},	//158
				{X, 4, X, X, 7, X},		//159
				{X, X, X, 4, X, X},	//160
				{X, X, X, X, 6, X},	//161
				{X, X, X, X, 10, X},	//162
				{X, 9, X, X, X, X},	//163
				{X, X, X, 6, X, X},	//164
				{X, X, X, X, 10, X},	//165
				{X, X, X, X, 9, X},	//166
				{X, 7, X, X, X, X},	//167
				{X, X, X, 6, X, X},	//168
				{X, X, X, X, 9, X},	//169
				{X, X, X, X, 7, X},	//170
				{X, 5, X, X, X, X},	//171
				{X, X, X, 4, X, X},	//172
				{X, X, X, X, 7, X},	//173
				{X, 4, X, X, 7, X},		//174
				{X, X, X, 4, X, X},	//175
				{X, X, X, X, 6, X},	//176
				{X, 4, X, X, X, X},	//177
				{X, 5, X, X, X, X},	//178
				{X, X, X, 4, X, X},	//179
				{X, X, X, X, 7, X},	//180
				{X, X, X, 6, X, X},	//181
				{X, X, X, X, X, 5},	//182
				{X, X, X, X, 7, X},	//183
				{X, X, X, 4, X, X},	//184
				{5, X, X, 4, 5, X},		//185
				{X, X, X, 2, X, X},	//186
				{X, X, X, X, 5, X},	//187
				{X, 4, X, X, X, X},	//188
				{X, X, 6, X, X, X},	//189
				{X, X, X, X, 6, X},	//190
				{X, 5, 7, X, 7, X},		//191
				{X, X, X, X, 7, X},	//192
				{4, X, 4, 4, 2, X},		//193
				{2, 4, 4, 2, 2, 2},			//194
				
				{X, X, X, X, 10, X},	//195 99 96
				{X, 9, X, X, X, X},	//196
				{X, X, X, 6, X, X},	//197
				{X, X, X, X, 10, X},	//198
				{X, X, X, X, 9, X},	//199
				{X, 7, X, X, X, X},	//200
				{X, X, X, 6, X, X},	//201
				{X, X, X, X, 9, X},	//202
				{X, X, X, X, 7, X},	//203
				{X, 5, X, X, X, X},	//204
				{X, X, X, 4, X, X},	//205
				{X, X, X, X, 7, X},	//206
				{X, 4, X, X, 7, X},		//207
				{X, X, X, 4, X, X},	//208
				{X, X, X, X, 6, X},	//209
				{X, X, X, X, 10, X},	//210
				{X, 9, X, X, X, X},	//211
				{X, X, X, 6, X, X},	//212
				{X, X, X, X, 10, X},	//213
				{X, X, X, X, 9, X},	//214
				{X, 7, X, X, X, X},	//215
				{X, X, X, 6, X, X},	//216
				{X, X, X, X, 9, X},	//217
				{X, X, X, X, 7, X},	//218
				{X, 5, X, X, X, X},	//219
				{X, X, X, 4, X, X},	//220
				{X, X, X, X, 7, X},	//221
				{X, 4, X, X, 7, X},		//222
				{X, X, X, 4, X, X},	//223
				{X, X, X, X, 6, X},	//224
				{X, 4, X, X, X, X},	//225
				{X, 5, X, X, X, X},	//226
				{X, X, X, 4, X, X},	//227
				{X, X, X, X, 7, X},	//228
				{X, X, X, 6, X, X},	//229
				{X, X, X, X, X, 5},	//230
				{X, X, X, X, 7, X},	//231
				{X, X, X, 4, X, X},	//232
				{5, X, X, 4, 5, X},		//233
				{X, X, X, 2, X, X},	//234
				{X, X, X, X, 5, X},	//235
				{X, 4, X, X, X, X},	//236
				{X, X, 6, X, X, X},	//237
				{X, X, X, X, 6, X},	//238
				{X, 5, 7, X, 7, X},		//239
				{X, X, X, X, 7, X},	//240
				{4, X, 4, 4, 2, X},		//241
				{2, 4, 4, 2, 2, 2},			//242
				
				{X, X, X, X, 10, X},	//243
				{X, 9, X, X, X, X},	//244
				{X, X, X, 6, X, X},	//245
				{X, X, X, X, 10, X},	//246
				{X, X, X, X, 9, X},	//247
				{X, 7, X, X, X, X},	//248
				{X, X, X, 6, X, X},	//249
				{X, X, X, X, 9, X},	//250
				{X, X, X, X, 7, X},	//251
				{X, 5, X, X, X, X},	//252
				{X, X, X, 4, X, X},	//253
				{X, X, X, X, 7, X},	//254
				{X, 4, X, X, 7, X},		//255
				{X, X, X, 4, X, X},	//256
				{X, X, X, X, 6, X},	//257
				{X, X, X, X, 10, X},	//258
				{X, 9, X, X, X, X},	//259
				{X, X, X, 6, X, X},	//260
				{X, X, X, X, 10, X},	//261
				{X, X, X, X, 9, X},	//262
				{X, 7, X, X, X, X},	//263
				{X, X, X, 6, X, X},	//264
				{X, X, X, X, 9, X},	//265
				{X, X, X, X, 7, X},	//266
				{X, 5, X, X, X, X},	//267
				{X, X, X, 4, X, X},	//268
				{X, X, X, X, 7, X},	//269
				{X, 4, X, X, 7, X},		//270
				{X, X, X, 4, X, X},	//271
				{X, X, X, X, 6, X},	//272
				{X, 4, X, X, X, X},	//273
				{X, 5, X, X, X, X},	//274
				{X, X, X, 4, X, X},	//275
				{X, X, X, X, 7, X},	//276
				{X, X, X, 6, X, X},	//277
				{X, X, X, X, X, 5},	//278
				{X, X, X, X, 7, X},	//279
				{X, X, X, 4, X, X},	//280
				{5, X, X, 4, 5, X},		//281
				{X, X, X, 2, X, X},	//282
				{X, X, X, X, 5, X},	//283
				{X, 4, X, X, X, X},	//284
				{X, X, 6, X, X, X},	//285
				{X, X, X, X, 6, X},	//286
				{X, 5, 7, X, 7, X},		//287
				{X, X, X, X, 7, X},	//288
				{4, X, 4, 4, 2, X},		//289

//				{2, 4, 4, 2, 2, 2},			//290
//				
//				{X, X, X, X, 10, X},	//291
//				{X, 9, X, X, X, X},	//292
//				{X, X, X, 6, X, X},	//293
//				{X, X, X, X, 10, X},	//294
//				{X, X, X, X, 9, X},	//295
//				{X, 7, X, X, X, X},	//296
//				{X, X, X, 6, X, X},	//297
//				{X, X, X, X, 9, X},	//298
//				{X, X, X, X, 7, X},	//299
//				{X, 5, X, X, X, X},	//300
//				{X, X, X, 4, X, X},	//301
//				{X, X, X, X, 7, X},	//302
//				{X, 4, X, X, 7, X},		//303
//				{X, X, X, 4, X, X},	//304
//				{X, X, X, X, 6, X},	//305
//				{X, X, X, X, 10, X},	//306
//				{X, 9, X, X, X, X},	//307
//				{X, X, X, 6, X, X},	//308
//				{X, X, X, X, 10, X},	//309
//				{X, X, X, X, 9, X},	//310
//				{X, 7, X, X, X, X},	//311
//				{X, X, X, 6, X, X},	//312
//				{X, X, X, X, 9, X},	//313
//				{X, X, X, X, 7, X},	//314
//				{X, 5, X, X, X, X},	//315
//				{X, X, X, 4, X, X},	//316
//				{X, X, X, X, 7, X},	//317
//				{X, 4, X, X, 7, X},		//318
//				{X, X, X, 4, X, X},	//319
//				{X, X, X, X, 6, X},	//320
//				{X, 4, X, X, X, X},	//321
//				{X, 5, X, X, X, X},	//322
//				{X, X, X, 4, X, X},	//323
//				{X, X, X, X, 7, X},	//324
//				{X, X, X, 6, X, X},	//325
//				{X, X, X, X, X, 5},	//326
//				{X, X, X, X, 7, X},	//327
//				{X, X, X, 4, X, X},	//328
//				{5, X, X, 4, 5, X},		//329
//				{X, X, X, 2, X, X},	//330
//				{X, X, X, X, 5, X},	//331
//				{X, 4, X, X, X, X},	//332
//				{X, X, 6, X, X, X},	//333
//				{X, X, X, X, 6, X},	//334
//				{X, 5, 7, X, 7, X},		//335
//				{X, X, X, X, 7, X},	//336
//				{X, X, X, X, 7, X},	//337
//				{4, X, 4, 4, 2, X},		//338
				
				//여기 아래서부터는 인덱스 290부터 시작임
				{2, 4, 4, 2, 2, 2},			//339 - 49
				{2, 4, 4, 2, 2, 2},			//340
				{2, 4, 2, 2, 2, 2},			//341
				{2, 4, 2, 2, 2, 2},			//342
				{X, 5, 7, X, 7, X},		//343
				{X, X, X, X, 7, X},	//344
				{X, X, X, X, 7, X},	//345
				{4, X, 4, 4, 2, X},		//346
				{4, X, 4, 4, 2, X},		//347
				{4, X, 4, 4, 2, X},		//348
				{4, X, 4, 4, 2, X},		//349
				{4, X, 4, 4, 2, X},		//350
				
				{X, X, X, 9, X, X},	//351
				{9, X, X, X, X, X},	//352
				{X, X, 6, X, X, X},	//353
				{X, X, X, 9, X, X},	//354
				{X, X, X, 8, X, X},	//355
				{7, X, X, X, X, X},	//356
				{X, X, 6, X, X, X},	//357
				{X, X, X, 8, X, X},	//358
				{X, X, X, 6, X, X},	//359
				{5, X, X, X, X, X},	//360
				{X, X, 4, X, X, X},	//361
				{X, X, X, 6, X, X},	//362
				{4, X, X, 6, X, X},		//363
				{X, X, 4, X, X, X},	//364
				{X, X, X, 5, X, X},	//365
				{X, X, X, 9, X, X},	//366
				{9, X, X, X, X, X},	//367
				{X, X, 7, X, X, X},	//368
				{X, X, X, 9, X, X},	//369
				{X, X, X, 8, X, X},	//370
				{7, X, X, X, X, X},	//371
				{X, X, 6, X, X, X},	//372
				{X, X, X, 8, X, X},	//373
				{X, X, X, 6, X, X},	//374
				{5, X, X, X, X, X},	//375
				{X, X, 4, X, X, X},	//376
				{X, X, X, 6, X, X},	//377
				{4, X, X, 6, X, X},		//378
				{X, X, 4, X, X, X},	//379
				{X, X, X, 5, X, X},	//380
				{4, X, X, X, X, X},	//381
				{5, X, X, X, X, X},	//382
				{X, X, 4, X, X, X},	//383
				{X, X, X, 6, X, X},	//384
				{X, X, 4, X, X, X},	//385
				{X, X, X, X, 5, X},	//386
				{X, X, X, 6, X, X},	//387
				{X, X, 4, X, X, X},	//388
				{0, X, X, X, X, X},	//389
				{X, 2, X, 1, X, X},		//390
				{4, X, X, X, X, X},	//391
				{X, 6, X, X, X, X},	//392
				{X, X, X, 5, X, X},	//393
			
				{5, 7, 7, 6, 5, 5},			//394
				{5, 7, 7, 6, 5, 5},			//395
				{4, 6, 4, 6, 4, 4},			//396
				{4, 6, 4, 6, 4, 4},			//397
				{X, 4, 6, 6, 5, 4},		//398
				{X, 4, 6, 6, 5, 4},		//399
				{X, 4, 6, 4, 5, 4},		//400
				{X, 4, 6, 4, 5, 4},		//401
				{5, 7, 7, 6, 5, 5},			//402
				{5, 7, 7, 6, 5, 5},			//403
				{4, 6, 4, 6, 4, 4},			//404
				{5, 7, 7, 6, 0, 0},			//405
				
				{X, X, X, X, 10, X},	//406
				{X, 9, X, X, X, X},	//407
				{X, X, X, 6, X, X},	//408
				{X, X, X, X, 10, X},	//409
				{X, X, X, X, 9, X},	//410
				{X, 7, X, X, X, X},	//411
				{X, X, X, 6, X, X},	//412
				{X, X, X, X, 9, X},	//413
				{X, X, X, X, 7, X},	//414
				{X, 5, X, X, X, X},	//415
				{X, X, X, 4, X, X},	//416
				{X, X, X, X, 7, X},	//417
				{X, 4, X, X, 7, X},		//418
				{X, X, X, 4, X, X},	//419
				{X, X, X, X, 6, X},	//420
				{X, X, X, X, 10, X},	//421
				{X, 9, X, X, X, X},	//422
				{X, X, X, 6, X, X},	//423
				{X, X, X, X, 10, X},	//424
				{X, X, X, X, 9, X},	//425
				{X, 7, X, X, X, X},	//426
				{X, X, X, 6, X, X},	//427
				{X, X, X, X, 9, X},	//428
				{X, X, X, X, 7, X},	//429
				{X, 5, X, X, X, X},	//430
				{X, X, X, 4, X, X},	//431
				{X, X, X, X, 7, X},	//432
				{X, 4, X, X, 7, X},		//433
				{X, X, X, 4, X, X},	//434
				{X, X, X, X, 6, X},	//435
				{X, 4, X, X, X, X},	//436
				{X, 5, X, X, X, X},	//437
				{X, X, X, 4, X, X},	//438
				{X, X, X, X, 7, X},	//439
				{X, X, X, 6, X, X},	//440
				{X, X, X, X, X, 5},	//441
				{X, X, X, X, 7, X},	//442
				{X, X, X, 4, X, X},	//443
				{5, X, X, 4, 5, X},		//444
				{X, X, X, 2, X, X},	//445
				{X, X, X, X, 5, X},	//446
				{X, 4, X, X, X, X},	//447
				{X, X, 6, X, X, X},	//448
				{X, X, X, X, 6, X},	//449
				{X, 5, 7, X, 7, X},		//450
				{X, X, X, X, 7, X},	//451
				{X, X, X, X, 7, X},	//452
				{4, X, 4, 4, 2, X},		//453
				{2, 4, 4, 2, 2, 2},			//454
				
				{X, X, X, X, 10, X},	//455
				{X, 9, X, X, X, X},	//456
				{X, X, X, 6, X, X},	//457
				{X, X, X, X, 10, X},	//458
				{X, X, X, X, 9, X},	//459
				{X, 7, X, X, X, X},	//460
				{X, X, X, 6, X, X},	//461
				{X, X, X, X, 9, X},	//462
				{X, X, X, X, 7, X},	//463
				{X, 5, X, X, X, X},	//464
				{X, X, X, 4, X, X},	//465
				{X, X, X, X, 7, X},	//466
				{X, 4, X, X, 7, X},		//467
				{X, X, X, 4, X, X},	//468
				{X, X, X, X, 6, X},	//469
				{X, X, X, X, 10, X},	//470
				{X, 9, X, X, X, X},	//471
				{X, X, X, 6, X, X},	//472
				{X, X, X, X, 10, X},	//473
				{X, X, X, X, 9, X},	//474
				{X, 7, X, X, X, X},	//475
				{X, X, X, 6, X, X},	//476
				{X, X, X, X, 9, X},	//477
				{X, X, X, X, 7, X},	//478
				{X, 5, X, X, X, X},	//479
				{X, X, X, 4, X, X},	//480
				{X, X, X, X, 7, X},	//481
				{X, 4, X, X, 7, X},		//482
				{X, X, X, 4, X, X},	//483
				{X, X, X, X, 6, X},	//484
				{X, 4, X, X, X, X},	//485
				{X, 5, X, X, X, X},	//486
				{X, X, X, 4, X, X},	//487
				{X, X, X, X, 7, X},	//488
				{X, X, X, 6, X, X},	//489
				{X, X, X, X, X, 5},	//490
				{X, X, X, X, 7, X},	//491
				{X, X, X, 4, X, X},	//492
				{5, X, X, 4, 5, X},		//493
				{X, X, X, 2, X, X},	//494
				{X, X, X, X, 5, X},	//495
				{X, 4, X, X, X, X},	//496
				{X, X, 6, X, X, X},	//497
				{X, X, X, X, 6, X},	//498
				{X, 5, 7, X, 7, X},		//499
				{X, X, X, X, 7, X},	//500
				{X, X, X, X, 7, X},	//501
				{4, X, 4, 4, 2, X},		//502
				{2, 4, 4, 2, 2, 2},			//503
				
				{X, X, X, X, 10, X},	//504
				{X, 9, X, X, X, X},	//505
				{X, X, X, 6, X, X},	//506
				{X, X, X, X, 10, X},	//507
				{X, X, X, X, 9, X},	//508
				{X, 7, X, X, X, X},	//509
				{X, X, X, 6, X, X},	//510
				{X, X, X, X, 9, X},	//511
				{X, X, X, X, 7, X},	//512
				{X, 5, X, X, X, X},	//513
				{X, X, X, 4, X, X},	//514
				{X, X, X, X, 7, X},	//515
				{X, 4, X, X, 7, X},		//516
				{X, X, X, 4, X, X},	//517
				{X, X, X, X, 6, X},	//518
				{X, X, X, X, 10, X},	//519
				{X, 9, X, X, X, X},	//520
				{X, X, X, 6, X, X},	//521
				{X, X, X, X, 10, X},	//522
				{X, X, X, X, 9, X},	//523
				{X, 7, X, X, X, X},	//524
				{X, X, X, 6, X, X},	//525
				{X, X, X, X, 9, X},	//526
				{X, X, X, X, 7, X},	//527
				{X, 5, X, X, X, X},	//528
				{X, X, X, 4, X, X},	//529
				{X, X, X, X, 7, X},	//530
				{X, 4, X, X, 7, X},		//531
				{X, X, X, 4, X, X},	//532
				{X, X, X, X, 6, X},	//533
				{X, 4, X, X, X, X},	//534
				{X, 5, X, X, X, X},	//535
				{X, X, X, 4, X, X},	//536
				{X, X, X, X, 7, X},	//537
				{X, X, X, 6, X, X},	//538
				{X, X, X, X, X, 5},	//539
				{X, X, X, X, 7, X},	//540
				{X, X, X, 4, X, X},	//541
				{5, X, X, 4, 5, X},		//542
				{X, X, X, 2, X, X},	//543
				{X, X, X, X, 5, X},	//544
				{X, 4, X, X, X, X},	//545
				{X, X, 6, X, X, X},	//546
				{X, X, X, X, 6, X},	//547
				{X, 5, 7, X, 7, X},		//548
				{X, X, X, X, 7, X},	//549
				{X, X, X, X, 7, X},	//550
				{4, X, 4, 4, 2, X},		//551
				
				{2, 4, 4, 2, 2, 2},			//553
				{2, 4, 4, 2, 2, 2},			//554
				{2, 4, 2, 2, 2, 2},			//555
				{2, 4, 2, 2, 2, 2},			//556
				{X, 5, 7, X, 7, X},		//557
				{X, X, X, X, 7, X},	//558
				{X, X, X, X, 7, X},	//559
				{4, X, 4, 4, 2, X},		//560
				{2, 4, 4, 2, 2, 2},			//562
				{2, 4, 4, 2, 2, 2},			//563
				{2, 4, 2, 2, 2, 2},			//564
				{2, 4, 2, 2, 2, 2},			//565
				{X, 5, 7, X, 7, X},		//567
				{X, X, X, X, 7, X},	//568
				{X, X, X, X, 7, X},	//569
				{4, X, 4, 4, 2, 2},		//570
				{X, X, 4, 4, 2, 2},		//571
				{X, X, 4, 4, 2, 2},		//572
				{X, X, 4, 4, 2, 2},		//573
				{4, X, 4, 4, 2, 2},		//574
			
				{X, X, X, X, 10, X},	//575
				{X, 9, X, X, X, X},	//576
				{X, X, X, 6, X, X},	//577
				{X, X, X, X, 10, X},	//578
				{X, X, X, X, 9, X},	//579
				{X, 7, X, X, X, X},	//580
				{X, X, X, 6, X, X},	//581
				{X, X, X, X, 9, X},	//582
				{X, X, X, X, 7, X},	//583
				{X, 5, X, X, X, X},	//584
				{X, X, X, 4, X, X},	//585
				{X, X, X, X, 7, X},	//586
				{X, 4, X, X, 7, X},		//587
				{X, X, X, 4, X, X},	//588
				{X, X, X, X, 6, X},	//589
				{X, X, X, X, 3, X},	//590
				{X, 2, X, X, X, X},	//591
				{X, X, 4, X, X, X},	//592
				{X, X, X, X, 3, X},	//593
				{X, X, X, X, 2, X},	//594
				{X, 0, X, X, X, X},	//595
				{X, X, 2, X, X, X},	//596
				{X, X, X, X, 2, X},	//597
				{X, X, X, 4, X, X},	//598
				{4, X, X, X, X, X},	//599
				{X, X, 3, X, X, X},	//600
				{X, X, X, 4, X, X},	//601
				{X, 4, X, X, 7, X},		//602
				{X, X, 7, X, X, X},	//603
				{X, X, X, 4, X, X},	//604
				{X, X, X, X, 6, X},	//605
				{X, X, X, X, X, 4},	//606
				{2, 4, 4, 2, 2, 2},			//607
				{X, X, X, 14, 14, 14},	//608
				
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[] {
				"", //0
				"He deals the cards as a meditation", //1
				"And those he plays never suspect", //2
				"He doesn`t play for the money he wins", //3
				"He doesn`t play for respect", //4
				"", //5
				"He deals the cards to find the answer", //6 
				"The sacred geometry of chance", //7
				"The hidden law of a probable outcome", //8
				"The numbers lead a dance", //9
				"", //10
				"I know that the spades are the swords of a soldier", //11
				"I know that the clubs are wepons of war", //12
				"I know that diamonds mean money for this art", //13
				"But that`s not the shape of my heart", //14
				"", //15
				"He may play the jack of diamonds", //16
				"He may lay the queen of spades", //17
				"He may conceal a king in his hand", //18
				"While the memory of it fades", //19
				"", //20
				"I know that the spades are the swords of a soldier", //21
				"I know that the clubs are wepons of war", //22
				"I know that diamonds mean money for this art", //23
				"But that`s not the shape of my heart", //24
				"That`s not the shape, shape of my heart", //25
				"", //26
				"And if I told you that I loved you", //27
				"You`d maybe think there`s something wrong", //28
				"I`m not a man of too many faces", //29
				"The mask I wear is one", //30
				"", //31
				"Those who speak know nothing", //32
				"And find out to their cost", //33
				"Like those who curse their luck in too many places", //34
				"And those who fear are lost", //35
				"", //36
				"I know that the spades are the swords of a soldier", //37
				"I know that the clubs are wepons of war", //38
				"I know that diamonds mean money for this art", //39
				"But that`s not the shape of my heart", //40
				"", //41
				"That`s not the shape of my heart", //42
				"", //43
				"That`s not the shape, shape of my heart", //44
				"" //45
		};
		song.lyricIndex = new int []{ //46
			0, 51, 66, 81, 95, 98, 99, 114, 129, 143,
			146, 147, 162, 177, 191, 194, 195, 210, 225, 239,
			242, 243, 258, 273, 287, 294, 302, 357, 372, 387,
			401, 405, 406, 421, 436, 450, 454, 455, 470, 485,
			499, 505, 507, 513, 516, 524
			
			
		};
		song.lyricLength = song.lyric.length;	
	}
	
	private static void loadMarryMe() {
		song = new Song();
		song.title = "Marry Me - Train";
		song.position = new int[][]{
				//Intro
				{0, X, X, X, 1, X}, //0
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27
				{0, X, X, X, 1, X}, //0 + 28 = 28
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 28 = 55
				
				//Verse 1
				{X, 3, X, X, 1, X}, //0 + 56 = 56
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 3, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{X, 3, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{X, 3, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{X, 2, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{X, 2, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{X, 2, X, X, 3, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{X, 2, X, X, X, X}, //24
				{X, X, X, X, 3, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 56 = 83
				{X, 0, X, X, 1, X}, //0 + 84 = 84
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 0, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{3, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{3, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 84 = 111
				
				{X, 3, X, X, 1, X}, //0 + 112 = 112
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 3, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{X, 3, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{X, 3, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{X, 2, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{X, 2, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{X, 2, X, X, 3, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{X, 2, X, X, X, X}, //24
				{X, X, X, X, 3, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 112 = 139
				{X, 0, X, X, 1, X}, //0 + 140 = 140
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 0, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{3, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{3, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 140 = 167
				
				{0, X, X, X, 1, X}, //0 + 168 = 168
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 168 = 195 
				{0, X, X, X, 1, X}, //0 + 196 = 196
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 196 = 223
				{1, X, 3, 0, 1, X}, //224
				
				//Sabi 1
				{X, 3, X, X, 1, X}, //0 + 225 = 225
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 3, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{X, 3, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{X, 3, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{X, 2, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{X, 2, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{X, 2, X, X, 3, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{X, 2, X, X, X, X}, //24
				{X, X, X, X, 3, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 225 = 252
				{X, 0, X, X, 1, X}, //0 + 253 = 253
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 0, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{3, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{3, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 253 = 280
				
				{X, 3, X, X, 1, X}, //0 + 281 = 281
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 3, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{X, 3, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{X, 3, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{X, 2, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{X, 2, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{X, 2, X, X, 3, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{X, 2, X, X, X, X}, //24
				{X, X, X, X, 3, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 281 = 308
				{X, 0, X, X, 1, X}, //0 + 309 = 309
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{X, 0, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{3, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{3, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 309 = 336
				
				{0, X, X, X, 1, X}, //0 + 337 = 337
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 337 = 364 
				{0, X, X, X, 1, X}, //0 + 365 = 365
				{X, X, 2, X, X, X}, //1
				{X, X, X, 0, X, X}, //2
				{0, X, X, X, X, X}, //3
				{X, X, X, X, 1, X}, //4
				{X, X, X, 0, X, X}, //5
				{X, X, 2, X, X, X}, //6
				{0, X, X, X, 1, X}, //7
				{X, X, 2, X, X, X}, //8
				{X, X, X, 0, X, X}, //9
				{0, X, X, X, X, X}, //10
				{X, X, X, X, 1, X}, //11
				{X, X, X, 0, X, X}, //12
				{X, X, 2, X, X, X}, //13
				{1, X, X, X, 1, X}, //14
				{X, X, 3, X, X, X}, //15
				{X, X, X, 0, X, X}, //16
				{1, X, X, X, X, X}, //17
				{X, X, X, X, 1, X}, //18
				{X, X, X, 0, X, X}, //19
				{X, X, 3, X, X, X}, //20
				{1, X, X, X, 1, X}, //21
				{X, X, 3, X, X, X}, //22
				{X, X, X, 0, X, X}, //23
				{1, X, X, X, X, X}, //24
				{X, X, X, X, 1, X}, //25
				{X, X, X, 0, X, X}, //26
				{X, X, 3, X, X, X}, //27 + 365 = 392
				{1, X, 3, 0, 1, X}, //393 
		};
		song.songLength = song.position.length;
		song.bLyric = true;
		song.lyric = new String[] {
				"", //0
				"Forever can never be long enough for me", //1
				"To feel like I've had long enough with you", //2
				"Forget the world now, we won't let them see", //3
				"But there's one thing left to do", //4
				"", //5
				"Now that the weight has lifted", //6
				"Love has surely shifted my way", //7
				"", //8
				"Marry me", //9
				"Today and every day", //10
				"Marry me", //11
				"If I ever get the nerve to say hello in this cafe", //12
				"", //13
				"Say you will", //14
				"", //15
				"Together can never be close enough for me", //16
				"To feel like I am close enough to you", //17
				"You wear white and I'll wear out the words I love you", //18
				"And you're beautiful", //19 
				"", //20
				"Now that the wait is over", //21
				"And love and has finally showed her my way", //22
				"", //23
				"Marry me", //24
				"Today and every day", //25
				"Marry me", //26
				"If I ever get the nerve to say hello in this cafe", //27
				"", //28
				"Say you will", //29
				"", //30
				"Promise me you'll always be", //31
				"Happy by my side", //32
				"I promise to sing to you", //33
				"When all the music dies", //34
				"", //35
				"And marry me", //36
				"Today and everyday", //37
				"Marry me", //38
				"If I ever get the nerve to say hello in this cafe", //39
				"", //40
				"Say you will", //41
				"Marry me", //42
		};
		song.lyricIndex = new int []{ //43
			0, 62, 84, 118, 140, 168, 175, 203, 224, 225,
			256, 281, 306, 332, 333, 294, 297, 313, 329, 342,
			357, 378, 432, 449, 464, 477, 492, 521
			
		};
		song.lyricLength = song.lyric.length;	
	}
}
