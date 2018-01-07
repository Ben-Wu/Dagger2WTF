package ca.benwu.dagger2wtf.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private WtfApplication mApplication;

    public AppModule(WtfApplication application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    WtfApplication provideApplication() {
        return mApplication;
    }

}
