package com.rotanareg.skolan.signIn;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Nils Gerstner on 2017-09-01.
 */

@Named
@SessionScoped
public class LoggedIn implements Serializable {
    private Long id = null;

    public LoggedIn() {
    }

    public LoggedIn(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
