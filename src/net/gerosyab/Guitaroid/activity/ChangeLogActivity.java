package net.gerosyab.Guitaroid.activity;

import java.io.InputStream;

import net.gerosyab.Guitaroid.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ChangeLogActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changelog);
		
		TextView changeLogText = (TextView)findViewById(R.id.changelog_text);
		changeLogText.setText(R.string.changeLog);
	}
}
