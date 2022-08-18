package com.example.CourseBookingSystem.repositories;

import com.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByTownAndBookingsCourseName(String town, String course);

    List<Customer> findByTownAndBookingsCourseNameAndAgeGreaterThan(String town, String course, Integer age);
}
