/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "STUDENT")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByYearlevel", query = "SELECT s FROM Student s WHERE s.yearlevel = :yearlevel")})
public class Student implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Period> periodCollection;

    @Id
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "YEARLEVEL")
    private Integer yearlevel;

    public Student(Integer studentid, String firstname, String lastname, Integer yearlevel) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }

    public Student() {
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(Integer yearlevel) {
        this.yearlevel = yearlevel;
    }

    @Override
    public String toString() {
        return "Student{" + "studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", yearlevel=" + yearlevel + '}';
    }

    @XmlTransient
    public Collection<Period> getPeriodCollection() {
        return periodCollection;
    }

    public void setPeriodCollection(Collection<Period> periodCollection) {
        this.periodCollection = periodCollection;
    }

}
