package test.presenter;

import test.model.Model;
import test.model.ModelImpl;
import test.model.data.Repo;
import test.view.View;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class RepoListPresenter implements Presenter, Callback<List<Repo>> {

    private Model model = new ModelImpl();

    private View view;
    private Call<List<Repo>> repoCB;

    public RepoListPresenter(View view) {
        this.view = view;
    }

    @Override
    public void onSearchButtonClick() {

        repoCB = model.getRepoList(view.getUserName());
        repoCB.enqueue(this);
    }

    @Override
    public void onStop() {
        if (repoCB != null)
       repoCB.cancel();
    }

    @Override
    public void onResponse(Response<List<Repo>> response, Retrofit retrofit) {
        if (response.body() != null && !response.body().isEmpty()) {
            view.showData(response.body());
        } else {
            view.showEmptyList();
        }
        }

    @Override
    public void onFailure(Throwable t) {
        view.showError(t.getMessage());
    }
}
