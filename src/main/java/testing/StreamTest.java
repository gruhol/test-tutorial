package testing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> personList = StreamTest.generatedList();

        personList.stream()
                .map(person -> person.getName() + " " + person.getSex())
                .forEach(System.out::println);

        List<Person> kobiety = personList.stream()
                .filter(person -> person.getSex() == 'k')
                .collect(Collectors.toList());

        System.out.println();
    }

    private static List<Person> generatedList() {
        List<Person> personList;
        Person person1 = new Person("Wojtek", true, 38, 'm');
        Person person2 = new Person("Anna", true, 37, 'k');
        Person person3 = new Person("Karol", false, 6, 'm');
        Person person4 = new Person("Filip", false, 11, 'm');
        Person person5 = new Person("Paweł", true, 36, 'm');
        Person person6 = new Person("Magda", true, 35, 'k');
        Person person7 = new Person("Tomek", false, 7, 'm');
        Person person8 = new Person("Małgosia", false, 3, 'k');
        Person person9 = new Person("Barbara", true, 67, 'k');
        return  personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9);
    }

}
