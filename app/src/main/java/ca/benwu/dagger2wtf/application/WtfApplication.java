package ca.benwu.dagger2wtf.application;

import android.app.Application;
import android.content.Context;

import ca.benwu.dagger2wtf.home.HomeComponent;
import ca.benwu.dagger2wtf.home.HomeModule;
import ca.benwu.dagger2wtf.network.DaggerNetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkModule;

public class WtfApplication extends Application {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private AppComponent mAppComponent;
    private NetworkComponent mNetworkComponent;
    private HomeComponent mHomeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetworkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkComponent(mNetworkComponent)
                .build();
    }

    public HomeComponent getHomeComponent(Context context) {
        if (mHomeComponent == null) {
            mHomeComponent = mAppComponent.plus(new HomeModule(context));
        }
        return mHomeComponent;
    }
}
