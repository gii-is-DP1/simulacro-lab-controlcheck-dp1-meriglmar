<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<%-- 
<petclinic:layout pageName="products">
    <jsp:body>
        <c:if test="messages != null">
            <div class="messages">
                <c:forEach items="${messages}" var="message">
                    <div class="message">
                        <c:out value="${message}"/>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <form:form modelAttribute="product"
                   class="form-horizontal">
            <petclinic:inputField label="ID" name="id"/>
            <petclinic:inputField label="Name" name="name"/>
            <petclinic:selectField name="productType" label="Product type" names="${productTypes}" size="5"/>
            <button class="btn btn-default" type="submit">Add Pet</button>
            <petclinic:inputField label="Price" name="price"/>
        </form:form>
    </jsp:body>
</petclinic:layout>  --%>

<petclinic:layout pageName="Products">
	
	<jsp:body>
		<h2>Product</h2>
		<form:form modelAttribute="product" class="form-horizontal" >
            <div class="form-group has-feedback">
            	<petclinic:inputField label="Name" name="name"/> 
            	<petclinic:inputField label="Price" name="price"/>
            	<div class="control-group">
            		<petclinic:selectField name="productType" label="Product Type" names="${productType}" size="3"/>
            	</div>
            </div>
                        
            <div class="form-group">
            	<div class="col-sm-offset-2 col-sm-10">
            		<input type="hidden" name="id" value="${card.id}"/>
            		<button class="btn btn-default" type=submit>Add Product</button>            	
            	</div>
            </div>
        </form:form>
	
	</jsp:body>


</petclinic:layout>