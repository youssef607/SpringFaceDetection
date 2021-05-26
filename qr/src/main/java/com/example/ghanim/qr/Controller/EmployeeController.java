package com.example.ghanim.qr.Controller;

import com.example.ghanim.qr.FileUploadUtil;
import com.example.ghanim.qr.Repository.EmployeeRepository;
import com.example.ghanim.qr.entities.Employee;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
public class EmployeeController {
    public EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("Employee")
    public List<Employee> getAllEmployee()
    {
    return employeeRepository.findAll();
    }

    @PostMapping(value = "Employee",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveEmployee(
            @RequestPart("Employee") Employee employee,
            @RequestPart("image1") MultipartFile image1
    ) throws IOException {

        employeeRepository.save(employee);
        employee.setImageEmployee(employee.getIdEmployee()+"image1");
        String MainfolderDir = System.getProperty("user.home")+"/Pointage";
        Path MainfolderPath = Paths.get(MainfolderDir);

        if(!Files.exists(MainfolderPath)){
            Files.createDirectories(MainfolderPath);
        }

        String folderDir = System.getProperty("user.home")+"/Pointage/"+employee.getIdEmployee();

        Path folderPath = Paths.get(folderDir);

        if (!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }

        FileUploadUtil.saveFile(folderDir+"/"+employee.getImageEmployee()+".jpg",  image1);
        return String.valueOf(employee.getIdEmployee());
    }


    @GetMapping(value = "Employee/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProduitImage(@PathVariable long id)throws IOException{
        String imageDir = System.getProperty("user.home")+"/Pointage/"+id+"/"+id+"image1"+".jpg";
        Path imagePath = Paths.get(imageDir);

        return Files.readAllBytes(imagePath);
    }

    @DeleteMapping(value = "Employee/{id}")
    public void deleteEmployee(@PathVariable long id) throws IOException {
        employeeRepository.deleteById(id);
        String folderDir = System.getProperty("user.home")+"/Pointage/"+id;
        File file = new  File(folderDir);
        FileUtils.deleteDirectory(file);
    }

    @PutMapping(value = "Employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("Employee/CodeQr/{Qr}")
    public Employee GetEmployeeByQr(@PathVariable String Qr)
    {
        return employeeRepository.EmployeeByCodeQR(Qr);
    }
}
