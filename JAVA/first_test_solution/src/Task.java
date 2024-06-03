/**
@author Mikhail Tabakaev
@version 1.001

This class contains single task general information:
 name - task name
 description - task description
*/
public class Task {
    protected String name;
    protected String description;
    Task() {
        name = "na";
        description = "na";
    }
    Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return String.valueOf(this.hashCode()).equals(String.valueOf(obj.hashCode()));
    }

    @Override
    public String toString() {
        return String.join(" - ", getName(), getDescription());
    }
}
