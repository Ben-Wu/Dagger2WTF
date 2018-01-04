package ca.benwu.dagger2wtf.repositories;

import java.util.List;

import ca.benwu.dagger2wtf.models.Post;
import io.reactivex.Observable;

public class ApiRepository {

    private final ApiRepositoryDataSource mApiRepository;

    private static ApiRepository INSTANCE;

    public static ApiRepository getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            INSTANCE = new ApiRepository(apiService);
        }
        return INSTANCE;
    }

    public ApiRepository(ApiService apiService) {
        mApiRepository = new RemoteApiRepository(apiService);
    }

    public Observable<List<Post>> getPosts() {
        return mApiRepository.getPosts();
    }
}
