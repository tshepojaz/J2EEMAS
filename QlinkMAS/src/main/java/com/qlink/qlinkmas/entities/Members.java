/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DineoJaz
 */
@Entity
@Table(name = "members")
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m"),
    @NamedQuery(name = "Members.findByMemberId", query = "SELECT m FROM Members m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "Members.findByFirstName", query = "SELECT m FROM Members m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "Members.findByLastName", query = "SELECT m FROM Members m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "Members.findByInitials", query = "SELECT m FROM Members m WHERE m.initials = :initials"),
    @NamedQuery(name = "Members.findByIdNo", query = "SELECT m FROM Members m WHERE m.idNo = :idNo"),
    @NamedQuery(name = "Members.findByDob", query = "SELECT m FROM Members m WHERE m.dob = :dob"),
    @NamedQuery(name = "Members.findByGender", query = "SELECT m FROM Members m WHERE m.gender = :gender"),
    @NamedQuery(name = "Members.findByCellNo", query = "SELECT m FROM Members m WHERE m.cellNo = :cellNo"),
    @NamedQuery(name = "Members.findByEmail", query = "SELECT m FROM Members m WHERE m.email = :email")})
public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "INITIALS")
    private String initials;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NO")
    private long idNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "CELL_NO")
    private Integer cellNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;

    public Members() {
    }

    public Members(Integer memberId) {
        this.memberId = memberId;
    }

    public Members(Integer memberId, String firstName, String lastName, String initials, long idNo, Date dob, String gender) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.idNo = idNo;
        this.dob = dob;
        this.gender = gender;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCellNo() {
        return cellNo;
    }

    public void setCellNo(Integer cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlink.qlinkmas.entities.Members[ memberId=" + memberId + " ]";
    }
    
}
