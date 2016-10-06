<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="tasksRegister.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <%@include file="/WEB-INF/jspf/header.jspf"%>
    
    <article class="content">
        <div id="backToTasks">
            <div class="clear"></div>
            <img src="<c:url value="/resources/images/backIcon.png" />" alt="backIcon">
            <a href="login.htm"><spring:message code="tasksRegister.backToLogin"/></a>
            <div class="clear"></div>
        </div>
        <section id="login">
        <h2><spring:message code="tasksRegister.h2"/></h2>
        <form:form method="post" action="processRegister.htm" commandName="tasksUser">
            <p>
                <label><spring:message code="tasksLoginOrRegister.emailLabel"/></label>
                <input name="email" type="email" placeholder="<spring:message code="tasksLoginOrRegister.emailPlaceholder"/>" value="<c:out value="${param.email}"/>" required></p>
                <c:if test="${!empty error}"><p class="error"><spring:message code="tasksRegister.emailAlreadyRegistered"/></p></c:if>
            <p>
                <label><spring:message code="tasksLoginOrRegister.passwordLabel"/></label>
                <input name="password" type="password" placeholder="*****" required></p>
            </p>
            <input id="register" type="submit" value="<spring:message code="tasksRegister.submit"/>">
        </form:form>
        </section>
    </article>
    
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</body>
</html>