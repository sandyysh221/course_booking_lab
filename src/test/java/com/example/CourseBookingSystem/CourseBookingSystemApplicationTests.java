package com.example.CourseBookingSystem;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createBookingThenSave() {
		Course intermediatePython = new Course("Intermediate Python", "Perth", 5);
		courseRepository.save(intermediatePython);

		Customer sandy = new Customer("Sandy", "Edinburgh", 30);
		customerRepository.save(sandy);

		Booking booking = new Booking("11-11-22", intermediatePython, sandy);
		bookingRepository.save(booking);
	}

	@Test
	public void canFindCourseByRating() {
		List<Course> foundCourses = courseRepository.findByRating(3);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canFindCustomerByCourse() {
		List<Customer> foundCustomer = customerRepository.findByBookingsCourseNameIgnoreCase("Intro to Java");
		assertEquals(2, foundCustomer.size());
	}

	@Test
	public void canFindCoursesByCustomerName() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerNameIgnoreCase("Chris");
		assertEquals(1, foundCourses.size());
		assertEquals("Intro to JavaScript", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("21-02-22");
		assertEquals(1, foundBookings.size());
		assertEquals("Intro to Ruby", foundBookings.get(0).getCourse().getName());
	}

	@Test
	public void canFindCustomerByTownAndCourseName() {
		List<Customer> foundCustomer = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Manchester", "Intro to Ruby");
		assertEquals(2, foundCustomer.size());
	}

	@Test
	public void canFindCustomerByTownAndCourseNameAndIfOverAge() {
		List<Customer> foundCustomer = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan("Manchester", "Intro to Ruby", 30);
		assertEquals(1, foundCustomer.size());
		assertEquals("Michael", foundCustomer.get(0).getName());
	}
}

