package com.school.entity;

import com.school.entity.Period;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T16:16:37")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> code;
    public static volatile SingularAttribute<Course, Integer> credits;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile CollectionAttribute<Course, Period> periodCollection;
    public static volatile SingularAttribute<Course, Integer> students;
    public static volatile SingularAttribute<Course, Integer> semester;

}