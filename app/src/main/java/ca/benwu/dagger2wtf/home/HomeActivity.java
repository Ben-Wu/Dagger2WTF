package ca.benwu.dagger2wtf.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.activity.BaseActivity;
import ca.benwu.dagger2wtf.comments.CommentActivity;
import ca.benwu.dagger2wtf.network.NetworkService;
import ca.benwu.dagger2wtf.utils.Constants;
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
        if (savedInstanceState == null) {
            loadData();
        }
        mHomeAdapter.getClickSubject().subscribe(
                post -> {
                    Toast.makeText(this, String.valueOf(post.getId()),
                        Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CommentActivity.class);
                    intent.putExtra(Constants.EXTRA_POST_ID, post.getId());
                    intent.putExtra(Constants.EXTRA_POST_TITLE, post.getTitle());
                    intent.putExtra(Constants.EXTRA_POST_BODY, post.getBody());
                    startActivity(intent);
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRecyclerView.setLayoutManager(null);
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
        mRecyclerView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
        mNetworkService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        posts -> {
                            mHomeAdapter.add(posts);
                            mRecyclerView.setVisibility(View.VISIBLE);
                            mProgressBar.setVisibility(View.GONE);
                        },
                        throwable -> Toast.makeText(
                                this, throwable.getMessage(), Toast.LENGTH_LONG).show(),
                        () -> {},
                        disposable -> mDisposable = disposable
                );
    }
}
