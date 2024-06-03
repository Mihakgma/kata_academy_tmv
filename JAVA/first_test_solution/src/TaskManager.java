//import jdk.incubator.vector.VectorOperators;

import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;

public class TaskManager {
    protected Task[] tasks;
    TaskManager() {
        tasks = new Task[0];
    }

    private void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public Task[] getTasks() {
        return tasks;
    }
    /*
    * Adds new task to tasks field (Task[] array)
    * */
    public void addTask(Task newTask) {
        if (taskCreatedBefore(newTask)) {
            print("Задача с наименованием: <" + newTask.getName() + "> и описанием: <" + newTask.getDescription() +
                  "> была создана ранее.");
            print("Пожалуйста, попробуйте изменить наименование и / или ее описание, а затем повторить ввод.");
            print("Благодарю за понимание!");
            return;
        }
        int tasksNumber = getTasks().length;
        Task[] tempTasks = new Task[tasksNumber + 1];
        tempTasks[tasksNumber] = newTask;
        setTasks(tempTasks);
    }
    public void removeTask(String name) {
        if (taskCreatedBefore(name)) {
            print("Удаление задачи с именем <" + name + "> инициализируется ...");
//            ArrayList<Task> tmpArray = new ArrayList.(getTasks());
//            Task[] tempArray = new Task[getTasks().length];
//            for (int i = 0; i < getTasks().length; i++) {
//
//            }
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
        boolean elementFound = false;
        for (Task t: tasksCreated) {
            if (t.getName() == name) {
                elementFound = true;
                break;
            }
        }
        if (elementFound == false){
            print("Задачи с введенным названием не найдено!");
        }
        return elementFound;
    }
    static void print(Object obj) {
        System.out.println(obj);
    }
}
