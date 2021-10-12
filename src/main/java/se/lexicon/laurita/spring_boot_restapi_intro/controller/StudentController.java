package se.lexicon.laurita.spring_boot_restapi_intro.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.laurita.spring_boot_restapi_intro.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("123456","Laurita", "Owanta", LocalDate.parse("1990-09-14"),"1990-09-14-0000", "Islandvagen 8 vaxjo"),
                    new Student("24685", "Neon", "Owanta", LocalDate.parse("2020-11-30"),"2020-11-30-0000","Arabyvagen 4 SomeWhereStreet")
            )
    );


    @GetMapping("/firstresource")
    public ResponseEntity<Student> getResource(){

        return ResponseEntity.status(HttpStatus.valueOf(200)).body(students.get(0));
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> findAll(){

        if (students.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

}

