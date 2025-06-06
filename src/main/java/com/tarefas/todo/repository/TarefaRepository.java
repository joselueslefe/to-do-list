package com.tarefas.todo.repository;

import com.tarefas.todo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository <Tarefa, Long> {
}
