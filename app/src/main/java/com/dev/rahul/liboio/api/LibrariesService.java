package com.dev.rahul.liboio.api;

import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.utility.LibConstants;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static com.dev.rahul.liboio.api.Libraries.CONTRIBUTORS;
import static com.dev.rahul.liboio.api.Libraries.DEPENDENCIES;
import static com.dev.rahul.liboio.api.Libraries.MAIN_URL;
import static com.dev.rahul.liboio.api.Libraries.PLATFORMS;
import static com.dev.rahul.liboio.api.Libraries.SEARCH;

/**
 * Created by rahul on 7/1/18.
 */

public interface LibrariesService {

    @GET(PLATFORMS)
    Single<List<Platforms>> getPlatforms(@Query(LibConstants.API_KEY) String apiKey);

    @GET(SEARCH)
    Single<List<Projects>> getProjectSearchResult(@QueryMap HashMap<String,String> queryMaps);

    @GET(DEPENDENCIES)
    Single<Projects> getProjectDependencies(
            @Path("platform") String platform,
            @Path("name") String name,
            @Query("api_key") String apiKey
    );

    @GET(CONTRIBUTORS)
    Single<List<Contributors>> getContributors(
            @Path("platform") String platform,
            @Path("name") String name,
            @QueryMap HashMap<String,String> queryMaps
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(MAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    LibrariesService LIBRARIES_SERVICE = retrofit.create(LibrariesService.class);
}
