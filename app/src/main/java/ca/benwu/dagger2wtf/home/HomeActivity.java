package ca.benwu.dagger2wtf.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.activity.BaseActivity;
import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.network.NetworkService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends BaseActivity {

    @Inject
    HomeAdapter mHomeAdapter;
    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    NetworkService mNetworkService;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication.getHomeComponent(this).inject(this);

        setContentView(R.layout.activity_home);

        initViews();
        initRecyclerView();
        loadData();
        mHomeAdapter.getClickSubject().subscribe(
                post -> Toast.makeText(
                        this,
                        String.valueOf(post.getId()),
                        Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.home_post_feed);
        mProgressBar = findViewById(R.id.home_loading);
    }

    private void initRecyclerView() {
        mRecyclerView.setAdapter(mHomeAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void loadData() {
        mNetworkService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        posts -> {
                            mHomeAdapter.add(posts);
                            mProgressBar.setVisibility(View.GONE);
                        },
                        throwable -> Toast.makeText(
                                this, throwable.getMessage(), Toast.LENGTH_LONG).show(),
                        () -> {},
                        disposable -> mDisposable = disposable
                );
    }
}
