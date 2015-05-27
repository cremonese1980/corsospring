<%@ page contentType="text/html" session="false" %>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <div id="logo">
            <img src="images/logo.png" alt="Logo"> 
        </div>        
        <div id="content">
            <div id="insert"><img src="images/webflow-logo.jpg" width="65" height="42"/></div>
            <h3>Adivina un numero entre 0 y 100</h3>
            <hr/>
            <form name="guessForm" method="post">
                <table>
                    <tr class="readOnly">
                        <td>Numero intentos:</td><td><b>${juego.intentos}</b></td>
                    </tr>
                    <tr class="readOnly">
                        <td>Tu ultimo intento fue:</td><td><b><i>${juego.resultado}</i></b></td>
                    </tr>
                    <tr>
                        <td>Numero:</td>
                        <td><input type="text" name="valor" value="${param.valor}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="buttonBar">
                            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
                            <input type="submit" class="button" name="_eventId_submit" value="Enviar">
                        </td>
                    </tr>		    
                </table>
            </form>
        </div>
    </body>
</html>