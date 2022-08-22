package testing;

public class Person {
    private String Name;
    private boolean isParent;
    private int age;
    private char sex;

    public Person(String name, boolean isParent, int age, char sex) {
        Name = name;
        this.isParent = isParent;
        this.age = age;
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public boolean isParent() {
        return isParent;
    }

    public int getAge() {
        return age;
    }
}
