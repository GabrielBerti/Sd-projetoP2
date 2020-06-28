package br.edu.logatti.projetoP2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Curso implements Serializable {

    private static final long serialVersionUID = 5633078074869730452L;

    @Id
    private String id;
    private String nome;
    private String cargaHoraria;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}