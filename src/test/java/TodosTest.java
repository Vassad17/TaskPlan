import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import ru.netology.plan.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subTask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subTask);

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
    public void testSearchFindsMatchingTasks() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Совещание по проекту", "Приложение", "В понедельник");

        Todos todos = new Todos();
        todos.add(task);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Купить");
        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchFindsNoMatchingTasks() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        String[] subtasks = {"Купить молоко", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Совещание по проекту", "Приложение", "В понедельник");

        Todos todos = new Todos();
        todos.add(task);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Отчёт");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testAllGet() {
        Task task = new Task(5);
        SimpleTask simpleTask = new SimpleTask(6, "Забрать ребенка из сада");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Домашнее задание в Нетологии",
                "Java",
                "26.10.2024"
        );

        Assertions.assertEquals("Забрать ребенка из сада", simpleTask.getTitle());
        Assertions.assertEquals(5, task.getId());
        Assertions.assertEquals(subtasks, epic.getSubTask());
        Assertions.assertEquals("Домашнее задание в Нетологии", meeting.getTopic());
        Assertions.assertEquals("Java", meeting.getProject());
        Assertions.assertEquals("26.10.2024", meeting.getStart());

    }

    @Test
    public void test() {
        Task task = new Task(2);

        Assertions.assertEquals(false, task.matches("2"));

    }

}







