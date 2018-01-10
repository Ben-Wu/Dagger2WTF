package ca.benwu.dagger2wtf.application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class WtfApplication extends DaggerApplication {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}
