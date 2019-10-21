package gmail.kazzimir.bortnik.sting.authorizationserver.service.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.UserService;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.AccountDTO;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("User is trying to login by Email:= {}", email);
        AccountDTO account = userService.getAccountByEmail(email);
        logger.info("Account found := {}", account);
        return new CustomUserDetails(account);
    }
}

