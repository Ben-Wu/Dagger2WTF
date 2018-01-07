package ca.benwu.dagger2wtf.home;

import dagger.Subcomponent;

@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    void inject(HomeActivity homeActivity);

}
