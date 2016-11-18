package br.edu.garanhuns.sysreservajsf.persistencia;

import br.edu.garanhuns.sysreservajsf.entity.Equipamento;
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
public class EquipamentoDao {

    private Session sessao;
    private Transaction trans;
    private List<Equipamento> list;
    
    private Connection connection;
    
    public EquipamentoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Equipamento> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Equipamento.class);
        this.list = cri.list();
        return list;
    }

    public void addEquipamento(Equipamento eq) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.save(eq);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

//    public void removeEquipamento(Equipamento eq) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.delete(eq);
//            trans.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }

    //metodo para alterar Equipamento
    public void updateEquipamento(Equipamento equipamento){
        String sql = "update equipamento set nome=?, marca=?, tipo=?, utilidade=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getMarca());
            stmt.setString(3, equipamento.getTipo());
            stmt.setString(4, equipamento.getUtilidade());
            stmt.setInt(5, equipamento.getId());
            
            stmt.execute();
            stmt.close();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //metodo para remover Equipamento
    public void removeEquipamento(Equipamento equipamento){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                        "delete from equipamento where id=?");
            stmt.setInt(1, equipamento.getId());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
//    public void updateEquipamento(Equipamento eq) {
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            trans = sessao.beginTransaction();
//
//            sessao.update(eq);
//            trans.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sessao.close();
//        }
//    }

}