package labs.L_immutable_objects;

final public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge( ) {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String []args) {
        Person myPerson = new Person("Arslan",25);
        System.out.println(myPerson);
    }
}

