<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#saleVisit==null?'添加':'修改'" />拜访记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<!-- 使用日期控件步骤1: 导入js和css -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
	
<!-- 使用日期控件步骤2: 当页面加载完成时,调用 datepick方法指定需要应用的文本框 -->
	$(document).ready(function(){
			// yy 已经代表了4位的年份
			// mm 代表月份
			// dd 代表日期
		$('#visit_time').datepick({dateFormat: 'yy-mm-dd'}); 
		$('#visit_nexttime').datepick({dateFormat: 'yy-mm-dd'}); 
	});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/SaleVisitAction_add"
		method="post"  onsubmit="return checkForm(['user.user_id','visit_nexttime']);" >
		<!-- 隐藏域回显当前编辑的拜访记录id -->
		<input  type="hidden"  name="visit_id" value="<s:property value="#saleVisit.visit_id" />"  />

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：拜访记录管理 &gt; <s:property value="#saleVisit==null?'添加':'修改'" />拜访记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>所属客户：</td>
								<td >
								<input type="hidden" name="customer.cust_id" style="WIDTH: 180px" id="cust_id" value="<s:property value="#saleVisit.customer.cust_id" />" />
								<input type="text"  style="WIDTH: 180px" id="cust_name" value="<s:property value="#saleVisit.customer.cust_name" />"/>
									<input type="button" value="选择客户" onclick="window.open('${pageContext.request.contextPath}/CustomerAction_list?select=true','','width=600,height=300')" />
								</td>
								<td>拜访时间 ：</td>
								<td  >
									<INPUT class=textbox id="visit_time" type="text" 
														style="WIDTH: 180px" maxLength=50 name="visit_time" readonly="readonly" value="<s:property value="#saleVisit.visit_time_s" />" >
								</td>
							</TR>
							
							<TR>
								
								<td>被拜访人 ：</td>
								<td >
								<INPUT class=textbox id=sChannel2 type="text"
														style="WIDTH: 180px" maxLength=50 name="visit_interviewee" value="<s:property value="#saleVisit.visit_interviewee" />" >
								</td>
								<td>拜访地址：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="visit_addr" value="<s:property value="#saleVisit.visit_addr" />">
								</td>
							</TR>
							
							<TR>
								
								
								<td>拜访详情 ：</td>
								<td>
								<INPUT class=textbox id="cust_phone"
														style="WIDTH: 180px" maxLength=50 name="visit_detail" value="<s:property value="#saleVisit.visit_detail" />">
								</td>
								<td>下次拜访时间：</td>
								<td>
								<INPUT class=textbox id="visit_nexttime" readonly="readonly"
														style="WIDTH: 180px" maxLength=50 name="visit_nexttime" value="<s:property value="#saleVisit.visit_nexttime_s" />">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type="submit"
														value="保存 " name=sButton2>
								</td>
							</tr>
							
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
