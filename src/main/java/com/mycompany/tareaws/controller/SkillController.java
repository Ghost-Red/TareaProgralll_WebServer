/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.controller;

import com.mycompany.tareaws.model.SkillDto;
import com.mycompany.tareaws.service.SkillService;
import com.mycompany.tareaws.util.Respuesta;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 *
 * @author james
 */
@WebService(serviceName = "SkillController")
public class SkillController {

    @EJB
    SkillService skillService;

    @WebMethod(operationName = "getSkill")
    public SkillDto getSkill(@WebParam(name = "id") Long id) {
        Respuesta res = skillService.getSkill(id);
        return (SkillDto) res.getResultado("Skill");
    }

    @WebMethod(operationName = "saveSkill")
    public boolean saveSkill(SkillDto skill) {
        Respuesta res = skillService.saveSkill(skill);
        return res.getEstado();
    }

    @WebMethod(operationName = "deleteSkill")
    public boolean deleteSkill(@WebParam(name = "id") Long id) {
        Respuesta res = skillService.deleteSkill(id);
        return res.getEstado();
    }
}
