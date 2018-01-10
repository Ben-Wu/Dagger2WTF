package ca.benwu.dagger2wtf.comments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.activity.BaseActivity;
import ca.benwu.dagger2wtf.network.NetworkService;
import ca.benwu.dagger2wtf.utils.Constants;
import ca.benwu.dagger2wtf.utils.ParentUtils;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentActivity extends BaseActivity {

    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    CommentAdapter mCommentAdapter;
    @Inject
    NetworkService mNetworkService;
    @Inject
    ParentUtils mParentUtils; // trivial example of @Binds and constructor injection

    private Disposable mDisposable;

    private RecyclerView mCommentsView;
    private View mLoadingView;

    private int mPostId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Intent intent = getIntent();
        mPostId = intent.getIntExtra(Constants.EXTRA_POST_ID, -1);
        String postTitle = intent.getStringExtra(Constants.EXTRA_POST_TITLE);
        String postBody = intent.getStringExtra(Constants.EXTRA_POST_BODY);

        TextView titleView = findViewById(R.id.title_text);
        titleView.setText(postTitle);

        TextView bodyView = findViewById(R.id.content_text);
        bodyView.setText(postBody);

        mCommentsView = findViewById(R.id.comments_view);
        mCommentsView.setAdapter(mCommentAdapter);
        mCommentsView.setLayoutManager(mLayoutManager);
        mCommentsView.addItemDecoration(new DividerItemDecoration(
                mCommentsView.getContext(), DividerItemDecoration.VERTICAL));

        mLoadingView = findViewById(R.id.comments_loading);

        if (savedInstanceState == null) {
            loadData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCommentsView.setLayoutManager(null);
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    private void loadData() {
        mCommentsView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
        mNetworkService.getComments(mPostId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        comments -> {
                            mCommentAdapter.setComments(comments);
                            mCommentsView.setVisibility(View.VISIBLE);
                            mLoadingView.setVisibility(View.GONE);
                        },
                        throwable -> Toast.makeText(
                                this, throwable.getMessage(), Toast.LENGTH_LONG).show(),
                        () -> {},
                        disposable -> mDisposable = disposable
                );
    }
}
