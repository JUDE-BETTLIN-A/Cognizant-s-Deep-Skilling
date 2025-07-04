package org.example.employee_management.repository;

import org.example.employee_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query methods
    Optional<Department> findByName(String name);

    List<Department> findByNameContainingIgnoreCase(String name);

    List<Department> findByLocation(String location);

    List<Department> findByLocationContainingIgnoreCase(String location);

    List<Department> findByBudgetGreaterThan(Double budget);

    List<Department> findByBudgetBetween(Double minBudget, Double maxBudget);

    List<Department> findByNameStartingWithIgnoreCase(String prefix);

    List<Department> findByNameEndingWithIgnoreCase(String suffix);

    // Custom query methods
    @Query("SELECT d FROM Department d WHERE d.budget > :minBudget AND d.location = :location")
    List<Department> findByBudgetGreaterThanAndLocation(@Param("minBudget") Double minBudget,
                                                        @Param("location") String location);

    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.employees WHERE d.id = :id")
    Optional<Department> findByIdWithEmployees(@Param("id") Long id);

    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :count")
    List<Department> findDepartmentsWithMoreThanXEmployees(@Param("count") int count);

    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) = 0")
    List<Department> findDepartmentsWithNoEmployees();

    // Native query example
    @Query(value = "SELECT * FROM departments WHERE budget > ?1 ORDER BY budget DESC",
            nativeQuery = true)
    List<Department> findDepartmentsByBudgetGreaterThanOrderByBudgetDesc(Double budget);

    // Count methods
    long countByLocation(String location);

    long countByBudgetGreaterThan(Double budget);

    // Exists methods
    boolean existsByName(String name);

    boolean existsByLocation(String location);
}