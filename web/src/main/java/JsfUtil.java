import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by abarajas on 5/12/17.
 */
public class JsfUtil {

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null,facesMsg);
    }
}
