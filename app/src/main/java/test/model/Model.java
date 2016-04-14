package test.model;

import test.model.data.Repo;

import java.util.List;

import retrofit.Call;

public interface Model {

    Call<List<Repo>> getRepoList(String name);
}
