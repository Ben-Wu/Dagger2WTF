package ca.benwu.dagger2wtf.repositories;

import java.util.List;

import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;

public class RemoteApiRepository implements ApiRepositoryDataSource {

    private final ApiService mApiService;

    public RemoteApiRepository(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return mApiService.getAllPosts();
    }
}
