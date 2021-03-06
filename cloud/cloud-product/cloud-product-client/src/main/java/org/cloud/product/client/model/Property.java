package org.cloud.product.client.model;

public class Property{

	private Long proid;//编号

	private Long productid;//产品编号

	private Long groid;//属性组编号

	private Long attid;//属性编号

	private String attribute;//属性名

	private Integer type;

	private String value;//属性值

	private Long time;//创建时间

	public Long getProid() {
		return proid;
	}

	public void setProid(Long proid) {
		this.proid = proid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getGroid() {
		return groid;
	}

	public void setGroid(Long groid) {
		this.groid = groid;
	}

	public Long getAttid() {
		return attid;
	}

	public void setAttid(Long attid) {
		this.attid = attid;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
	
}
