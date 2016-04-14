package test.model;

import test.model.api.ApiInterface;
import test.model.api.ApiModule;
import test.model.data.Repo;

import java.util.List;

import retrofit.Call;

public class ModelImpl implements Model {

    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Call<List<Repo>> getRepoList(String name) {
        return apiInterface.getRepositories(name);
    }
}
