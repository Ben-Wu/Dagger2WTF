package ca.benwu.dagger2wtf.network;

import java.util.List;

import ca.benwu.dagger2wtf.models.Comment;
import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;

public class NetworkService {

    private final NetworkApi mApi;

    public NetworkService(NetworkApi api) {
        mApi = api;
    }

    public Observable<List<Post>> getPosts() {
        return mApi.getAllPosts();
    }

    public Observable<List<Comment>> getComments(int postId) {
        return mApi.getComments(postId);
    }
}
