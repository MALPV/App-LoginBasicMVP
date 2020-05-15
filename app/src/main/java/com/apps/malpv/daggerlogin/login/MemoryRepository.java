package com.apps.malpv.daggerlogin.login;

// Aqui persiste la información
// Aplica para cualquier implementación
public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public void saveUser(User user) {
        if (user == null){
            user = getUser();
        }
        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null){
            user = new User("Jorge", "Valdivia");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }
}
