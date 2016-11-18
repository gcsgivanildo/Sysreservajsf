/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.persistencia;

import br.edu.garanhuns.sysreservajsf.entity.Aula;
import br.edu.garanhuns.sysreservajsf.entity.Equipamento;
import br.edu.garanhuns.sysreservajsf.entity.Sala;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
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
public class AulaDao {

    private Session sessao;
    private Transaction trans;
    private List<Aula> list;
    
    private Connection connection;
    
    public AulaDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Aula> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Aula.class);
        this.list = cri.list();
        return list;
    }

    public void addAula(Aula a) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(a);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

//    public void removeAula(Aula a) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.delete(a);
//            trans.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }

    //metodo para alterar aula
    public void updateAula(Aula aula){
        String sql = "update aula set data=?, hora=?, duracao=?, professor_id=?, sala_id=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, new Date(aula.getData().getTimezoneOffset()));
            stmt.setTime(2, new Time(aula.getHora().getTime()));
            stmt.setInt(3, aula.getDuracao());
            stmt.setObject(4, aula.getProfessor());
            stmt.setObject(5, aula.getSala());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para remover aula
    public void removeAula(Aula aula){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                        "delete from aula where id=?");
            stmt.setInt(1, aula.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
//    public void updateAula(Aula a) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.update(a);
//            trans.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }

}