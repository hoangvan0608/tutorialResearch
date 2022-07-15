<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty message}">
    <div class="alert alert-${alert}">
            ${message}
    </div>
</c:if>