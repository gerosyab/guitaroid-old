package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import net.gerosyab.Guitaroid.data.SongData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SongSelect extends Activity {
	
	Context context;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.song_select);
		context = this;
		ListView list = (ListView)findViewById(R.id.song_select_list);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.song_select_list_item, R.id.song_select_list_item_text, SongData.songList);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent i = new Intent(context, SongPlayActivity.class);
				i.putExtra(SongPlayActivity.EXTRA_SONG_INDEX, arg2);
				
				startActivity(i);
				finish();
			}
		});
		
	}
}
