package com.apps.malpv.daggerlogin.login;

public interface LoginRepository {

    void saveUser(User user);

    User getUser();
}
