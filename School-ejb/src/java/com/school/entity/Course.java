/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByCredits", query = "SELECT c FROM Course c WHERE c.credits = :credits")
    , @NamedQuery(name = "Course.findBySemester", query = "SELECT c FROM Course c WHERE c.semester = :semester")
    , @NamedQuery(name = "Course.findByStudents", query = "SELECT c FROM Course c WHERE c.students = :students")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODE")
    private String code;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREDITS")
    private Integer credits;
    @Column(name = "SEMESTER")
    private Integer semester;
    @Column(name = "STUDENTS")
    private Integer students;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<Period> periodCollection;

    public Course() {
    }

    public Course(String code, String name, Integer credits, Integer semester, Integer students) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.semester = semester;
        this.students = students;
    }

    public Course(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    @XmlTransient
    public Collection<Period> getPeriodCollection() {
        return periodCollection;
    }

    public void setPeriodCollection(Collection<Period> periodCollection) {
        this.periodCollection = periodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.entity.Course[ code=" + code + " ]";
    }

}
