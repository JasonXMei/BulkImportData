package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JasonMei
 * @since 2022-10-19
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public void batchInsert() {
        List<Student> list = new ArrayList<>(5000);
        for (int i = 68350; i < 5000000; i++) {
            Student student = Student.builder()
                    .age(new Random().nextInt(100))
                    .address("四川" + i)
                    .department("IT" + i)
                    .name("test" + i)
                    .sex(i % 2 == 0 ? "男" : "女")
                    .build();
            list.add(student);

            if (i % 5000 == 0) {
                studentService.saveBatch(list);
                list.clear();
            }


        }
    }
}
