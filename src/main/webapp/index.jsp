<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:import url="includes/menu.jsp"></c:import>
  
  <h1> Bem vindo, '${sessionScope.usuLogado.nome}'  ao sistema !</h1>
</body>
</html>