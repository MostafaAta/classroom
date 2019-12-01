package classroom.dal.entities.Embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseRatingKey implements Serializable
{
	@Column(name = "student_id", unique = true)
	private Long studentId;
	@Column(name = "course_id", unique = true)
	private Long courseId;

	public CourseRatingKey()
	{
	}

	public CourseRatingKey(Long studentId, Long courseId)
	{
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public Long getStudentId()
	{
		return studentId;
	}

	public void setStudentId(Long studentId)
	{
		this.studentId = studentId;
	}

	public Long getCourseId()
	{
		return courseId;
	}

	public void setCourseId(Long courseId)
	{
		this.courseId = courseId;
	}
}
