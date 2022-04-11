package ru.gb.hw;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("productRepository")
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(0, "Milk", 115d));
        products.add(new Product(1, "Coffee", 400d));
        products.add(new Product(2, "Bread", 60d));
        products.add(new Product(3, "Sugar", 79d));
        products.add(new Product(4, "Snickers", 43d));
    }

    public List<Product> findAll(){
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id){
        if (id< (products.size()) && id >= 0){
            return Optional.of(products.get(id));
        }else{
            return Optional.empty();
        }
    }
}
