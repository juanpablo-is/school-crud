/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juan Pablo
 */
@Embeddable

public class PeriodPK implements Serializable{

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ID_COURSE")
    private String idCourse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STUDENT")
    private int idStudent;

    public PeriodPK() {
    }

    public PeriodPK(String idCourse, int idStudent) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourse != null ? idCourse.hashCode() : 0);
        hash += (int) idStudent;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodPK)) {
            return false;
        }
        PeriodPK other = (PeriodPK) object;
        if ((this.idCourse == null && other.idCourse != null) || (this.idCourse != null && !this.idCourse.equals(other.idCourse))) {
            return false;
        }
        if (this.idStudent != other.idStudent) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.entity.PeriodPK[ idCourse=" + idCourse + ", idStudent=" + idStudent + " ]";
    }
}
