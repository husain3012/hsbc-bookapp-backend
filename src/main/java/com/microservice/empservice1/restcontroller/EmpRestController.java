package com.microservice.empservice1.restcontroller;


import com.microservice.empservice1.empdao.EmpDaoRepo;
import com.microservice.empservice1.model.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("emprest")
@RestController
public class EmpRestController {

    Logger logger = LoggerFactory.getLogger(EmpRestController.class);

    @Autowired
    private EmpDaoRepo empdao;

    @GetMapping("emps")
    public List<Emp> getAllEmps()
    {
        logger.debug("inside getAllEmps of Emp Contoller");
        return this.empdao.findAll().subList(0,100);
    }


    @PostMapping("emp")
    public Emp postEmp(@RequestBody Emp e)
    {
        logger.info("inside postEmp, emp:"+e);
        return this.empdao.save(e);
    }

    @PutMapping("emp")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Emp> updateEmp(@RequestBody Emp e)
    {
        Optional<Emp> op = this.empdao.findById(e.getEmpId());

        logger.info("inside updateEmp, emp:"+e);
        Emp x = this.empdao.save(e);
        if(op.isPresent()) {
           logger.info("emp was updated...");
           return ResponseEntity.ok(x);
        }
        else
        {
            logger.info("emp was created...");
            return ResponseEntity.status(201).build();
        }
    }

    @GetMapping("emp/{empid}")
    public ResponseEntity<Emp> getEmpById(@PathVariable int empid)
    {
        logger.info("inside empservice-getempbyid");
        Optional<Emp> e = this.empdao.findById(empid);

        if(e.isPresent())
        {
            return ResponseEntity.ok(e.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("emp/{empid}")
    public ResponseEntity<Emp> deleteEmpById(@PathVariable int empid)
    {
        logger.info("inside empservice-deleteempbyid");

        Optional<Emp> e =  this.empdao.findById(empid);
        if(e.isPresent())
        {
            this.empdao.deleteById(empid);
            return ResponseEntity.ok(e.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("emp/{empname}")
    public ResponseEntity<Emp> getEmpByEmpName(@PathVariable String empName)
    {
        logger.info("inside empservice-getempbyname");
        Optional<Emp> e = this.empdao.findByEmpName(empName);

        if(e.isPresent())
        {
            return ResponseEntity.ok(e.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
