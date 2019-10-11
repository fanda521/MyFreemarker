<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>course.jsp</title>
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
    .hobby{
        width: 24px;
        height: 14px;
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
    <form action="CourseServlet" method="post"   id="content">
        <div id="nav">
            <div id="left">
                <p><span>:</span></p>
                <p><span>:</span></p>
            </div>
            <div id="right">
                <p><input type="text" name="courseId"/></p>
                <p><input type="text" name="courseName"/></p>
            </div>
            <div id="bottom">
                <p><input type="reset" /><input type="submit" /></p>
            </div>
        </div>
    </form>
</div>
</body>
</html>