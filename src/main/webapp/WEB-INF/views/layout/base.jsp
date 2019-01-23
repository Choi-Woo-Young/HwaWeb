<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title>NICE�˸���</title>
	<meta name="author" content="NICE">
    <tiles:insertAttribute name="header" />
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	
	<tiles:insertAttribute name="navbarTop" />
	
	<tiles:insertAttribute name="menu" />
	
	<div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
			
        </div>
        <div class="content-body"><!-- stats -->
        
        <tiles:insertAttribute name="content" />
        
        </div>
      	</div>
	</div>
	
	<!-- <tiles:insertAttribute name="footer" /> -->
	<!-- <tiles:insertAttribute name="bottomJs" /> -->
	

</body>
</html>