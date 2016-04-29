<%@include file="../header.jsp" %>


<form method="post" action="${SITE_URL}/admin/employee/save">
  <div class="form-group">
    <label>First Name</label>
    <input type="text" class="form-control" name="first_name" value="${employee.firstName}" required="required">
  </div>
   <div class="form-group">
    <label>Last Name</label>
    <input type="text" class="form-control" name="last_name" value="${employee.lastName}" required="required">
  </div>
  <div class="form-group">
    <label>Email</label>
    <input type="email" class="form-control" name="email" value="${employee.email}" required="required">
  </div>
    
     <div class="form-group">
    <label>Phone</label>
    <input type="text" class="form-control" name="contact" value="${employee.contactNo}" required="required">
  </div>
  
  <div class="form-group"> 
  
      <label>Department</label>
      <select name="department_id">
          <c:forEach var="d" items="${depts}">
              <option value="${d.id}" >${d.name}</option>
          </c:forEach>
      </select>
      
  </div>

  <div class="checkbox">
    <label>
        <input type="checkbox" name="status" <c:if test="${employee.status}">checked="checked"
                </c:if>> Active
    </label>
  </div>
  
    <input type="hidden" name="id" value="${employee.id}"/>
    <a href="${SITE_URL}/admin/employee" class="btn btn-danger">Back</a>
    
  <button type="submit" class="btn btn-success">Save</button>
</form>


<%@include file="../footer.jsp" %>

