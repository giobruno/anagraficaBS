<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="inserimentoAssociazioneBSProcesso" method='GET' commandName="associazioneBSProcessoForm">
	 <div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					<p class="visualizzaFormLegend">Inserimento Associazione Business Service - Processo</p>
	</div>
	</div>
	</div>
		<div class="div-table-centrata">
	<div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div>
	
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
	 <div class="div-table-row">
 		<p class="erroreForm"><form:errors path="*"/> </p>
 		<br/>
		<fieldset >
		
		<legend>Compila il seguente form per inserire una nuova Associazione Business Service - Processo</legend>		
		
		<div class="div-table">	
			<c:set value="${associazioneBSProcessoForm.codiBusinessService != null && associazioneBSProcessoForm.codiBusinessService != '' ? true : false}" var="disabled"></c:set>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Business Service*:</label></div>
			<div class="div-table-col">
								<form:select path="codiBusinessService" id="codiBusinessService" name="codiBusinessService" style="width:180px" disabled="${disabled}">
									<form:option value="" label="--" />
									<form:options items="${businessServiceList}" 
										itemValue="codiBusinessService"
										itemLabel="textNomeBusinessService" />										
								</form:select>&nbsp;
								</div>				
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiProcesso"> <img src="resources/img/query.png" alt="" title="">&nbsp;Processo*:</label></div>
			<div class="div-table-col">
								<form:select path="codiProcesso" id="codiProcesso" name="codiProcesso" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiProcessoList}" 
										itemValue="codiProcesso"
										itemLabel="textSiglaProcesso" />										
								</form:select>
							</div>							
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiCategoriaMac"> <img src="resources/img/query.png" alt="" title="">&nbsp;Categoria Mac*:</label></div>
			<div class="div-table-col">
								<form:select path="codiCategoriaMac" id="codiCategoriaMac" name="codiCategoriaMac" style="width:180px">
									<form:option value="00" label="--" />
									<form:options items="${codiCategoriaMacList}" 
										itemValue="codiCategoriaMac"
										itemLabel="codiDescCategoriaMac" />										
								</form:select>
							</div>							
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiCategoriaInfr"> <img src="resources/img/query.png" alt="" title="">&nbsp;Categoria Infr*:</label></div>
			<div class="div-table-col">
								<form:select path="codiCategoriaInfr" id="codiCategoriaInfr" name="codiCategoriaInfr" style="width:180px">
									<form:option value="00" label="--" />
									<form:options items="${codiCategoriaInfrList}" 
										itemValue="codiCategoriaInfr"
										itemLabel="descCategoriaInfr" />										
								</form:select>
							</div>								
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="orarioLavIni"> <img src="resources/img/query.png" alt="" title="">&nbsp;Inizio Orario Lavorativo*:</label></div>
			<div class="div-table-col">
								<form:select path="orarioLavIniOre" id="orarioLavIniOre" name="orarioLavIniOre" style="width:50px">
									<form:option value="00" label="00" />
									<form:option value="01" label="01" />
									<form:option value="02" label="02" />
									<form:option value="03" label="03" />
									<form:option value="04" label="04" />
									<form:option value="05" label="05" />
									<form:option value="06" label="06" />
									<form:option value="07" label="07" />
									<form:option value="08" label="08" />
									<form:option value="09" label="09" />
									<form:option value="10" label="10" />
									<form:option value="11" label="11" />
									<form:option value="12" label="12" />
									<form:option value="13" label="13" />
									<form:option value="14" label="14" />
									<form:option value="15" label="15" />
									<form:option value="16" label="16" />
									<form:option value="17" label="17" />
									<form:option value="18" label="18" />
									<form:option value="19" label="19" />
									<form:option value="20" label="20" />
									<form:option value="21" label="21" />
									<form:option value="21" label="22" />
									<form:option value="23" label="23" />																											
								</form:select>			
								<form:select path="orarioLavIniMinuti" id="orarioLavIniMinuti" name="orarioLavIniMinuti" style="width:50px">
									<form:option value="00" label="00" />
									<form:option value="01" label="01" />
									<form:option value="02" label="02" />
									<form:option value="03" label="03" />
									<form:option value="04" label="04" />
									<form:option value="05" label="05" />
									<form:option value="06" label="06" />
									<form:option value="07" label="07" />
									<form:option value="08" label="08" />
									<form:option value="09" label="09" />
									<form:option value="10" label="10" />
									<form:option value="11" label="11" />
									<form:option value="12" label="12" />
									<form:option value="13" label="13" />
									<form:option value="14" label="14" />
									<form:option value="15" label="15" />
									<form:option value="16" label="16" />
									<form:option value="17" label="17" />
									<form:option value="18" label="18" />
									<form:option value="19" label="19" />
									<form:option value="20" label="20" />
									<form:option value="21" label="21" />
									<form:option value="21" label="22" />
									<form:option value="23" label="23" />									
									<form:option value="24" label="24" />
									<form:option value="25" label="25" />
									<form:option value="26" label="26" />
									<form:option value="27" label="27" />
									<form:option value="28" label="28" />
									<form:option value="29" label="29" />
									<form:option value="30" label="30" />
									<form:option value="31" label="31" />
									<form:option value="32" label="32" />
									<form:option value="33" label="33" />
									<form:option value="34" label="34" />
									<form:option value="35" label="35" />
									<form:option value="36" label="36" />
									<form:option value="37" label="37" />
									<form:option value="38" label="38" />
									<form:option value="39" label="39" />
									<form:option value="40" label="40" />
									<form:option value="41" label="41" />
									<form:option value="42" label="42" />
									<form:option value="43" label="43" />
									<form:option value="44" label="44" />
									<form:option value="45" label="45" />
									<form:option value="46" label="46" />
									<form:option value="47" label="47" />									
									<form:option value="48" label="48" />
									<form:option value="49" label="49" />
									<form:option value="50" label="50" />
									<form:option value="51" label="51" />
									<form:option value="52" label="52" />
									<form:option value="53" label="53" />
									<form:option value="54" label="54" />
									<form:option value="55" label="55" />
									<form:option value="56" label="56" />
									<form:option value="57" label="57" />
									<form:option value="58" label="58" />
									<form:option value="59" label="59" />																		
								</form:select>	
								</div>					
								
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="orarioLavFine"> <img src="resources/img/query.png" alt="" title="">&nbsp;Fine Orario Lavorativo*:</label></div>
			<div class="div-table-col">
								<form:select path="orarioLavFineOre" id="orarioLavFineOre" name="orarioLavFineOre" style="width:50px">
									<form:option value="00" label="00" />
									<form:option value="01" label="01" />
									<form:option value="02" label="02" />
									<form:option value="03" label="03" />
									<form:option value="04" label="04" />
									<form:option value="05" label="05" />
									<form:option value="06" label="06" />
									<form:option value="07" label="07" />
									<form:option value="08" label="08" />
									<form:option value="09" label="09" />
									<form:option value="10" label="10" />
									<form:option value="11" label="11" />
									<form:option value="12" label="12" />
									<form:option value="13" label="13" />
									<form:option value="14" label="14" />
									<form:option value="15" label="15" />
									<form:option value="16" label="16" />
									<form:option value="17" label="17" />
									<form:option value="18" label="18" />
									<form:option value="19" label="19" />
									<form:option value="20" label="20" />
									<form:option value="21" label="21" />
									<form:option value="21" label="22" />
									<form:option value="23" label="23" />										
								</form:select>							
								<form:select path="orarioLavFineMinuti" id="orarioLavFineMinuti" name="orarioLavFineMinuti" style="width:50px">
									<form:option value="00" label="00" />
									<form:option value="01" label="01" />
									<form:option value="02" label="02" />
									<form:option value="03" label="03" />
									<form:option value="04" label="04" />
									<form:option value="05" label="05" />
									<form:option value="06" label="06" />
									<form:option value="07" label="07" />
									<form:option value="08" label="08" />
									<form:option value="09" label="09" />
									<form:option value="10" label="10" />
									<form:option value="11" label="11" />
									<form:option value="12" label="12" />
									<form:option value="13" label="13" />
									<form:option value="14" label="14" />
									<form:option value="15" label="15" />
									<form:option value="16" label="16" />
									<form:option value="17" label="17" />
									<form:option value="18" label="18" />
									<form:option value="19" label="19" />
									<form:option value="20" label="20" />
									<form:option value="21" label="21" />
									<form:option value="21" label="22" />
									<form:option value="23" label="23" />									
									<form:option value="24" label="24" />
									<form:option value="25" label="25" />
									<form:option value="26" label="26" />
									<form:option value="27" label="27" />
									<form:option value="28" label="28" />
									<form:option value="29" label="29" />
									<form:option value="30" label="30" />
									<form:option value="31" label="31" />
									<form:option value="32" label="32" />
									<form:option value="33" label="33" />
									<form:option value="34" label="34" />
									<form:option value="35" label="35" />
									<form:option value="36" label="36" />
									<form:option value="37" label="37" />
									<form:option value="38" label="38" />
									<form:option value="39" label="39" />
									<form:option value="40" label="40" />
									<form:option value="41" label="41" />
									<form:option value="42" label="42" />
									<form:option value="43" label="43" />
									<form:option value="44" label="44" />
									<form:option value="45" label="45" />
									<form:option value="46" label="46" />
									<form:option value="47" label="47" />									
									<form:option value="48" label="48" />
									<form:option value="49" label="49" />
									<form:option value="50" label="50" />
									<form:option value="51" label="51" />
									<form:option value="52" label="52" />
									<form:option value="53" label="53" />
									<form:option value="54" label="54" />
									<form:option value="55" label="55" />
									<form:option value="56" label="56" />
									<form:option value="57" label="57" />
									<form:option value="58" label="58" />
									<form:option value="59" label="59" />																			
								</form:select>
							</div>	
			</div>				
			
			<div class="div-table-row">			
			<div class="div-table-col"><label for="misuTmpLavorativo"> <img src="resources/img/query.png" alt="" title="">&nbsp;Tempo Lavorativo*:</label></div>
			<div class="div-table-col">
			<!-- 		<label for="misuTmpSolare">Giorni</label><form:input style="width:50px"  maxlength="4"  id="misuTmpLavorativoGiorni" path="misuTmpLavorativoGiorni"/>   -->
					<label for="misuTmpLavorativo">Ore</label><form:input style="width:50px"  maxlength="4"  id="misuTmpLavorativoOre" path="misuTmpLavorativoOre"/>
					<label for="misuTmpLavorativo">Minuti</label><form:input style="width:50px"  maxlength="4"  id="misuTmpLavorativoMinuti" path="misuTmpLavorativoMinuti"/>
			</div>
			
			</div>
			
			<div class="div-table-row">
			<div class="div-table-col"><label for="misuTmpSolare"> <img src="resources/img/query.png" alt="" title="">&nbsp;Tempo Solare*:</label></div>
			<div class="div-table-col">
		<!-- 			<label for="misuTmpSolare">Giorni</label><form:input style="width:50px"  maxlength="4"  id="misuTmpSolareGiorni" path="misuTmpSolareGiorni"/>  -->
					<label for="misuTmpSolare">Ore</label><form:input style="width:50px"  maxlength="4"  id="misuTmpSolareOre" path="misuTmpSolareOre"/>
					<label for="misuTmpSolare">Minuti</label><form:input style="width:50px"  maxlength="4"  id="misuTmpSolareMinuti" path="misuTmpSolareMinuti"/>
			</div>
			
			</div>		
					
		
			</div>
			</fieldset>			
			</div>
			<br/>
			<div class="div-table-row">
					<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
			
			<div class="div-table-row">
			<div class="div-table-col">
					 &nbsp;
							</div>
							</div>
	
	
					<div class="div-table-row">
						<div class="div-table-col-center" >
						
						<input type="reset" name="Cancella" value="Cancella"/>
						<input type="submit" name="Associa"  value="Associa" />							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>
	
				<br/>				 
	</form:form>	
	
	</div>
</body>