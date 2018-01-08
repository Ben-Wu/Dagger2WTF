package ca.benwu.dagger2wtf.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Subject<Post> mClickSubject;
    private List<Post> mPosts;

    public HomeAdapter() {
        this(new ArrayList<>());
    }

    public HomeAdapter(@NonNull List<Post> posts) {
        mPosts = posts;
        mClickSubject = PublishSubject.create();
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        return new HomeViewHolder(
                mLayoutInflater.inflate(R.layout.item_post_home, parent, false),
                mClickSubject
        );
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.bind(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public Observable<Post> getClickSubject() {
        return mClickSubject;
    }

    public void add(@NonNull List<Post> posts) {
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }

}
