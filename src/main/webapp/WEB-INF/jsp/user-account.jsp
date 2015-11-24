<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<c:forEach items="${user.obras}" var="obra" >

  <table id="tabelaspec">
   
   <tr><td colspan="2" class="alc">Governo federal</td></tr>
   <tr><td colspan="2" ></td></tr>

   
   <tr><td colspan="2" class="alr"> ${obra.description}</td></tr>
   <tr><td colspan="2" class="alr"></td></tr>
   <tr><td colspan="2" class="alr"></td></tr>
   
   <tr>
     <td class="ale">Objetivo: ${obra.objective}</td>
     <td class="ale">Valor: ${obra.money}</td>
   </tr>
   <tr>
   <td class="ale">Cidade:  ${obra.city}</td>
   <td class="ale">Estado:  ${obra.state}</td>
   </tr>
   <tr>
   <td class="ale">Data Inicial:  ${obra.publishedDate}</td>
   <td class="ale">Data Final:  ${obra.finalDate}</td>
   </tr>
   
   <tr>
   <c:forEach items="${obra.patrocinadores}" var="patrocinador" >
          <tr>
             <td colspan="2" class="alc" >${patrocinador.nome}</td>
             
          </tr>
       
       </c:forEach>
   </tr>
   
   


</c:forEach>

