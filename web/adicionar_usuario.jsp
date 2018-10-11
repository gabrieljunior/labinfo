<%-- 
    Document   : adicionar_usuario
    Created on : 10/09/2018, 20:33:47
    Author     : Gabriel Júnior
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:include page="header.jsp"/>
    <title>Adicionar Usuário | LabInfo</title>
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
                    <h2>Adicionar Laboratório</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br>
                    <form action="Pagina" id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
                        <input type="hidden" name="page" value="AdicionaUsuario">
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">Nome Completo<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="nome" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nome">SIAPE<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" name="codigo" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Email</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="middle-name" class="form-control col-md-7 col-xs-12" type="email" name="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Senha</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="middle-name" class="form-control col-md-7 col-xs-12" type="password" name="senha">
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button class="btn btn-primary" type="button">Cancelar</button>
                          <button class="btn btn-primary" type="reset">Limpar</button>
                          <input type="submit" class="btn btn-success" value="Salvar"/>
                        </div>
                      </div>
                    </form>
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
