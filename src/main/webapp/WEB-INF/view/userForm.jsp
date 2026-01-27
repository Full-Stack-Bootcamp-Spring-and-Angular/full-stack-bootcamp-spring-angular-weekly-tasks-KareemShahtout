<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
         <link
           href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
           rel="stylesheet">

            <style>
                   body {
                       background-color: #f0f0f0;
                       height: 100vh;
                       display: flex;
                       justify-content: center;
                       align-items: center;
                   }

                   .floating-form {
                       background-color: #ffffff;
                       padding: 30px;
                       border-radius: 15px;
                       box-shadow: 0 8px 20px rgba(0,0,0,0.3);
                       width: 350px;
                   }
               </style>
     </head>
    <body >
        <div class="floating-form">
            <form:form action="submitUserData"  modelAttribute="userModel">
                 <h3 class="text-center mb-4">User Form</h3>

                  <div class="mb-3">
                    <label for="firstname" class="form-label">First Name</label>
                    <form:errors path="firstname" cssClass="text-danger"/>
                    <form:input type="text" placeholder="First name" path="firstname" class="form-control mb-3"/>
                  </div>

                  <div class="mb-3">
                    <label for="lastname" class="form-label">Last Name</label>
                    <form:errors path="lastname" cssClass="text-danger"/>
                    <form:input type="text" placeholder="Last name" path="lastname" class="form-control mb-3"/>
                  </div>


                  <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <form:errors path="email" cssClass="text-danger"/>
                    <form:input type="text" placeholder="Email" path="email" class="form-control mb-3"/>
                  </div>

                  <div class="mb-3">
                    <label for="date" class="form-label">Date Of Birth</label>
                    <form:errors path="date" cssClass="text-danger"/>
                    <form:input type="date" placeholder="Date of Birth" path="date" class="form-control mb-3"/>
                  </div>

                  <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <form:errors path="" cssClass="text-danger"/>
                    <form:input type="password" placeholder="Password" path="password" class="form-control mb-3"/>
                  </div>

                  <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <form:errors path="" cssClass="text-danger"/>
                    <form:input type="password" placeholder="Confirm Password" path="confirmPassword" class="form-control mb-3"/>
                  </div>

                  <div class="mb-3">
                    <label for="city" class="form-label">City</label>
                    <form:select path="city" class="form-control mb-3">
                        <form:option value="" label="-- Select City --"/>
                        <form:option value="Rafah" label="Rafah"/>
                        <form:option value="Khan-Yonis" label="Khan-Yonis"/>
                        <form:option value="Dair-Elbalah" label="Dair-Elbalah"/>
                        <form:option value="Nesirat" label="Nesirat"/>
                        <form:option value="Gaza" label="Gaza"/>
                    </form:select>
                  </div>

                   <input type="submit" value="Submit" class="btn btn-primary w-100"/>
            </form:form>
        </div>
    </body>


</html>