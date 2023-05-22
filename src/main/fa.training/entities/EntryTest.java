package fa.training.entities;


import fa.training.Enum.ResultStatus;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "entry_test")
public class EntryTest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "time")
  private String time;
  @Column(name = "date")
  private Date date;
  @Column(name = "language_valuator")
  private String languageValuator;
  @Column(name = "language_result")
  @Range(min = 0, max = 10)
  private Double languageResult;
  @Column(name = "technical_valuator")
  private String technicalValuator;
  @Column(name = "technical_result")
  @Range(min = 0, max = 10)
  private Double technicalResult;
  @Column(name = "result")
  @Enumerated(EnumType.STRING)
  private ResultStatus result;
  @Column(name = "remark")
  private String remark;
  @Column(name = "entry_test_skill")
  private String entryTestSkill;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "candidate_id", referencedColumnName = "id")
  private Candidate idCandidate;

  public EntryTest(String time, Date date, String languageValuator, Double languageResult,
      String technicalValuator, Double technicalResult, ResultStatus result, String remark, String entryTestSkill,
      Candidate idCandidate) {
    this.time = time;
    this.date = date;
    this.languageValuator = languageValuator;
    this.languageResult = languageResult;
    this.technicalValuator = technicalValuator;
    this.technicalResult = technicalResult;
    this.result = result;
    this.remark = remark;
    this.entryTestSkill = entryTestSkill;
    this.idCandidate = idCandidate;
  }

  public EntryTest() {

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getLanguageValuator() {
    return languageValuator;
  }

  public void setLanguageValuator(String languageValuator) {
    this.languageValuator = languageValuator;
  }

  public Double getLanguageResult() {
    return languageResult;
  }

  public void setLanguageResult(Double languageResult) {
    this.languageResult = languageResult;
  }

  public String getTechnicalValuator() {
    return technicalValuator;
  }

  public void setTechnicalValuator(String technicalValuator) {
    this.technicalValuator = technicalValuator;
  }

  public Double getTechnicalResult() {
    return technicalResult;
  }

  public void setTechnicalResult(Double technicalResult) {
    this.technicalResult = technicalResult;
  }

  public ResultStatus getResult() {
    return result;
  }

  public void setResult(ResultStatus result) {
    this.result = result;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getEntryTestSkill() {
    return entryTestSkill;
  }

  public void setEntryTestSkill(String entryTestSkill) {
    this.entryTestSkill = entryTestSkill;
  }

  public Candidate getIdCandidate() {
    return this.idCandidate;
  }

  public void setIdCandidate(Candidate idCandidate) {
    this.idCandidate = idCandidate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntryTest entryTest = (EntryTest) o;
    return Objects.equals(time, entryTest.time) && Objects.equals(date,
        entryTest.date) && Objects.equals(languageValuator, entryTest.languageValuator)
        && Objects.equals(languageResult, entryTest.languageResult)
        && Objects.equals(technicalValuator, entryTest.technicalValuator)
        && Objects.equals(technicalResult, entryTest.technicalResult)
        && result == entryTest.result && Objects.equals(remark, entryTest.remark)
        && Objects.equals(entryTestSkill, entryTest.entryTestSkill);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, date, languageValuator, languageResult, technicalValuator,
        technicalResult, result, remark, entryTestSkill);
  }

  @Override
  public String toString() {
    return "EntryTest{" +
        "time='" + time + '\'' +
        ", date=" + date +
        ", languageValuator='" + languageValuator + '\'' +
        ", languageResult=" + languageResult +
        ", technicalValuator='" + technicalValuator + '\'' +
        ", technicalResult=" + technicalResult +
        ", result=" + result +
        ", remark='" + remark + '\'' +
        ", entryTestSkill='" + entryTestSkill + '\'' +
        ", idCandidate=" + idCandidate +
        '}';
  }
}
