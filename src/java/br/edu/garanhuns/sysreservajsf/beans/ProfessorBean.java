/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.beans;


import br.edu.garanhuns.sysreservajsf.entity.Professor;
import br.edu.garanhuns.sysreservajsf.persistencia.DAOException;
import br.edu.garanhuns.sysreservajsf.persistencia.ProfessorDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author givanildo
 */
@ManagedBean
@SessionScoped
public class ProfessorBean {
    private Professor professor = new Professor();
    private ProfessorDao professorDao = new ProfessorDao();
    private List<Professor> listaProfessor;
    
    public ProfessorBean(){
        
    }
    
    public String adicionaProfessor(){
        ProfessorDao.addProfessor(professor);
//        this.professor.setSiape(Integer.parseInt(null));
//        this.professor.setNome(null);
//        this.professor.setSenha(null);
//        this.professor.setAulas(null);
        
        return "listaProf";
    }
    
    public String removeProfessor(Professor p){
        this.professor = p;
        professorDao.removeProfessor(professor);
        
        return "listaProf";
    }
    
    public List listarProfessor(){
        listaProfessor = professorDao.getList();
        return listaProfessor;
    }
    
    public String carregarProfessor(Professor p){
        this.professor = p;
        return "editarProf";
    }
    
    public String updateProfessor(){
        this.professorDao.updateProfessor(professor);
        
        return "listaProf";
    }
    
//    public void abrirDialogo(){
//        Map<String, Object> opcoes = new HashMap<>();
//        opcoes.put("modal", true);
//        opcoes.put("resizable", false);
//        opcoes.put("contentHeight", 470);
//        
//        RequestContext.getCurrentInstance().openDialog("editaProf", opcoes, null);
//    }
    

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfessorBean other = (ProfessorBean) obj;
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
    }

   

    
    
    
}
