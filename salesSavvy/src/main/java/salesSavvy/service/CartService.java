package salesSavvy.service;

import java.util.List;
import salesSavvy.dto.CartItemResponseDto;

public interface CartService {
    void addToCart(String username, Long productId);
    List<CartItemResponseDto> getCartItems(String username);
}
