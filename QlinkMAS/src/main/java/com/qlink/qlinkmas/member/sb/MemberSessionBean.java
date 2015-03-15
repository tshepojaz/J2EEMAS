/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.member.sb;

import com.qlink.qlinkmas.entities.Members;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


/**
 *
 * @author DineoJaz
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MemberSessionBean implements MemberSessionBeanLocal {
    @Resource
    private UserTransaction tx;
    @PersistenceContext(unitName="com.qlink_QlinkMAS_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<Members> getAllMembers() {
        return em.createNamedQuery("Members.findAll",Members.class).getResultList();
    }

    @Override
    public void createMember(String firstName, String lastName, String initial, Long idNo, Date DOB, String gender, Integer cellNo, String email) {
        try{
         tx.begin();   
          Members m = new Members();
          m.setFirstName(firstName);
          m.setLastName(lastName);
          m.setInitials(initial);
          m.setIdNo(idNo);
          m.setDob(DOB);
          m.setGender(gender);
          m.setCellNo(cellNo);
          m.setEmail(email);
        
          em.persist(m);
         tx.commit();
        }catch(Exception e){
            try {
                tx.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void updateMember(Members m) {
        try{
           tx.begin();
           em.merge(m);
           tx.commit();
        }catch(Exception e){
            try {
                tx.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deleteMember(Members m) {
        //Members m = em.find(Members.class,memberId);
        //if(m != null){
          try{
             tx.begin(); 
             em.remove(m);
             tx.commit();
          }catch(Exception e){
                try { 
                    tx.rollback();
                } catch (IllegalStateException ex) {
                    Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SystemException ex) {
                    Logger.getLogger(MemberSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                }
          }
        //}
    }

    @Override
    public Members selectMember(int member_id) {
        Members m = em.find(Members.class, member_id);
        
        if(m != null){
            return m;
        }
        else{
            return null;
        }
    }

    

}
