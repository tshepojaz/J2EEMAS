/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.webuser.sb;

import com.qlink.qlinkmas.entities.WebUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DineoJaz
 */
@Stateless
public class WebUserSessionBean implements WebUserSessionBeanLocal {
    
    @PersistenceContext(unitName="com.qlink_QlinkMAS_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<WebUser> getAllWUser() {
        return em.createNamedQuery("WebUser.findAll",WebUser.class).getResultList();
    }

    @Override
    public void createWebUser(String username, String password, String wuser) {
        WebUser w = new WebUser();
        w.setUsername(username);
        w.setPassword(password);
        w.setWuserRole(wuser);
        
        em.persist(w);
    }

    @Override
    public void updateWUser(WebUser w) {
        em.merge(w);
    }

    @Override
    public void delteWUser(int wuser_id) {
        WebUser w = em.find(WebUser.class, wuser_id);
        
        if(w != null){
            em.remove(w);
        }
    }

    @Override
    public WebUser getWUser(String username) {
        try{
            WebUser ws = (WebUser)em.createNamedQuery("WebUser.findByUsername").setParameter("username", username).getSingleResult();
            return ws;    
        }catch (NoResultException e){
            return null;
            
        }
    }

   

}
