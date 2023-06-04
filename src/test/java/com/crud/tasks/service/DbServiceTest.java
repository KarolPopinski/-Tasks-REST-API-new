package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {
    @InjectMocks
    private DbService service;
    @Mock
    private TaskRepository taskRepository;

    @Test
    void testDbServiceGetAllTasks() {
        //Given
        Task task = new Task(1L, "Nazwa 1", "Zawartosc 1");
        List<Task> taskList = List.of(task);
        when(taskRepository.findAll()).thenReturn(taskList);
        //When
        List<Task> allTasks = service.getAllTasks();
        //Then
        assertEquals(1, allTasks.size());
    }
    @Test
    void testShouldFindTaskById() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Nazwa 1", "Zawartosc 1");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        //When
        Task taskById = service.getTask(1L);
        //Then
        assertEquals(taskById, task);
    }
    @Test
    void testShouldSaveTask() {
        //Given
        Task task = new Task(1L, "Nazwa 1", "Zawartosc 1");
        when(taskRepository.save(task)).thenReturn(task);
        //When
        Task task1 = service.saveTask(task);
        //Then
        assertEquals(task, task1);
    }
    @Test
    void testShouldDeleteTask() {
        //Given
        Task task = new Task(1L, "Nazwa 1", "Zawartosc 1");
        doNothing().when(taskRepository).deleteById(1L);
        //When
        service.deleteTask(1L);
        //Then
        verify(taskRepository, times(1)).deleteById(1L);
    }
}
