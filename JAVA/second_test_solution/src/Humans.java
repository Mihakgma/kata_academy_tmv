import java.util.Objects;

public class Humans {
    protected String name;
    protected String lastName;
    protected int age;
    Humans(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return getName() + " " + getLastName();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getAge());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Humans other = (Humans) obj;
        return Objects.equals(getName(), other.getName())  &&
                Objects.equals(getLastName(), other.getLastName()) &&
                Objects.equals(getAge(), other.getAge());
    }
}
