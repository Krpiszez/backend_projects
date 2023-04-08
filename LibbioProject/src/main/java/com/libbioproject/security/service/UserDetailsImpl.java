package com.libbioproject.security.service;

import com.libbioproject.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. CLASS TO IMPLEMENT
 * Security helper class
 * This class uses our user which has been fetched from DB by UserDetailsServiceImpl class
 * load by userName method.
 * This user will be fulfilled with user details. Userdetails are overwritten methods below.
 * At the end we have UserDetailsImpl object that hat credentials and user details.
 */
@Setter
@Getter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     *
     * @param user to get details
     * @return UserDetailsImpl ( email + password +authorities )
     */
    public static UserDetailsImpl build(User user){
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getType().name())).collect(Collectors.toList());
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }


    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    //methods that return true can be changed according to business needs.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
