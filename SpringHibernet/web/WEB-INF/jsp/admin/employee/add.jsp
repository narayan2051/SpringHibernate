<%@include file="../header.jsp" %>


<h1> ADD Employee</h1>

<form method="post" action="${SITE_URL}/admin/employee/save">
  <div class="form-group">
    <label>First Name</label>
    <input type="text" class="form-control" name="first_name" placeholder="First name" required="required">
  </div>
   <div class="form-group">
    <label>Last Name</label>
    <input type="text" class="form-control" name="last_name" placeholder="Last name" required="required">
  </div>
  <div class="form-group">
    <label>Email</label>
    <input type="email" class="form-control" name="email" placeholder="Email" required="required">
  </div>
    
     <div class="form-group">
    <label>Phone</label>
    <input type="text" class="form-control" name="contact" placeholder="Phone number" required="required">
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
      <input type="checkbox" name="status"> Active
    </label>
  </div>
  
  <input type="hidden" name="id"/>
    <a href="${SITE_URL}/admin/employee" class="btn btn-danger">Back</a>
    
  <button type="submit" class="btn btn-success">Save</button>
</form>


<%@include file="../footer.jsp" %>