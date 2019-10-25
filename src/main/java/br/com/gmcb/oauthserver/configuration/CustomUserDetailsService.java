package br.com.gmcb.oauthserver.configuration;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gmcb.oauthserver.service.user.UserService;
import br.com.gmcb.oauthserver.domainobject.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final User user = userService.findByEmail(email);
        UserDetails userDetails;

        userDetails =  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, user.getNonLocked(), getAuthorities(user));
        
        return userDetails;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(final User user) throws UsernameNotFoundException {

        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
