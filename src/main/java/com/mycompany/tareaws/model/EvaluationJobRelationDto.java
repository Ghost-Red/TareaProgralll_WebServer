/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class EvaluationJobRelationDto {

    private Long id;
    private EvaluationDto evaluation;
    private JobDto job;
    private List<EmployeeEvaluationRelationDto> employeeEvaluationRelationList;
    private boolean modificate;

    public EvaluationJobRelationDto() {
        modificate = false;
        evaluation = new EvaluationDto();
        job = new JobDto();
        employeeEvaluationRelationList = new ArrayList<>();
    }

    public void setForeignAtributes(EvaluationJobRelation evaluationJobRelation) {
        evaluation = new EvaluationDto(evaluationJobRelation.getEvaluation());
        evaluation.setForeignAtributes(evaluationJobRelation.getEvaluation());
        job = new JobDto(evaluationJobRelation.getJob());
        job.setForeignAtributes(evaluationJobRelation.getJob());
        setEmployeeEvaluationRelationList(evaluationJobRelation.getEmployeeEvaluationRelationList());
    }

    public List<EmployeeEvaluationRelationDto> getEmployeeEvaluationRelationList() {
        return employeeEvaluationRelationList;
    }

    public void setEmployeeEvaluationRelationList(List<EmployeeEvaluationRelation> employeeEvaluationRelationList) {
        for (EmployeeEvaluationRelation employeeEvaluationRelation : employeeEvaluationRelationList) {
            this.employeeEvaluationRelationList.add(new EmployeeEvaluationRelationDto(employeeEvaluationRelation));
        }
    }

    public EvaluationJobRelationDto(EvaluationJobRelation evaluationJobRelation) {
        this();
        this.id = evaluationJobRelation.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EvaluationDto getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationDto evaluation) {
        this.evaluation = evaluation;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "EvaluationJobRelationDto{" + "id=" + id + ", id=" + evaluation + ", job=" + job + ", modificate=" + modificate + '}';
    }

}