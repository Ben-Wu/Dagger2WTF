package ca.benwu.dagger2wtf.comments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.models.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Comment> mComments;

    public CommentAdapter() {
        this(new ArrayList<>());
    }

    public CommentAdapter(@NonNull List<Comment> comments) {
        mComments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        return new CommentViewHolder(
                mLayoutInflater.inflate(R.layout.item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bind(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public void setComments(@NonNull List<Comment> comments) {
        mComments = comments;
        notifyDataSetChanged();
    }

}
