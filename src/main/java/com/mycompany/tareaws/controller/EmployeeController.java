/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.EmployeeDto;
import com.mycompany.tareaws.service.EmployeeService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

/**
 *
 * @author grana
 */
@WebService(serviceName = "EmployeeController")
public class EmployeeController {
    @EJB
    EmployeeService employeeService;

    @WebMethod(operationName = "getEmployee")
    public EmployeeDto getEmployee(@WebParam(name = "id") Long id) {
        Respuesta res = employeeService.getEmployee(id);
        return (EmployeeDto) res.getResultado("Employee");
    }
    @WebMethod(operationName = "saveEmployee")
    public EmployeeDto saveEmployee(EmployeeDto employee){
        Respuesta res = employeeService.saveEmployee(employee);
        return (EmployeeDto) res.getResultado("Employee");
    }
    
    @WebMethod(operationName = "deleteEmployee")
    public EmployeeDto deleteEmployee(@WebParam(name = "id") Long id){
        Respuesta res = employeeService.deleteEmployee(id);
        return (EmployeeDto) res.getResultado("Employee");
    }
}