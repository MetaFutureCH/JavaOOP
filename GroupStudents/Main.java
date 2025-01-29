package sample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем группу
        Group group = new Group("Java Developers");

        // Создаем объект для создания студентов через ввод с клавиатуры
        StudentCreator creator = new StudentCreator();

        // Добавляем 7 студентов заранее
        try {
            group.addStudent(new Student("Student1", "Fam1", Gender.MALE, 1, "Group1"));
            group.addStudent(new Student("Student2", "Fam2", Gender.FEMALE, 2, "Group1"));
            group.addStudent(new Student("Student3", "Fam3", Gender.MALE, 3, "Group1"));
            group.addStudent(new Student("Student4", "Fam4", Gender.FEMALE, 4, "Group1"));
            group.addStudent(new Student("Student5", "Fam5", Gender.MALE, 5, "Group1"));
            group.addStudent(new Student("Student6", "Fam6", Gender.FEMALE, 6, "Group1"));
            group.addStudent(new Student("Student7", "Fam7", Gender.MALE, 7, "Group1"));
        } catch (GroupOverflowException e) {
            System.out.println("Error adding students: " + e.getMessage());
        }

        // Создаем сканер для пользовательского ввода
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. Search student by last name");
            System.out.println("3. Remove student by ID");
            System.out.println("4. Show group");
            System.out.println("5. Sort students by last name");
            System.out.println("6. Add student (via StudentCreator)");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим ввод

            switch (choice) {
                case 1:
                    // Добавление студента вручную
                    System.out.print("Enter student's first name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student's last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter student's ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Чистим ввод

                    System.out.print("Enter student's group name: ");
                    String groupName = scanner.nextLine();

                    System.out.print("Enter student's gender (MALE/FEMALE): ");
                    String genderInput = scanner.nextLine();
                    Gender gender = Gender.valueOf(genderInput.toUpperCase());

                    try {
                        group.addStudent(new Student(name, lastName, gender, id, groupName));
                        System.out.println("Student added successfully.");
                    } catch (GroupOverflowException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Поиск студента по фамилии
                    System.out.print("Enter student's last name to search: ");
                    String searchLastName = scanner.nextLine();

                    try {
                        Student foundStudent = group.searchStudentByLastName(searchLastName);
                        System.out.println("Student found: " + foundStudent);
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Удаление студента по ID
                    System.out.print("Enter student's ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Чистим ввод

                    if (group.removeStudentByID(removeId)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student with ID " + removeId + " not found.");
                    }
                    break;

                case 4:
                    // Показать группу
                    System.out.println("\nCurrent group: " + group);
                    break;

                case 5:
                    // Сортировка студентов по фамилии
                    group.sortStudentsByLastName();
                    System.out.println("Students sorted by last name.");
                    break;

                case 6:
                    // Добавление студента через StudentCreator
                    creator.addStudentToGroup(group);
                    break;

                case 7:
                    // Выход из программы
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
