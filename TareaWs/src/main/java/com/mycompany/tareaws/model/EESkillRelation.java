/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaws.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 *
 * @author grana
 */
@Entity
@Table(name = "EE_SKILL_RELATION")
@NamedQueries({
    @NamedQuery(name = "EESkillRelation.findAll", query = "SELECT e FROM EESkillRelation e"),
    @NamedQuery(name = "EESkillRelation.findByid", query = "SELECT e FROM EESkillRelation e WHERE e.id = :id"),
    @NamedQuery(name = "EESkillRelation.findByskillClasification", query = "SELECT e FROM EESkillRelation e WHERE e.skillClasification = :skillClasification"),
    @NamedQuery(name = "EESkillRelation.findByversion", query = "SELECT e FROM EESkillRelation e WHERE e.version = :version")})
public class EESkillRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EES_ID")
    private Long id;
    @Column(name = "EES_SKILL_CLASIFICATION")
    private Long skillClasification;
    @Version
    @Column(name = "EES_VERSION")
    private Long version;
    @JoinColumn(name = "EES_EE_ID", referencedColumnName = "EE_ID")
    @ManyToOne(optional = false)
    private EmployeeEvaluatorRelation employeeEvaluatorRelation;
    @JoinColumn(name = "EES_SKILL_ID", referencedColumnName = "SKILL_ID")
    @ManyToOne(optional = false)
    private Skill evaluatedSkill;

    public EESkillRelation() {
    }

    public EESkillRelation(Long id) {
        this.id = id;
    }

    public EESkillRelation(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public EESkillRelation(EESkillRelationDto eESkillRelationDto) {
        updateEESkillRelation(eESkillRelationDto);
    }

    public void updateEESkillRelation(EESkillRelationDto eESkillRelationDto) {
        this.id = eESkillRelationDto.getId();
        this.skillClasification = eESkillRelationDto.getSkillClasification();
        this.employeeEvaluatorRelation.updateEmployeeEvaluatorRelation(eESkillRelationDto.getEmployeeEvaluatorRelation());
        this.evaluatedSkill.updateSkill(eESkillRelationDto.getSkill());
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Long getskillClasification() {
        return skillClasification;
    }

    public void setskillClasification(Long skillClasification) {
        this.skillClasification = skillClasification;
    }

    public Long getversion() {
        return version;
    }

    public void setversion(Long version) {
        this.version = version;
    }

    public EmployeeEvaluatorRelation getemployeeEvaluatorRelation() {
        return employeeEvaluatorRelation;
    }

    public void setemployeeEvaluatorRelation(EmployeeEvaluatorRelation employeeEvaluatorRelation) {
        this.employeeEvaluatorRelation = employeeEvaluatorRelation;
    }

    public Skill getevaluatedSkill() {
        return evaluatedSkill;
    }

    public void setevaluatedSkill(Skill evaluatedSkill) {
        this.evaluatedSkill = evaluatedSkill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EESkillRelation)) {
            return false;
        }
        EESkillRelation other = (EESkillRelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tareaws.model.EESkillRelation[ id=" + id + " ]";
    }

}
