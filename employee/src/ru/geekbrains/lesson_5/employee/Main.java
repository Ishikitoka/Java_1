package ru.geekbrains.lesson_5.employee;

public class Main {

    public static void main(String[] args) {
        /*
        *4.	Вывести при помощи методов из пункта 3 ФИО и должность.
        */
	    Employee c = new Employee("ФИО:\t\t Петров","Должность:\t Менеджер", 5000, 25);   // c - идентификатор объекта. Создали объект / экземпляр сотрудника
        System.out.println(c.getFullName() + "\n" + c.getPosition() + "\n");

        /*
        5.	Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
         */
        Employee[] workers = new Employee[5];
        workers[0] = c;
        workers[1] = new Employee("Сидоров","Инженер", 6000, 20);
        workers[2] = new Employee("Крылов","Метеоролог", 7000, 30);
        workers[3] = new Employee("Жуйков","Повар", 8000, 50);
        workers[4] = new Employee("Смирнов", "Учитель", 9000, 60);
        int age = 40;
        printWorkersInfo(workers, age);
    }

    public static void printWorkersInfo(Employee[] e, int borderAge){
        for (int i = 0; i < e.length; i++){
            if(e[i].getAge() > borderAge) System.out.println(e[i].getEmployeeInfo());
        }
    }
}
