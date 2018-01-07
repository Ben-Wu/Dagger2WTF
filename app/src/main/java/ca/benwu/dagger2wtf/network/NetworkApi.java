package ca.benwu.dagger2wtf.network;

import java.util.List;

import ca.benwu.dagger2wtf.models.Comment;
import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkApi {

    @GET("/posts")
    Observable<List<Post>> getAllPosts();

    @GET("/comments")
    Observable<List<Comment>> getComments(@Query("postId") int postId);

}
