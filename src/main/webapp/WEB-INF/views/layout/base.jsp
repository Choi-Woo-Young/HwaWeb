<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title>NICE</title>
	<meta name="author" content="NICE">
    <tiles:insertAttribute name="header" ignore="true"/>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	
	<tiles:insertAttribute name="navbarTop"  ignore="true"/>
	
	
	<tiles:insertAttribute name="menu"  ignore="true"/>
	
	<div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
			
        </div>
        <div class="content-body"><!-- stats -->
        
        <tiles:insertAttribute name="content"  ignore="true"/>
        
        </div>
      	</div>
	</div>
	
	<!-- <tiles:insertAttribute name="footer"  ignore="true"/> -->
	<tiles:insertAttribute name="bottomJs"  ignore="true"/> 
	

</body>
</html>