<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row match-height">
    <div class="col-xl-12 col-lg-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">공지사항 수정</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body  collapse in">
            	<div class="card-block">  
                	<form class="form" action="<c:url value="/notices/modNotice" />" method="post">
                		<fmt:parseNumber var= "noticeId" integerOnly= "true" value= "${notice.noticeId}" />
                		<input type="hidden" id="noticeId" name="noticeId" value="${noticeId}"/>
						<div class="form-body">
							<div class="col-md-8">
								<label for="noticeTitle">제목</label>
								<input type="text" id="noticeTitle" class="form-control" placeholder="공지사항 내용" name="noticeTitle" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="공지사항 내용" value="${notice.noticeTitle}"> 
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="projectinput5">알림 대상</label>
									<select id="pushTargetCd" name="pushTargetCd" class="form-control">
										<option value="110030" <c:if test="${notice.pushTargetCd == '110030' }"> selected="110030" </c:if>>알림없음</option>
										<option value="110020" <c:if test="${notice.pushTargetCd == '110020' }"> selected="110030" </c:if>>IT</option>
										<option value="110010" <c:if test="${notice.pushTargetCd == '110010' }"> selected="110030" </c:if>>전체</option>									
									</select>
								</div>
							</div>
							<div class="col-md-12">
								<label for="noticeCont">내용</label>
								<textarea id="noticeCont" rows="15" class="form-control" name="noticeCont" placeholder="공지사항 내용" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="공지사항 내용">${notice.noticeCont}</textarea>
							</div>
						</div>							
						<div class="form-actions float-xs-right" style="border-top: 0px solid #dadada;">
							<a href="/spring-mvc-showcase/notices/noticeList"><button type="button" class="btn btn-warning mr-1">	<i class="icon-cross2"></i> 취소</button></a>
							<button type="submit" class="btn btn-primary">	<i class="icon-check2"></i>수정 </button>
						</div>
					</form>
                </div>
            </div>
        </div>
    </div>
</div>
