package ru.netology.inherit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchWithQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        String query = new String("Позвонить");

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchWithQueryInMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        String query = new String("Приложение НетоБанка");

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchWithQueryInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        String query = new String("Яйца");

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchWithInvalidQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        String query = new String("Молоко");

        boolean expected = false;
        Task[] actual = todos.search(query);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchWithInvalidInMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        String query = new String("Позвонить родителям");

        boolean expected = false;
        Task[] actual = todos.search(query);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchWithInvalidInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        String query = new String("Во вторник после обеда");

        boolean expected = false;
        Task[] actual = todos.search(query);
        Assertions.assertNotEquals(expected, actual);
    }

}