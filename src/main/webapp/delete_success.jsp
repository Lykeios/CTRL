<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>删除成功页面</title>
</head>
<body>
<%--<%--%>
<%--    int chapter_id = Integer.parseInt(request.getParameter("chapter_id"));--%>
<%--    int user_id = Integer.parseInt(request.getParameter("user_id"));--%>
<%--%>--%>
<script language=JavaScript>
    window.location="singleChapter?chapter_id=${chapterId}&user_id=${sessionScope.user.userId}"
</script>
</body>
</html>

