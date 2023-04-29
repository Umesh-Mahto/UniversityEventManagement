package com.geekster.University.Event.Management.service;

import com.geekster.University.Event.Management.models.StudentModel;
import com.geekster.University.Event.Management.repository.IStudentDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentDao studentDao;

    public String saveStudent(ArrayList<StudentModel> studentList) {
        Iterable<StudentModel> saveStatus = studentDao.saveAll(studentList);
        if(saveStatus != null)
            return "added successfully.....!!!";
        else
            return "Not added successfully.....!!!";
    }
    @Transactional
    public void udateDetails(Integer id , String department) {

        studentDao.updateStudentDepartment(id,department);

    }
    public void deleteStudentDetails(Integer id) {
        studentDao.deleteById(id);
    }
    public Iterable<StudentModel> GetAllStudents() {
        return studentDao.findAll();
    }
    public Optional<StudentModel> findStudentById(Integer id) {
        return studentDao.findById(id);
    }
}