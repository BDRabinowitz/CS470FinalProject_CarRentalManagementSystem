package src;


public class Car {
	
	private int price;
	private String make;
	private String model;
	private boolean available;
	private String policy;
	private String type;
	private String image;
	private String specs;
	private int id;
	private static int maxID;

	public Car(int price, String make, String model, boolean available, String image, String type, String policy, String specs, int id) {
		this.setPrice(price);
		this.setMake(make);
		this.setModel(model);
		this.setAvailable(available);
		this.setImage(image);
		this.setType(type);
		this.setPolicy(policy);
		this.setSpecs(specs);
		this.setId(id);
		if(id > maxID) {
			maxID = id;
		}
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getMaxID() {
		return maxID;
	}
	
	public String toString() {
		return String.format("%d,%s,%s,%b,%s,%s,%s,%s,%d", price, make, model, available, image, type, policy, specs, id);
	}
}
