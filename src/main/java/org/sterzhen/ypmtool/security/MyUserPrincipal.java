package org.sterzhen.ypmtool.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.sterzhen.ypmtool.data.entities.ToolUser;
import org.sterzhen.ypmtool.data.entities.ToolUserRole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class MyUserPrincipal extends User {

    private final ToolUser user;

    public MyUserPrincipal(ToolUser user) {
        super(user.getLogin(), user.getPassword(), getGrantedAuthority(user));
        this.user = user;
    }

    private static Collection<? extends GrantedAuthority> getGrantedAuthority(ToolUser user) {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user != null) {
            ToolUserRole role = user.getUserRole();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getLevel().name()));
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getTag()));
        }
        return grantedAuthorities;
    }

    public ToolUser getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyUserPrincipal that = (MyUserPrincipal) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user);
    }
}
