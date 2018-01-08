package ca.benwu.dagger2wtf.home;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    @Subcomponent.Builder
    interface builder {
        HomeComponent.builder homeModule(HomeModule homeModule);
        HomeComponent build();
    }

    void inject(HomeActivity homeActivity);

}
