package com.qwm.ssh_crm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author：qiwenming
 * @date：2017/12/3 0003
 * @description：
 * 客户拜访记录
 */
public class SaleVisit {
    /*
 * CREATE TABLE `sale_visit` (
  `visit_id` VARCHAR(32) NOT NULL,
  `visit_cust_id` BIGINT(32) DEFAULT NULL COMMENT '客户id',
  `visit_user_id` BIGINT(32) DEFAULT NULL COMMENT '负责人id',
  `visit_time` DATE DEFAULT NULL COMMENT '拜访时间',
  `visit_interviewee` VARCHAR(32) DEFAULT NULL COMMENT '被拜访人',
  `visit_addr` VARCHAR(128) DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` VARCHAR(256) DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` DATE DEFAULT NULL COMMENT '下次拜访时间',
  PRIMARY KEY (`visit_id`),
  KEY `FK_sale_visit_cust_id` (`visit_cust_id`),
  KEY `FK_sale_visit_user_id` (`visit_user_id`),
  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sale_visit_user_id` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;
 */

    private String visit_id             ;
    private String visit_interviewee    ;
    private String visit_addr           ;
    private String visit_detail         ;
    private Date visit_time             ;
    private Date visit_nexttime         ;

    //表达所属客户对象 多对一
    private Customer customer;
    //表达所属用户对象 多对一
    private User	user;

    //-----------------------------------------------
    public String getVisit_time_s() {
        return transferDate(visit_time,"yyyy-MM-dd");
    }
    public String getVisit_nexttime_s() {
        return transferDate(visit_nexttime,"yyyy-MM-dd");
    }
    public static String  transferDate(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    //-----------------------------------------------


    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getVisit_interviewee() {
        return visit_interviewee;
    }

    public void setVisit_interviewee(String visit_interviewee) {
        this.visit_interviewee = visit_interviewee;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public Date getVisit_nexttime() {
        return visit_nexttime;
    }

    public void setVisit_nexttime(Date visit_nexttime) {
        this.visit_nexttime = visit_nexttime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
