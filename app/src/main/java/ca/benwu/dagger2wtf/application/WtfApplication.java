package ca.benwu.dagger2wtf.application;

import android.app.Application;
import android.content.Context;

import ca.benwu.dagger2wtf.comments.CommentComponent;
import ca.benwu.dagger2wtf.comments.CommentModule;
import ca.benwu.dagger2wtf.home.HomeComponent;
import ca.benwu.dagger2wtf.home.HomeModule;
import ca.benwu.dagger2wtf.network.DaggerNetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkModule;

public class WtfApplication extends Application {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static WtfApplication instance;

    private AppComponent mAppComponent;
    private NetworkComponent mNetworkComponent;
    private HomeComponent mHomeComponent;
    private CommentComponent mCommentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mNetworkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkComponent(mNetworkComponent)
                .build();
    }

    public static WtfApplication getInstance() {
        return instance;
    }

    public HomeComponent getHomeComponent(Context context) {
        if (mHomeComponent == null) {
            mHomeComponent = mAppComponent.homeComponentBuilder()
                    .homeModule(new HomeModule(context))
                    .build();
        }
        return mHomeComponent;
    }

    public CommentComponent getCommentComponent(Context context) {
        if (mCommentComponent == null) {
            mCommentComponent = mAppComponent.commentComponentBuilder()
                    .commentModule(new CommentModule(context))
                    .build();
        }
        return mCommentComponent;
    }

}
