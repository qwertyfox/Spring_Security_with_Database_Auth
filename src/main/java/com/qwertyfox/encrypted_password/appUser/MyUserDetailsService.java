package com.qwertyfox.encrypted_password.appUser;

import com.qwertyfox.encrypted_password.dao.MyUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUDS")
public class MyUserDetailsService implements UserDetailsService {

    private final MyUserDao myUserDao;

    @Autowired
    public MyUserDetailsService(MyUserDao myUserDao) {
        this.myUserDao = myUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
