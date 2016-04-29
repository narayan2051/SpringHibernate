<%@include file="../header.jsp" %>


<h1> ADD Department</h1>

<form method="post" action="${SITE_URL}/admin/department/save">
  <div class="form-group">
    <label>Name</label>
    <input type="text" class="form-control" name="name" required="required">
  </div>
  
  <input type="hidden" name="id"/>
  <a href="${SITE_URL}/admin/department" class="btn btn-danger">Back</a>
      
  <button type="submit" class="btn btn-success">Save</button>
</form>

  <%@include file="../footer.jsp" %>