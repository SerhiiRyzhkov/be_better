<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 21.08.2023
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page session="false" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="ru"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Transform Yourself, ​Classes&nbsp;for all levels, ​Formats, ​See more, follow us on, Contact Us">
    <meta name="description" content="">
    <title>BE BETTER</title>
    <link rel="stylesheet" href="<c:url value="/resources/style/statistic-views/statistic/nicepage.css"/>" media="screen">
    <link rel="stylesheet" href="<c:url value="/resources/style/statistic-views/statistic/Main.css"/>" media="screen">
    <script class="u-script" type="text/javascript"
            src="<c:url value="/resources/style/statistic-views/statistic/jquery.js"/>" defer=""></script>
    <script class="u-script" type="text/javascript"
            src="<c:url value="/resources/style/statistic-views/statistic/nicepage.js"/>" defer=""></script>
    <meta name="generator" content="Nicepage 5.0.7, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">



    <script type="application/ld+json">{
        "@context": "http://schema.org",
        "@type": "Organization",
        "name": "",
        "logo": "images/kisspng-whiskers-cat-logo-brand-product-design-animals-wall-decals-cat-wall-decal-ambiance-stic-5b6d5105d1a0b2.3383387515338908218586.png"
    }</script>
    <meta name="theme-color" content="#95ccc3">
    <meta property="og:title" content="Main">
    <meta property="og:type" content="website">
    <c:url var="daysButton" value="/days">
        <c:param name="delta" value="${rangeAtt}"/>
    </c:url>
    <c:url var="monthButton" value="/months">
        <c:param name="delta" value="${rangeAtt}"/>
    </c:url>
    <c:url var="weekButton" value="/weeks">
        <c:param name="delta" value="${rangeAtt}"/>
    </c:url>
    <c:url var="yearsButton" value="/years">
        <c:param name="delta" value="${rangeAtt}"/>
    </c:url>
</head>
<body data-home-page="Main.html" data-home-page-title="Main" class="u-body u-stick-footer u-xl-mode" data-lang="ru">
<body data-home-page="Main.html" data-home-page-title="Main" class="u-body u-stick-footer u-xl-mode" data-lang="ru">
<header class="u-clearfix u-header u-header" id="sec-cdb9">
    <div class="u-clearfix u-sheet u-sheet-1">
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="1200"
           data-image-height="1200">
            <img src="<c:url value="/resources/style/img/kisspng-whiskers-cat-logo-brand-product-design-animals-wall-decals-cat-wall-decal-ambiance-stic-5b6d5105d1a0b2.3383387515338908218586.png"/>"
                 class="u-logo-image u-logo-image-1" style="cursor: pointer" onclick="window.location.href='../../..'">
        </a>
        <h1 class="u-align-center u-text u-text-1" style="cursor: pointer"  onclick="window.location.href='/${urlAtt}?delta=${rangeAtt}'" data-lang-en="Transform Yourself&amp;nbsp;<br>">BE BETTER!<br>
        </h1>






        <nav class="u-menu u-menu-one-level u-menu-1" data-responsive-from="MD" data-position="">
            <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px; font-weight: 700;">
                <a class="u-button-style u-custom-border u-custom-border-color u-custom-borders u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
                   href="#"
                   data-lang-en="{&quot;content&quot;:&quot;<svg class=\&quot;u-svg-link\&quot; viewBox=\&quot;0 0 24 24\&quot;><use xmlns:xlink=\&quot;http://www.w3.org/1999/xlink\&quot; xlink:href=\&quot;#menu-hamburger\&quot;></use></svg><svg class=\&quot;u-svg-content\&quot; version=\&quot;1.1\&quot; id=\&quot;menu-hamburger\&quot; viewBox=\&quot;0 0 16 16\&quot; x=\&quot;0px\&quot; y=\&quot;0px\&quot; xmlns:xlink=\&quot;http://www.w3.org/1999/xlink\&quot; xmlns=\&quot;http://www.w3.org/2000/svg\&quot;>    <g>        <rect y=\&quot;1\&quot; width=\&quot;16\&quot; height=\&quot;2\&quot;></rect>        <rect y=\&quot;7\&quot; width=\&quot;16\&quot; height=\&quot;2\&quot;></rect>        <rect y=\&quot;13\&quot; width=\&quot;16\&quot; height=\&quot;2\&quot;></rect>    </g></svg>&quot;,&quot;href&quot;:&quot;#&quot;}">
                    <svg class="u-svg-link" viewBox="0 0 24 24">
                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use>
                    </svg>
                    <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px"
                         xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
                        <g>
                            <rect y="1" width="16" height="2"></rect>
                            <rect y="7" width="16" height="2"></rect>
                            <rect y="13" width="16" height="2"></rect>
                        </g>
                    </svg>
                </a>
            </div>
            <div class="u-custom-menu u-nav-container">
                <ul class="u-nav u-spacing-20 u-unstyled u-nav-1">
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                            style="padding: 10px 2px;">${emailAtt}</a>
                    </li>
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                            style="padding: 10px 2px; cursor: pointer" onclick="window.location.href='/statistic'">statistic</a>
                    </li>
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base" onclick="window.location.href='/about'"
                            style="padding: 10px 2px; cursor: pointer;">about app</a>
                    </li>
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                            style="padding: 10px 2px; cursor: pointer" onclick="window.location.href='/logoutApp'">logout</a>
                    </li>
                </ul>
            </div>
            <div class="u-custom-menu u-nav-container-collapse">
                <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                    <div class="u-inner-container-layout u-sidenav-overflow">
                        <div class="u-menu-close"></div>
                        <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
                            <li class="u-nav-item"><a class="u-button-style u-nav-link">${emailAtt}</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link">statistic</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link" onclick="window.location.href='/about'" style="cursor: pointer">about app</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link" onclick="window.location.href='/logoutApp'" style="cursor: pointer">logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
            </div>
        </nav>
        <span class="u-custom-item u-file-icon u-icon u-icon-1">
    <a href="https://www.facebook.com/had0uken1992" target="_blank">
        <img src="<c:url value="/resources/style/img/5968764.png"/>" alt="">
    </a>
</span>

        <span class="u-custom-item u-file-icon u-icon u-icon-2">
        <a href="https://www.linkedin.com/in/sryzhkov/" target="_blank">
        <img src="<c:url value="/resources/style/img/145807.png"/>" alt="">
    </a>
    </span>


        <span class="u-custom-item u-file-icon u-icon u-icon-3">
        <a href="mailto:had0uken@ukr.net" target="_blank">
        <img src="<c:url value="/resources/style/img/8862178.png"/>" alt="">
    </a>
    </span>
    </div>
</header>
<section class="u-align-center u-black u-clearfix u-section-1" id="sec-89cd">



    <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-layout-wrap u-layout-wrap-1">
            <div class="u-layout">
                <div class="u-layout-row">
                    <div class="u-container-style u-layout-cell u-size-20 u-layout-cell-1">
                        <div class="u-container-layout u-container-layout-1">
                            <div class="u-custom-color-1 u-preserve-proportions u-shape u-shape-circle u-shape-1 circle"
                                 onmouseover="changeText('YEARS')" onmouseout="resetText()" style="cursor: pointer;"
                                 onclick="window.location.href='${yearsButton}'"></div>
                            <div class="u-custom-color-2 u-preserve-proportions u-shape u-shape-circle u-shape-2 circle"
                                 onmouseover="changeText('MONTHS')" onmouseout="resetText()" style="cursor: pointer;"
                                 onclick="window.location.href='${monthButton}'"></div>
                            <div class="u-palette-4-base u-preserve-proportions u-shape u-shape-circle u-shape-3 circle"
                                 onmouseover="changeText('WEEKS')" onmouseout="resetText()" style="cursor: pointer;"
                                 onclick="window.location.href='${weekButton}'"></div>
                            <div class="u-palette-2-base u-preserve-proportions u-shape u-shape-circle u-shape-4 circle"
                                 onmouseover="changeText('DAYS')" onmouseout="resetText()" style="cursor: pointer;"
                                 onclick="window.location.href='${daysButton}'"></div>
                        </div>
                    </div>
                    <div class="u-container-style u-layout-cell u-size-20 u-layout-cell-2">
                        <div class="u-container-layout u-container-layout-2">
                            <a class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-1"
                               style="cursor: pointer" onclick="window.location.href='/routine?type=DAILY'">CONFIGURE
                                ROUTINE</a>
                            <a class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-2"
                               style="cursor: pointer" onclick="window.location.href='/frequent?type=DAILY'">configure
                                frequent</a>
                            <h2 class="u-text u-text-default u-text-palette-2-dark-1 u-text-1"><p id="shape-text">
                                STATISTIC</p></h2>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <div class="container">
            <form action="showStat" method="post">
                <h1 class="u-align-center u-text u-text-5" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">Start date</h1>
                <input type="date" style="color: black" id="startDate" name="startDate" required >

                <h1 class="u-align-center u-text u-text-7" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">End date</h1>
                <input type="date" style="color: black" id="endDate" name="endDate" required >

                <input type="submit" value="SHOW STATISTIC" class="u-align-left u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-3">
            </form>
        </div>
        <%--<h2 class="u-text u-text-palette-2-dark-1 u-text-4">Fill all the lines</h2>--%>
        <%--<h1 class="u-align-center u-text u-text-5" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">Start date</h1>
        <h1 class="u-align-center u-text u-text-6" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">Start date2</h1>
        <h1 class="u-align-center u-text u-text-7" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">End date</h1>
        <h1 class="u-align-center u-text u-text-8" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">End date2</h1>
        <a href="https://nicepage.com/c/medicine-science-html-templates" class="u-align-left u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-3">show statistic</a>
   --%>

        <p class="u-align-left u-text u-text-9"> Your statistic from ${startDateAtt} to ${endDateAtt}:<br>
            <br>Tasks: ${totalAmountAtt}<br>
            <span class="u-text-custom-color-2">Finished tasks:</span> ${finishedAtt}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ${FinishProcAtt}%<br>
            <span class="u-text-custom-color-1">Failed tasks:</span> ${failedAtt}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;${FailProcAtt}%<br>Points: ${pointsAtt}<br>Your task completion rate is below 30%. Keep up the effort and try to accomplish more tasks next time.
        </p>

    </div>
</section>
<section class="skrollable skrollable-between u-align-center u-black u-clearfix u-section-3" src="" id="sec-c8b7">
    <div class="u-clearfix u-sheet u-valign-middle-sm u-valign-middle-xs u-sheet-1">
        <h1 class="u-align-center u-text u-text-1" data-animation-name="customAnimationIn" data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">BE BETTER!<br>
        </h1>
        <p class="u-align-center u-text u-text-2" data-animation-name="customAnimationIn" data-animation-duration="1000" data-lang-en="​We recruit the smartest, most educated coaches who utilize state-of-the-art equipment and forward thinking methodologies. We coach rather than train. "> No matter who you are, no matter what you did, no matter where you havve come from, you can always change, become a better version of yourself.&nbsp;</p>
        <img class="u-image u-image-circle u-image-1"
             src="<c:url value="/resources/style/img/imgonline-com-ua-Compressed-ZBXfdMoPdP.jpg"/>" alt=""
             data-image-width="1825" data-image-height="2738" data-animation-name="flipIn"
             data-animation-duration="1000" data-animation-direction="X">
    </div>
</section>


<footer class="u-align-center u-black u-clearfix u-footer u-footer" id="sec-44c2"><div class="u-clearfix u-sheet u-sheet-1">
    <h4 class="u-align-center u-text u-text-default-lg u-text-default-md u-text-default-sm u-text-default-xl u-text-1">BE BETTER by Serhii Ryzhkov 2023</h4>
</div></footer>
<script>
    const showButtonF = document.getElementById("freqShowButton");
    const hideButtonF = document.getElementById("closeFreq");
    const hiddenDivF = document.getElementById("FREQ");

    showButtonF.addEventListener("click", () => {
        hiddenDivF.style.display = "block";
    });

    hideButtonF.addEventListener("click", () => {
        hiddenDivF.style.display = "none";
    });
</script>


<script>
    const circles = document.querySelectorAll('.circle');
    const circleTexts = document.querySelectorAll('.circle-text');

    const textMap = ['DAYS', 'WEEKS', 'MONTHS', 'YEARS'];

    circles.forEach((circle, index) => {
        circle.addEventListener('mouseenter', () => {
            circle.style.transform = 'scale(1.1)';
            circleTexts[index].textContent = textMap[index];
            circleTexts[index].style.opacity = 1;
        });

        circle.addEventListener('mouseleave', () => {
            circle.style.transform = 'scale(1)';
            circleTexts[index].textContent = '';
            circleTexts[index].style.opacity = 0;
        });
    });
</script>


<script>
    var defaultText = "STATISTIC";

    function changeText(shape) {
        document.getElementById('shape-text').textContent = shape;
    }

    function resetText() {
        document.getElementById('shape-text').textContent = defaultText;
    }
    window.addEventListener('load', function() {
        document.getElementById('shape-text').textContent = defaultText;
    });
</script>


</body></html>