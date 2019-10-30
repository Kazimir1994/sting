package gmail.kazzimir.bortnik.sting.authorizationserver.service.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails extends AccountDTO implements UserDetails {
    public CustomUserDetails(AccountDTO accountDTO) {
        super.setId(accountDTO.getId());
        super.setPassword(accountDTO.getPassword());
        super.setUsername(accountDTO.getUsername());
        super.setRoles(accountDTO.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        super.getRoles().forEach(roleDTO -> {
            roleDTO.getPermissions().forEach(permissionDTO -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(permissionDTO.getName()));
            });
        });
        return grantedAuthorities;
    }

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
