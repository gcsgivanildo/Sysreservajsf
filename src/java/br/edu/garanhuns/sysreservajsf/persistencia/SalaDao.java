/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.persistencia;

import br.edu.garanhuns.sysreservajsf.entity.Aula;
import br.edu.garanhuns.sysreservajsf.entity.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author givanildo
 */
public class SalaDao {

    private Session sessao;
    private Transaction trans;
    private List<Sala> list;
    private Connection connection;

    public SalaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Sala> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Sala.class);
        this.list = cri.list();
        return list;
    }

    public void addSala(Sala s) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(s);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

//    public void removeSala(Sala s) {
//        try {            
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//           sessao.delete(s);
//            
//            trans.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }
    
    
    //metodo para alterar Sala
    public void updateSala(Sala sala) {
        String sql = "update sala set nome=?, localizacao=?, capacidade=?, tipo=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setString(2, sala.getLocalizacao());
            stmt.setInt(3, sala.getCapacidade());
            stmt.setString(4, sala.getTipo());
            stmt.setInt(5, sala.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //metodo para remover Sala
    public void removeSala(Sala sala) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from sala where id=?");
            stmt.setInt(1, sala.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
//    public void updateSala(Sala s) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.update(s);
//            trans.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }

}
