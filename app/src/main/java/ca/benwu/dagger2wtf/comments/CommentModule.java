package ca.benwu.dagger2wtf.comments;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class CommentModule {

    private final Context mContext;

    public CommentModule(Context context) {
        mContext = context;
    }

    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    @ActivityScope
    @Provides
    static CommentAdapter provideCommentAdapter() {
        return new CommentAdapter();
    }

}
