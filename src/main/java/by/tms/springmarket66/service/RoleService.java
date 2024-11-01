package by.tms.springmarket66.service;

import by.tms.springmarket66.entity.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {
    public Set<String> getAllRoles() {
        Set<String> roles = new HashSet<>();
        for (Role role : Role.values()) {
            roles.add(role.name());
        }
        return roles;
    }
}
