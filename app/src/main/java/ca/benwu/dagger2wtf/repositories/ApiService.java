package ca.benwu.dagger2wtf.repositories;

import java.util.List;

import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts")
    Observable<List<Post>> getAllPosts();

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") int id);
}
