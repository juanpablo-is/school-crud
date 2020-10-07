package com.school.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "PERIOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p")
    , @NamedQuery(name = "Period.findByIdCourse", query = "SELECT p FROM Period p WHERE p.periodPK.idCourse = :idCourse")
    , @NamedQuery(name = "Period.findByIdStudent", query = "SELECT p FROM Period p WHERE p.periodPK.idStudent = :idStudent")
    , @NamedQuery(name = "Period.findByAll", query = "SELECT p FROM Period p WHERE p.periodPK.idStudent = :idStudent AND p.periodPK.idCourse = :idCourse")
    , @NamedQuery(name = "Period.findByDate", query = "SELECT p FROM Period p WHERE p.date = :date")})

public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeriodPK periodPK;
    @Size(max = 12)
    @Column(name = "DATE")
    private String date;
    @JoinColumn(name = "ID_COURSE", referencedColumnName = "CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Period() {
    }

    public Period(PeriodPK periodPK, String date) {
        this.date = date;
        this.periodPK = periodPK;
    }

    public Period(String idCourse, int idStudent) {
        this.periodPK = new PeriodPK(idCourse, idStudent);
    }

    public PeriodPK getPeriodPK() {
        return periodPK;
    }

    public void setPeriodPK(PeriodPK periodPK) {
        this.periodPK = periodPK;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodPK != null ? periodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.periodPK == null && other.periodPK != null) || (this.periodPK != null && !this.periodPK.equals(other.periodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.entity.Period[ periodPK=" + periodPK + " ]";
    }
    
}
