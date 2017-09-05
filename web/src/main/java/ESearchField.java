/**
 * Created by AnaCris on September/3/17.
 */
public enum ESearchField {
    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    COUNTRY("Country"),
    DEPARTMENT("Department"),
    STATUS("Status"),
    POSITION("Position");

    String name;

    ESearchField(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
