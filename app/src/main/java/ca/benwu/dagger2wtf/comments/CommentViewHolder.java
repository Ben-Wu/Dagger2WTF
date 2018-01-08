package ca.benwu.dagger2wtf.comments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ca.benwu.dagger2wtf.R;
import ca.benwu.dagger2wtf.models.Comment;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameView;
    private final TextView mBodyView;

    public CommentViewHolder(View itemView) {
        super(itemView);
        mNameView = itemView.findViewById(R.id.comment_name);
        mBodyView = itemView.findViewById(R.id.comment_body);
    }

    public void bind(Comment comment) {
        mNameView.setText(String.format("%s <%s>", comment.getName(), comment.getEmail()));
        mBodyView.setText(comment.getBody());
    }

}
