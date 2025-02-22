<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Course-create</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- ElegantFonts CSS -->
    <link rel="stylesheet" href="css/elegant-fonts.css">

    <!-- themify-icons CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#course-img").change(function () {
                var fil = this.files;
                console.log(fil.length);
                for (var i = 0; i < fil.length; i++) {
                    console.log(fil[i]);
                    console.log('--------------------------');
                    reads(fil[i]);
                }
            });
        });

        function reads(fil){
            var reader = new FileReader();
            reader.readAsDataURL(fil);
            reader.onload = function(){
                $('#cou-img').attr('src',reader.result);
            };
        }
    </script>
</head>

<body>
<div class="hero-content">
    <header class="site-header">

        <%@ include file="header.jsp" %>

        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-9 col-lg-3">
                        <div class="site-branding">
                            <h1 class="site-title"><a href="index.jsp" rel="home">Sdr<span>b</span></a></h1>
                        </div><!-- .site-branding -->
                    </div><!-- .col -->

                    <div class="col-3 col-lg-9 flex justify-content-end align-content-center">
                        <nav class="site-navigation flex justify-content-end align-items-center">
                            <ul class="flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                                <li class="current-menu-item"><a href="index">Home</a></li>
                                <li><a href="about">About</a></li>
                                <li><a href="allCourses">Courses</a></li>
                                <li><a href="https://weibo.com/u/5966988917?is_all=1">weibo</a></li>
                            </ul>

                            <div class="hamburger-menu d-lg-none">
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </div><!-- .hamburger-menu -->

                            <div class="header-bar-cart">
                                <a href="#" class="flex justify-content-center align-items-center"><span aria-hidden="true" class="icon_bag_alt"></span></a>
                            </div><!-- .header-bar-search -->
                        </nav><!-- .site-navigation -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .nav-bar -->
    </header><!-- .site-header -->

    <div class="hero-content-overlay">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="hero-content-wrap flex flex-column justify-content-center align-items-start">
                        <div class="form-group">
                            <h1 class="col-sm-12 control">创建课程</h1>
                        </div>
                        <form action="createCourse?teacher_id=${sessionScope.user.userId}" method="post" enctype="multipart/form-data" style='background-color: white' class="form-horizontal col-sm-10" role="form">
						    <div class="form-group">
							    <label class="col-sm-4 control-label" style="padding-top: 15px">课程封面</label>
							    <div class="col-sm-4">
								    <input type="file" name="courseImageFile" id="course-img"/>
							    </div>
						    </div>
                            <div class="form-group">
                               <img id="cou-img" src="#" class="col-sm-2">
                            </div>
						    <div class="form-group">
							    <label class="col-sm-4 control-label">课程名称(20个字符以内)</label>
							    <div class="col-sm-8">
								    <input type="text" name="courseName" minlength="1" maxlength="20" class="form-control" placeholder="请输入课程名称">
							    </div>
						    </div>
						    <div class="form-group">
							    <label class="col-sm-4 control-label">授课教师(20个字符以内)</label>
							    <div class="col-sm-8">
								    <input type="text" name="courseTeacher" minlength="1" maxlength="20" class="form-control" placeholder="请输入授课教师姓名">
							    </div>
						    </div>
						    <div class="form-group">
							    <label class="col-sm-4 control-label">课程介绍(200个字符以内)</label>
							    <div class="col-sm-8">
								    <textarea row='5' name="courseIntro" minlength="1" maxlength="200" class="form-control" placeholder="请输入课程介绍"></textarea>
						    	</div>
						    </div>
						    <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
								    <button class='col-sm-2' type="submit" class="btn btn-default" style="background-color: #19c880; color: white;">申请创建</button>
								    <button class='col-sm-2' type="reset" class="btn btn-default" style="background-color: white; color: #19c880">重置</button>
							    </div>
						    </div>
					    </form>
                    </div>
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .hero-content-hero-content-overlay -->
</div><!-- .hero-content -->


    <%@ include file="footer.jsp" %>

<script type='text/javascript' src='js/jquery.js'></script>
<script type='text/javascript' src='js/swiper.min.js'></script>
<script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
<script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
<script type='text/javascript' src='js/custom.js'></script>

</body>
</html>