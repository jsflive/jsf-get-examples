package at.irian.examples.get.service;

import at.irian.examples.get.domain.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

/**
 * @author Michael Kurz
 */
@SessionScoped
public class ProductRepository implements Serializable {
    private Map<Integer, Product> products;

    @PostConstruct
    void init() {
        products = new LinkedHashMap<Integer, Product>();
        products.put(1000, new Product(1000, "yPod Big", "It's big. It's mean. It's loud.", 90));
        products.put(1001, new Product(1001, "yPod Huge", "It's bigger. It's meaner. It's louder.", 110));
        products.put(1002, new Product(1002, "yPod Beast", "It's massive. It's mean as hell. It's an explosion.", 150));
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products.values());
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

}
