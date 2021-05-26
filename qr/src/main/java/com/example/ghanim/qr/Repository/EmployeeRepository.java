package com.example.ghanim.qr.Repository;

import com.example.ghanim.qr.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(nativeQuery = true,value = "select * from pointage.employee e where e.code_qr =?1")
    Employee EmployeeByCodeQR(String codeQr);

    
}
