package org.sterzhen.ypmtool.servises;

import org.springframework.stereotype.Service;
import org.sterzhen.ypmtool.data.entities.ToolUser;
import org.sterzhen.ypmtool.data.repositories.ToolUserRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class ToolUserServiceImpl implements ToolUserService {

    private final ToolUserRepository userRepository;

    public ToolUserServiceImpl(ToolUserRepository userRepository) {
        this.userRepository = userRepository;
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
}
