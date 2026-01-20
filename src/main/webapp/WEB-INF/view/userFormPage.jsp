<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

    <head>
    </head>
    <body>
        <form action="submitUserData" >
            <h1>User Form</h1>
            <br>
            First Name:
            <input type="text" placeholder="First name" id="fn" name="firstName" />
            <br><br>
            Last Name:
            <input type="text" placeholder="Last name" name="lastName" />
            <br><br>
            Email:
            <input type="email" placeholder="Email" name="email" />
            <br><br>
            Date of Birth:
            <input type="date" placeholder="Birth Date" name="birthDate" />
            <br><br>
            City:
            <input type="text" placeholder="City" name="city" />
            <br><br>
            <input type="submit" />

    </body>




</html>