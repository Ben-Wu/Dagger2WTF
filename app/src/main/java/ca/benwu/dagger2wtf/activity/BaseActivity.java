package ca.benwu.dagger2wtf.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.application.WtfApplication;

public abstract class BaseActivity extends AppCompatActivity{

    @Inject
    protected WtfApplication mApplication;
    @Inject
    protected SharedPreferences mSharedPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (WtfApplication) getApplication();
    }
}
