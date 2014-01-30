package at.irian.examples.get.ui.view;

import at.irian.examples.get.domain.Product;
import at.irian.examples.get.service.ProductRepository;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author Michael Kurz
 */
@Named
@ViewAccessScoped
public class ProductListPage implements Serializable {
    @Inject
    private ProductRepository productRepository;

    private List<Product> products;

    @PostConstruct
    void load() {
        products = productRepository.getProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

}
