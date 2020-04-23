package org.sterzhen.ypmtool.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sterzhen.ypmtool.data.entities.ToolUser;

import java.util.Optional;

@Repository
public interface ToolUserRepository extends JpaRepository<ToolUser, Long> {

    Optional<ToolUser> findByLogin(String login);
}
