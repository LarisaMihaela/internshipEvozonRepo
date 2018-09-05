package com.tools.factories;

import com.evozon.utils.Constants;
import com.evozon.tools.entities.Login;
import com.evozon.tools.entities.User;

public class LoginFactory {

    public static Login getLoginInstance() {
        Login login = new Login();
        User user = new User();
        user.setEmail(Constants.EMAIL);
        user.setPassword(Constants.PASSWORD);
        login.setUser(user);

        return login;
    }
}
