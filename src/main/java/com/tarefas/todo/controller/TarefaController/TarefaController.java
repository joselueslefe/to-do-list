package com.tarefas.todo.controller.TarefaController;

import com.tarefas.todo.model.Tarefa;
import com.tarefas.todo.repository.TarefaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController (TarefaRepository repo){
        this.repo = repo;
    }
    @GetMapping
    public List<Tarefa> listar(){
        return repo.findAll();
    }

    @PostMapping
    public Tarefa adicionar (@RequestBody Tarefa tarefa) {
        return repo.save(tarefa);
    }

    @PutMapping("/{id}/concluir")
    public Tarefa concluir (@PathVariable long id) {
        Tarefa tarefa = repo.findById(id).orElseThrow();
        tarefa.setConcluida(true);
        return repo.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar (@PathVariable long id, @RequestBody Tarefa novaTarefa){
        Tarefa tarefa = repo.findById(id).orElseThrow();
        tarefa.setDescrincao(novaTarefa.getDescrincao());
        tarefa.setConcluida(novaTarefa.isConcluida());
        return repo.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        repo.deleteById(id);
    }
}
