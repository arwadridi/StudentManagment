package tn.esprit.studentmanagement.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.services.IDepartmentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class DepartmentControllerTest {

    @Mock
    private IDepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    public DepartmentControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDepartments() {
        // Arrange
        Department dep1 = new Department();
        dep1.setIdDepartment(1L);
        dep1.setName("Informatique");

        Department dep2 = new Department();
        dep2.setIdDepartment(2L);
        dep2.setName("Électrique");

        when(departmentService.getAllDepartments()).thenReturn(Arrays.asList(dep1, dep2));

        // Act
        List<Department> result = departmentController.getAllDepartment();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Informatique", result.get(0).getName());
        verify(departmentService, times(1)).getAllDepartments();
    }

    @Test
    void testCreateDepartment() {
        // Arrange
        Department dep = new Department();
        dep.setName("Mécanique");

        when(departmentService.saveDepartment(dep)).thenReturn(dep);

        // Act
        Department result = departmentController.createDepartment(dep);

        // Assert
        assertEquals("Mécanique", result.getName());
        verify(departmentService, times(1)).saveDepartment(dep);
    }
}
