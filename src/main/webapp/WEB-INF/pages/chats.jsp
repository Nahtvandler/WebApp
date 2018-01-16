<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>

<head>
  <title>Index Page</title>
</head>

<body>
<h1>Chat list</h1>
<br/>

<c:if test="${!empty chatlist}">
  <table>
    <tr>
      <th width="60">ID</th>
      <th width="120">Room name</th>
      <th width="60">JoinTo</th>
    </tr>
    <c:forEach items="${chatlist}" var="chat">
      <tr>
        <td>${chat.id}</td>
        <td>${chat.rname}</td>
        <td><a href="<c:url value='/chatroom/${chat.id}'/>">JoinTo</a></td>
        <td><a href="<c:url value='/delete/${chat.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
    <tr>

    </tr>
  </table>
</c:if>
</body>
<h1>add new room</h1>

<c:url var="addAction" value="/chats/add"/>

<form:form action="${addAction}" commandName="chat">
  <table>
    <c:if test="${empty chat.rname}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="fase" size="8" disabled="false"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="rname">
          <spring:message text="Room name"/>
        </form:label>
      </td>
      <td>
        <form:input path="rname"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${empty chat.rname}">
          <input type="submit"
                 value="<spring:message text="Add room"/>"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
</html>