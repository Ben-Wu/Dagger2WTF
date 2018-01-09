package ca.benwu.dagger2wtf.comments;

import ca.benwu.dagger2wtf.activity.ActivityScope;
import ca.benwu.dagger2wtf.utils.IParentUtils;
import ca.benwu.dagger2wtf.utils.ParentUtils;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class CommentUtilsModule {

    @ActivityScope
    @Binds
    public abstract IParentUtils provideParentUtils(ParentUtils parentUtils);

}
