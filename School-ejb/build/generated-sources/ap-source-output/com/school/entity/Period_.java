package com.school.entity;

import com.school.entity.Course;
import com.school.entity.PeriodPK;
import com.school.entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T16:16:37")
@StaticMetamodel(Period.class)
public class Period_ { 

    public static volatile SingularAttribute<Period, String> date;
    public static volatile SingularAttribute<Period, PeriodPK> periodPK;
    public static volatile SingularAttribute<Period, Student> student;
    public static volatile SingularAttribute<Period, Course> course;

}