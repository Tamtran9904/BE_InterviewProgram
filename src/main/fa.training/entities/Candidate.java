package fa.training.entities;


import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "candidate")
public class Candidate {

  @Id
//  @GeneratedValue(generator="myInc")
//  @GenericGenerator(name="myInc", strategy = "increment")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "full_name", nullable = false)
  private String name;
  @Column(name = "date_of_birth", nullable = false)
  private Date dateOfBirth;
  @Column(name = "gender")
//  @Pattern(regexp = "/^[01]?$/")
  private Integer gender;
  @Column(name = "graduation_year", nullable = false)
  private Date graduationYear;
  @Column(name = "phone", nullable = false, unique = true)
  private String phone;
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "skill")
  private String skill;
  @Column(name = "foreign_language")
  private String foreignLanguage;
  @Column(name = "level")
  @Range(min = 1, max = 7)
  private Integer level;
  @Column(name = "cv")
  private String cv;
  @Column(name = "allocation_status")
  private Integer AllocationStatus;
  @Column(name = "remark")
  private String remark;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCandidate")
  private List<EntryTest> listEntryTest;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCandidate")
  private List<Interview> listInterview;

  public Candidate(String name, Date dateOfBirth, Integer gender, Date graduationYear,
      String phone, String email, String skill, String foreignLanguage, Integer level, String cv,
      Integer allocationStatus, String remark) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.graduationYear = graduationYear;
    this.phone = phone;
    this.email = email;
    this.skill = skill;
    this.foreignLanguage = foreignLanguage;
    this.level = level;
    this.cv = cv;
    AllocationStatus = allocationStatus;
    this.remark = remark;
  }

  public Candidate() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Date getGraduationYear() {
    return graduationYear;
  }

  public void setGraduationYear(Date graduationYear) {
    this.graduationYear = graduationYear;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  public String getForeignLanguage() {
    return foreignLanguage;
  }

  public void setForeignLanguage(String foreignLanguage) {
    this.foreignLanguage = foreignLanguage;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getCv() {
    return cv;
  }

  public void setCv(String cv) {
    this.cv = cv;
  }

  public Integer getAllocationStatus() {
    return AllocationStatus;
  }

  public void setAllocationStatus(Integer allocationStatus) {
    AllocationStatus = allocationStatus;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Candidate candidate = (Candidate) o;
    return Objects.equals(name, candidate.name) && Objects.equals(dateOfBirth,
        candidate.dateOfBirth) && Objects.equals(gender, candidate.gender)
        && Objects.equals(graduationYear, candidate.graduationYear)
        && Objects.equals(phone, candidate.phone) && Objects.equals(email,
        candidate.email) && Objects.equals(skill, candidate.skill)
        && Objects.equals(foreignLanguage, candidate.foreignLanguage)
        && Objects.equals(level, candidate.level) && Objects.equals(cv,
        candidate.cv) && Objects.equals(AllocationStatus, candidate.AllocationStatus)
        && Objects.equals(remark, candidate.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dateOfBirth, gender, graduationYear, phone, email, skill,
        foreignLanguage, level, cv, AllocationStatus, remark);
  }

  @Override
  public String toString() {
    return "Candidate{" +
        ", name='" + name + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", gender=" + gender +
        ", graduationYear=" + graduationYear +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", skill='" + skill + '\'' +
        ", foreignLanguage='" + foreignLanguage + '\'' +
        ", level=" + level +
        ", cv='" + cv + '\'' +
        ", AllocationStatus=" + AllocationStatus +
        ", remark='" + remark + '\'' +
        '}';
  }
}
