package com.springboot.ordermgmt.model;

import java.util.List;

public class OrderItem {

	private String itemId;
	private String itemName;
	private String description;
	private List<String> ingredients;
	
	public OrderItem(){
		
	}
	public OrderItem(String itemId, String itemName, String description, List<String> ingredients) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.ingredients = ingredients;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OrderItem [itemId=%s, itemName=%s, description=%s, ingredients=%s]", itemId, itemName,
				description, ingredients);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}
	
}
