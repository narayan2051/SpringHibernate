<%@include file="../header.jsp" %>

<h1>Employees</h1>
<div class="pull-right">
    <p >
        <a href="${SITE_URL}/admin/employee/add" class="btn btn-success">
            <span class="glyphicon glyphicon-plus">
                
            </span></a>
    </p>
</div>

<table class="table table-hover table-striped table-bordered">
    
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Added Date</th>
        <th>Modified Date</th>
        <th>Status</th>
         <th>Action</th>
        
        
        
    </tr>

<c:forEach  var="e" items="${employees}">
        
          <tr>
        <td>${e.id}</td>
        <td>${e.firstName} ${e.lastName}</td>
        <td>${e.email}</td>
        <td>${e.contactNo}</td>
        <td>${e.addedDate}</td>
        <td>${e.modifiedDate}</td>
        <td>
            <c:choose>
                <c:when test="${e.status}">
                    <a href="${SITE_URL}/admin/employee/status/${e.id}" class="btn btn-success"><span class="glyphicon glyphicon-ok">
                        
                </span></a>
                </c:when>
                <c:otherwise>
                     <a href="" class="btn btn-success" class="btn btn-danger">
                         <span class="glyphicon glyphicon-remove">
                </c:otherwise>
                </c:choose></td>
        <td>
            <a href="${SITE_URL}/admin/employee/edit/${e.id}" class="btn btn-success">
                <span class="glyphicon glyphicon-pencil"/>
               </a>
                
            <a href="${SITE_URL}/admin/employee/delete/${e.id}" class="btn btn-danger" onclick="return confirm('Do you really want to delete?')">
                <span class="glyphicon glyphicon-trash"/>
               </a>
              
        </td>
    </tr>
    
    </c:forEach>
    
  
</table>

<%@include file="../footer.jsp" %>