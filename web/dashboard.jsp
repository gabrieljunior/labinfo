<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:include page="header.jsp"/>
    <title>Dashboard | LabInfo</title>
  </head>
  
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>LabInfo</span></a>
            </div> 
            <jsp:include page="sidebar.jsp"/>
          </div>
        </div>
        <jsp:include page="top_navigation.jsp"/>
        <jsp:include page="footer_logouf.jsp"/>
        <div class="right_col" role="main" style="min-height: 3722px;">
          <div class="">
            <div class="page-title">
              <div class="title_left">
              </div>
            </div>
            <div class="clearfix"></div>
            <div class="row">
              <div class="col-md-8 col-sm-8 col-xs-8">
                 <div class="x_panel">
                  <div class="x_title">
                    <h2>Dashboard</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br>
                  </div>
                </div>
              </div>
            </div>
           </div>
          </div>
        <jsp:include page="footer.jsp"/>
      </div>
    </div>
    <jsp:include page="imports_js.jsp"/>
  </body>
</html>
