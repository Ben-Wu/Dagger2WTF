package ca.benwu.dagger2wtf.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ca.benwu.dagger2wtf.application.WtfApplication;

public abstract class BaseActivity extends AppCompatActivity{

    protected WtfApplication mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (WtfApplication) getApplication();
    }
}
