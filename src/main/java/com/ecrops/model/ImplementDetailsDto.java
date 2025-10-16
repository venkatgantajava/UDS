package com.ecrops.model;

public class ImplementDetailsDto {

	private String impltypeName;
	private String implName;
	private Integer quantity;
	private Integer impltype_id;
	private Integer impl_id;

	public String getImpltypeName() {
		return impltypeName;
	}

	public void setImpltypeName(String impltypeName) {
		this.impltypeName = impltypeName;
	}

	public String getImplName() {
		return implName;
	}

	public void setImplName(String implName) {
		this.implName = implName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getImpltype_id() {
		return impltype_id;
	}

	public void setImpltype_id(Integer impltype_id) {
		this.impltype_id = impltype_id;
	}

	public Integer getImpl_id() {
		return impl_id;
	}

	public void setImpl_id(Integer impl_id) {
		this.impl_id = impl_id;
	}

	@Override
	public String toString() {
		return "ImplementDetailsDto [impltypeName=" + impltypeName + ", implName=" + implName + ", quantity=" + quantity
				+ ", impltype_id=" + impltype_id + ", impl_id=" + impl_id + ", getImpltypeName()=" + getImpltypeName()
				+ ", getImplName()=" + getImplName() + ", getQuantity()=" + getQuantity() + ", getImpltype_id()="
				+ getImpltype_id() + ", getImpl_id()=" + getImpl_id() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
