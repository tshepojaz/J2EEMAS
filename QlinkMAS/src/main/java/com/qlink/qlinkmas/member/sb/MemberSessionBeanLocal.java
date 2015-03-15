/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.member.sb;

import com.qlink.qlinkmas.entities.Members;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DineoJaz
 */
@Local
public interface MemberSessionBeanLocal {
   List <Members> getAllMembers();
   void createMember(String firstName, String lastName, String initial, Long idNo, Date DOB,String gender, Integer cellNo, String email);
   void updateMember(Members m);
   void deleteMember(Members m);
   Members selectMember(int member_id);
}
