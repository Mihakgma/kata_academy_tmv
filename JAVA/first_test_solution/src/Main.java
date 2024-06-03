public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Кодекс самурая", "Есть только путь...");
        TaskManager taskManager = new TaskManager(task1);
//        taskManager.addTask(task1);
        taskManager.addTask(task1);
        taskManager.addTask(new Task());
        taskManager.addTask(new Task("имя задачи", "описание задачи"));
        taskManager.viewTasks();
        taskManager.removeTask("na");
        taskManager.removeTask("имя задачи");
        taskManager.viewTasks();
        Menu menu = new Menu();
        menu.start();
    }

    static void print(Object obj) {
        System.out.println(obj);
    }
}
