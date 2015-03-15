/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DineoJaz
 */
@Entity
@Table(name = "web_user")
@NamedQueries({
    @NamedQuery(name = "WebUser.findAll", query = "SELECT w FROM WebUser w"),
    @NamedQuery(name = "WebUser.findByWuserId", query = "SELECT w FROM WebUser w WHERE w.wuserId = :wuserId"),
    @NamedQuery(name = "WebUser.findByUsername", query = "SELECT w FROM WebUser w WHERE w.username = :username"),
    @NamedQuery(name = "WebUser.findByPassword", query = "SELECT w FROM WebUser w WHERE w.password = :password"),
    @NamedQuery(name = "WebUser.findByWuserRole", query = "SELECT w FROM WebUser w WHERE w.wuserRole = :wuserRole")})
public class WebUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wuser_id")
    private Integer wuserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "wuser_role")
    private String wuserRole;

    public WebUser() {
    }

    public WebUser(Integer wuserId) {
        this.wuserId = wuserId;
    }

    public WebUser(Integer wuserId, String username, String password) {
        this.wuserId = wuserId;
        this.username = username;
        this.password = password;
    }

    public Integer getWuserId() {
        return wuserId;
    }

    public void setWuserId(Integer wuserId) {
        this.wuserId = wuserId;
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

    public String getWuserRole() {
        return wuserRole;
    }

    public void setWuserRole(String wuserRole) {
        this.wuserRole = wuserRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wuserId != null ? wuserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebUser)) {
            return false;
        }
        WebUser other = (WebUser) object;
        if ((this.wuserId == null && other.wuserId != null) || (this.wuserId != null && !this.wuserId.equals(other.wuserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlink.qlinkmas.entities.WebUser[ wuserId=" + wuserId + " ]";
    }
    
}
