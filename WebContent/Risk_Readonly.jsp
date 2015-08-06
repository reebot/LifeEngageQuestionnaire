
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

</head>
<body>
<% StringBuffer sb=new StringBuffer(); int i=0,j=0,k=0; String s="risk0",m="risk";%>
<form method="post" name="riskform" 
		>
		<table border="0" cellspacing=5 cellpadding=5>
		<tr><a href="./Product_Questionnaire.jsp">Product Questionnaire </a> </tr>
		

								 <c:forEach var="eachrisk" items="${RISK}">
								<%if (j%2==0){ pageContext.setAttribute("nam",s); %> 
								<%if(i<4) { if(i==0){%>
								
								<tr>
								
								<td></td>
								<td>
								<c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach>
									  </td></tr>
									<%} else if(i==1){ %>
									<tr>
									<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td>
										<%} else if(i==2) {%> 
											<td></td>
											<td></td>
											<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td> <td> ${eachrisk.riskquestions} </td>  </tr>
										<%}else if(i==3){%> 
										<tr>
								<td></td>
								<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td></tr>
										<%}i++;} if(i==4){i=0;j++;k++;sb.delete(0,sb.length()); sb.append(m).append(k);s=sb.toString();}} else if(j%2!=0){pageContext.setAttribute("nam",s);  %>
									
									
									
									<%if(i<4) { if(i==0){%>
								<tr>
								<td></td>
				<td></td>				
				<td></td>
				<td></td>
				<td></td>
								<td></td>
								<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td></tr>
									<%} else if(i==1){ %>
									<tr>
									<td></td>
				<td></td>
				<td></td>
				<td></td>
									<td> ${eachrisk.riskquestions} </td>
									<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td>
										<%} else if(i==2) {%> 
										
											
											
											<td></td>
											<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td>   </tr>
										<%}else if(i==3){%> 
										<tr>
									<td></td>
									<td></td>				
				<td></td>
				<td></td>
				<td></td>
								<td></td>
								<td><c:forEach items="${RISKPROFILE.custanswer}" var="custanswer" >
								<c:if test="${custanswer.key==nam}"><c:choose><c:when test="${custanswer.value==eachrisk.riskoptions}"> <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" checked>
									${eachrisk.riskoptions}
									</c:when>
									
									 <c:otherwise> 
									 <input type="radio" name=<%=s%> 
									value="${eachrisk.weightage}" disabled>
									${eachrisk.riskoptions}
									 </c:otherwise> 
									 </c:choose></c:if>
									  </c:forEach></td></tr>
										<%}i++;} if(i==4){i=0;j++;k++;sb.delete(0,sb.length()); sb.append(m).append(k);s=sb.toString();}}%>
									
									
											
								</c:forEach>
								<tr>
								<td colspan=9 align="center"><input type="submit" name="submit" value="SUBMIT" disabled/></td>
								</tr>
								
								<tr><td><input type="text" name="total" id="total"
				  				value=<%=k %> style="visibility:hidden" ></td></tr>
								
								</table>
								</form>
								
				
						
</body>
</html>