<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><g:message code="springSecurity.login.title"/></title>
<link rel="icon" type="image/x-ico" href="${resource(dir: 'images', file: 'favicon.ico')}" />
<!-- Bootstrap -->
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'animate.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-checkbox.css')}" type="text/css">
 <link rel="stylesheet" href="${resource(dir: 'css', file: 'webkiosk.css')}" type="text/css">

</head>
<body class="brownish-scheme">

    <!-- Preloader -->
<div class="mask"><div id="loader"></div></div>
<!--/Preloader -->

<!-- Wrap all page content here -->
<div id="wrap">




    <!-- Make page fluid -->
    <div class="row">






        <!-- Page content -->
        <div id="content" class="col-md-12 full-page login">

            <div class="welcome">
                <g:img uri="/images/logo-big.png" class="logo"/>
                <h1><strong>Webkiosk</strong></h1>
                <h5>student online portal</h5>


                <g:if test='${flash.message}'>
                    <section>
                        <div class="error-msg-login">
                            <span style="color:#f5f5f5">${flash.message}</span>
                        </div>
                    </section>
                </g:if>




                <form id="form-signin" class="form-signin" action='${postUrl}' method='POST' autocomplete='off'>
                    <section>
                        <div class="input-group">
                            <input type='text' class="form-control" name='j_username' id='username' value="Username"/>
                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                        </div>

                        <div class="input-group">
                            <input type='password' class='form-control' name='j_password' id='password' value="Password"/>
                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                        </div>
                    </section>

                    <section class="controls">
                        <div class="checkbox check-transparent">
                            <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                            <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
                        </div>
                        <g:link action="" class="pull-right">Forget password ?</g:link>
                    </section>

                    <section class="new-acc">
                        <button class="btn btn-greensea">Create an account</button>
                    </section>
                </form>
            </div>



            <g:link href="index.html" class="log-in">Log In<i class="fa fa-arrow-right fa-5x"></i></g:link>



        </div>
        <!-- Page content end -->






    </div>
    <!-- Make page fluid-->




</div>
<!-- Wrap all page content end -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
<script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js?lang=css&amp;skin=sons-of-obsidian"></script>
<script src="../js/plugins/jquery.nicescroll.min.js"></script>
<script src="../js/plugins/blockui/jquery.blockUI.js"></script>
<script src="../js/webkiosk.min.js"></script>

<script>
    $(function(){

        $('.welcome').addClass('animated bounceIn');

    })

</script>
</body>
</html>
