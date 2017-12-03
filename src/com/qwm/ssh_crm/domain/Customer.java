package com.qwm.ssh_crm.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	/*
	 * CREATE TABLE `cst_customer` (
	  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
	  `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
	  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
	  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
	  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
	  `cust_linkman` VARCHAR(64) DEFAULT NULL COMMENT '联系人',
	  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
	  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
	  PRIMARY KEY (`cust_id`)
	) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	 */
	private Long cust_id;
	
	private String cust_name;
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;
	//引用关联的数据字典对象
	private BaseDict cust_source; //客户来源 cust_source.dict_id
	private BaseDict cust_industry; //客户行业
	private BaseDict cust_level; //客户级别

	//表达客户与拜访记录的一对多
	private Set<SaleVisit> saleVisits = new HashSet<SaleVisit>();


	public Set<SaleVisit> getSaleVisits() {
		return saleVisits;
	}
	public void setSaleVisits(Set<SaleVisit> saleVisits) {
		this.saleVisits = saleVisits;
	}

	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getCust_source() { return cust_source; }
	public void setCust_source(BaseDict cust_source) { this.cust_source = cust_source; }
	public BaseDict getCust_industry() { return cust_industry; }
	public void setCust_industry(BaseDict cust_industry) { this.cust_industry = cust_industry; }
	public BaseDict getCust_level() { return cust_level; }
	public void setCust_level(BaseDict cust_level) { this.cust_level = cust_level; }

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + "]";
	}
	
	
	

}
