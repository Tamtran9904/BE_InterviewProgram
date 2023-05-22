package fa.training.entities;


import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interview")
public class Interview {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "time")
  private String time;
  @Column(name = "date")
  private Date date;
  @Column(name = "interviewer")
  private String interviewer;
  @Column(name = "comments")
  private String comments;
  @Column(name = "interview_result")
  private String interviewResult;
  @Column(name = "remark")
  private String remark;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "candidate_id", referencedColumnName = "id")
  private Candidate idCandidate;

  public Interview(String time, Date date, String interviewer, String comments,
      String interviewResult, String remark, Candidate idCandidate) {
    this.time = time;
    this.date = date;
    this.interviewer = interviewer;
    this.comments = comments;
    this.interviewResult = interviewResult;
    this.remark = remark;
    this.idCandidate = idCandidate;
  }

  public Interview() {

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

  public String getInterviewer() {
    return interviewer;
  }

  public void setInterviewer(String interviewer) {
    this.interviewer = interviewer;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getInterviewResult() {
    return interviewResult;
  }

  public void setInterviewResult(String interviewResult) {
    this.interviewResult = interviewResult;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Candidate getIdCandidate() {
    return idCandidate;
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
    Interview interview = (Interview) o;
    return Objects.equals(time, interview.time) && Objects.equals(date,
        interview.date) && Objects.equals(interviewer, interview.interviewer)
        && Objects.equals(comments, interview.comments) && Objects.equals(
        interviewResult, interview.interviewResult) && Objects.equals(remark,
        interview.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, date, interviewer, comments, interviewResult, remark);
  }
}
