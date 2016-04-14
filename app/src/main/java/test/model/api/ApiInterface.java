package test.model.api;

import test.global.Constants;
import test.model.data.Repo;
import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ApiInterface {

    @GET(Constants.API_USERS +"{" + Constants.API_PARAM_USER + "}/" + Constants.API_REPOS)
    Call<List<Repo>> getRepositories(@Path(Constants.API_PARAM_USER) String user);

}
