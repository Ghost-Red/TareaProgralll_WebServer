/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.CompanyDto;
import com.mycompany.tareaws.service.CompanyService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author grana
 */
@WebService(serviceName = "CompanyController")
public class CompanyController {

    @EJB
    CompanyService companyService;

    @WebMethod(operationName = "getCompany")
    public CompanyDto getCompany(@WebParam(name = "id") Long id) {
        Respuesta res = companyService.getCompany(id);
        return (CompanyDto) res.getResultado("Company");
    }
}