/**
 * Created by AnaCris on July/9/17.
 */
public abstract class AbstractEmployeeController {

    public String returnToList() {
        cleanUp();
        return "list?faces-redirect=true";
    }

    protected abstract void cleanUp();
}
