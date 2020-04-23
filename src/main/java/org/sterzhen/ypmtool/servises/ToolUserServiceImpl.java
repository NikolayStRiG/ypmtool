package org.sterzhen.ypmtool.servises;

import org.springframework.stereotype.Service;
import org.sterzhen.ypmtool.data.entities.ToolUser;
import org.sterzhen.ypmtool.data.repositories.ToolUserRepository;
import org.sterzhen.ypmtool.data.repositories.ToolUserRoleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class ToolUserServiceImpl implements ToolUserService {

    private final ToolUserRepository userRepository;
    private final ToolUserRoleRepository roleRepository;

    public ToolUserServiceImpl(ToolUserRepository userRepository, ToolUserRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<ToolUser> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Collection<ToolUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<ToolUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public ToolUser createUser(ToolUser newUser) {
        var role = roleRepository.findById(newUser.getUserRole().getId())
                .orElseThrow(() -> new EntityNotFoundException("Role with id = " + newUser.getUserRole().getId() + " not found"));
        newUser.setUserRole(role);
        return userRepository.save(newUser);
    }
}
