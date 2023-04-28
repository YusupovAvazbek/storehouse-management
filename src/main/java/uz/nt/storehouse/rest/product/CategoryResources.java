package uz.nt.storehouse.rest.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.storehouse.rest.base.AbstractResources;
import uz.nt.storehouse.service.product.category.CategoryServiceImpl;

@RestController
@RequestMapping("api/category")
public class CategoryResources extends AbstractResources<CategoryServiceImpl> {
    public CategoryResources(CategoryServiceImpl service) {
        super(service);
    }
}
