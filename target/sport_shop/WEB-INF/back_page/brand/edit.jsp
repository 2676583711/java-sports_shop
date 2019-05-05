<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-edit</title>
<script type="text/javascript">
	function uploadPic() {
		var option = {
			url : "/upload/uploadImg.do",
			dataType : "json",
			type : "post",
			success : function(data) {
				//图片回显
				$("#imgSize1ImgSrc").attr("src", data.url);
				//ajax　传递图片地址用于提交图片地址
				$("#imageUrl").attr("value", data.path);
			}
		}
		$("#jvForm").ajaxSubmit(option);
	}
</script>

</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 品牌管理 - 添加</div>
		<form class="ropt">
			<input type="submit"
				onclick="this.form.action='/admin/brand/list.do';" value="返回列表"
				class="return-button" />
		</form>
		<div class="clear"></div>
	</div>

	<!--提交修改信息  -->
	<div class="body-box" style="float: right">
		<form id="jvForm" action="/admin/brand/update.do" method="post">

			<!--隐藏域 用于提交id  -->
			<input type="hidden" name="id" value="${brandBean.id}" />


			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>
							品牌名称:
						</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="name" maxlength="100"
								value="${brandBean.name }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>
							上传商品图片(90x150尺寸):
						</td>
						<td width="80%" class="pn-fcontent">注:该尺寸图片必须为90x150。</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">

							<!--*************************************************************************************  -->


							<!--隐藏域提交图片地址 name用于提交,id用于ajax传递图片地址 -->
							<input type="hidden" name="imageUrl" id="imageUrl" />
							<!-- 展示图片 -->
							<img width="100" height="100" id="imgSize1ImgSrc"
								src="${brandBean.picUrl}" />
							<!--  选择并上传图片-->
							<input type="file" name="img" onchange="uploadPic()" />
							<!--************************************************************************************  -->
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">品牌描述:</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="description" maxlength="80"
								size="60" value="${brandBean.description }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">排序:</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="sort" maxlength="80"
								value="${brandBean.sort }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">是否可用:</td>
						<td width="80%" class="pn-fcontent">
							<input type="radio" name="isDisplay"
								value="${brandBean.isDisplay }"
								<c:if test="${brandBean.isDisplay==1}">checked="checked" </c:if>>
								可用 </input>
							<input type="radio" name="isDisplay"
								value="${brandBean.isDisplay }"
								<c:if test="${brandBean.isDisplay==0}">checked="checked" </c:if> />
							不可用
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2">
							<input type="submit" class="submit" value="提交" />
							&nbsp;
							<input type="reset" class="reset" value="重置" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>