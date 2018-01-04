package ca.benwu.dagger2wtf.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ca.benwu.dagger2wtf.application.WtfApplication;
import ca.benwu.dagger2wtf.repositories.ApiRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final Context mContext;

    public HomeActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    public RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @Provides
    public HomeAdapter homeAdapter() {
        return new HomeAdapter(new ArrayList<>());
    }

    @Provides
    public ApiRepository apiRepository() {
        return WtfApplication.getApplication().apiRepository();
    }
}
