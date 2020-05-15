package com.apps.malpv.daggerlogin.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    //Esta clase será utilizada para llevar un control de todas las deoendencias del codigo
    //Añadiendo @Module Dagger sabra que es un modulo que hará el control.
    //Se pueden crear varios modulos para cada una de las funcionalidades del proyecto
    private Application application;

    public ApplicationModule(Application application){
        this.application=application;
    }

    @Provides // Para los metodos expuestos con valor de retorno
    @Singleton // Para indicar que es una instancia que solo debe crearse una vez.
    public Context provideContext(){
        return application;
    }
}
