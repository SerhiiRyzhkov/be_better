<%--
  Created by IntelliJ IDEA.
  User: serhii.ryzhkov
  Date: 17.08.2023
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page session="false" %>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="ru">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords"
          content="Transform Yourself, Classes&nbsp;for all levels, Formats, See more, follow us on, Contact Us">
    <meta name="description" content="">
    <title>BE BETTER</title>
    <link rel="stylesheet" href="<c:url value="/resources/style/scale-views/tasks-view/nicepage.css"/>" media="screen">
    <link rel="stylesheet" href="<c:url value="/resources/style/scale-views/tasks-view/Main.css"/>" media="screen">
    <script class="u-script" type="text/javascript"
            src="<c:url value="/resources/style/scale-views/tasks-view/jquery.js"/>" defer=""></script>
    <script class="u-script" type="text/javascript"
            src="<c:url value="/resources/style/scale-views/tasks-view/nicepage.js"/>" defer=""></script>
    <meta name="generator" content="Nicepage 5.0.7, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">


    <script type="application/ld+json">{
        "@context": "http://schema.org",
        "@type": "Organization",
        "name": "",
        "logo": "<c:url
            value="/resources/style/img/kisspng-whiskers-cat-logo-brand-product-design-animals-wall-decals-cat-wall-decal-ambiance-stic-5b6d5105d1a0b2.3383387515338908218586.png"/>"
    }
    </script>
    <meta name="theme-color" content="#95ccc3">
    <meta property="og:title" content="Main">
    <meta property="og:type" content="website">
</head>
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
                            style="padding: 10px 2px;">user@ukr.net</a>
                    </li>
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                            style="padding: 10px 2px; cursor: pointer" onclick="window.location.href='/statistic'">statistic</a>
                    </li>
                    <li class="u-nav-item"><a
                                              class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                                              style="padding: 10px 2px; cursor: pointer;">about app</a>
                    </li>
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-2-base u-text-grey-90 u-text-hover-palette-2-base"
                            style="padding: 10px 2px;" onclick="window.location.href='/logout'">logout</a>
                    </li>
                </ul>
            </div>
            <div class="u-custom-menu u-nav-container-collapse">
                <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                    <div class="u-inner-container-layout u-sidenav-overflow">
                        <div class="u-menu-close"></div>
                        <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
                            <li class="u-nav-item"><a class="u-button-style u-nav-link">user@ukr.net</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link">statistic</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link">about app</a>
                            </li>
                            <li class="u-nav-item"><a class="u-button-style u-nav-link" onclick="window.location.href='/logout'" style="cursor: pointer">logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
            </div>
        </nav>
        <span class="u-custom-item u-file-icon u-icon u-icon-1"><img
                src="<c:url value="/resources/style/img/5968764.png"/>" alt=""></span><span
            class="u-custom-item u-file-icon u-icon u-icon-2"><img
            src="<c:url value="/resources/style/img/145807.png"/>" alt=""></span><span
            class="u-custom-item u-file-icon u-icon u-icon-3"><img
            src="<c:url value="/resources/style/img/8862178.png"/>" alt=""></span>
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
                                ${scaleAtt}</p></h2>
                        </div>
                    </div>
                    <div class="u-container-style u-layout-cell u-size-20 u-layout-cell-3">
                        <div class="u-container-layout u-container-layout-3"><span
                                class="u-file-icon u-icon u-icon-1"><img
                                src="<c:url value="/resources/style/img/5629216.png"/>" alt=""></span>
                            <h4 class="u-align-center u-text u-text-2">Your score this<br>${typeAtt}
                            </h4>
                            <h4 class="u-align-center u-text u-text-3">${pointsAtt}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>





        <div class="u-expanded-width u-layout-horizontal u-list u-list-1">


            <div class="u-repeater u-repeater-1">


                <c:forEach var="d" items="${datesListAtt}" varStatus="loop">
                    <c:choose>
                        <c:when test="${actualDateAtt==d.key}">

                            <c:if test="${loop.index == rangeAtt}">
                                <div class="u-align-center u-container-style u-list-item u-repeater-item"
                                     onclick="window.location.href='${urlAtt}?delta=${loop.index}'">
                                    <div class="u-container-layout u-similar-container u-container-layout-4">
                                        <h4 class="u-text u-text-palette-4-base u-text-4" style="cursor: pointer"><a
                                                style="color: yellow">${d.value}</a>
                                        </h4>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${loop.index != rangeAtt}">
                                <div class="u-align-center u-container-style u-list-item u-repeater-item"
                                     onclick="window.location.href='${urlAtt}?delta=${loop.index}'">
                                    <div class="u-container-layout u-similar-container u-container-layout-4">
                                        <p class="u-text u-text-palette-4-base u-text-5" style="cursor: pointer"><a
                                                style="color: yellow">${d.value}</a></p>
                                    </div>
                                </div>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${loop.index == rangeAtt}">
                                <div class="u-align-center u-container-style u-list-item u-repeater-item"
                                     onclick="window.location.href='${urlAtt}?delta=${loop.index}'">
                                    <div class="u-container-layout u-similar-container u-container-layout-4">
                                        <h4 class="u-text u-text-palette-4-base u-text-4"
                                            style="cursor: pointer">${d.value}
                                        </h4>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${loop.index != rangeAtt}">
                                <div class="u-align-center u-container-style u-list-item u-repeater-item"
                                     onclick="window.location.href='${urlAtt}?delta=${loop.index}'">
                                    <div class="u-container-layout u-similar-container u-container-layout-4">
                                        <p class="u-text u-text-palette-4-base u-text-5"
                                           style="cursor: pointer">${d.value}</p>
                                    </div>
                                </div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>


            </div>
            <a class="u-absolute-vcenter u-gallery-nav u-gallery-nav-prev u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-1"
               href="#" role="button">
            <span aria-hidden="true">
              <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
            </span>
                <span class="sr-only">
              <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
            </span>
            </a>
            <a class="u-absolute-vcenter u-gallery-nav u-gallery-nav-next u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-2"
               href="#" role="button">
            <span aria-hidden="true">
              <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
            </span>
                <span class="sr-only">
              <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
            </span>
            </a>
        </div>


        <a class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-3"
           onclick="window.location.href='setToday${prefixAtt}'">set today</a>


        <c:forEach var="t" items="${toDoAtt}" varStatus="loop">
            <c:url var="completeButton" value="/complete${prefixAtt}">
                <c:param name="index" value="${loop.index}"/>
            </c:url>
            <c:url var="deleteButton" value="/delete${prefixAtt}">
                <c:param name="index" value="${loop.index}"/>
            </c:url>
            <c:url var="transferButton" value="/transfer${prefixAtt}">
                <c:param name="index" value="${loop.index}"/>
            </c:url>

            <div class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-2">
                <div class="u-layout">
                    <div class="u-layout-row">


                        <div class="u-container-style u-layout-cell u-size-15 u-layout-cell-4">
                            <div class="u-container-layout u-valign-middle u-container-layout-11">
                                <h6 class="u-text u-text-18"><p title="${t.description}">${t.title}</p></h6>
                                <c:if test="${showRangeAtt}">
                                    <form oninput="result.value = slider.value" action="/postRange${prefixAtt}" method="post" >
                                        <div class="slidecontainer">


                                            <input type="range" min="0" max="${t.total}" value="${t.score}" id="slider" name="sliderValue">
                                            The val: <output name="result" for="slider">${t.score}</output>


                                        </div>
                                        <input type="hidden" name="task_index" value="${loop.index}">
                                        <button type="submit" class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-16">Set progress</button>
                                    </form>
                                </c:if>



                            </div>
                        </div>

                        <div class="u-container-style u-layout-cell u-size-15 u-layout-cell-5">
                            <div class="u-container-layout u-container-layout-12">
                                <a onclick="window.location.href='${completeButton}'" value="${loop.index}"
                                   style="cursor: pointer"
                                   class="u-border-active-palette-4-light-2 u-border-hover-black u-border-none u-btn u-button-style u-hover-palette-4-base u-none u-text-hover-black u-text-palette-2-base u-btn-4">
                                    <c:if test="${t.status == 'FAILED'}">
                                        <p style="color: red"> ${t.status} </p>
                                    </c:if>


                                    <c:if test="${t.status == 'FINISHED'}">
                                        <p style="color: #06e800"> ${t.status} </p>
                                    </c:if>

                                    <c:if test="${t.status == 'IN_PLAN'}">
                                        <p> ${t.status} </p>
                                    </c:if>

                                    <c:if test="${t.status == 'IN_PROCESS'}">
                                        <p> ${t.status} </p>
                                    </c:if>

                                </a>
                            </div>
                        </div>


                        <div class="u-container-style u-layout-cell u-size-15 u-layout-cell-6" style="margin-top: 15px">
                            <div class="u-container-layout u-container-layout-13">
                                <a onclick="window.location.href='${deleteButton}'" value="${loop.index}"
                                   value="${loop.index}" style="cursor: pointer"
                                   class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-5">DELETE</a>
                            </div>
                        </div>


                        <c:if test="${t.status == 'FAILED'}">
                            <div class="u-container-style u-layout-cell u-size-15 u-layout-cell-7">
                                <div class="u-container-layout u-container-layout-14">
                                    <a onclick="window.location.href='${transferButton}'" style="cursor: pointer"
                                       class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-6">to
                                        the next ${typeAtt}</a>
                                </div>
                            </div>
                        </c:if>

                    </div>
                </div>
            </div>
        </c:forEach>


        <div class="u-repeater u-repeater-2">
            <div class="u-container-style u-list-item u-repeater-item">
                <div class="u-container-layout u-similar-container u-container-layout-27">
                    <a onclick="window.location.href='addingNewTask${prefixAtt}'"
                       class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-16">add
                        new task</a>
                </div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
                <div class="u-container-layout u-similar-container u-container-layout-28">
                    <a onclick="window.location.href='setRoutine${prefixAtt}'"
                       class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-17">set
                        routine tasks</a>
                </div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
                <div class="u-container-layout u-similar-container u-container-layout-29">
                    <a id="freqShowButton"
                       class="u-border-2 u-border-active-palette-4-light-2 u-border-hover-black u-border-palette-4-base u-btn u-btn-round u-button-style u-custom-item u-hover-palette-4-base u-none u-radius-50 u-text-hover-black u-btn-18">frequent
                        tasks</a>
                </div>
            </div>
        </div>





        <div id="FREQ" style="display: none;">
            <div class="u-container-style u-group u-palette-4-base u-radius-12 u-shape-round u-group-2">
                <div class="u-container-layout u-container-layout-31"><span
                        class="u-file-icon u-icon u-icon-rectangle u-text-white u-icon-3"><img
                        id="closeFreq" style="cursor: pointer;"
                        src="<c:url value="/resources/style/img/10335950-65ad2489.png"/>"
                        src="<c:url value="/resources/style/img/10335950-65ad2489.png"/>" alt=""></span>
                    <ul class="u-custom-list u-text u-text-default u-text-23">


                        <c:forEach var="t" items="${frequentlyAtt}" varStatus="loop">
                            <c:url var="addFreqButton" value="/addFrequentlyToday${prefixAtt}">
                                <c:param name="index" value="${loop.index}"/>
                            </c:url>


                            <li onclick="window.location.href='${addFreqButton}'" value="${loop.index}" style="cursor: pointer">
                                <div class="u-list-icon u-text-palette-2-base" >
                                    <svg class="u-svg-content" viewBox="0 0 512.019 512.019" x="0px" y="0px"
                                         id="svg-dd96" style="enable-background:new 0 0 512.019 512.019;">
                                        <path fill="currentColor"
                                              d="M362.676,0H149.343C119.888,0,96.01,23.878,96.01,53.333v448 c-0.011,5.891,4.757,10.675,10.648,10.686c2.84,0.005,5.565-1.123,7.571-3.134L256.01,367.083l141.781,141.781 c4.16,4.171,10.914,4.179,15.085,0.019c2.006-2.001,3.133-4.717,3.134-7.55v-448C416.01,23.878,392.131,0,362.676,0z"></path>
                                    </svg>
                                </div>
                                    ${t.title}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>


    </div>
    </div>
    </div>
    </div>
</section>
<section class="skrollable skrollable-between u-align-center u-black u-clearfix u-section-2" src="" id="sec-c8b7">
    <div class="u-clearfix u-sheet u-valign-middle-sm u-valign-middle-xs u-sheet-1">
        <h1 class="u-align-center u-text u-text-1" data-animation-name="customAnimationIn"
            data-animation-duration="1000" data-animation-delay="500" data-lang-en="Transform Yourself&amp;nbsp;<br>">BE
            BETTER!<br>
        </h1>
        <p class="u-align-center u-text u-text-2" data-animation-name="customAnimationIn" data-animation-duration="1000"
           data-lang-en="We recruit the smartest, most educated coaches who utilize state-of-the-art equipment and forward thinking methodologies. We coach rather than train. ">
            No matter who you are, no matter what you did, no matter where you’ve come from, you can always change,
            become a better version of yourself.&nbsp;</p>
        <img class="u-image u-image-circle u-image-1"
             src="<c:url value="/resources/style/img/imgonline-com-ua-Compressed-ZBXfdMoPdP.jpg"/>" alt=""
             data-image-width="1825" data-image-height="2738" data-animation-name="flipIn"
             data-animation-duration="1000" data-animation-direction="X">
    </div>
</section>


<footer class="u-align-center u-black u-clearfix u-footer u-footer" id="sec-44c2">
    <div class="u-clearfix u-sheet u-sheet-1">
        <h4 class="u-align-center u-text u-text-default-lg u-text-default-md u-text-default-sm u-text-default-xl u-text-1">
            BE BETTER by Serhii Ryzhkov 2023</h4>
    </div>
</footer>

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
    var defaultText = "${scaleAtt}";

    function changeText(shape) {
        document.getElementById('shape-text').textContent = shape;
    }

    function resetText() {
        document.getElementById('shape-text').textContent = defaultText;
    }

</script>

</body>
</html>