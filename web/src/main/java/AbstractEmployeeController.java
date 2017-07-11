import java.io.Serializable;

/**
 * Created by AnaCris on July/9/17.
 */
public abstract class AbstractEmployeeController implements Serializable {

    public String returnToList() {
        cleanUp();
        return "list?faces-redirect=true";
    }

    protected abstract void cleanUp();
}
