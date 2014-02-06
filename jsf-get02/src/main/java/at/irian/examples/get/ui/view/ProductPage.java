package at.irian.examples.get.ui.view;

import at.irian.examples.get.domain.Product;
import at.irian.examples.get.service.ProductRepository;
import at.irian.examples.get.ui.jsf.MessageHelper;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

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
    @Inject
    private MessageHelper messageHelper;

    private int id;
    private Product product;

    public void loadProduct() {
        product = productRepository.getProductById(id);
        if (product == null) {
            messageHelper.addError("Product with id {0} not found", id);
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
