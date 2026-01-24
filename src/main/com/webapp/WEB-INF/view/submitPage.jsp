<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

    <head> </head>
    <body>
        <h1> ${message}</h1>
        <br><br>
        <h3> First name is : ${submittedUser.firstname} </h3>
        <br>
        <h3> Last name is : ${submittedUser.lastname} </h3>
        <br>
        <h3> Email is : ${submittedUser.email} </h3>
        <br>
        <h3> Date of Birth is : ${submittedUser.dateOfBirth} </h3>
        <br>
        <h3> City is : ${submittedUser.city} </h3>
        <br><br>

    </body>




</html>