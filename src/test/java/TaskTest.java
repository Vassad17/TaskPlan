import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.plan.*;

public class TaskTest {
    @Test
    public void ShouldSimpleTaskMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(1, "Забрать ребенка из сада");
        boolean expected = true;
        boolean actual = simpleTask.matches("Забрать");
        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void ShouldSimpleTaskMatchesFalse() {
        SimpleTask simpleTask = new SimpleTask(1, "Забрать ребенка из сада");
        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void ShouldEpisTaskMatchesTrue() {
        String[] subtasks = {"Забрать ребенка из сада", "Купить продукты", "Договриться о встрече с друзьями"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("ребенка");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldEpisTaskMatchesNoneQauery() {
        String[] subtasks = {"Забрать ребенка из сада", "Купить продукты", "Договриться о встрече с друзьями"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldEpisTaskMatchesFalse() {
        String[] subtasks = {"Забрать ребенка из сада", "Купить продукты", "Договриться о встрече с друзьями"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("велосипед");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldEpisTaskMatchesNoneQuaery() {
        String[] subtasks = {"Забрать ребенка из сада", "Купить продукты", "Договриться о встрече с друзьями"};
        Epic epic = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldMeetingTaskMatchesTrueContains() {
        Meeting meeting = new Meeting(3, "Сделать ДЗ в Нетологии", "Java", "26.10.2024");

        boolean expected = true;
        boolean actual = meeting.matches("Java");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldMeetingTaskMatchesTrueProject() {
        Meeting meeting = new Meeting(3, "Сделать ДЗ в Нетологии", "Java", "26.10.2024");

        boolean expected = true;
        boolean actual = meeting.matches("Сделать ДЗ в Нетологии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldMeetingTaskMatchesFalse() {
        Meeting meeting = new Meeting(3, "Сделать ДЗ в Нетологии", "Java", "26.10.2024");

        boolean expected = false;
        boolean actual = meeting.matches("Посмотреть фильм");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldMeetingTaskMatchesNoneQuaery() {
        Meeting meeting = new Meeting(3, "Сделать ДЗ в Нетологии", "Java", "26.10.2024");

        boolean expected = true;
        boolean actual = meeting.matches("");

        Assertions.assertEquals(expected, actual);
    }

}
