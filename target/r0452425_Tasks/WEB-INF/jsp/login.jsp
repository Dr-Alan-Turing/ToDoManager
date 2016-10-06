<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="tasksLogin.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <%@include file="/WEB-INF/jspf/header.jspf"%>
    <c:if test="${!empty loginSuccess}">
        <article id="successHeader">
            <h1><p class="success"><spring:message code="tasksLogin.registerSuccess"/></p></h1>
        </article>
    </c:if>
    
    <article class="content">
        <section id="login">
        <h2><spring:message code="tasksLogin.h2"/></h2>
        <c:if test="${!empty error}"><p class="error"><spring:message code="tasksLogin.credentialsNotFound"/></p></c:if>
        <form method="post" action="processLogin.htm">
            <p>
                <label><spring:message code="tasksLoginOrRegister.emailLabel"/></label>
                <input name="email" type="email" placeholder="<spring:message code="tasksLoginOrRegister.emailPlaceholder"/>" value="<c:out value="${param.email}"/>" required></p>
            <p>
                <label><spring:message code="tasksLoginOrRegister.passwordLabel"/></label>
                <input name="password" type="password" placeholder="*****" required></p>
            </p>
            <p>
                <spring:message code="tasksLogin.noAccountText"/> <a href="register.htm"><spring:message code="tasksLogin.noAccountLink"/></a>
            </p>
            <input type="submit" value="<spring:message code="tasksLogin.submit"/>">
        </form>
        </section>
    </article>
    
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</body>
</html>