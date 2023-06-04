package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Zadanie 1", "Zawartosc 1");
        //When
        Task resulTask = taskMapper.mapToTask(taskDto);
        //Then
        assertNotNull(taskDto);
        assertEquals(1L, resulTask.getId());
        assertEquals("Zadanie 1", resulTask.getTitle());
        assertEquals("Zawartosc 1", resulTask.getContent());
    }
    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Zadanie 1", "Zawartosc 1");
        //When
        TaskDto resultTaskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertNotNull(task);
        assertEquals(1L, resultTaskDto.getId());
        assertEquals("Zadanie 1", resultTaskDto.getTitle());
        assertEquals("Zawartosc 1", resultTaskDto.getContent());
    }
    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "Zadanie 1", "Zawartosc 1");
        Task task2 = new Task(2L, "Zadanie 2", "Zawartosc 2");
        Task task3 = new Task(3L, "Zadanie 3", "Zawartosc 3");
        Task task4 = new Task(4L, "Zadanie 4", "Zawartosc 4");
        Task task5 = new Task(5L, "Zadanie 5", "Zawartosc 5");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);
        //When
        List<TaskDto> resultTasksDto = taskMapper.mapToTaskDtoList(taskList);
        //Then
        TaskDto resultTaskDto1 = resultTasksDto.get(0);
        TaskDto resultTaskDto2 = resultTasksDto.get(1);
        TaskDto resultTaskDto3 = resultTasksDto.get(2);
        TaskDto resultTaskDto4 = resultTasksDto.get(3);
        TaskDto resultTaskDto5 = resultTasksDto.get(4);

        assertEquals(5, resultTasksDto.size());

        assertNotNull(resultTaskDto1);
        assertEquals(1L, resultTaskDto1.getId());
        assertEquals("Zadanie 1", resultTaskDto1.getTitle());
        assertEquals("Zawartosc 1", resultTaskDto1.getContent());

        assertNotNull(resultTaskDto2);
        assertEquals(2L, resultTaskDto2.getId());
        assertEquals("Zadanie 2", resultTaskDto2.getTitle());
        assertEquals("Zawartosc 2", resultTaskDto2.getContent());

        assertNotNull(resultTaskDto3);
        assertEquals(3L, resultTaskDto3.getId());
        assertEquals("Zadanie 3", resultTaskDto3.getTitle());
        assertEquals("Zawartosc 3", resultTaskDto3.getContent());

        assertNotNull(resultTaskDto4);
        assertEquals(4L, resultTaskDto4.getId());
        assertEquals("Zadanie 4", resultTaskDto4.getTitle());
        assertEquals("Zawartosc 4", resultTaskDto4.getContent());

        assertNotNull(resultTaskDto5);
        assertEquals(5L, resultTaskDto5.getId());
        assertEquals("Zadanie 5", resultTaskDto5.getTitle());
        assertEquals("Zawartosc 5", resultTaskDto5.getContent());
    }
}