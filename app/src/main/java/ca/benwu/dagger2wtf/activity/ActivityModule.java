package ca.benwu.dagger2wtf.activity;

import ca.benwu.dagger2wtf.comments.CommentActivity;
import ca.benwu.dagger2wtf.comments.CommentModule;
import ca.benwu.dagger2wtf.home.HomeActivity;
import ca.benwu.dagger2wtf.home.HomeModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {HomeModule.class})
    abstract HomeActivity bindHomeActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {CommentModule.class})
    abstract CommentActivity bindCommentActivity();

}
