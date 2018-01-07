package ca.benwu.dagger2wtf.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private final Context mContext;

    public HomeModule(Context context) {
        mContext = context;
    }

    @Provides
    RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Provides
    HomeAdapter homeAdapter() {
        return new HomeAdapter(new ArrayList<>());
    }

}
