package ca.benwu.dagger2wtf.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observer;


public class HomeViewHolder extends RecyclerView.ViewHolder {

    private final View mParentView;
    private final Observer<Post> mClickObserver;
    private final TextView mTitleView;
    private final TextView mContentView;

    public HomeViewHolder(View itemView, Observer<Post> clickObserver) {
        super(itemView);
        mTitleView = itemView.findViewById(R.id.title_text);
        mContentView = itemView.findViewById(R.id.content_text);
        mParentView = itemView;
        mClickObserver = clickObserver;
    }

    public void bind(Post post) {
        mTitleView.setText(post.getTitle());
        mContentView.setText(post.getBody());
        mParentView.setOnClickListener(v -> mClickObserver.onNext(post));
    }

}
