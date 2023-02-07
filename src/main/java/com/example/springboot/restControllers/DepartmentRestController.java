package com.example.springboot.restControllers;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


// Hey, Spring, this class has methods which should become REST endpoints. Please do the the right thing.
@RestController
public class DepartmentRestController {
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Inconsistent ID")
    private static class InconsistentIDException extends RuntimeException {
    }

    private final DepartmentRepository departmentRepository;

    // Hey, I'm the constructor of this class. When you call me, please give me any isntance of a
    // DepartmentRepository you've create along the way.
    public DepartmentRestController(@Autowired DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Hey Spring, if someome does an HTTP GET against /departments, please run this method.
    // And Spring, I know if I give you a stream of Department objects, you'll convert it to JSON for me.
    // curl -v http://localhost:8080/departments.
    @GetMapping(value = "/departments")
    public Iterable<Department> departments() {
        return departmentRepository.findAll();
    }

    // curl -v http://localhost:8080/departments/d008
    @GetMapping(value = "/departments/{department_id}")
    public Optional<Department> getDeptById(@PathVariable String department_id) {
        return departmentRepository.findById(department_id);
    }

    public Optional<Integer> betterFromString(final String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (final Exception e) {
            return Optional.empty();
        }
    }

    // curl -v http://localhost:8080/departments/d009 -H 'Content-Type: application/json' -d '{"id":"d008","deptName":"Research and Development"}'

    // This method updates data so it's dangerous. But it should *never* know about checking passwords.
    // Instead, it should know about an interface exposing methods like .isAllowed()
    @PostMapping(value = "/departments/{department_id}")
    public Department getDeptById(@RequestBody Department newDepartmentEntity,
                                  @PathVariable String department_id) {
        final String entityID = newDepartmentEntity.getId();
        if (entityID != null && !entityID.equals(department_id))
            throw new InconsistentIDException();

        final Optional<Department> fromDatabase = departmentRepository.findById(department_id);

        return fromDatabase
                // What do to if the Optional contains an entity
                .map((entity) -> {
                    entity.setDeptName(newDepartmentEntity.getDeptName());
                    return departmentRepository.save(entity);
                })
                // What to do if the Optional doesn't contain an entity.
                .orElseGet(() -> {
                    newDepartmentEntity.setId(department_id);
                    return departmentRepository.save(newDepartmentEntity);
                });
    }
}
