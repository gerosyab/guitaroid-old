package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class EarTestSelect extends Activity {
	String [] testList = {"Note", "Chord"};
	Context context;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ear_test_select);
		context = this;
		ListView list = (ListView)findViewById(R.id.ear_test_select_list);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ear_test_select_list_item, R.id.ear_test_select_list_item_text, testList);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				if(arg3 == 0){
					Intent i = new Intent(context, EarTestNoteActivity.class);
					startActivity(i);
				}
				else if(arg3 == 1){
					Intent i = new Intent(context, EarTestChordActivity.class);
					startActivity(i);
				}
				finish();
			}
		});
		
	}
}
