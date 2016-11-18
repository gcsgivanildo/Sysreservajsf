/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.beans;


import br.edu.garanhuns.sysreservajsf.entity.Sala;
import br.edu.garanhuns.sysreservajsf.persistencia.DAOException;
import br.edu.garanhuns.sysreservajsf.persistencia.SalaDao;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author givanildo
 */
@ManagedBean
@SessionScoped
public class SalaBean {
    private Sala sala = new Sala();
    private SalaDao salaDao = new SalaDao();
    private List<Sala> listaSala;
    
    public SalaBean(){
        
    }
    
    public String adicionaSala(){
        salaDao.addSala(sala);
        //this.sala.setNome(null);
        return "listaSala";
    }
    
    public String removeSala(Sala s){
        this.sala = s;
        salaDao.removeSala(this.sala);
        return "listaSala";
    }
    
    public List listarSala(){
        listaSala = salaDao.getList();
        return listaSala;
    }
    
    public String carregarSala(Sala s){
        this.sala = s;
        return "editarSala";
    }
    
    public String updateSala(){
        this.salaDao.updateSala(sala);
        
        return "listaSala";
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.sala);
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
        final SalaBean other = (SalaBean) obj;
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        return true;
    }

//    private final SalaDAO salaDao;
//    
//    public SalaNegocio(){
//        salaDao = new SalaDAO();
//    }
//    
//    public void salvar(Sala sala)throws DAOException{
//       salaDao.save(sala);
//    }
//    
//    public void atualizar(Sala sala) throws DAOException{
//        salaDao.update(sala);
//    }
//
//   
//    public void remover (Sala sala) throws DAOException{        
//        salaDao.delete(sala);
//    }
//    
//   
//    
//      public List<Sala> listarSala() throws DAOException{
//        return salaDao.getAll();
//}
//      
//      public Sala SalaCodigo(int codigoSala) throws DAOException{
//          return salaDao.getSalaById(codigoSala);
//      }
//    
    
}
