<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Add User Form</title>
   </head>
   <body>
      <form:form method="POST" action="${flowExecutionUrl}" 
         modelAttribute="user">
         <table>
            <tr>
               <td>Enter your username :</td>
               <td>
                  <form:input     path="username" id="username"/>
               </td>
               <td>
                  <form:errors    path="username"/>
               </td>
            </tr>
            <tr>
               <td>Enter your password :</td>
               <td>
                  <form:password  path="password"/>
               </td>
               <td>
                  <form:errors    path="password"/>
               </td>
            </tr>
            <tr>
               <td>Enter your email :</td>
               <td>
                  <form:input     path="email"/>
               </td>
               <td>
                  <form:errors    path="email"/>
               </td>
            </tr>
            <tr>
               <td><input type="submit" name="_eventId_submit" 
                  value="validate"/></td>
               <td><input type="reset" value="Reset" /></td>
            </tr>
         </table>
      </form:form>
   </body>
</html>