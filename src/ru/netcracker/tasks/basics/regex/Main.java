package ru.netcracker.tasks.basics.regex;

import ru.netcracker.tasks.basics.regex.address.Address;
import ru.netcracker.tasks.basics.regex.person.Person;
import ru.netcracker.tasks.basics.regex.phone.PhoneNumber;
import ru.netcracker.tasks.basics.regex.shirt.Shirt;
import ru.netcracker.tasks.basics.regex.sql.InstructionSQL;

public class Main {
    public static void main(String[] args) {
        /* Задание 1 */
        InstructionSQL instruction = new InstructionSQL("T_Student", "T_GroupSelected");
        System.out.println(instruction.getInstruction("Math", 10));

        /* Задание 2 */
        Person person = new Person("Мисник");
        System.out.println(person.getFullName());
        person.setFirstName("Кирилл");
        System.out.println(person.getFullName());
        person.setPatronymic("Григорьевич");
        System.out.println(person.getFullName());

        /* Задание 3 */
        Address address = new Address("Россия, Ростовская, Ростов, Иванова, 5, 2, 213");
        System.out.println(address);
        address.setAddress("США, Калифорния, Лос-Анджелес, Голливуд, 10, 2, 12");
        System.out.println(address);
        address.setAddress("Россия, Архангельская. Архангельск. Ленина. 1. 12. 4");
        System.out.println(address);
        address.setAddress("Россия; Челябинская; Челябинск; Ивановкая; 4; 11; 3");
        System.out.println(address);

        /* Задание 4 */
        Shirt[] shirts = new Shirt[11];
        shirts[0] = new Shirt("S001,Black Polo Shirt,Black,XL");
        shirts[1] = new Shirt("S002,Black Polo Shirt,Black,L");
        shirts[2] = new Shirt("S003,Blue Polo Shirt,Blue,XL");
        shirts[3] = new Shirt("S004,Blue Polo Shirt,Blue,M");
        shirts[4] = new Shirt("S005,Tan Polo Shirt,Tan,XL");
        shirts[5] = new Shirt("S006,Black T-Shirt,Black,XL");
        shirts[6] = new Shirt("S007,White T-Shirt,White,XL");
        shirts[7] = new Shirt("S008,White T-Shirt,White,L");
        shirts[8] = new Shirt("S009,Green T-Shirt,Green,S");
        shirts[9] = new Shirt("S010,Orange T-Shirt,Orange,S");
        shirts[10] = new Shirt("S011,Maroon Polo Shirt,Maroon,S");
        System.out.println(shirts[2].toString());

        /* Задание 5 */
        PhoneNumber phoneNumber1 = new PhoneNumber("+79175655655");
        System.out.println(phoneNumber1);
        PhoneNumber phoneNumber2 = new PhoneNumber("+14289652211");
        System.out.println(phoneNumber2);
    }
}
