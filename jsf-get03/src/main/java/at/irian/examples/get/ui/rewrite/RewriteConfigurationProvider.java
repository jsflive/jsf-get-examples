package at.irian.examples.get.ui.rewrite;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class RewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext context) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/product/{/\\d+/ id}/edit").to("/faces/view/editProduct.xhtml"))
                .addRule(Join.path("/product/{/\\d+/ id}/details").to("/faces/view/productDetails.xhtml"))
                .addRule(Join.path("/products").to("/faces/view/productList.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }

}
