package at.irian.examples.get.ui.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.text.MessageFormat;

@ApplicationScoped
public class MessageHelper {
    @Inject
    @SuppressWarnings("CdiInjectionPointsInspection")
    private FacesContext facesContext;

    public void addError(String message) {
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public void addError(String message, Object... arguments) {
        addError(MessageFormat.format(message, (Object[]) arguments));
    }

}
