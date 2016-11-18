/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.beans;



import br.edu.garanhuns.sysreservajsf.entity.Equipamento;
import br.edu.garanhuns.sysreservajsf.persistencia.DAOException;
import br.edu.garanhuns.sysreservajsf.persistencia.EquipamentoDao;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jboss.weld.util.Beans;
import org.primefaces.context.RequestContext;

/**
 *
 * @author givanildo
 */
@ManagedBean
@SessionScoped
public class EquipamentoBean {
    private Equipamento equipamento = new Equipamento();
    private EquipamentoDao equipamentoDao = new EquipamentoDao();
    private List<Equipamento> listaEquipamento;
    
    public EquipamentoBean(){
        
    }
    
    public String adicionaEquipamento(){
        equipamentoDao.addEquipamento(equipamento);
        //this.equipamento.setNomeEquipamento(null);
        //this.equipamento.setMarca(null);
        //this.equipamento.setTipo(null);
        //this.equipamento.setUtilidade(null);
        return "listaEquip";
    }
    
    public String removeEquipamento(Equipamento eq){
        this.equipamento = eq;
        equipamentoDao.removeEquipamento(this.equipamento);
        return "listaEquip";
    }
    
    public List listarEquipamento(){
        listaEquipamento = equipamentoDao.getList();
        return listaEquipamento;
    }
    
    public String carregarEquipamento(Equipamento eq){
        this.equipamento = eq;
        return "editarEquip";
    }
    
    public String updateEquipamento(){
        this.equipamentoDao.updateEquipamento(equipamento);
        
        return "listaEquip";
    }
    
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.equipamento);
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
        final EquipamentoBean other = (EquipamentoBean) obj;
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        return true;
    }
    
    
}

