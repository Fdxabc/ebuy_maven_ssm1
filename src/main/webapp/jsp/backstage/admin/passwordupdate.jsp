<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="<%=basePath%>jsp/backstage/index.jsp">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>

    <div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>

    <%--<ul class="forminfo">
    <li><label>*新密码</label><input name="" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>*旧密码</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
    &lt;%&ndash;<li><label>*确认密码</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>&ndash;%&gt;
        <li><label>*确认密码</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认修改"/></li>
    </ul>--%>

        <form action="<%=basePath%>backstage/admin/doUpdatePassword" method="post">
          <%--  <input name="userId" type="hidden" value="1"/>--%>
            <ul class="forminfo">
                <li><label>*旧密码</label><input name="oldPass" type="password" class="dfinput"/></li>
                <li><label>*新密码</label><input name="newPass" type="password" class="dfinput"/></li>
                <li><label>*确认密码</label><input name="confirmPass" type="password" class="dfinput"/></li>
                <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>
            </ul>
        </form>
    </div>
</body>
</html>
