<header>
	<div class="contenedor-interno">
		<div class="cabecera">
			<h1><s:text name="m.nombreproyecto" /></h1>
			<nav class="menu">
				<a href="#"><s:text name="m.categorias" /></a>
				<%-- <a href="#"><s:text name="m.listagastos" /></a>
				<a href="#"><s:text name="m.listaprestamos" /></a> --%>
				<a href="#">
					<em class="fas fa-sign-out-alt"></em>
				</a>
			</nav>
		</div>
	</div>
</header>

 <section class="main">
	<section class="categoria-fecha">
		<div class="contenedor-interno">
			<div class="contenedor-categoria-fecha">
				<div>
					<select class="categoria" name="categoria" id="categoria">
						<option value="">Seleccione una opci&oacute;n</option>
					</select>
				</div>
				<div class="fecha">
					<p>
						<fmt:formatDate value="${date}" pattern="dd" />
					 	de
					 	<fmt:formatDate value="${date}" pattern="MMMM" />
					 	del
					 	<fmt:formatDate value="${date}" pattern="yyyy" />
					 </p>
				</div>
			</div>
		</div>
	</section>
	
	<section class="descripcion">
		<div class="contenedor-interno">
			<h1 id="descripcion-total"><s:text name="m.descripcionTotal" /></h1>
			<hr />
		</div>
	</section>
	
	<section class="total">
		<div class="contenedor-interno">
			<p>
				<fmt:formatNumber value="${total}" type="currency" />
			</p>
			<hr />
		</div>
	</section>
	
	<section class="btn-opciones">
		<div class="contenedor-interno">
			<nav>
				<button id="addAhorro">
					<s:text name="btn.agregarahorro" />
					<em class="fas fa-plus"></em>
				</button>
				<button id="addGasto">
					<s:text name="btn.agregargasto" />
					<em class="fas fa-plus"></em>
				</button>
				<button id="addPrestamo">
					<s:text name="btn.agregarprestamo" />
					<em class="fas fa-plus"></em>
				</button>
			</nav>
		</div>
	</section>
	
	<section class="gastos-mes">
		<div class="contenedor-gastos-mes">
			<h3><s:text name="msg.totalgastosmes" /></h3>
			<h3>$0.00</h3>
		</div>
	</section>
</section>