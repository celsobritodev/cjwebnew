<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>  
<%@page import="br.com.hightechcursos.entidades.Usuario"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">

 <tr bgcolor="#CCCCCC">
  <th> ID</th>  <th>Nome</th>  <th>Login</th> <th>Senha</th> <th>Ação</th>
</tr>


<%
 List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

for(Usuario usu:lista) {
%>

  <tr>
      <td> <%=usu.getId() %> </td>
      <td> <%=usu.getNome()%> </td>
      <td> <%=usu.getLogin()%> </td>
      <td> <%=usu.getSenha()%>  </td>
      <td> <a href="usucontroller.do?acao=exc&id=<%=usu.getId()%>"> Excluir </a> </td>
      
      <td> <a href="usucontroller.do?acao=alt&id=<%=usu.getId()%>"> Alterar </a> </td>
  </tr>
  


<% 

}

%>

</table>

</body>

</html>