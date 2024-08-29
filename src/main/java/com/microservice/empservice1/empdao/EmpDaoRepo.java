package com.microservice.empservice1.empdao;

import com.microservice.empservice1.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpDaoRepo extends JpaRepository<Emp,Integer> {


    public Optional<Emp> findByEmpName(String empName);

    public Optional<Emp> findByEmpNameAndEmpSal(String empName, double empSal);


}
