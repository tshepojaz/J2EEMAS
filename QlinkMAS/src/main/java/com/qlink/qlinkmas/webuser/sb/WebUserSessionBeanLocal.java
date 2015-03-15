/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.webuser.sb;

import com.qlink.qlinkmas.entities.WebUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DineoJaz
 */
@Local
public interface WebUserSessionBeanLocal {
    List <WebUser> getAllWUser();
    void createWebUser(String username, String password, String wuser);
    void updateWUser(WebUser w);
    void delteWUser(int wuser_id);
    WebUser getWUser(String username);
}
