import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AnaCris on July/9/17.
 */

@Named(value="utils")
@SessionScoped
public class Utils implements Serializable {

    public String formatDateWithTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d yyyy");
        return dateFormat.format(date);
    }
}
