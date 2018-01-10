package ca.benwu.dagger2wtf.comments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class CommentModule {

    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager(CommentActivity commentActivity) {
        return new LinearLayoutManager(commentActivity);
    }

    @ActivityScope
    @Provides
    static CommentAdapter provideCommentAdapter() {
        return new CommentAdapter();
    }

}
