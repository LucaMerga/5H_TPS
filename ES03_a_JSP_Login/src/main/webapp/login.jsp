<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container"> <!-- div contenente il form e il titolo per modifiche css -->
	<h3 class="title">Accedi</h3> <!-- titolo del form -->
	<div class="contenuto"> <!-- div contenente il form per modifiche css -->
		<form action="post.jsp" method="POST">  <!-- form con metodo POST / chiamata a se stesso ($_SERVER['PHP_SELF']) / trasformazione caratteri speciali in caratteri html (htmlspecialchars) -->
			<div class="user-details">  <!-- div contenente gli input del form per modifiche css -->
				<div class="input-box"> <!-- div contenente ogni singolo input del form per modifiche css -->
					<label for="user">Username</label>  <!-- etichetta con il usern -->
					<input type="text" name="user" value="" placeholder="Username" id="user"> <!-- type text perchè si tratta di una stringa (usern) -->
				</div>

				<div class="input-box">
					<label for="password">Password</label>
					<input type="password" name="password" value="" placeholder="Password" id="password"> <!-- type password perchè si tratta di una password -->
				</div>
			</div>

			<div class="button">  <!-- div contenente l'input del submit del form per modifiche css -->
				<input type="submit" value="login" name="login" id="btn"> <!-- type submit perchè si tratta di un bottone per l'invio dei dati -->
			</div>

			<div class="user-details">
				<div>
					<small>Torna a <a href="index.jsp">home</a></small>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>