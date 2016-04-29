<%@include file="../header.jsp" %>


<h1> Edit Department</h1>

<form method="post" action="${SITE_URL}/admin/department/save">
  <div class="form-group">
    <label>Name</label>
    <input type="text" class="form-control" name="name" value="${dept.name}">
  </div>
  <input type="hidden" name="id" value="${dept.id}"/>

    <a href="${SITE_URL}/admin/department" class="btn btn-danger">Back</a>
      
  <button type="submit" class="btn btn-success">Update</button>
</form>

<%@include file="../header.jsp" %>