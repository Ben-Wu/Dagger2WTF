package ca.benwu.dagger2wtf.comments;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {CommentModule.class, CommentUtilsModule.class})
public interface CommentComponent {

    @Subcomponent.Builder
    interface builder {
        CommentComponent.builder commentModule(CommentModule commentModule);
        CommentComponent build();
    }

    void inject(CommentActivity commentActivity);

}
