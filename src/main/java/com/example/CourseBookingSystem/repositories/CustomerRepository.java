package com.example.CourseBookingSystem.repositories;

import com.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String course);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(String town, String course, Integer age);
}
