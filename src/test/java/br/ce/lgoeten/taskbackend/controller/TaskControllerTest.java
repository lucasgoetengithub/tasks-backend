package br.ce.lgoeten.taskbackend.controller;


import br.ce.lgoeten.taskbackend.model.Task;
import br.ce.lgoeten.taskbackend.repo.TaskRepo;
import br.ce.lgoeten.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @Mock
    private TaskRepo todoRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveTaskWithoutDescription() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithoutDate() {
        Task todo = new Task();
        todo.setTask("Description");
        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithPastDate() {
        Task todo = new Task();
        todo.setTask("Description");
        todo.setDueDate(LocalDate.of(2010,01,01));
        try {
            taskController.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void shouldSaveTaskWithSuccess() throws ValidationException {
        Task todo = new Task();
        todo.setTask("Description");
        todo.setDueDate(LocalDate.now());
        taskController.save(todo);
    }

}
