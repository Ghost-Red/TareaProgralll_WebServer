/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

/**
 *
 * @author james
 */
public class EmployeeEvaluatorRelationDto {

    private Long id;
    private String relationType;
    private String feedback;
    private EmployeeDto employee;
    private EmployeeEvaluationRelationDto employeeEvaluationRelation;
    private boolean modificate;

    public EmployeeEvaluatorRelationDto() {
        modificate = false;
    }

    public EmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this();
        this.id = employeeEvaluatorRelation.getId();
        this.relationType = employeeEvaluatorRelation.getEmployeeEvaluatorRelationType();
        this.feedback = employeeEvaluatorRelation.getFeedback();
        this.employee = new EmployeeDto(employeeEvaluatorRelation.getEmployeeEvaluator());
        this.employeeEvaluationRelation = new EmployeeEvaluationRelationDto(employeeEvaluatorRelation.getEmployeeEvaluated());
    }

    public void updateEmployeeEvaluatorRelationDto(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this.id = employeeEvaluatorRelation.getEeId();
        this.relationType = employeeEvaluatorRelation.getEeRelationType();
        this.feedback = employeeEvaluatorRelation.getEeFeedback();
        this.employee.updateEmployeeDto(employeeEvaluatorRelation.getEeEmpId());
        this.employeeEvaluationRelation.updateEmployeeEvaluationRelationDto(employeeEvaluatorRelation.getEvaEmployeeId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public EmployeeEvaluationRelationDto getEmployeeEvaluationRelation() {
        return employeeEvaluationRelation;
    }

    public void setEmployeeEvaluationRelation(EmployeeEvaluationRelationDto employeeEvaluationRelation) {
        this.employeeEvaluationRelation = employeeEvaluationRelation;
    }

    @Override
    public String toString() {
        return "EmployeeEvaluatorRelationDto{" + "id=" + id + ", employeeEvaluatorRelationType=" + relationType + ", feedback=" + feedback + ", id=" + employee + ", employeeEvaluated=" + employeeEvaluationRelation + ", modificate=" + modificate + '}';
    }

}