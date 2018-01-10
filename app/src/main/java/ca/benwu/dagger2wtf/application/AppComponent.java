package ca.benwu.dagger2wtf.application;

import javax.inject.Singleton;

import ca.benwu.dagger2wtf.activity.ActivityModule;
import ca.benwu.dagger2wtf.network.DaggerNetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkComponent;
import ca.benwu.dagger2wtf.network.NetworkModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(
        modules = {
                AppModule.class,
                ActivityModule.class,
                AndroidInjectionModule.class
        },
        dependencies = {NetworkComponent.class}
)
public interface AppComponent extends AndroidInjector<WtfApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<WtfApplication> {
        abstract Builder appModule(AppModule appModule);

        abstract Builder networkComponent(NetworkComponent networkComponent);

        @Override
        public void seedInstance(WtfApplication instance) {
            appModule(new AppModule(instance));
            networkComponent(DaggerNetworkComponent.builder()
                    .networkModule(new NetworkModule(WtfApplication.BASE_URL))
                    .build());
        }
    }

}
