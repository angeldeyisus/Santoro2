<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Santoro Carniceria</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
				<li class="nav-item"><a class="nav-link" href="carrito.jsp">Carrito <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
                                <li class="nav-item"><a class="nav-link" href="contacto.jsp">Contactanos</a></li>
				<%
				if (usuario != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="ordenes.jsp">Ordenes</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Cerrar Sesion</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar Sesion</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</nav>