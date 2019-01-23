<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Recent invoice with Statistics -->
<div class="row match-height">
    <div class="col-xl-12 col-lg-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">공지사항</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="card-block">
                    <p>공지사항입니다.<span class="float-xs-right"><a href="#">뭐넣지? <i class="icon-arrow-right2"></i></a></span></p>
                    <li class=" nav-item"><a href="<c:url value="/notices/noticeList"/>"><i class="icon-table2"></i><span data-i18n="nav.bootstrap_tables.table_basic" class="menu-title">공지사항</span></a>
          </li>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover mb-0" style="table-layout: fixed;">
                        <thead>
                            <tr>
                                <th>제목</th>
                                <th>내용</th>
                                <th>알림대상</th>
                                <th>작성자</th>
                                <th>작성일시</th>
                            </tr>
                        </thead>
                        <tbody> 
	                	<c:forEach var="row" items="${Notices}">
							<tr>
                                <td class="text-truncate"><a href="#">${row.noticeTitle}</td>
                                <td class="text-truncate" style='width:50px;white-space:nowrap;overflow:hidden;text-overflow;ellipsis;'>${row.noticeCont} </td>
                                <td class="text-truncate"><span class="tag tag-default tag-success">${row.pushTargetCdNm}</span></td>
                                <td class="text-truncate">${row.usrNm}</td>
                                <td class="text-truncate">${row.created}</td>
                           </tr>
						</c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
