package com.apps.malpv.daggerlogin.root;

import com.apps.malpv.daggerlogin.login.LoginActivity;
import com.apps.malpv.daggerlogin.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);// Para cada una que se quiera definir debe ser injectada.
}
