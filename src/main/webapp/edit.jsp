<%@ page import="classroom.dal.roots.*" %>
<%@ page import="classroom.domain.common.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js">
    </script>
    <link href="home-style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
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
        <a href="list_view_servlet?class=Student">Student</a>
        <a href="list_view_servlet?class=Course">Course</a>
        <a href="list_view_servlet?class=Instructor">Instructors</a>
        <a href="list_view_servlet?class=CourseLike">Course Likes</a>
        <a href="list_view_servlet?class=CourseRegistration">Course Registration</a>
        <a href="list_view_servlet?class=CourseRating">Course Rating</a>
    </div>
    <div>
        <h1 style="text-align: center; font-size: 25px; margin: 1px;"><%=request.getAttribute("class_name") + " Entity"%>
        </h1>
        <%
            BaseEntity entity = (BaseEntity) request.getAttribute("entity");
            List<FieldMetaData> data = FieldMetaDataUtil.createFieldsMetaDataFrom(entity);
            int col = 0;
            int fieldsPerRow = 2;
            for (FieldMetaData field : data)
            {
                if (field.getValue() == null)
                    field.setValue(" ");
        %>
        <div class="field">
            <label class="label" style="margin-right: 25px"><%=field.getFieldName()%> :
            </label>
            <input class="input" value="<%=field.getValue()%>" type="text" style="margin-right: 25px"/>
        </div>
        <%
            col++;
            if (col == fieldsPerRow)
            {%>
        <br/>
        <%
                    col = 0;
                }
            }
        %>
    </div>
</div>
</body>
</html>
