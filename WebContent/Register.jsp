<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Register Any Type of User Here

<form name="Register" action="RequestManager" method="post">
	<TABLE  WIDTH="100%">
                <tr width="100%">
                    <td >First Name :</td>
					<td> <input type="text" id="userFirstName" name="firstname"/> </td>
				</tr>
				 <tr width="100%">
                    <td >Last Name :</td>
					<td> <input type="text" id="userLastName" name="lastname"/> </td>
				</tr>
				<tr>
					<td >Email :</td>
					<td> <input type="text" id="email" name="email"/> </td>
				</tr>
				<tr>
					<td >Password :</td>
					<td> <input type="password" id="passWord" name="passWord"/> </td>
				</tr>
				<tr>
					<td >Address :</td>
					<td> <input type="text" id="address" name="address"/> </td>
				</tr>
				<tr>
					<td >City :</td>
					<td> <input type="text" id="city" name="city"/> </td>
				</tr>
				<tr>
					<td >State :</td>
					<td> <input type="text" id="state" name="state"/> </td>
				</tr>
				<tr>
					<td >Zipcode :</td>
					<td> <input type="text" id="zipcode" name="zipcode"/> </td>
				</tr>
				<tr> 
					<td>Usertype :</td>
					<td> <input type="radio"  name="module" value="supplier"> Supplier </input> </td>
					<td> <input type="radio"  name="module" value="customer"> Customer </input> </td>
					<td> <input type="radio"  name="module" value="administrator"> Administrator </input> </td>
				</tr>
				<tr> 
					<td> <input type="submit" id="registersubmit" name="registerSubmit" value="Register"/> </td>
					<td> <input type="reset" name="reset" value="Clear"/> <input type="hidden" name="service" value="Authentication"/>
					 <input type="hidden" name="feature" value="register"/></td>
				</tr>
				
	</TABLE>
			
</form>
</body>
</html>