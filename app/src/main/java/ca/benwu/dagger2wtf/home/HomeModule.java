package ca.benwu.dagger2wtf.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Named;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private final Context mContext;

    public HomeModule(Context context) {
        mContext = context;
    }

    @ActivityScope
    @Provides
    @Named("Linear")
    RecyclerView.LayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @ActivityScope
    @Provides
    @Named("Grid")
    RecyclerView.LayoutManager provideGridLayoutManager() {
        return new GridLayoutManager(mContext, 2);
    }

    @ActivityScope
    @Provides
    static HomeAdapter provideHomeAdapter() {
        return new HomeAdapter();
    }

}
