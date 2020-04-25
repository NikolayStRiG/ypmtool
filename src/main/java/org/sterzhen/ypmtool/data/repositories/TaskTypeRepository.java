package org.sterzhen.ypmtool.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sterzhen.ypmtool.data.entities.TaskType;

import java.util.Optional;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
    Optional<TaskType> findByType(String type);
}
