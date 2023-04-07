<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href='<c:url value="/templates/user/assets/css/grid.css" />'>
  <link rel="stylesheet" href='<c:url value="/templates/user/assets/css/base.css" />'>
   <link rel="stylesheet" href='<c:url value="/templates/user/assets/css/index.css" />'>
   <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
      crossorigin="anonymous"
    />
</head>
<body>
	<div class="main">
      <div class="grid wide">
      		<%@ include file="/common/user/header.jsp" %>
      		
      		 <div class="content">
            	<div class="row">
              		<div class="col l-2">
              			<%@ include file="/common/user/nav.jsp" %>
              		</div>
              			<div class="col l-10">
                    			<decorator:body></decorator:body>
                    	
                    	</div>
              	</div>
             </div>
      		
      		<%@ include file="/common/user/footer.jsp" %>
      </div>
     </div>
</body>
</html>