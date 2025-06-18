package salesSavvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import salesSavvy.dto.CartItemResponseDto;
import salesSavvy.entity.Cart;
import salesSavvy.entity.CartItem;
import salesSavvy.entity.Product;
import salesSavvy.entity.Users;
import salesSavvy.repository.CartItemRepository;
import salesSavvy.repository.CartRepository;
import salesSavvy.repository.ProductRepository;
import salesSavvy.repository.UsersRepository;
import salesSavvy.service.CartService;

@Service
public class CartServiceImplementation implements CartService {

	@Autowired
    UsersRepository userRepo;
	@Autowired
    CartRepository cartRepo;
	@Autowired
    ProductRepository productRepo;
	@Autowired
    CartItemRepository itemRepo;

    @Override
    @Transactional
    public void addToCart(String username, Long productId) {
        // 1) Look up user
        Optional<Users> userOpt = userRepo.findByUsername(username);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }
        Users user = userOpt.get();

        // 2) Look up or create the cart
        Optional<Cart> cartOpt = cartRepo.findByUser(user);
        Cart cart;
        if (cartOpt.isPresent()) {
            cart = cartOpt.get();
        } else {
            cart = new Cart(user);
            cartRepo.save(cart);
        }

        // 3) Look up product
        Optional<Product> productOpt = productRepo.findById(productId);
        if (!productOpt.isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }
        Product product = productOpt.get();

        // 4) Prevent duplicate items
        boolean exists = itemRepo.existsByCartAndProduct(cart, product);
        if (exists) {
            return;  // already in cart
        }

        // 5) Create and save a new CartItem
        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(1);
        itemRepo.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartItemResponseDto> getCartItems(String username) {
        // 1) Look up user
        Optional<Users> userOpt = userRepo.findByUsername(username);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }
        Users user = userOpt.get();

        // 2) Look up cart (if none, treat as empty)
        Optional<Cart> cartOpt = cartRepo.findByUser(user);
        Cart cart = cartOpt.isPresent() ? cartOpt.get() : new Cart(user);

        // 3) Build DTO list
        List<CartItemResponseDto> dtoList = new ArrayList<>();
        for (CartItem ci : cart.getItems()) {
            dtoList.add(new CartItemResponseDto(
                ci.getProduct().getId(),
                ci.getProduct().getName(),
                ci.getProduct().getPhoto(),
                ci.getProduct().getPrice(),
                ci.getQuantity()
            ));
        }
        return dtoList;
    }
}
