<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>babasport-list</title>

<script type="text/javascript">
	/*
	 * 多个删除，全选
	 */
	function checkBox(name, checked) {
		//checked="checked"
		$("input[name='" + name + "']").attr("checked", checked)
	}

	function optDelete(name, isDisplay) {
		/*
		length是js 原生的方法，用于计算对象的个数和字符串的长度，并且计算字符串的长度只能用length
		size() 是jq的方法用于计算对象的个数
		 */
		var size = $("input[name='ids']:checked").length;
		if (size <= 0) {
			alert("请最少选择一个!!!");
			return;
		}

		if (!confirm("Do you sure delete???"))
			return;
		/*
		 * JQ　选择id必须加#前缀
		 */
		//alert(size);
		$("#deletes").attr(
				"action",
				"/admin/brand/deletes.do?name=" + name + "&isDisplay"
						+ isDisplay);
		$("#deletes").attr("method", "post").submit();
	}
</script>


</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 品牌管理 - 列表</div>
		<form class="ropt">
			<input class="add" type="button" value="添加"
				onclick="javascript:window.location.href='add.do'" />
		</form>
		<div class="clear"></div>
	</div>


	<!--条件查询  -->
	<div class="body-box">
		<!--  -->
		<form action="/admin/brand/divide.do" method="post"
			style="padding-top: 5px;">
			品牌名称:
			<input type="text" name="name" value="${name}" />
			<select name="isDisplay" id="isDisplay">
				<option value="1"
					<c:if test="${isDisplay==1}">selected="selected"</c:if>>是</option>
				<option value="0"
					<c:if test="${isDisplay==0 }">selected="selected"</c:if>>不是</option>
			</select>
			<input type="submit" class="query" value="查询" />
		</form>


		<!--多删  -->
		<form id="deletes">

			<!--全选  -->
			<table cellspacing="1" cellpadding="0" border="0" width="100%"
				class="pn-ltable">
				<thead class="pn-lthead">
					<tr>
						<th width="20">
							<input type="checkbox" onclick="checkBox('ids',this.checked)" />
						</th>
						<th>品牌ID</th>
						<th>品牌名称</th>
						<th>品牌图片</th>
						<th>品牌描述</th>
						<th>排序</th>
						<th>是否可用</th>
						<th>操作选项</th>
					</tr>
				</thead>

				<!--分页显示  -->
				<!--分页开始  -->
				<tbody class="pn-ltbody">
					<!--  遍历品牌数据，然后逐一展示-->
					<c:forEach items="${pageBean.beanList}" var="brandBean">

						<!--设置  isDisplay pageCode-->
						<c:set var="isDisplay" value="${brandBean.isDisplay }"></c:set>
						<c:set var="pageCode" value="${pageBean.pageCode }"></c:set>
						<c:set var="totalPages" value="${pageBean.totalPages }"></c:set>

						<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
							onmouseover="this.bgColor='#eeeeee'">

							<td>
								<!--!!!!!!!!!!!!!!!!!!!!!!多个删除的id,关键，此处出错，无法实现多删 !!!!!!!!!!! -->
								<input type="checkbox" value="${brandBean.id }" name="ids" />
							</td>

							<td align="center">${brandBean.id }</td>
							<td align="center">${brandBean.name }</td>
							<td align="center">

								<!--/res/img/pic/ppp0.jpg  
								////${serverUrl.concat(brandBean.imageUrl)}-->

								<img width="40" height="40" src="${brandBean.picUrl}" />
							</td>
							<td align="center"></td>
							<td align="center">${brandBean.sort }</td>
							<td align="center">
								<c:if test="${isDisplay==1}">是</c:if>
								<c:if test="${isDisplay==0}">不是</c:if>
							</td>

							<td align="center">
								<!--&name=name&imageUrl=imageUrl&description=description&sort=sort&isDisplay=isDisplay  -->
								<!--单个修改  -->
								<a class="pn-opt" href="/admin/brand/edit.do?id=${brandBean.id}">修改</a>
								|
								<!-- 单个删除 -->
								<a class="pn-opt"
									onclick="if(!confirm('您确定删除吗？')) {return false;}"
									href="/admin/brand/delete.do?id=${brandBean.id}&
								name=${brandBean.name}&isDisplay=${brandBean.isDisplay}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<!--分页显示结束  -->
		<!--& amp; 表示符号 &、
			& nbsp;表示空格
			一般常见的还有
			& lt; 表示小于号 <
			& gt; 表示大于号 >
			& copy ;表示 @   -->


		<!--分页控制 -->
		<div class="page pb15">
			<span class="r inb_a page_b">
				<font size="2">
					<c:if test="${pageCode!=1}">
						<!--/admin/brand/divide.do?&amp;isDisplay=${isDisplay }  -->
						<a href="${pageBean.url}&amp;pageCode=1">首页</a>
					</c:if>
					<!-- href="${pageBean.url}&amp;pageCode=1" -->
					<c:if test="${pageCode==1}">
						<a>首页</a>
					</c:if>

				</font>



				<c:if test="${pageCode!=1}">
					<a href="${pageBean.url}&amp;pageCode=${pageCode-1}">
						<font size="2"> 上一页 </font>
					</a>
				</c:if>

				<c:if test="${pageCode ==1}">
					<a>
						<font size="2"> 上一页 </font>
					</a>
				</c:if>

				<!--1234 tp-1 tp +1  -->
				<c:forEach begin="1" end="${totalPages }" step="1" var="tp">


					<c:choose>

						<c:when test="${tp!=pageCode }">
							<a href="${pageBean.url}&amp;pageCode=${tp}"> [${tp}]</a>
						</c:when>
						<c:when test="${tp==pageCode }">
						[${tp}]
						</c:when>

						<c:when test="${tp!=pageCode }">
							<a href="${pageBean.url}&amp;pageCode=${tp+1}"> [${tp+1}]</a>
						</c:when>
						<c:when test="${tp==pageCode }">
						[${tp+1}]
						</c:when>

						<c:when test="${tp!=pageCode }">
							<a href="${pageBean.url}&amp;pageCode=${tp+2}"> [${tp+2}]</a>
						</c:when>
						<c:when test="${tp==pageCode }">
						[${tp+2}]
						</c:when>
					</c:choose>
				</c:forEach>


				<c:if test="${pageCode <totalPages}">
					<a href="${pageBean.url}&amp;pageCode=${pageCode+1}">
						<font size="2">下一页</font>
					</a>
				</c:if>

				<c:if test="${pageCode>=totalPages }">
					<a>
						<font size="2">下一页</font>
					</a>
				</c:if>

				<c:if test="${pageCode < totalPages }">
					<a href="${pageBean.url}&pageCode=${totalPages}">
						<font size="2">尾页</font>
					</a>
				</c:if>
				<c:if test="${pageCode>=totalPages }">
					<a>
						<font size="2">尾页</font>
					</a>
				</c:if>

				共
				<var>${totalPages}</var>
				页 到第
				<input type="text" size="3" id="pageCode" name="pageCode"
					value="${pageCode}" />
				页
				<!--选择跳转，确定  -->
				<input type="button"
					onclick="javascript:window.location.href ='${pageBean.url}&amp;pageCode=' + $('#pageCode').val() "
					value="确定" class="hand btn60x20" id="skip" />
			</span>
		</div>


		<!-- 多个删除 -->
		<div style="margin-top: 15px;float=left">
			<input class="del-button" type="button" value="多个删除"
				onclick="optDelete('${name}','${isDisplay }');" />
		</div>

	</div>
</body>
</html>