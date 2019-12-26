<%@ page import="classroom.dal.entities.*" %>
<%@ page import="classroom.domain.test.*" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: MOSTAFA
  Date: 12/17/2019
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! BusinessLogicCore core; %>
<%
    List<Student> allStudents = new ArrayList<>();
    try
    {
        core = new BusinessLogicCore<>();
        allStudents = core.findAll(Student.class);
        for (Student student : allStudents)
            student.getName1();

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
%>


<html>
<head>
    <title>Home Page</title>
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js">
    </script>
    <link href="home-style.css" rel="stylesheet" type="text/css">
    <script>
        function openSlideMenu() {
            document.getElementById("menu").style.width = '250px';
            document.getElementById('content').style.marginLeft = '250px';
        }

        function closeSlideMenu() {
            document.getElementById("menu").style.width = '0px';
            document.getElementById('content').style.marginLeft = '0px';
        }
    </script>
</head>
<body>
<div id="content">

    <span class="slide">
        <a href="#" onclick="openSlideMenu()">
            <i class="fas fa-bars"></i>
        </a>
    </span>

    <div id="menu" class="nav">
        <a href="#" class="close" onclick="closeSlideMenu()">
            <i class="fas fa-times"></i>
        </a>
        <a href="#">Student</a>
        <a href="#">Course</a>
        <a href="#">Instructors</a>
        <a href="#">Course Likes</a>
        <a href="#">Course Registration</a>
        <a href="#">Course Rating</a>
    </div>

    <h1>Welcome to our Classroom - Home Page Content - (Responsive - ya hoda)</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <%
            for (Student student : allStudents)
            {
        %>
        <tr>
            <td><%= student.getId()%>
            </td>
            <td><%= student.getName1()%>
            </td>
            <td>
                <%= student.getEmail()%>
                <% System.out.println();%>
            </td>
        </tr>

        <%
            }
        %>
    </table>
    <%--    <a href="addStudent.html"></a>--%>
</div>

</body>
</html>
