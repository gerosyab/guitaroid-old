package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;

public class SoundResourceTable {
	public static final int ACOUSTIC_FRET_LENGTH = 19 + 1;
	public static final int STRAT_FRET_LENGTH = 22 + 1;
	
	public static final int [][] ACOUSTIC_RESOURCE_TABLE = {
		{R.raw.acoustic_6_0, R.raw.acoustic_6_1, R.raw.acoustic_6_2, R.raw.acoustic_6_3, R.raw.acoustic_6_4,
		 R.raw.acoustic_5_0, R.raw.acoustic_5_1, R.raw.acoustic_5_2, R.raw.acoustic_5_3, R.raw.acoustic_5_4,
		 R.raw.acoustic_4_0, R.raw.acoustic_4_1, R.raw.acoustic_4_2, R.raw.acoustic_4_3, R.raw.acoustic_4_4,
		 R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3, R.raw.acoustic_2_0},
		{R.raw.acoustic_5_0, R.raw.acoustic_5_1, R.raw.acoustic_5_2, R.raw.acoustic_5_3, R.raw.acoustic_5_4,
		 R.raw.acoustic_4_0, R.raw.acoustic_4_1, R.raw.acoustic_4_2, R.raw.acoustic_4_3, R.raw.acoustic_4_4,
		 R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3, R.raw.acoustic_2_0,
		 R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4, R.raw.acoustic_1_0},
		{R.raw.acoustic_4_0, R.raw.acoustic_4_1, R.raw.acoustic_4_2, R.raw.acoustic_4_3, R.raw.acoustic_4_4,
		 R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3, R.raw.acoustic_2_0,
		 R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4, R.raw.acoustic_1_0,
		 R.raw.acoustic_1_1, R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4, R.raw.acoustic_1_5},
		{R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3, R.raw.acoustic_2_0,
		 R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4, R.raw.acoustic_1_0,
		 R.raw.acoustic_1_1, R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4, R.raw.acoustic_1_5,
		 R.raw.acoustic_1_6, R.raw.acoustic_1_7, R.raw.acoustic_1_8, R.raw.acoustic_1_9, R.raw.acoustic_1_10},
		{R.raw.acoustic_2_0, R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4,
		 R.raw.acoustic_1_0, R.raw.acoustic_1_1, R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4,
		 R.raw.acoustic_1_5, R.raw.acoustic_1_6, R.raw.acoustic_1_7, R.raw.acoustic_1_8, R.raw.acoustic_1_9,
		 R.raw.acoustic_1_10, R.raw.acoustic_1_11, R.raw.acoustic_1_12, R.raw.acoustic_1_13, R.raw.acoustic_1_14},
		{R.raw.acoustic_1_0, R.raw.acoustic_1_1, R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4,
		 R.raw.acoustic_1_5, R.raw.acoustic_1_6, R.raw.acoustic_1_7, R.raw.acoustic_1_8, R.raw.acoustic_1_9,
		 R.raw.acoustic_1_10, R.raw.acoustic_1_11, R.raw.acoustic_1_12, R.raw.acoustic_1_13, R.raw.acoustic_1_14,
		 R.raw.acoustic_1_15, R.raw.acoustic_1_16, R.raw.acoustic_1_17, R.raw.acoustic_1_18, R.raw.acoustic_1_19}
	};
	
	public static final int [] ACOUSTIC_RESOURCE_ARRAY = {
		R.raw.acoustic_6_0, R.raw.acoustic_6_1, R.raw.acoustic_6_2, R.raw.acoustic_6_3, R.raw.acoustic_6_4,
		R.raw.acoustic_5_0, R.raw.acoustic_5_1, R.raw.acoustic_5_2, R.raw.acoustic_5_3, R.raw.acoustic_5_4,
		R.raw.acoustic_4_0, R.raw.acoustic_4_1, R.raw.acoustic_4_2, R.raw.acoustic_4_3, R.raw.acoustic_4_4,
		R.raw.acoustic_3_0, R.raw.acoustic_3_1, R.raw.acoustic_3_2, R.raw.acoustic_3_3,
		R.raw.acoustic_2_0, R.raw.acoustic_2_1, R.raw.acoustic_2_2, R.raw.acoustic_2_3, R.raw.acoustic_2_4,
		R.raw.acoustic_1_0, R.raw.acoustic_1_1, R.raw.acoustic_1_2, R.raw.acoustic_1_3, R.raw.acoustic_1_4,
		R.raw.acoustic_1_5, R.raw.acoustic_1_6, R.raw.acoustic_1_7, R.raw.acoustic_1_8, R.raw.acoustic_1_9,
		R.raw.acoustic_1_10, R.raw.acoustic_1_11, R.raw.acoustic_1_12, R.raw.acoustic_1_13, R.raw.acoustic_1_14,
		R.raw.acoustic_1_15, R.raw.acoustic_1_16, R.raw.acoustic_1_17, R.raw.acoustic_1_18, R.raw.acoustic_1_19
	};
	
//	public static final int [][] STRAT_RESOURCE_TABLE = {
//		{R.raw.elec_6_0, R.raw.elec_6_1, R.raw.elec_6_2, R.raw.elec_6_3, R.raw.elec_6_4,
//		 R.raw.elec_5_0, R.raw.elec_5_1, R.raw.elec_5_2, R.raw.elec_5_3, R.raw.elec_5_4,
//		 R.raw.elec_4_0, R.raw.elec_4_1, R.raw.elec_4_2, R.raw.elec_4_3, R.raw.elec_4_4,
//		 R.raw.elec_3_0, R.raw.elec_3_1, R.raw.elec_3_2, R.raw.elec_3_3, R.raw.elec_2_0,
//		 R.raw.elec_2_1, R.raw.elec_2_2, R.raw.elec_2_3},
//		{R.raw.elec_5_0, R.raw.elec_5_1, R.raw.elec_5_2, R.raw.elec_5_3, R.raw.elec_5_4,
//		 R.raw.elec_4_0, R.raw.elec_4_1, R.raw.elec_4_2, R.raw.elec_4_3, R.raw.elec_4_4,
//		 R.raw.elec_3_0, R.raw.elec_3_1, R.raw.elec_3_2, R.raw.elec_3_3, R.raw.elec_2_0,
//		 R.raw.elec_2_1, R.raw.elec_2_2, R.raw.elec_2_3, R.raw.elec_2_4, R.raw.elec_1_0,
//		 R.raw.elec_1_1, R.raw.elec_1_2, R.raw.elec_1_3},
//		{R.raw.elec_4_0, R.raw.elec_4_1, R.raw.elec_4_2, R.raw.elec_4_3, R.raw.elec_4_4,
//		 R.raw.elec_3_0, R.raw.elec_3_1, R.raw.elec_3_2, R.raw.elec_3_3, R.raw.elec_2_0,
//		 R.raw.elec_2_1, R.raw.elec_2_2, R.raw.elec_2_3, R.raw.elec_2_4, R.raw.elec_1_0,
//		 R.raw.elec_1_1, R.raw.elec_1_2, R.raw.elec_1_3, R.raw.elec_1_4, R.raw.elec_1_5,
//		 R.raw.elec_1_6, R.raw.elec_1_7, R.raw.elec_1_8},
//		{R.raw.elec_3_0, R.raw.elec_3_1, R.raw.elec_3_2, R.raw.elec_3_3, R.raw.elec_2_0,
//		 R.raw.elec_2_1, R.raw.elec_2_2, R.raw.elec_2_3, R.raw.elec_2_4, R.raw.elec_1_0,
//		 R.raw.elec_1_1, R.raw.elec_1_2, R.raw.elec_1_3, R.raw.elec_1_4, R.raw.elec_1_5,
//		 R.raw.elec_1_6, R.raw.elec_1_7, R.raw.elec_1_8, R.raw.elec_1_9, R.raw.elec_1_10,
//		 R.raw.elec_1_11, R.raw.elec_1_12, R.raw.elec_1_13},
//		{R.raw.elec_2_0, R.raw.elec_2_1, R.raw.elec_2_2, R.raw.elec_2_3, R.raw.elec_2_4,
//		 R.raw.elec_1_0, R.raw.elec_1_1, R.raw.elec_1_2, R.raw.elec_1_3, R.raw.elec_1_4,
//		 R.raw.elec_1_5, R.raw.elec_1_6, R.raw.elec_1_7, R.raw.elec_1_8, R.raw.elec_1_9,
//		 R.raw.elec_1_10, R.raw.elec_1_11, R.raw.elec_1_12, R.raw.elec_1_13, R.raw.elec_1_14,
//		 R.raw.elec_1_15, R.raw.elec_1_16, R.raw.elec_1_17},
//		{R.raw.elec_1_0, R.raw.elec_1_1, R.raw.elec_1_2, R.raw.elec_1_3, R.raw.elec_1_4,
//		 R.raw.elec_1_5, R.raw.elec_1_6, R.raw.elec_1_7, R.raw.elec_1_8, R.raw.elec_1_9,
//		 R.raw.elec_1_10, R.raw.elec_1_11, R.raw.elec_1_12, R.raw.elec_1_13, R.raw.elec_1_14,
//		 R.raw.elec_1_15, R.raw.elec_1_16, R.raw.elec_1_17, R.raw.elec_1_18, R.raw.elec_1_19,
//		 R.raw.elec_1_20, R.raw.elec_1_21, R.raw.elec_1_22,},
//	};
}
