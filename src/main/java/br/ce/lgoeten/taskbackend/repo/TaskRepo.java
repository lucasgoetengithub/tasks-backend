package br.ce.lgoeten.taskbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ce.lgoeten.taskbackend.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
