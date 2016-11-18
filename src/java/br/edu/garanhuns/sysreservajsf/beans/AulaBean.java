/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.beans;




import br.edu.garanhuns.sysreservajsf.entity.Aula;
import br.edu.garanhuns.sysreservajsf.persistencia.AulaDao;
import br.edu.garanhuns.sysreservajsf.persistencia.DAOException;
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
public class AulaBean {
    private Aula aula = new Aula();
    private AulaDao aulaDao = new AulaDao();
    private List<Aula> listaAula;
    
    public AulaBean(){
        
    }
    
    public String adicionaAula(){
        aulaDao.addAula(aula);
        //this.equipamento.setNomeEquipamento(null);
        //this.equipamento.setMarca(null);
        //this.equipamento.setTipo(null);
        //this.equipamento.setUtilidade(null);
        return "listaEquip";
    }
    
    public String removeAula(Aula a){
        this.aula = a;
        aulaDao.removeAula(this.aula);
        return "listaEquip";
    }
    
    public List listarAula(){
        listaAula = aulaDao.getList();
        return listaAula;
    }
    
    public String carregarAula(Aula eq){
        this.aula = eq;
        return "editarAula";
    }
    
    public String updateAula(){
        this.aulaDao.updateAula(aula);
        
        return "listaAula";
    }
    
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.aula);
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
        final AulaBean other = (AulaBean) obj;
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        return true;
    }

    
    
}
