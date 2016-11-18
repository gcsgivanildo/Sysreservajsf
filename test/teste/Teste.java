/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.edu.garanhuns.sysreservajsf.entity.Aula;
import br.edu.garanhuns.sysreservajsf.entity.Equipamento;
import br.edu.garanhuns.sysreservajsf.entity.Professor;
import br.edu.garanhuns.sysreservajsf.entity.Sala;
import java.time.Instant;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author givanildo
 */
public class Teste {
    public static void main(String[] args) throws Exception{
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        
        
        Aula a = new Aula();
        a.setId(2);
        session.delete(a);
        
        Professor p = new Professor();
        p.setSiape(11);
        session.delete(p);
        
        Sala s = new Sala();
        s.setNome("s1");
        s.setCapacidade(32);
        s.setLocalizacao("l1");
        s.setTipo("t1");
        session.save(s);
        
        

//        session.save(a);
//        
//        Equipamento e = new Equipamento();
//        e.setNome("e2");
//        e.setMarca("m2");
//        e.setTipo("t2");
//        e.setUtilidade("u2");
//        e.getAulas().add(a);
//        session.save(e);
       session.getTransaction().commit();
    }
}
