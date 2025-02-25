package br.unitins.topicos.Lista.repository;

import br.unitins.topicos.Lista.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
