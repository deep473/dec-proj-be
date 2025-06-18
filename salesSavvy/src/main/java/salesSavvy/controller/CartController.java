// src/main/java/salesSavvy/controller/CartController.java
package salesSavvy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import salesSavvy.dto.CartData;
import salesSavvy.dto.CartItemResponseDto;
import salesSavvy.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody CartData req) {
        cartService.addToCart(req.getUsername(), req.getProductId());
        return ResponseEntity.ok("success");
    }

    @GetMapping("/getCartItems/{username}")
    public ResponseEntity<List<CartItemResponseDto>> getCartItems(@PathVariable String username) {
        List<CartItemResponseDto> items = cartService.getCartItems(username);
        return ResponseEntity.ok(items);
    }
}
