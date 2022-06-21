<c:if test="${not empty message}">
    <div class="alert alert-${alert}">
            ${message}
    </div>
</c:if>