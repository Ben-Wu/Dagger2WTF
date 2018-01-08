package ca.benwu.dagger2wtf.application;

import javax.inject.Singleton;

import ca.benwu.dagger2wtf.comments.CommentComponent;
import ca.benwu.dagger2wtf.home.HomeComponent;
import ca.benwu.dagger2wtf.network.NetworkComponent;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class}, dependencies = {NetworkComponent.class})
public interface AppComponent {

    HomeComponent.builder homeComponentBuilder();

    CommentComponent.builder commentComponentBuilder();

}
