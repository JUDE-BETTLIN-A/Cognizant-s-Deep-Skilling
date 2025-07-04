package org.example.employee_management.repository;

import org.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Basic derived query methods
    Optional<Employee> findByEmail(String email);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    // Job title related queries
    List<Employee> findByJobTitle(String jobTitle);

    List<Employee> findByJobTitleContainingIgnoreCase(String jobTitle);

    List<Employee> findByJobTitleStartingWithIgnoreCase(String prefix);

    // Salary related queries
    List<Employee> findBySalary(BigDecimal salary);

    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    List<Employee> findBySalaryLessThan(BigDecimal salary);

    List<Employee> findBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary);

    // Hire date related queries
    List<Employee> findByHireDate(LocalDate hireDate);

    List<Employee> findByHireDateAfter(LocalDate date);

    List<Employee> findByHireDateBefore(LocalDate date);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Active status queries
    List<Employee> findByIsActive(Boolean isActive);

    List<Employee> findByIsActiveTrue();

    List<Employee> findByIsActiveFalse();

    // Department related queries
    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByDepartmentNameContainingIgnoreCase(String departmentName);

    // Complex derived queries
    List<Employee> findByIsActiveTrueAndSalaryGreaterThan(BigDecimal salary);

    List<Employee> findByDepartmentIdAndIsActiveTrue(Long departmentId);

    List<Employee> findByJobTitleAndSalaryGreaterThan(String jobTitle, BigDecimal salary);

    // Custom JPQL queries
    @Query("SELECT e FROM Employee e WHERE e.salary > :minSalary AND e.department.name = :departmentName")
    List<Employee> findByMinSalaryAndDepartmentName(@Param("minSalary") BigDecimal minSalary,
                                                    @Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department WHERE e.id = :id")
    Optional<Employee> findByIdWithDepartment(@Param("id") Long id);

    @Query("SELECT e FROM Employee e WHERE e.hireDate >= :startDate AND e.hireDate <= :endDate ORDER BY e.hireDate DESC")
    List<Employee> findEmployeesHiredBetweenDates(@Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> searchEmployees(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId ORDER BY e.salary DESC")
    List<Employee> findByDepartmentIdOrderBySalaryDesc(@Param("departmentId") Long departmentId);

    // Statistical queries
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :departmentId")
    BigDecimal findAverageSalaryByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT MAX(e.salary) FROM Employee e WHERE e.department.id = :departmentId")
    BigDecimal findMaxSalaryByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT MIN(e.salary) FROM Employee e WHERE e.department.id = :departmentId")
    BigDecimal findMinSalaryByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.department.id = :departmentId AND e.isActive = true")
    long countActiveEmployeesByDepartmentId(@Param("departmentId") Long departmentId);

    // Native query examples
    @Query(value = "SELECT * FROM employees WHERE salary > ?1 ORDER BY salary DESC LIMIT ?2",
            nativeQuery = true)
    List<Employee> findTopEmployeesBySalary(BigDecimal minSalary, int limit);

    @Query(value = "SELECT * FROM employees WHERE hire_date >= ?1 ORDER BY hire_date DESC",
            nativeQuery = true)
    List<Employee> findRecentHires(LocalDate sinceDate);

    // Count methods
    long countByDepartmentId(Long departmentId);

    long countByIsActiveTrue();

    long countByJobTitle(String jobTitle);

    long countBySalaryGreaterThan(BigDecimal salary);

    // Exists methods
    boolean existsByEmail(String email);

    boolean existsByDepartmentId(Long departmentId);

    boolean existsByJobTitle(String jobTitle);

    // Delete methods
    void deleteByIsActiveFalse();

    void deleteByDepartmentId(Long departmentId);

    // Ordering methods
    List<Employee> findByDepartmentIdOrderByHireDateDesc(Long departmentId);

    List<Employee> findByJobTitleOrderBySalaryDesc(String jobTitle);

    List<Employee> findByIsActiveTrueOrderByLastNameAscFirstNameAsc();
}