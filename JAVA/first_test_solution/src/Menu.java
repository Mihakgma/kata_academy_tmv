import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void start() {
        int answer = 0;
        TaskManager taskManager = new TaskManager();
        Scanner console = new Scanner(System.in);
        while (answer != 4) {
            print("1. Создать задачу");
            print("2. Удалить задачу");
            print("3. Посмотреть все задачи");
            print("4. Выход");
            try {
                answer = console.nextInt();
            } catch (InputMismatchException e){
                print(e);
                console.nextLine();
                answer = 0;
            }
            switch (answer) {
                case 1: addTask(taskManager);
                    break;
                case 2: removeTask(taskManager);
                    break;
                case 3: taskManager.viewTasks();
                    break;
                case 4: print("Выполнение программы завершено");
                    break;
                default: print("Пожалуйста, внимательно ознакомьтесь с условиями ввода!");
            }
        }
        console = null;
        taskManager = null;
    }
    void addTask(TaskManager taskManager) {
        Scanner scanner = new Scanner(System.in);
        print("Введите имя задачи:");
        String name = scanner.nextLine();
        print("Введите описание задачи:");
        String description = scanner.nextLine();
        taskManager.addTask(new Task(name, description));
    }
    void removeTask(TaskManager taskManager) {
        Scanner scanner = new Scanner(System.in);
        print("Введите имя задачи, которую вы хотите удалить:");
        String name = scanner.nextLine();
        taskManager.removeTask(name);
    }
    static void print(Object obj) {
        System.out.println(obj);
    }
}
