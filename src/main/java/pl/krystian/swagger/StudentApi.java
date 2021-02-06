package pl.krystian.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApi {

    private List<Student> studentList;


    public StudentApi() {
//        this.studentList=new ArrayList<>();
      this.studentList = Arrays.asList(new Student(1,"Krystian","Swagger"));
    }
    @ApiOperation(value = "Find students by id",notes="provide information about student by id")
    @GetMapping("/{id}")
    public Student getStudents(@ApiParam(value = "unique id of student",example = "1") @PathVariable int id){
        return studentList.stream()
                .filter(student -> student.getId()==id).findFirst().get();
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentList;
    }

    @PostMapping
    public boolean addStudent(@RequestBody Student student){
        return studentList.add(student);
    }

}
