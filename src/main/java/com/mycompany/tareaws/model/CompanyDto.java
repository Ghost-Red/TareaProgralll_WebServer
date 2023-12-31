/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Progralll
 */
@XmlRootElement
public class CompanyDto {

    private Long id;
    private String name;
    private String email;
    private byte[] logo;
    private byte[] emailTemplatePassword;
    private String tokenEmail;
    private byte[] emailTemplateActivateUser;
    private boolean modificate;

    private List<EmployeeDto> employeeList;
    private List<EvaluationDto> evaluationList;
    private List<JobDto> jobList;
    private List<SkillDto> skillList;

    public CompanyDto() {
        modificate = false;
        employeeList = new ArrayList<>();
        evaluationList = new ArrayList<>();
        jobList = new ArrayList<>();
        skillList = new ArrayList<>();
    }

    public CompanyDto(Company company) {
        this();
        if (company != null) {
            this.id = company.getId();
            this.name = company.getName();
            this.email = company.getEmail();
            this.logo = company.getLogo();
            this.emailTemplatePassword = company.getEmailTemplatePassword();
            this.tokenEmail = company.getTokenEmail();
            this.emailTemplateActivateUser = company.getEmailTemplateActivateUser();
        }
    }

    public void setForeignAtributes(Company company) {
        setEmployeeList(company.getEmployeeList());
        setEvaluationList(company.getEvaluationList());
        setJobList(company.getJobList());
        setSkillList(company.getSkillList());
    }

    @XmlElement(name = "skillList")
    public List<SkillDto> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        for (Skill skill : skillList) {
            this.skillList.add(new SkillDto(skill));
        }
    }

    @XmlElement(name = "employeeList")
    public List<EmployeeDto> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            this.employeeList.add(new EmployeeDto(employee));
        }
    }

    @XmlElement(name = "evaluationList")
    public List<EvaluationDto> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        for (Evaluation evaluation : evaluationList) {
            this.evaluationList.add(new EvaluationDto(evaluation));
        }
    }

    @XmlElement(name = "jobList")
    public List<JobDto> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        for (Job job : jobList) {
            this.jobList.add(new JobDto(job));
        }
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "logo")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @XmlElement(name = "emailTemplatePassword")
    public byte[] getEmailTemplatePassword() {
        return emailTemplatePassword;
    }

    public void setEmailTemplatePassword(byte[] emailTemplatePassword) {
        this.emailTemplatePassword = emailTemplatePassword;
    }

    @XmlElement(name = "tokenEmail")
    public String getTokenEmail() {
        return tokenEmail;
    }

    public void setTokenEmail(String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    @XmlElement(name = "emailTemplateActivateUser")
    public byte[] getEmailTemplateActivateUser() {
        return emailTemplateActivateUser;
    }

    public void setEmailTemplateActivateUser(byte[] emailTemplateActivateUser) {
        this.emailTemplateActivateUser = emailTemplateActivateUser;
    }

    @XmlElement(name = "modificate")
    public boolean isModificate() {
        return modificate;
    }

    public void setModificate(boolean modificate) {
        this.modificate = modificate;
    }

    @Override
    public String toString() {
        return "CompanyDto{" + "id=" + id + ", name=" + name + ", email=" + email + ", logo=" + logo + ", emailTemplatePassword=" + emailTemplatePassword + ", tokenEmail=" + tokenEmail + ", emailTemplateActivateUser=" + emailTemplateActivateUser + ", modificate=" + modificate + '}';
    }

}
