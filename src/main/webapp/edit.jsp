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
        <a href="listView?class=Student">Student</a>
        <a href="listView?class=Course">Course</a>
        <a href="listView?class=Instructor">Instructors</a>
        <a href="listView?class=CourseLike">Course Likes</a>
        <a href="listView?class=CourseRegistration">Course Registration</a>
        <a href="listView?class=CourseRating">Course Rating</a>
    </div>
    <div>
        <h1 style="text-align: center; font-size: 25px; margin: 1px;"><%=request.getAttribute("class_name") + " Entity"%>
            <% request.getSession().setAttribute("class", request.getParameter("class"));%>
            <% request.getSession().setAttribute("idStr", request.getParameter("idStr"));%>
        </h1>
        <form action="add">
            <%
                BaseEntity entity = (BaseEntity) request.getAttribute("entity");
                List<FieldMetaData> data = FieldMetaDataUtil.createFieldsMetaDataFrom(entity);
                int col = 0;
                session.setAttribute("entity", request.getAttribute("entity"));
                int fieldsPerRow = 2;
                List<String> filedNames = new ArrayList<>();
                for (FieldMetaData field : data)
                {
                    filedNames.add(field.getFieldName());
                    if (field.getValue() == null)
                        field.setValue(" ");
            %>
            <div class="field">
                <label class="label" id="fieldName" for="fieldName" style="margin-right: 25px">
                    <%=field.getFieldName()%> :
                </label>
                <input class="input" name="fieldValue" value="<%=field.getValue()%>" type="text"/>
            </div>
            <%
                col++;
                if (col == fieldsPerRow)
                {
            %>
            <br/>
            <%
                        col = 0;
                    }
                }
                request.getSession().setAttribute("fieldNames", filedNames);
            %>
            <input style="font-size: 25px; color: lightseagreen;margin-left: 33px;padding: 5px;" type="submit"
                   value="Save"/>
        </form>
    </div>
</div>
</body>
</html>
