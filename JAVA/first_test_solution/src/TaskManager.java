import java.util.Arrays;
import java.util.List;

public class TaskManager {
    protected Task[] tasks;
    TaskManager() {
        tasks = new Task[] {};
    }
    TaskManager(Task task) {
        if (getTasks() == null) {
            setTasks(new Task[0]);
        }
//        this();
        addTask(task);
    }

    private void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public Task[] getTasks() {
        return this.tasks;
    }
    /*
    * Adds new task to tasks field (Task[] array)
    * */
    public void addTask(Task newTask) {
        if (getTasks().length > 0 && taskCreatedBefore(newTask)) {
            print("Задача с наименованием: <" + newTask.getName() + "> и описанием: <" + newTask.getDescription() +
                  "> была создана ранее.");
            print("Пожалуйста, попробуйте изменить наименование и / или ее описание, а затем повторить ввод.");
            print("Благодарю за понимание!");
            return;
        }
        int tasksNumber = getTasks().length;
//        Task[] tempTasks = new Task[tasksNumber + 1];
        Task[] tempTasks = Arrays.copyOf(getTasks(), tasksNumber + 1);
        tempTasks[tasksNumber] = newTask;
        setTasks(tempTasks);
    }
    public void removeTask(String name) {
        if (taskCreatedBefore(name)) {
            print("Удаление задачи с именем <" + name + "> инициализируется ...");
            int counter = 0;
            for (Task task: getTasks()) {
                if (task.getName() == name) {
                    counter = counter + 1;
                }
            }
            Task[] tmpArray = new Task[getTasks().length-counter];
            int j = 0;
            for (Task t: getTasks()) {
                if (t.getName() != name) {
                    tmpArray[j] = t;
                    j++;
                }
            }
            setTasks(tmpArray);
        }
    }
    public void viewTasks() {
        print(Arrays.toString(getTasks()));
    }
    protected boolean taskCreatedBefore(Task taskToCheck) {
        return Arrays.asList(getTasks()).contains(taskToCheck);
    }
    protected boolean taskCreatedBefore(String name) {
        List<Task> tasksCreated = Arrays.asList(getTasks());
        boolean elementFound = tasksCreated.contains(new Task(name, ""));
        if (!elementFound) {
            print("Задачи с введенным названием не найдено!");
        }
        return elementFound;
    }
    static void print(Object obj) {
        System.out.println(obj);
    }
}
