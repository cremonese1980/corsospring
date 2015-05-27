<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display User</title>
    </head>
    <body>
      The details of the user added :
      <table>
          <tr>
              <td>Username : </td>
              <td>${user.username}</td>
          </tr>
          <tr>
              <td>Password : </td>
              <td>${user.password}</td>
          </tr>
          <tr>
              <td>Email : </td>
              <td>${user.email}</td>
          </tr>
       </table>
    </body>
</html>