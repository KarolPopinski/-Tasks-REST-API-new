package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;
    @Mock
    private DbService service;
    @Mock
    private TaskMapper taskMapper;

    @Test
    void shouldCreateTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Nazwa 1", "Opis 1");
        Task task = new Task(1L, "Nazwa 1", "Opis 1");

        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(task)).thenReturn(task);
        //When
        ResponseEntity<Void> resultResponse = taskController.createTask(taskDto);
        //Then
        assertEquals(resultResponse, ResponseEntity.ok().build());
    }
    @Test
    void shouldDeleteTask() {
        //Given
        Task task1 = new Task(1L, "Nazwa 1", "Zawartosc 1");
        Task task2 = new Task(2L, "Nazwa 2", "Zawartosc 2");
        Task task3 = new Task(3L, "Nazwa 3", "Zawartosc 3");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
    }
    @Test
    void shouldUpdateTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Nazwa 1", "Opis 1");
        Task task = new Task(1L, "Nazwa 1", "Opis 1");

        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(service.saveTask(task)).thenReturn(task);
        //When
        ResponseEntity<TaskDto> resultTaskDto = taskController.updateTask(taskDto);
        //Then
        assertNotNull(resultTaskDto);
    }
    @Test
    void shouldFetchTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Nazwa 1", "Zawartosc 1");
        TaskDto taskDto = new TaskDto(1L, "Nazwa 1", "Zawartosc 1");

        when(service.getTask(task.getId())).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        ResponseEntity<TaskDto> resultTaskDto = taskController.getTask(task.getId());
        //Then
        assertNotNull(resultTaskDto);
    }

}
