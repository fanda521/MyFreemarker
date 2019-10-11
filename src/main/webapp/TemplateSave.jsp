<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TemplateSave.jsp</title>
</head>
<style type="text/css">
    *{
        padding: 0;
        margin: 0;
    }
    body{
        margin: 0 auto;
    }
    #all{
        width: 80%;
        margin: 0 auto;
        height: auto;
        border:1px solid blanchedalmond ;


    }
    #nav{
        width: 100%;
        left: 30px;
        right: 30%;
        border:1px solid red ;
    }
    #left{
        float: left;
        height: auto;
        width: 45%;
        text-align:right;
        /*border:1px solid red ;*/
        margin-top: 20px;

    }
    #left p{
        height: 30px;
        line-height: 30px;
        margin-top: 20px;
    }
    #right{
        float: left;
        width: 55%;
        /*border:1px solid yellow;*/
        margin-top: 20px;
        position: relative;

    }

    #right p{
        height: 30px;
        line-height: 30px;
        margin-top: 20px;
    }
    input{
        width: 180px;
        height: 24px;
    }
    #bottom{
        clear: both;
        text-align: center;
    }
    input[type="reset"],input[type="submit"]{
        width: 80px;
        margin: 4px;
        margin-left: 30px;
    }
    #image{
        position: absolute;
        left: 180px;
        top:160px;

    }
</style>
<script type="text/javascript">
    //以后写上传图片预览效果的
    window.onload=function(){
        imageNode=document.getElementById("image");
        fileNode=document.getElementById("file");
    }
    function loadImage(){
        console.log(fileNode)
        var urltext=fileNode.value;
        console.log(urltext);
        imageNode.src=urltext;
    }

</script>
<body>
<div id="all">
    <form action="AddUserDetailServlet" method="post" enctype="multipart/form-data"  id="content">
        <div id="nav">
            <div id="left">
                <p><span>积分：</span></p>
                <p><span>等级：</span></p>
                <p><span>联系方式：</span></p>
                <p><span>上传头像：</span></p>
                <p><span>性别：</span></p>
                <p><span>年龄：</span></p>
            </div>
            <div id="right">
                <p><input type="text" name="score"/></p>
                <p><input type="text" name="rank"/></p>
                <p><input type="text" name="contact"/></p>
                <p><input type="file" name="url" id="file"  onchange="loadImage()"/></p><img src="#" width="60px" height="40px" id="image">
                <p><input type="text" name="sex"/></p>
                <p><input type="text" name="age"/></p>

            </div>
            <div id="bottom">
                <p><input type="reset" /><input type="submit" /></p>
            </div>
        </div>
    </form>
</div>
</body>
</html>