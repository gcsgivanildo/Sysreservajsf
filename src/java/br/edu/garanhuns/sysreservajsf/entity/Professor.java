package br.edu.garanhuns.sysreservajsf.entity;
// Generated 14/11/2016 19:17:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class Professor{


     private int siape;
     private String nome;
     private String senha;
     private Set<Aula> aulas = new LinkedHashSet<Aula>();

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

   

}


