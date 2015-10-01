<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: chunkygarg
  Date: 23/09/15
  Time: 5:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    %{--<link rel="stylesheet" href="${resource(dir: wedding?.template.contentPath+'/css', file: 'app.css')}" type="text/css">--}%
    %{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">--}%
    <title></title>
</head>

<body>
    %{--Welcome ${username} ! (<g:link uri="/j_spring_security_logout">Logout</g:link>)--}%
    Welcome! <sec:username/>

    <facebookAuth:serverSideConnect> Login on server</facebookAuth:serverSideConnect>

    <sec:ifNotGranted roles="ROLE_USER">
    <facebookAuth:connect />

</sec:ifNotGranted>
<sec:ifAllGranted roles="ROLE_USER"></sec:ifAllGranted>

<div class="header">
    <h1>${wedding?.bride} weds  ${wedding?.groom}</h1>
    <h3> ON</h3>
    <h2> ${wedding?.weddingDate}</h2>
    <img><
    </div>
    </div>

</div>

<oauth:connect provider="facebook" id="facebook-connect-link">Facebook</oauth:connect>
Logged with facebook?
<s2o:ifLoggedInWith provider="facebook">yes</s2o:ifLoggedInWith>
<s2o:ifNotLoggedInWith provider="facebook">no</s2o:ifNotLoggedInWith>


<oauth:connect provider="google" id="google-connect-link">Google</oauth:connect>
Logged with google?
<s2o:ifLoggedInWith provider="google">yes</s2o:ifLoggedInWith>
<s2o:ifNotLoggedInWith provider="google">no</s2o:ifNotLoggedInWith>


</body>
</html>