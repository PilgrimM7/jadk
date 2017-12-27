<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="<%=basePath%>">
<script src="<c:url value='/plugins/jquery-1.12.4.min.js' />"></script>
<script src="<c:url value='/plugins/bootstrap/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/plugins/bootstrap-table/bootstrap-table.min.js' />"></script>
<script src="<c:url value='/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js' />"></script>
<link rel="stylesheet" href="<c:url value='/plugins/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/plugins/bootstrap-table/bootstrap-table.min.css' />">
<title>用户index</title>
</head>
<body>
	<table id="table" data-toolbar="#toolbar"></table>

<script type="text/javascript"> 
$('#table').bootstrapTable({
    url: 'user/queryForPage',
    sidePagination: 'server',
    queryParamsType: '',
    queryParams: function(params) {
    	params.abc = 'abc';
    	return params;
    },
    columns: [{
        field: 'id',
        title: 'Item ID'
    }, {
        field: 'name',
        title: '姓名'
    }, {
        field: 'age',
        title: '年龄'
    } ],
    striped: true,
    pagination: true,
    pageList: [5, 10, 25, 50, 100]
});
</script>
</body>
</html>