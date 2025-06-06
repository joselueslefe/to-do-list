package com.tarefas.todo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private long id;

    private String descrincao;

    private boolean concluida;
}
