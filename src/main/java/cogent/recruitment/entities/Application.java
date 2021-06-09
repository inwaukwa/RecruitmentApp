package cogent.recruitment.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "application")
public class Application implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(name = "date_of_application")
	private LocalDate dateCreated;
	
	@NotBlank
	@Column(name = "citizen")
	private boolean isUSCitizen;
	
	@Column(name = "location")
	private String location;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "visa_status")
	private String visaStatus;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "degree")
	private String degree;
	
	@NotBlank
	@Column(name = "core_java")
	private int coreJavaRating;
	
	@NotBlank
	@Column(name = "advanced_java")
	private int advancedJavaRating;
	
	@NotBlank
	@Column(name = "oops")
	private int oopsRating;
	
	@NotBlank
	@Column(name = "exception_handling")
	private int exceptionHandlingRating;
	
	@NotBlank
	@Column(name = "multithreading")
	private int multithreadingRating;
	
	@NotBlank
	@Column(name = "collection_framework")
	private int collectionFrameworkRating;
	
	@NotBlank
	@Column(name = "jdbc")
	private int jdbcRating;
	
	@ManyToOne
	@JoinColumn(name = "applicant_id",referencedColumnName = "id")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name = "admin_id", referencedColumnName = "id")
	private Admin recruiter;
	
	@ManyToOne
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;
	
	public Application() {}

	public Application(LocalDate dateCreated, boolean isUSCitizen, String location, String visaStatus,String degree,
			int coreJavaRating,  int advancedJavaRating, int oopsRating, int exceptionHandlingRating,  int multithreadingRating,
			int collectionFrameworkRating, int jdbcRating, Applicant applicant, Admin recruiter, Job job) {
		
		this.dateCreated = dateCreated;
		this.isUSCitizen = isUSCitizen;
		this.location = location;
		this.visaStatus = visaStatus;
		this.degree = degree;
		this.coreJavaRating = coreJavaRating;
		this.advancedJavaRating = advancedJavaRating;
		this.oopsRating = oopsRating;
		this.exceptionHandlingRating = exceptionHandlingRating;
		this.multithreadingRating = multithreadingRating;
		this.collectionFrameworkRating = collectionFrameworkRating;
		this.jdbcRating = jdbcRating;
		this.applicant = applicant;
		this.recruiter = recruiter;
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Application [id=" + id + ", dateCreated=" + dateCreated + ", isUSCitizen=" + isUSCitizen + ", location="
				+ location + ", visaStatus=" + visaStatus + ", degree=" + degree + ", coreJavaRating=" + coreJavaRating
				+ ", advancedJavaRating=" + advancedJavaRating + ", oopsRating=" + oopsRating
				+ ", exceptionHandlingRating=" + exceptionHandlingRating + ", multithreadingRating="
				+ multithreadingRating + ", collectionFrameworkRating=" + collectionFrameworkRating + ", jdbcRating="
				+ jdbcRating + ", applicant=" + applicant + ", recruiter=" + recruiter + ", job=" + job + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isUSCitizen() {
		return isUSCitizen;
	}

	public void setUSCitizen(boolean isUSCitizen) {
		this.isUSCitizen = isUSCitizen;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getCoreJavaRating() {
		return coreJavaRating;
	}

	public void setCoreJavaRating(int coreJavaRating) {
		this.coreJavaRating = coreJavaRating;
	}

	public int getAdvancedJavaRating() {
		return advancedJavaRating;
	}

	public void setAdvancedJavaRating(int advancedJavaRating) {
		this.advancedJavaRating = advancedJavaRating;
	}

	public int getOopsRating() {
		return oopsRating;
	}

	public void setOopsRating(int oopsRating) {
		this.oopsRating = oopsRating;
	}

	public int getExceptionHandlingRating() {
		return exceptionHandlingRating;
	}

	public void setExceptionHandlingRating(int exceptionHandlingRating) {
		this.exceptionHandlingRating = exceptionHandlingRating;
	}

	public int getMultithreadingRating() {
		return multithreadingRating;
	}

	public void setMultithreadingRating(int multithreadingRating) {
		this.multithreadingRating = multithreadingRating;
	}

	public int getCollectionFrameworkRating() {
		return collectionFrameworkRating;
	}

	public void setCollectionFrameworkRating(int collectionFrameworkRating) {
		this.collectionFrameworkRating = collectionFrameworkRating;
	}

	public int getJdbcRating() {
		return jdbcRating;
	}

	public void setJdbcRating(int jdbcRating) {
		this.jdbcRating = jdbcRating;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Admin getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Admin recruiter) {
		this.recruiter = recruiter;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
		
}
