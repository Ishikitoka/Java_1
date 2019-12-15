package ru.geekbrains.lesson_5.employee;

/**
 * 1.	Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
 */

/**
 * Class "Employee" / Конуструктор
 * Каждый новый класс создаётся в отдельном файле
 * Задаются параметры
 */
public class Employee {
    private String fullName;      // field. В переменных хранится состояние объекта
    private String post;
    private int salary;
    private int age;

    /**
     * 3.	Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
     */
    public String getFullName() { return fullName; } // Чтение текущего значения
    public String getPosition() { return post; }
    public int getSalary() { return salary; }
    public int getAge() { return age; }

    /**
     * 2.	Конструктор класса должен заполнять эти поля при создании объекта;
     */
    /**
     * Вызов Конструктора
     */
    public Employee(String fullName, String post, int salary, int age){  // Передали аргументы конструктору
            this.fullName = fullName;  // ссылка на текущий экземпляр класса
            this.post= post;
            this.salary = salary;
            this.age = age;
    }
    /*
    Вывод информаци о сотруднике
     */
    public String getEmployeeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО:\t\t" + fullName + "\n");
        sb.append("Должность:\t" + post + "\n");
        sb.append("Зарплата:\t" + salary + "\n");
        sb.append("Возраст:\t" + age + "\n");
        return sb.toString();
    }
}
