package com.rotanareg.skolan.signIn;

import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.inject.*;

import com.rotanareg.skolan.userPersist.UserService;

@Named
@RequestScoped
public class SignIn {

    @Inject
    private LoggedIn loggedIn;

    @EJB
    private UserService us;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void submit() {
        if (us.getUserContaining(username).get(0).getPassWord().equals(password)){
            this.loggedIn = new LoggedIn(us.getUserContaining(username).get(0).getId());
        }
    }

    public boolean loggedIn(){
        if (loggedIn != null)
            return true;
        return false;
    }

    public void logout(){
        this.loggedIn = null;
    }
}
