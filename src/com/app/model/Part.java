package com.app.model;

public class Part {

	private int partId;
	private String partName;
	private double cost;
	
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partName=" + partName + ", cost="
				+ cost + "]";
	}

}
