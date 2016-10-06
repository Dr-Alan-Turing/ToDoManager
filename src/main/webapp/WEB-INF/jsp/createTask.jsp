<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="tasksCreateTask.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <%@include file="/WEB-INF/jspf/header.jspf"%>
    
    <article class="content">
        <div id="backToTasks">
            <div class="clear"></div>
            <img src="<c:url value="/resources/images/backIcon.png" />" alt="backIcon">
            <a href="overviewTasks.htm?category=${param.category}"><spring:message code="tasksCreateOrModifyTask.backToTasks"/></a>
            <div class="clear"></div>
        </div>
        <section id="createOrModifyTask">
        <h2><spring:message code="tasksCreateTask.h2"/></h2>
        <form:form method="post" action="processCreateTask.htm" commandName="task">
            <p>
                <label><spring:message code="tasksCreateOrModifyTask.descriptionLabel"/></label>
                <input name="description" type="text" placeholder="<spring:message code="tasksCreateOrModifyTask.descriptionPlaceholder"/>" value="<c:out value="${task.description}"/>" required>
                <c:if test="${!empty errorMessages['description']}"><p class="error"><spring:message code="tasksCreateTask.taskExists"/></p></c:if>
            </p>
            <input type="hidden" name="owner" value="${loggedInUserId}"/>
            <p>
                <label><spring:message code="tasksCreateOrModifyTask.categoryLabel"/></label>
                <form:select id="categoriesSelect" path="category">
                    <form:option value="0"><spring:message code="tasksCreateOrModifyTask.categoryDefaultOption"/></form:option>
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </p>
            <p>
                <label><spring:message code="tasksCreateOrModifyTask.doneLabel"/></label>
                <input name="isDone" type="checkbox" value="true">
            </p>
            <input type="submit" value="<spring:message code="tasksCreateTask.submit"/>">
        </form:form>
        </section>
    </article>
    
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
            
    <script type="text/javascript">
        //functions to be executed on page load
        selectRelevantOption(${param.category});
    </script>
</body>
</html>