package classroom.dal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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

	@Override
	public String toString()
	{
		return "Course{" + "id=" + id + ", name1='" + name + '\'' + ", isPreRequest=" + isPreRequest + ", instructor=" + instructor + '}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Course course = (Course) o;
		return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(isPreRequest, course.isPreRequest) && Objects
				.equals(instructor, course.instructor);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, isPreRequest, instructor);
	}
}
