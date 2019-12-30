<%
    Class<? extends BaseEntity> klass = (Class<? extends BaseEntity>) request.getAttribute("class");
    if (klass == null)
        request.setAttribute("class", Course.class);
%>
<jsp:include page="/list_view_servlet"/>
<%@ page import="classroom.dal.entities.*" %>
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
<form action="${pageContext.request.contextPath}/list_view_servlet" method="post">
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
            <input class="menu_btn" type="submit" value="Student" name="class"/>
            <input class="menu_btn" type="submit" value="Course" name="class"/>
            <input class="menu_btn" type="submit" value="Instructor" name="class"/>
            <input class="menu_btn" type="submit" value="CourseLike" name="class"/>
            <input class="menu_btn" type="submit" value="CourseRegistration" name="class"/>
            <input class="menu_btn" type="submit" value="CourseRating" name="class"/>
        </div>
        <div class="limiter">

            <h1 style="text-align: center; font-size: 25px; margin: 1px;"><%=request.getAttribute("class_name") + " Table"%>
            </h1>
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table">
                        <div class="row header">
                            <% List<TableHeaderMetaData> headers = TableUIUtil
                                    .tableHeaders((Class<? extends BaseEntity>) request.getAttribute("class"));
                                for (int i = 0; i < headers.size(); i++)
                                {%>
                            <div class="cell">
                                <%=headers.get(i).getName()%>
                            </div>
                            <%}%>
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
                                <%= field.getValue()%>
                            </div>
                            <% }%>
                        </div>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
