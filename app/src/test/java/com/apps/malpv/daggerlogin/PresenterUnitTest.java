package com.apps.malpv.daggerlogin;

import com.apps.malpv.daggerlogin.login.LoginActivityMVP;
import com.apps.malpv.daggerlogin.login.LoginActivityPresenter;
import com.apps.malpv.daggerlogin.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterUnitTest {

    LoginActivityPresenter presenter;
    User user;

    // Obj a simular
    LoginActivityMVP.Model mockitoModel;
    LoginActivityMVP.View mockitoView;

    @Before
    public void init(){
        // Objetos simulados por mockito
        mockitoModel = mock(LoginActivityMVP.Model.class);
        mockitoView = mock(LoginActivityMVP.View.class);

        user = new User("Jorge", "Valdivia");

        //when(mockitoModel.getUser()).thenReturn(user);

        //when(mockitoView.getFirstName()).thenReturn(user.getFirstname());
        //when(mockitoView.getLastName()).thenReturn(user.getLastname());

        presenter = new LoginActivityPresenter(mockitoModel);
        presenter.setView(mockitoView);
    }

    @Test
    public void noExistsInteractionWithView(){
        presenter.getCurrentUser();
        // Verifica que en la vista solo se muestre una vez el mensaje
        verify(mockitoView, times(1)).showUserNotAvailable();

        // Verifica que haya 0 interación.
        // verifyZeroInteractions(mockitoView);
    }

    @Test
    public void loadUserFromTheRepoWheValidUserIsPresenter(){
        when(mockitoModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        // Se comprueba la interacción con el modelo.
        verify(mockitoModel, times(1)).getUser();

        // Se comprueba la interacción con la vista.
        verify(mockitoView, times(1)).setFirstName("Jorge");
        verify(mockitoView, times(1)).setLastName("Valdivia");
        verify(mockitoView, never()).showUserNotAvailable();
    }
}
