package entities;

import entities.Embeddable.Name;
import primitives.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Student implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Name name;
	private String email;
	private Gender gender;
	private BigDecimal gpa;
	@ManyToMany
	@JoinTable(name = "course_like", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> likedCourses;
	@OneToMany(mappedBy = "student")
	private Set<CourseRating> ratings;
	@OneToMany(mappedBy = "student")
	private Set<CourseRegistration> registrations;

	public Set<CourseRegistration> getRegistrations()
	{
		return registrations;
	}

	public void setRegistrations(Set<CourseRegistration> registrations)
	{
		this.registrations = registrations;
	}

	public Set<CourseRating> getRatings()
	{
		return ratings;
	}

	public void setRatings(Set<CourseRating> ratings)
	{
		this.ratings = ratings;
	}

	public Set<Course> getLikedCourses()
	{
		return likedCourses;
	}

	public void setLikedCourses(Set<Course> likedCourses)
	{
		this.likedCourses = likedCourses;
	}

	public BigDecimal getGpa()
	{
		return gpa;
	}

	public void setGpa(BigDecimal gpa)
	{
		this.gpa = gpa;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Name getName()
	{
		return name;
	}

	public void setName(Name name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

}
