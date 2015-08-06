
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script>
var names=new Array();
var j=0,k=0,flag;

function fCheck(a) { 
	
	var total=document.getElementById("total").value;
	
	
	if(j==0)
		{
		names[0]=a;
		k++;
		j++;
		}
	else
		{
		for(var i=0;i<k;i++)
			{flag=0;
			if(names[i]==a)
				{
				flag=1;
				break;
				}
			}
			if(flag==0)
				{
				names[k]=a;
				k++;
				}
		}
	if(k==total)
		{
		document.getElementsByName("submit")[0].disabled = false;
		}
	


}
</script>
</head>
<body>
<% StringBuffer sb=new StringBuffer(); int i=0,j=0,k=0; String s="risk0",m="risk";%>
<form method="post" name="riskform" action="FNAQuestionnaireRiskController">
		<table border="0" cellspacing=5 cellpadding=5>
		
		

								 <c:forEach var="eachrisk" items="${RISK}">
								<%if (j%2==0){ %>
								<%if(i<4) { if(i==0){%>
								<tr>
								<td></td>
								<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td></tr>
									<%} else if(i==1){ %>
									<tr>
									<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td>
										<%} else if(i==2) {%> 
											<td></td>
											<td></td>
											<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td> <td> ${eachrisk.riskquestions} </td>  </tr>
										<%}else if(i==3){%> 
										<tr>
								<td></td>
								<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td></tr>
										<%}i++;} if(i==4){i=0;j++;k++;sb.delete(0,sb.length()); sb.append(m).append(k);s=sb.toString();}} else if(j%2!=0){ %>
									
									
									
									<%if(i<4) { if(i==0){%>
								<tr>
								<td></td>
				<td></td>				
				<td></td>
				<td></td>
				<td></td>
								<td></td>
								<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td></tr>
									<%} else if(i==1){ %>
									<tr>
									<td></td>
				<td></td>
				<td></td>
				<td></td>
									<td> ${eachrisk.riskquestions} </td>
									<td><input type="radio" name=<%=s%>
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td>
										<%} else if(i==2) {%> 
										
											
											
											<td></td>
											<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td>   </tr>
										<%}else if(i==3){%> 
										<tr>
									<td></td>
									<td></td>				
				<td></td>
				<td></td>
				<td></td>
								<td></td>
								<td><input type="radio" name=<%=s%> 
									value="${eachrisk.riskoptions}" onclick=javascript:fCheck(name);>
									${eachrisk.riskoptions}</td></tr>
										<%}i++;} if(i==4){i=0;j++;k++;sb.delete(0,sb.length()); sb.append(m).append(k);s=sb.toString();}}%>
									
									
											
								</c:forEach>
								<tr>
								<td colspan=9 align="center"><input type="submit" name="submit" value="SUBMIT" disabled/></td>
								</tr>
								
								<tr><td><input type="text" name="total" id="total"
				  				value=<%=k %> style="visibility:hidden" ></td>
				  				<td><input type="text" name="custid" id="custid"
				  				value="2" style="visibility:hidden" ></td></tr>
								
								</table>
								</form>
								
				
						
</body>
</html>