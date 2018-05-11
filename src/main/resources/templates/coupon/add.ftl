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
                                    <input class="form-control" id="couponName" name="couponName" maxlength="32">
                                    <p class="help-block">Example block-level help text here.</p>
                                </div>
                                <div class="form-group">
                                    <label>优惠券类型</label>
                                    <select class="form-control" id="couponType" name="couponType">
                                        <option>-- 请选择 --</option>
                                        <option value="1">现金券</option>
                                        <option value="2">折扣券</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>优惠券面值</label>
                                    <input class="form-control" id="parValue" name="parValue" placeholder="正整数">
                                </div>
                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control" rows="3" id="remark" name="remark"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Checkboxes</label>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">Checkbox 1
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">Checkbox 2
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="">Checkbox 3
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Inline Checkboxes</label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox">1
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox">2
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox">3
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Radio Buttons</label>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio 1
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Radio 2
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">Radio 3
                                        </label>
                                    </div>
                                </div>
                                <#--<div class="form-group">
                                    <label>Inline Radio Buttons</label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>1
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">2
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="option3">3
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Selects</label>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Multiple Selects</label>
                                    <select multiple class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>-->
                                <button type="submit" class="btn btn-primary">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>
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
        $(function() {
            $("#couponForm").validate({
                rules: {

                },
                submitHandler: function () {
                    var data = {
                       merchantId: 123,
                        couponName: "哈哈哈",
                        couponType: 1,
                        parValue: 100,
                        quantity: 1000,
                        releaseStartTime: "2018-04-25 00:00:00",
                        releaseEndTime: "2018-04-21 23:59:59",
                        validityMode: 2
                    };
                    $.post("/coupon/save.json", data, function(res) {
                        console.log(res);
                        if (res.code == 200) {
                            alert(res.msg);
                        }else {
                            alert(res.msg);
                        }
                    });
                }
            });
        });
    </script>
</body>
</html>