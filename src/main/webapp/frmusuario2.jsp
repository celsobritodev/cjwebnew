<%@page import="br.com.hightechcursos.entidades.Usuario"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuario</title>
</head>
<body>
     <%

     Usuario usuario = (Usuario) request.getAttribute("usuario");

     %>
  <form action="usucontroller.do" method="post">
     
     <label>ID: </label>
     <input type="text" readonly="readonly" name="txtid" value="<%=usuario.getId() %>" size="20">
    
     <label>Nome:</label>
     <input type="text" name="txtnome" value="<%=usuario.getNome() %>" size="20">
     
     <label>Login:</label>
     <input type="text" name="txtlogin" value="<%=usuario.getLogin() %>" size="20">
     
     <label>Senha:</label>
     <input type="password" name="txtsenha" value="<%=usuario.getSenha() %>" size="20">
     
     <input type="submit" value="Salvar"/>
  
  </form>
</body>
</html>