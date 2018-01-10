package ca.benwu.dagger2wtf.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Named;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import ca.benwu.dagger2wtf.utils.Child1Utils;
import ca.benwu.dagger2wtf.utils.Child2Utils;
import ca.benwu.dagger2wtf.utils.ParentUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @ActivityScope
    @Provides
    @Named("Linear")
    RecyclerView.LayoutManager provideLinearLayoutManager(HomeActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @ActivityScope
    @Provides
    @Named("Grid")
    RecyclerView.LayoutManager provideGridLayoutManager(HomeActivity activity) {
        return new GridLayoutManager(activity, 2);
    }

    @ActivityScope
    @Provides
    static HomeAdapter provideHomeAdapter() {
        return new HomeAdapter();
    }

    @ActivityScope
    @Provides
    static ParentUtils provideParentUtils(Child1Utils child1Utils, Child2Utils child2Utils) {
        return new ParentUtils(child1Utils, child2Utils);
    }

}
