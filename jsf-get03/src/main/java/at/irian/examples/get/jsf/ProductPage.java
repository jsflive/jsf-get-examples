package at.irian.examples.get.jsf;

import at.irian.examples.get.domain.Product;
import at.irian.examples.get.service.ProductRepository;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Michael Kurz
 */
@Named
@ViewAccessScoped
public class ProductPage implements Serializable {
    @Inject
    private ProductRepository productRepository;
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private FacesContext facesContext;

    private int id;
    private Product product;

    @SuppressWarnings("UnusedParameters")
    public void preRenderView(ComponentSystemEvent event) {
        if (!facesContext.isValidationFailed()) {
            product = productRepository.getProductById(id);
            if (product == null) {
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error loading", null));
            }
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
