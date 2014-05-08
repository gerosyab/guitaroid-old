package net.gerosyab.Guitaroid.activity;

import net.gerosyab.Guitaroid.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Information extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.information);
    }
}
