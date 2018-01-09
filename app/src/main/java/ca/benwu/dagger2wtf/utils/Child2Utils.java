package ca.benwu.dagger2wtf.utils;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.activity.ActivityScope;

@ActivityScope
public class Child2Utils {

    @Inject
    public Child2Utils() {}

    public int get() {
        return 2;
    }

}
