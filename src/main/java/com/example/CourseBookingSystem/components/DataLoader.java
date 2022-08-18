package com.example.CourseBookingSystem.components;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course course1 = new Course("Intro to Python", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Intro to JavaScript", "Glasgow", 5);
        courseRepository.save(course2);

        Course course3 = new Course("Intro to Java", "Remote", 5);
        courseRepository.save(course3);

        Course course4 = new Course("Intro to React", "Newcastle", 5);
        courseRepository.save(course4);

        Course course5 = new Course("Intro to Ruby", "Manchester", 5);
        courseRepository.save(course5);

        Customer customer1 = new Customer("Sandy", "Edinburgh", 30);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Chris", "Glasgow", 32);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Clare", "Stiring", 30);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("James", "Newcastle", 36);
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Michael", "Manchester", 38);
        customerRepository.save(customer5);

        Booking booking1 = new Booking("18-08-22", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("10-08-22", course2, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("07-07-22", course3, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("04-03-2022", course4, customer4);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("21-02-22", course5, customer5);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("19-06-22", course2, customer1);
        bookingRepository.save(booking6);
    }
}
