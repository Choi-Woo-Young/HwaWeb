<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Recent invoice with Statistics -->
<div class="row match-height">
    <div class="col-xl-12 col-lg-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">공지사항 등록</h4>
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
                	<form class="form" action="<c:url value="/notices/regNotice" />" method="post">
						<div class="form-body">
							<div class="col-md-8">
								<label for="noticeTitle">제목</label>
								<input type="text" id="noticeTitle" class="form-control" placeholder="공지사항 제목" name="noticeTitle" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="공지사항 제목">
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="projectinput5">알림대상</label>
									<select id="pushTargetCd" name="pushTargetCd" class="form-control">
										<option value="110030" selected="">알림없음</option>
										<option value="110020">IT</option>
										<option value="110010">전체</option>									
									</select>
								</div>
							</div>
							<div class="col-md-12">
								<label for="noticeCont">내용</label>
								<textarea id="noticeCont" rows="15" class="form-control" name="noticeCont" placeholder="공지사항 내용" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="공지사항 내용"></textarea>
							</div>
						</div>
						<!-- 
						<div class="col-md-2">		
							<label for="issueinput8">알림 대상</label>
						</div>
						<div class="col-md-4">						
						<ul class="nav nav-pills">
							<li class="nav-item">
								<a class="nav-link active" id="base-pill1" data-toggle="pill" href="#pill1" aria-expanded="true">전체</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-pill2" data-toggle="pill" href="#pill2" aria-expanded="false">IT</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" id="base-pill3" data-toggle="pill" href="#pill3" aria-expanded="false">알림없음</a>
							</li>
						</ul>
						</div>
						<div class="col-md-6">
							<div class="tab-content px-1 pt-1">
								<div role="tabpanel" class="tab-pane active" id="pill1" aria-expanded="true" aria-labelledby="base-pill1">
									<p>전체 사용자를 대상으로 push 알림을 보냅니다.</p>
								</div>
								<div class="tab-pane" id="pill2" aria-labelledby="base-pill2">
									<p>IT소속 사용자를 대상으로 push 알림을 보냅니다.</p>
								</div>
								<div class="tab-pane" id="pill3" aria-labelledby="base-pill3">
									<p>push 알림을 보내지 않습니다.</p>
								</div>
							</div>
						</div>		
						 -->		
						<div class="form-actions float-xs-right" style="border-top: 0px solid #dadada;">
							<a href="/spring-mvc-showcase/notices/noticeList"><button type="button" class="btn btn-warning mr-1">	<i class="icon-cross2"></i> 취소	</button></a>
							<button type="submit" class="btn btn-primary">	<i class="icon-check2"></i> 등록 </button>
						</div>
					</form>
                </div>
            </div>
        </div>
    </div>
</div>
