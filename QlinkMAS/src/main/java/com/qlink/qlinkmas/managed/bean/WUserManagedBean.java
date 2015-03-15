/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.managed.bean;

import com.qlink.qlinkmas.entities.WebUser;
import com.qlink.qlinkmas.webuser.sb.WebUserSessionBeanLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DineoJaz
 */
@ManagedBean(name="wusermb")
@RequestScoped
public class WUserManagedBean {
    public static final String USER_SESSION_KEY = "wuser";
    
    private List<WebUser> wuserList;
    private List<WebUser> filterWUser;
    private WebUser webuser;
    private String username;
    private String password;
    private String wuser_role;
    private String passwordv;
    private String matchstats;
     
    @EJB
    WebUserSessionBeanLocal wuserbean;
    
    
    @PostConstruct 
    public void init(){
       wuserList = wuserbean.getAllWUser(); 
    }

    public List<WebUser> getWuserList() {
        return wuserList;
    }

    public void setWuserList(List<WebUser> wuserList) {
        this.wuserList = wuserList;
    }

    public List<WebUser> getFilterWUser() {
        return filterWUser;
    }

    public void setFilterWUser(List<WebUser> filterWUser) {
        this.filterWUser = filterWUser;
    }
    
    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWuser_role() {
        return wuser_role;
    }

    public void setWuser_role(String wuser_role) {
        this.wuser_role = wuser_role;
    }

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public String getMatchstats() {
        return matchstats;
    }

    public void setMatchstats(String matchstats) {
        this.matchstats = matchstats;
    }
    
    
    
    //Validate user login crediantials
    public String validatWUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        WebUser wuser = wuserbean.getWUser(username);
        
        if(wuser != null){
            if(!wuser.getPassword().equals(password)){
                FacesMessage message;
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login Failed!",
                        "Username or password is not correct.");
                context.addMessage(null, message);
                return null;
            }
            
          
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, wuser);
            return "main-app";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Failed",
                    "Username or password is not correct.");
           context.addMessage(null, message);
                return null; 
        }
        
    }
    
    //log the user out and terminate the session
    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
          
           if(session != null ){
             session.invalidate();
           }
          return "index";    
    }
    
    //add new web user
    public String createWuser(){
        wuserbean.createWebUser(username, password, wuser_role);
        FacesMessage msg = new FacesMessage("","Web user added sucessfully");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "main-app";
    }
    
    public String updateWebUser(WebUser w){
        wuserbean.updateWUser(w);
        FacesMessage msg = new FacesMessage("","Web user updated sucessfully");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "main-app";  
    }
    
    public String onRowEdit(WebUser w){
       wuserbean.updateWUser(w);
        FacesMessage msg = new FacesMessage("","Web user updated sucessfully");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public String onRowCancel(){
        FacesMessage msg = new FacesMessage("","Update cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public void passwordMatch(){
       if (!password.equals(passwordv)){
            matchstats = "The specified passwords do not match.";                
       } 
       else {
           matchstats = "Match ok";
       }
    }
    
    
}
