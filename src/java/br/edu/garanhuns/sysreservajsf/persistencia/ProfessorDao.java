/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.sysreservajsf.persistencia;

import br.edu.garanhuns.sysreservajsf.entity.Professor;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;





/**
 *
 * @author givanildo
 */
public class ProfessorDao {
private Connection connection;

    private static Session sessao;
    private Transaction trans;
    private List<Professor> list;
    private SessionFactory sessionFactory;

    public ProfessorDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    public List<Professor> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Professor.class);
        this.list = cri.list();
        return list;
    }

    public void addProfessor(Professor p) {
        
          
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
                    BigInteger senhaCriptografada = new BigInteger(1, md5.digest(p.getSenha().getBytes()));
                    p.setSenha(senhaCriptografada.toString(16));
            }  catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }  
            sessao.merge(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

//    public void removeProfessor(Professor eq) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.delete(eq);
//            trans.commit();
//
//        } catch (Exception e) {
//            trans.rollback();
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }
    
    
    //metodo para remover Professor
    public void removeProfessor(Professor professor){
            try {
                PreparedStatement stmt = connection.prepareStatement(
                        "delete from professor where siape=?");
                stmt.setInt(1, professor.getSiape());
                stmt.execute();
                stmt.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
    }

//    public void updateProfessor(Professor pp) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.update(pp);
//            trans.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }
    
    //metodo para alterar Professor
    public void updateProfessor(Professor professor){
        String sql = "update professor set siape=?, Nome=?, Senha=? where siape=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, professor.getSiape());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getSenha());
            stmt.setInt(4, professor.getSiape());
            
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}