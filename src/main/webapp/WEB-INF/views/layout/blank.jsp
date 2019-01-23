<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title>NICE¾Ë¸®¹Ì</title>
	<meta name="author" content="NICE">
    <tiles:insertAttribute name="header" />
</head>
	<div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
			
        </div>
        <div class="content-body"><!-- stats -->
        
        <tiles:insertAttribute name="content" />
        
        </div>
      	</div>
	</div>

</body>
</html>