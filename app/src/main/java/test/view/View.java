package test.view;

import test.model.data.Repo;

import java.util.List;

public interface View {

    void showData(List<Repo> list);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
