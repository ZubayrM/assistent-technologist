package project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.Repositories.UserRepo;
import project.model.User;

@Service
public class MyUserDS implements UserDetailsService {

    @Autowired
    private UserRepo ur;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byNumber = ur.findByCode(s);
        System.out.println(byNumber.getNumber());
        return byNumber;
    }
}
