<%@ page import="classroom.dal.entities.*" %>
<%@ page import="classroom.domain.common.*" %>
<%@ page import="classroom.domain.test.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! BusinessLogicCore core; %>
<%
    List<Student> allStudents = new ArrayList<>();
    try
    {
        core = BusinessLogicCore.get();
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="add-style/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="add-style/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="add-style/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="add-style/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="add-style/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="add-style/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="add-style/css/util.css">
    <link rel="stylesheet" type="text/css" href="add-style/css/main.css">
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
<div class="limiter">
    <h1 style="text-align: center; font-size: 25px; margin: 20px;">Student Table</h1>
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table">
                <div class="row header">
                    <% for (int i = 0; i < TableUIUtil.tableHeaders(Student.class).size(); i++)
                    {%>
                    <div class="cell">
                        <%=TableUIUtil.tableHeaders(Student.class).get(i).getName()%>
                    </div>
                    <%}%>
                </div>
                <% for (Student allStudent : allStudents)
                {%>
                <div class="row">
                    <%
                        List<FieldMetaData> fields = FieldMetaDataUtil.createFieldsMetaDataFrom(allStudent);
                        for (FieldMetaData field : fields)
                        {
                    %>
                    <div class="cell">
                        <%= field.getValue()%>
                    </div>
                    <%}%>
                </div>
                <%}%>
            </div>
        </div>
    </div>
</div>
</body>
</html>