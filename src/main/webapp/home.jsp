<%@ page import="classroom.dal.roots.*" %>
<%@ page import="classroom.domain.common.*" %>
<%@ page import="classroom.util.*" %>
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
    <%
        if (request.getAttribute("class") != null)
        {
    %>
    <div class="limiter">

        <h1 style="text-align: center; font-size: 25px; margin: 1px;"><%=request.getAttribute("class_name") + " Table"%>
        </h1>
        <h1 style="text-align: right; margin-right: 25px"><a
                href="edit?idStr=<%=CommonUtil.createInstanceFrom(request.getAttribute("class")).getId()%>&class=<%=request.getAttribute("class_name")%>">Add</a>
        </h1>
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table">
                    <div class="row header">
                        <% List<TableHeaderMetaData> headers = TableUIUtil.tableHeaders((Class<? extends BaseEntity>) request.getAttribute("class"));
                            for (int i = 0; i < headers.size(); i++)
                            {%>
                        <div class="cell">
                            <%=headers.get(i).getName()%>
                        </div>
                        <%}%>
                        <div class="cell">Actions</div>
                    </div>
                    <% List<? extends BaseEntity> list = (List<? extends BaseEntity>) request.getAttribute("list");
                        for (int i = 0; i < list.size(); i++)
                        {
                            BaseEntity entity = list.get(i);
                            String row_class = "row odd";
                            if (i % 2 == 1)
                                row_class = "row even";
                    %>
                    <div class="<%=row_class%>">
                        <%
                            List<FieldMetaData> fields = FieldMetaDataUtil.createFieldsMetaDataFrom(entity);
                            for (FieldMetaData field : fields)
                            {
                        %>
                        <div class="cell">
                            <%
                                if (field.getFieldName().equals("Code"))
                                {
                            %>
                            <a href="edit?idStr=<%=entity.getId()%>&class=<%=request.getAttribute("class_name")%>">Code</a>
                            <%
                            }
                            else
                            {
                            %>
                            <%= field.getValue()%>
                            <%}%>
                        </div>
                        <% }%>
                        <div class="cell">
                            <a href="delete?id=<%=entity.getId()%>&class=<%=request.getAttribute("class_name")%>">Delete</a>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
    <%}%>
</div>

</body>
</html>
