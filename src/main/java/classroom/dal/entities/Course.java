package classroom.dal.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Course extends BaseEntity implements Serializable
{
	private String name;
	private Boolean isPreRequest;
	private String code;
	@ManyToOne
	private Instructor instructor;
	@ManyToMany(mappedBy = "likedCourses")
	private Set<Student> likes;
	@OneToMany(mappedBy = "course")
	private Set<CourseRating> ratings;
	@OneToMany(mappedBy = "course")
	private Set<CourseRegistration> registrations;

	public Course()
	{

	}

	public Course(Long id)
	{
		this.setId(id);
	}

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

	public Set<Student> getLikes()
	{
		return likes;
	}

	public void setLikes(Set<Student> likes)
	{
		this.likes = likes;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name1)
	{
		this.name = name1;
	}

	public Boolean getPreRequest()
	{
		return isPreRequest;
	}

	public void setPreRequest(Boolean preRequest)
	{
		isPreRequest = preRequest;
	}

	public Instructor getInstructor()
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}
}
