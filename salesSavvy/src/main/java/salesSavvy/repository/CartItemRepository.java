package salesSavvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salesSavvy.entity.Cart;
import salesSavvy.entity.CartItem;
import salesSavvy.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    boolean existsByCartAndProduct(Cart cart, Product product);
}
