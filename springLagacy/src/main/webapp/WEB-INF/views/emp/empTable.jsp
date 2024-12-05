<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<table class="table table-striped table-hover">
    <tr>
        <td>직원번호</td>
        <td>fname</td>
        <td>lname</td>
        <td>email</td>
        <td>phone</td>
        <td>job</td>
        <td>hiredate</td>
        <td>commission</td>
        <td>salary</td>
        <td>manager</td>
        <td>department</td>
        <td>get요청</td>
        <td>post요청</td>
    </tr>
    <c:forEach items="${empDatas}" var="emp">
        <tr>
            <td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
            <td><a href="${path}/emp/detail.do?empid=${emp.employee_id}">${emp.first_name}</a></td>
            <td>${emp.last_name}</td>
            <td>${emp.email}</td>
            <td>${emp.phone_number}</td>
            <td>${emp.job_id}</td>
            <td>${emp.hire_date}</td>
            <td>${emp.commission_pct}</td>
            <td>${emp.salary}</td>
            <td>${emp.manager_id}</td>
            <td>${emp.department_id}</td>
            <td><button class="btn btn-success" onclick="location.href='${path}/emp/delete.do?empid=${emp.employee_id}'">삭제(get)</button></td>
            <td><form action="${path}/emp/delete.do" method="post"><input type="hidden" name="empid" value="${emp.employee_id}"><button class="btn btn-success">삭제(post)</button></form></td>
        </tr>
    </c:forEach>
</table>