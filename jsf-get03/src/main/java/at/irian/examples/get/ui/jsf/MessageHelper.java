package at.irian.examples.get.ui.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ApplicationScoped
public class MessageHelper {
    @Inject @SuppressWarnings("CdiInjectionPointsInspection")
    private FacesContext facesContext;

    public void addError(String message) {
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public void addError(String message, Serializable... parameters) {
        String formattedMessage = String.format(message, parameters);
        addError(formattedMessage);
    }

}
