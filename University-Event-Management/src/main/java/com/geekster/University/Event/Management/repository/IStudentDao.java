package com.geekster.University.Event.Management.repository;

import com.geekster.University.Event.Management.models.StudentModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends CrudRepository <StudentModel , Integer> {

    @Modifying
    @Query(value = "update student_model set student_department=:department where student_id=:id" ,nativeQuery = true )
    public void updateStudentDepartment(Integer id, String department);
}
