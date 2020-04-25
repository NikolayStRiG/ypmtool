package org.sterzhen.ypmtool.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sterzhen.ypmtool.data.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
