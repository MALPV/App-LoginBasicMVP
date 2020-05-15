package com.apps.malpv.daggerlogin.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    // @Provides se usa cuando hay retorno
    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository){
        return new LoginActivityModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository(); // Cambiar aqui la implementacion de guardado de datos
    }
}
