<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listando com JSTL</title>
</head>
<body>

<%
  String nome = (String) request.getAttribute("meunome");
  out.print(nome);
%>
${requestScope.meunome}


<table border="1">

 <tr bgcolor="#CCCCCC">
  <th> ID</th>  <th>Nome</th>  <th>Login</th> <th>Senha</th> <th>Ação</th>
</tr>


<c:forEach items="${requestScope.lista}" var="usu">
  <tr>
      <td> ${usu.id}    </td>
      <td> ${usu.nome}  </td>
      <td> ${usu.login} </td>
      <td> ${usu.senha} </td>
      <td>
       <a href="usucontroller.do?acao=exc&id=${usu.id}"> Excluir </a> 
       <a href="usucontroller.do?acao=alt&id=${usu.id}"> Alterar </a> 
      </td>
      
  </tr>
  
 </c:forEach>


</table>

</body>

</html>