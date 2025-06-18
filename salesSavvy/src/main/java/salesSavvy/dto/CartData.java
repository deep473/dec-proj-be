package salesSavvy.dto;

public class CartData {
	String username;
	Long productId;
	public CartData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartData(String username, Long productId) {
		super();
		this.username = username;
		this.productId = productId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "CartData [username=" + username + ", productId=" + productId + "]";
	}
}
