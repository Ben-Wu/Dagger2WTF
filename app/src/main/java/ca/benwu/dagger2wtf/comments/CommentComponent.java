package ca.benwu.dagger2wtf.comments;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {CommentModule.class})
public interface CommentComponent {

    void inject(CommentActivity commentActivity);

}
