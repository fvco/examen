<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="es">
<head>
<title>Exámen</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-offset-2 col-sm-8">
				<h1 class="text-center">Lista de Pendientes</h1>
				<hr>
				<form:form modelAttribute="pendiente"
					action="/Examen/pendientes/add" method="post"
					class="form-horizontal">
					<div class="form-group">
						<label for="pwd">Pendiente: </label>
						<form:hidden path="id" />
						<form:input path="pendiente" type="text" class="form-control"
							placeholder="Obligatorio" />
						<form:errors path="pendiente" cssClass="text-danger" />
					</div>
					<div id="buttons-form">
						<button type="submit" class="btn btn-success" id="btn-submit-form">Agregar</button>
					</div>
				</form:form>
				<hr>
				<blockquote>
					<span id="total-pendientes">${lista.size()}</span> pendientes
				</blockquote>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Pendiente</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pendiente" items="${lista}">
							<tr>
								<td>${pendiente.id}</td>
								<td>${pendiente.pendiente}</td>
								<td>
									<div class='btn btn-info btn-xs acciones'
										title="editar registro ${pendiente.id}"
										onclick="editar(${pendiente.id})">
										<i class='glyphicon glyphicon-pencil' style='color: white'></i>
									</div>
									<div class='btn btn-danger btn-xs acciones'
										title="eliminar registro ${pendiente.id}"
										onclick="eliminar(${pendiente.id}, this)">
										<i class='glyphicon glyphicon-trash' style='color: white'></i>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function editar(id){
		$.post("/Examen/pendientes/getPendiente",{id: id}, function(data){
			setForm(data);
		});
	}
	
	function setForm(data){
		$("#id").val(data.id);
		$("#pendiente").val(data.pendiente);
		$(".acciones").attr('disabled',true);
		$("#buttons-form").append("<button type='button' class='btn btn-default' id='btn-cancel-form' onclick='cancelarActualizacion()'>Cancelar</button>");
		$("#btn-submit-form").html("Actualizar");
	}
	
	function cancelarActualizacion(){
		$("#id").val("");
		$("#pendiente").val("");
		$(".acciones").attr('disabled',false);
		$("#btn-cancel-form").remove();
		$("#btn-submit-form").html("Agregar");
	}
	
	function eliminar(id, t){
		if(confirm("Desea eliminar el pendiente #" + id + "?")){
			var f = $(t).parents('tr');
			$.post("/Examen/pendientes/deletePendiente",{id: id}, function(data){
				if(data == "ok"){
					f.fadeOut();
					var tot = $("#total-pendientes").html();
					$("#total-pendientes").html(tot-1)
				}
			});
		}
	}
	</script>
</body>
</html>

