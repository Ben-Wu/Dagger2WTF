package ca.benwu.dagger2wtf.utils;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.activity.ActivityScope;

@ActivityScope
public class ParentUtils implements IParentUtils {

    private final Child1Utils mChild1Utils;
    private final Child2Utils mChild2Utils;

    @Inject
    public ParentUtils(Child1Utils child1Utils, Child2Utils child2Utils) {
        mChild1Utils = child1Utils;
        mChild2Utils = child2Utils;
    }

    public int get() {
        return mChild1Utils.get() + mChild2Utils.get();
    }
}
