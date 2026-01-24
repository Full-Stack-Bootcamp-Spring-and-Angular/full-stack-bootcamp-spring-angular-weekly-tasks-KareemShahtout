<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

    <head> </head>
    <body>
      <form:form action="submitPage" modelAttribute="userData">
         <h1>User Form</h1>
         <br>
         First Name:
         <form:input type="text" placeholder="First name" path="firstname" />
         <br><br>
            Last Name:
            <form:input type="text" placeholder="Last name" path="lastname" />
            <br><br>
            Email:
            <form:input type="email" placeholder="Email" path="email" />
            <br><br>
            Date of Birth:
            <form:input type="date" placeholder="Birth Date" path="dateOfBirth" />
            <br><br>
            City:
            <form:input type="text" placeholder="City" path="city" />
            <br><br>
            <input type="submit" value="Submit" />


      </form:form>
    </body>




</html>