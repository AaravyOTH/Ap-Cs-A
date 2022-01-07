public class Person{
    private String name, job;

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return this.name;
    }


    public String getJob() {
        return this.job;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", job='" + getJob() + "'" +
            "}";
    }

}