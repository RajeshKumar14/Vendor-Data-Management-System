package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TAB")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private int itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_cost")
	private double itemCost;
	@Column(name="item_margin")
	private int marginValue;
	@Column(name="c_id")
	private int custId;
	
	public Item() {
	}

	public Item(int itemId) {
		this.itemId = itemId;
	}

	public Item(int itemId, String itemName, double itemCost, int marginValue,
			int custId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.marginValue = marginValue;
		this.custId = custId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	public int getMarginValue() {
		return marginValue;
	}

	public void setMarginValue(int marginValue) {
		this.marginValue = marginValue;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCost=" + itemCost + ", marginValue=" + marginValue
				+ ", custId=" + custId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		long temp;
		temp = Double.doubleToLongBits(itemCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + marginValue;
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
		Item other = (Item) obj;
		if (custId != other.custId)
			return false;
		if (Double.doubleToLongBits(itemCost) != Double
				.doubleToLongBits(other.itemCost))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (marginValue != other.marginValue)
			return false;
		return true;
	}

}
