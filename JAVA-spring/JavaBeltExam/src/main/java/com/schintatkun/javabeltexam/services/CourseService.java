package com.schintatkun.javabeltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.schintatkun.javabeltexam.models.Course;
import com.schintatkun.javabeltexam.repositories.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepo;
	
	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	//find all
	public List<Course> findAllCourses(){
		return courseRepo.findAll();
	}
	
	//find by id
	
	public Course findCourseById(Long id) {
		Optional<Course> myCourse = courseRepo.findById(id);
		if(myCourse.isPresent()) {
			return myCourse.get();
		}else {
			return null;
		}
	}
	
	//create course
	public Course createCourse(Course myCourse) {
		return courseRepo.save(myCourse);
	}
	//update course
	public void updateCourse(Course myCourse) {
		courseRepo.save(myCourse);
	}
	//delete course
	public void deleteCourse(Course course) {
		courseRepo.delete(course);
	}
	//high to low
//	public List<Course> findHighLow(){
//		return courseRepo.findAllHighToLow();
//	}
}
