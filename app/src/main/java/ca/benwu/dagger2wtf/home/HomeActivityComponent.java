package ca.benwu.dagger2wtf.home;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import ca.benwu.dagger2wtf.repositories.ApiRepository;
import dagger.Component;
import io.reactivex.disposables.Disposable;

@Component(modules = {HomeActivityModule.class})
public interface HomeActivityComponent {

    void inject(HomeActivity homeActivity);

    RecyclerView.LayoutManager getLayoutManager();

    HomeAdapter getHomeAdapter();

    ApiRepository getApiRepository();

}
