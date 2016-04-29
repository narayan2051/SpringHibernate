<%@include file="../header.jsp" %>

<h1>Departments</h1>
<div class="pull-right">
    <p >
        <a href="${SITE_URL}/admin/department/add" class="btn btn-success">
            <span class="glyphicon glyphicon-plus">
                
            </span></a>
    </p>
</div>

<table class="table table-hover table-striped table-bordered">
    
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
        
        
        
    </tr>

<c:forEach  var="d" items="${depts}">
        
          <tr>
        <td>${d.id}</td>
        <td>${d.name}</td>
        <td>
            <a href="${SITE_URL}/admin/department/edit/${d.id}" class="btn btn-success">
                <span class="glyphicon glyphicon-pencil"/>
               </a>
                
            <a href="${SITE_URL}/admin/department/delete/${d.id}" class="btn btn-danger" onclick="return confirm('Do you really want to delete?')">
                <span class="glyphicon glyphicon-trash"/>
               </a>
              
        </td>
    </tr>
    
    </c:forEach>
    
  
</table>

<%@include file="../footer.jsp" %>