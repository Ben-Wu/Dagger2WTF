package ca.benwu.dagger2wtf.utils;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.activity.ActivityScope;

@ActivityScope
public class Child1Utils {

    @Inject
    public Child1Utils() {}

    public int get() {
        return 1;
    }

}
