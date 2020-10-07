package com.school.entity;

import com.school.entity.Period;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T16:16:37")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentid;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Integer> yearlevel;
    public static volatile CollectionAttribute<Student, Period> periodCollection;
    public static volatile SingularAttribute<Student, String> lastname;

}