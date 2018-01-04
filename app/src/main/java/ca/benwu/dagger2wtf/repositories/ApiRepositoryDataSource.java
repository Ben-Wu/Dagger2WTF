package ca.benwu.dagger2wtf.repositories;

import java.util.List;

import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;

public interface ApiRepositoryDataSource {

    Observable<List<Post>> getPosts();
}
