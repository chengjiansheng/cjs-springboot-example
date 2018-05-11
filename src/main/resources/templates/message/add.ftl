<!DOCTYPE html>
<html lang="zh">
<head>
    <title>优惠券添加</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="/sb-admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/sb-admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/sb-admin/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/sb-admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">添加优惠券</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Basic Form Elements
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" id="couponForm" method="post">
                                <div class="form-group">
                                    <label>优惠券名称</label>
                                    <input class="form-control" id="messageContent" name="messageContent">
                                </div>
                                <button type="button" class="btn btn-primary" onclick="sendMsg();">Send Button</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="/sb-admin/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/sb-admin/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/sb-admin/vendor/metisMenu/metisMenu.min.js"></script>
    <script type="text/javascript" src="/sb-admin/dist/js/sb-admin-2.js"></script>
    <script type="text/javascript" src="/plugins/jquery-validation-1.17.0/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-validation-1.17.0/dist/localization/messages_zh.js"></script>

    <script type="text/javascript">
        function sendMsg() {
            $.post("/message/send.json", {text: $("#messageContent").val()}, function(res) {
                console.log(res);
            });
        }
    </script>
</body>
</html>