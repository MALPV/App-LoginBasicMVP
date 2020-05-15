package com.apps.malpv.daggerlogin.root;

import android.app.Application;

import com.apps.malpv.daggerlogin.login.LoginModule;

public class App extends Application {
    //Aqui va la logica de la propia clase, cada instancia solo debe hacer una vez

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
