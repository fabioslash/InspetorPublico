<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<script type="text/javascript">
	$(document).ready(function() {
		
		$(".triggerRemove").click(function(e) {
			e.preventDefault();
			$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();
		});
	});
</script>

<table class="table table-bordered table-hover table-striped">
<thead>
    <tr>
       <th>Nome do usuário</th>
       <th>Operação</th>
    </tr>
</thead>

<tbody>
  <c:forEach items="${users}" var="user"  >
     <tr>
        <td>
           <a href="<spring:url value="/users/${user.id}.html" />">
             <c:out value="${user.name}"/>
           </a>
        </td>
        <td>
           <a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger triggerRemove" >
           Delete
           </a>
        </td>
     
     </tr>
      
  
  </c:forEach>

</tbody>

</table>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Excluir Usuário</h4>
			</div>
			<div class="modal-body">Deseja excluir o usuário?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-danger removeBtn">Excluir</a>
			</div>
		</div>
	</div>
</div>

