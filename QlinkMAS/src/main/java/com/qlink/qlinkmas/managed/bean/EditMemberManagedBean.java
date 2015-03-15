/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlink.qlinkmas.managed.bean;

import com.qlink.qlinkmas.entities.Members;
import com.qlink.qlinkmas.member.sb.MemberSessionBeanLocal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author TshepoJaz
 */
@ManagedBean(name="editmember")
@SessionScoped
public class EditMemberManagedBean {
    private List <Members> membersList;
    private List <Members> filterMembers;
    private Members members;
    private Members member = null;
    private String firstName;
    private String lastName;
    private String initials;
    private Long idNo;
    private Date dob;
    private String gender;
    private Integer cellNo;
    private String email;
    
    @EJB 
    MemberSessionBeanLocal memBean;
    
    @PostConstruct
    public void init(){
        membersList = memBean.getAllMembers();
    }

    public List<Members> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Members> membersList) {
        this.membersList = membersList;
    }

    public List<Members> getFilterMembers() {
        return filterMembers;
    }

    public void setFilterMembers(List<Members> filterMembers) {
        this.filterMembers = filterMembers;
    }

   
    public Members getMembers() {
        return members;
    }
    
    public Members getMember(){
        return member;
    }

    public void setMembers(Members members) {
        this.members = members;
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

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
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
    
    //update existing member
    public String updateMember(Members m){
        memBean.updateMember(m);
        FacesMessage msg = new FacesMessage("","Member updated sucessfully");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "memberlist";  
    }  
    
    //Redirect to edit member page
    public String editMember(Members member){
        this.member = member;
        return "editmember";
    }
    
     //Remove member
    public String removeMember(Members m){
        memBean.deleteMember(m);
        return "memberlist";
    }
}
