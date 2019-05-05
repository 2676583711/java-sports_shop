<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-add</title>

<script type="text/javascript" language="JavaScript"
	charset="x-UTF-16LE-BOM">
	function uploadImg() {
		//alert("success")
		var options = {
			url : "/upload/uploadImg.do",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#allImgUrl").attr("src", data.url);
				$("#imageUrl").attr("value", data.path);

			}
		}
		//使用jquery.form　模拟表单的提交方式
		$("#jvForm").ajaxSubmit(options);
	}
</script>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 品牌管理 - 添加</div>
		<form class="ropt">
			<!-- v_list.shtml -->
			<input type="submit"
				onclick="this.form.action='/admin/brand/list.do';" value="返回列表"
				class="return-button" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box" style="float: right">

		<!--上传表单　  enctype="multipart/form-data"   /admin/brand/add.do -->
		<form id="jvForm" action="/admin/brand/add.do" method="post"
			enctype="multipart/form-data">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							<span class="pn-frequired">*</span>
							品牌名称:
						</td>
						<!--品牌名称输入框  -->
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="name" maxlength="100" />
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
						<!-- 图片展示框 -->
						<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<!--选择上传文件  -->
						<td width="80%" class="pn-fcontent">

							<!--展示图片  -->
							<img width="100" height="100" id="allImgUrl" />
							<!--隐藏域，图片地址  -->
							<input type="hidden" id="imageUrl" name="imageUrl" />
							<!--选择的图片  -->
							<input type="file" name="img" onchange="uploadImg()" />
						</td>
					</tr>

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">品牌描述:</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="description"
								maxlength="80" size="60" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">排序:</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="sort" maxlength="80" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">是否可用:</td>
						<td width="80%" class="pn-fcontent">
							<input type="radio" name="isDisplay" value="1" checked="checked" />
							可用
							<input type="radio" name="isDisplay" value="0" />
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