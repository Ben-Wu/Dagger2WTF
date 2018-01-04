package ca.benwu.dagger2wtf.application;

import android.app.Application;

import ca.benwu.dagger2wtf.repositories.ApiRepository;
import ca.benwu.dagger2wtf.repositories.ApiServiceGenerator;


public class WtfApplication extends Application {

    private static WtfApplication mApplication;

    private ApiRepository mApiRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mApiRepository = ApiRepository.getInstance(
                ApiServiceGenerator.apiService("https://jsonplaceholder.typicode.com"));
    }

    public static WtfApplication getApplication() {
        return mApplication;
    }

    public ApiRepository apiRepository() {
        return mApiRepository;
    }
}
