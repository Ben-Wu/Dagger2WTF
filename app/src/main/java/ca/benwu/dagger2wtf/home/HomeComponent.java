package ca.benwu.dagger2wtf.home;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    void inject(HomeActivity homeActivity);

}
