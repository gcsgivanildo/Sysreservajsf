package br.edu.garanhuns.sysreservajsf.entity;
// Generated 14/11/2016 19:17:57 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


public class Aula {


     private Integer id;
     private Professor professor;
     private Sala sala;
     private Date data;
     private Date hora;
     private Integer duracao;
     private Set<Equipamento> equipamentos = new LinkedHashSet<Equipamento>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Set<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Set<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    

}


