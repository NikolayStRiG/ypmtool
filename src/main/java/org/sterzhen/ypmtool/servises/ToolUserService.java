package org.sterzhen.ypmtool.servises;

import org.sterzhen.ypmtool.data.entities.ToolUser;

import java.util.Collection;
import java.util.Optional;

public interface ToolUserService {

    Optional<ToolUser> findByLogin(String login);

    Collection<ToolUser> findAll();

    Optional<ToolUser> findById(Long id);
}
