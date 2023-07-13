package ru.netology.inherit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {

    @Test
    public void ShouldTestSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(1, "Индивидуальный тест на SimpleTask");
        String query = new String("Индивидуальный тест на SimpleTask");

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldTestSimpleTaskMatchesNegative() {
        SimpleTask simpleTask = new SimpleTask(1, "Индивидуальный тест на SimpleTask");
        String query = new String("Негативный тест на SimpleTask");

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldTestMeetingMatches() {
        Meeting meeting = new Meeting(
                111,
                "Индивидуальный тест на Meeting",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = new String("Индивидуальный тест на Meeting");

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldTestMeetingMatchesNegative() {
        Meeting meeting = new Meeting(
                111,
                "Индивидуальный тест на Meeting",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = new String("Негативный тест на Meeting");

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldTestEpicMatches() {
        String[] subtasks = {"Молоко", "Индивидуальный тест на Epic", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = new String("Индивидуальный тест на Epic");

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldTestEpicMatchesNegative() {
        String[] subtasks = {"Молоко", "Индивидуальный тест на Epic", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = new String("Негативный тест на Epic");

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

}
