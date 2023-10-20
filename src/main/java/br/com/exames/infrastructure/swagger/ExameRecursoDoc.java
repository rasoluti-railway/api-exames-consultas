package br.com.exames.infrastructure.swagger;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import br.com.exames.dto.ExameDto;
import br.com.exames.dto.ResponseObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Houve sucesso na requisição mas sem dados para retornar.", examples = @Example(value = {
				@ExampleProperty(mediaType = "application/json", value = "{}") })),
		@ApiResponse(code = 404, message = "Retorno obtido caso seja solicitado uma rota não que não existe.", examples = @Example(value = {
				@ExampleProperty(mediaType = "application/json", value = "{\n"
						+ " \"timestamp\":\"2022-12-1413:53:24\",\n" + " \"status\":404,\n"
						+ " \"error\":\"NotFound\",\n" + " \"message\":\"Nomessageavailable\",\n"
						+ " \"path\":\"/api-exames-consultas/rota-inexistente\"\n" + "}") })),
		@ApiResponse(code = 406, message = "Retorno obtido caso o dado informado não seja aceito pela requisição.", examples = @Example(value = {
				@ExampleProperty(mediaType = "application/json", value = "{\n" + "  \"status\": \"NOT_ACCEPTABLE\",\n"
						+ "  \"timestamp\": \"1670249099\",\n"
						+ "  \"erro\": \"O parâmetro deve ser um caractere numérico.\",\n" + "  \"retorno\": {}\n"
						+ "}") })),
		@ApiResponse(code = 400, message = "Retorno obtido caso haja alguma informidade no processo ou inconsistência nas informações passadas.", examples = @Example(value = {
				@ExampleProperty(mediaType = "application/json", value = "{\n" + "  \"status\": \"BAD_REQUEST\",\n"
						+ "  \"timestamp\": \"1670249099\",\n"
						+ "  \"erro\": \"Campo nome não informado. Não é possível continuar.\",\n"
						+ "  \"retorno\": {}\n" + "}") })),
		@ApiResponse(code = 500, message = "Erro interno do servidor, obtido quando há um erro inesperado durante o processamento dos dados.", examples = @Example(value = {
				@ExampleProperty(mediaType = "application/json", value = "{\n"
						+ "  \"status\": \"INTERNAL_SERVER_ERROR\",\n" + "  \"timestamp\": \"1670249287\",\n"
						+ "  \"erro\": \"### NPE ###\",\n" + "  \"retorno\": {\n" + "    \"retorno\": {\n"
						+ "      \"mensagem\": \"Data informada para busca não pode ser nula no parâmetro.\"\n"
						+ "     },\n" + "    \"status\": \"INTERNAL_SERVER_ERROR\"\n" + "  }\n" + "}") })) })
@SuppressWarnings("deprecation")
@Api(tags = "exames", description = "- Disponibiliza recursos de gerenciamento de exames")
public interface ExameRecursoDoc {

	/*
	 * -----------------------------------------------------------------------------
	 * -------------------------
	 */

	@ApiOperation(value = "Salva o exame do cliente no prontuário", notes = "<!DOCTYPE html>" + "<html>" + "<head>"
			+ "<title>upload.md</title>" + "<meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\">"
			+ "<style>"
			+ "/* https://github.com/microsoft/vscode/blob/master/extensions/markdown-language-features/media/markdown.css */"
			+ "/*---------------------------------------------------------------------------------------------"
			+ " *  Copyright (c) Microsoft Corporation. All rights reserved."
			+ " *  Licensed under the MIT License. See License.txt in the project root for license information."
			+ " *--------------------------------------------------------------------------------------------*/"
			+ "body {"
			+ "	font-family: var(--vscode-markdown-font-family, -apple-system, BlinkMacSystemFont, \"Segoe WPC\", \"Segoe UI\", \"Ubuntu\", \"Droid Sans\", sans-serif);"
			+ "	font-size: var(--vscode-markdown-font-size, 14px);" + "	padding: 0 26px;"
			+ "	line-height: var(--vscode-markdown-line-height, 22px);" + "	word-wrap: break-word;" + "}"
			+ "#code-csp-warning {" + "	position: fixed;" + "	top: 0;" + "	right: 0;" + "	color: white;"
			+ "	margin: 16px;" + "	text-align: center;" + "	font-size: 12px;" + "	font-family: sans-serif;"
			+ "	background-color:#444444;" + "	cursor: pointer;" + "	padding: 6px;"
			+ "	box-shadow: 1px 1px 1px rgba(0,0,0,.25);" + "}" + "#code-csp-warning:hover {"
			+ "	text-decoration: none;" + "	background-color:#007acc;" + "	box-shadow: 2px 2px 2px rgba(0,0,0,.25);"
			+ "}" + "body.scrollBeyondLastLine {" + "	margin-bottom: calc(100vh - 22px);" + "}"
			+ "body.showEditorSelection .code-line {" + "	position: relative;" + "}"
			+ "body.showEditorSelection .code-active-line:before,"
			+ "body.showEditorSelection .code-line:hover:before {" + "	content: \"\";" + "	display: block;"
			+ "	position: absolute;" + "	top: 0;" + "	left: -12px;" + "	height: 100%;" + "}"
			+ "body.showEditorSelection li.code-active-line:before,"
			+ "body.showEditorSelection li.code-line:hover:before {" + "	left: -30px;" + "}"
			+ ".vscode-light.showEditorSelection .code-active-line:before {"
			+ "	border-left: 3px solid rgba(0, 0, 0, 0.15);" + "}"
			+ ".vscode-light.showEditorSelection .code-line:hover:before {"
			+ "	border-left: 3px solid rgba(0, 0, 0, 0.40);" + "}"
			+ ".vscode-light.showEditorSelection .code-line .code-line:hover:before {" + "	border-left: none;" + "}"
			+ ".vscode-dark.showEditorSelection .code-active-line:before {"
			+ "	border-left: 3px solid rgba(255, 255, 255, 0.4);" + "}"
			+ ".vscode-dark.showEditorSelection .code-line:hover:before {"
			+ "	border-left: 3px solid rgba(255, 255, 255, 0.60);" + "}"
			+ ".vscode-dark.showEditorSelection .code-line .code-line:hover:before {" + "	border-left: none;" + "}"
			+ ".vscode-high-contrast.showEditorSelection .code-active-line:before {"
			+ "	border-left: 3px solid rgba(255, 160, 0, 0.7);" + "}"
			+ ".vscode-high-contrast.showEditorSelection .code-line:hover:before {"
			+ "	border-left: 3px solid rgba(255, 160, 0, 1);" + "}"
			+ ".vscode-high-contrast.showEditorSelection .code-line .code-line:hover:before {" + "	border-left: none;"
			+ "}" + "img {" + "	max-width: 100%;" + "	max-height: 100%;" + "}" + "a {" + "	text-decoration: none;"
			+ "}" + "a:hover {" + "	text-decoration: underline;" + "}" + "a:focus," + "input:focus," + "select:focus,"
			+ "textarea:focus {" + "	outline: 1px solid -webkit-focus-ring-color;" + "	outline-offset: -1px;" + "}"
			+ "hr {" + "	border: 0;" + "	height: 2px;" + "	border-bottom: 2px solid;" + "}" + "h1 {"
			+ "	padding-bottom: 0.3em;" + "	line-height: 1.2;" + "	border-bottom-width: 1px;"
			+ "	border-bottom-style: solid;" + "}" + "h1, h2, h3 {" + "	font-weight: normal;" + "}" + "table {"
			+ "	border-collapse: collapse;" + "}" + "table > thead > tr > th {" + "	text-align: left;"
			+ "	border-bottom: 1px solid;" + "}" + "table > thead > tr > th," + "table > thead > tr > td,"
			+ "table > tbody > tr > th," + "table > tbody > tr > td {" + "	padding: 5px 10px;" + "}"
			+ "table > tbody > tr + tr > td {" + "	border-top: 1px solid;" + "}" + "blockquote {"
			+ "	margin: 0 7px 0 5px;" + "	padding: 0 16px 0 10px;" + "	border-left-width: 5px;"
			+ "	border-left-style: solid;" + "}" + "code {"
			+ "	font-family: Menlo, Monaco, Consolas, \"Droid Sans Mono\", \"Courier New\", monospace, \"Droid Sans Fallback\";"
			+ "	font-size: 1em;" + "	line-height: 1.357em;" + "}" + "body.wordWrap pre {"
			+ "	white-space: pre-wrap;" + "}" + "pre:not(.hljs)," + "pre.hljs code > div {" + "	padding: 16px;"
			+ "	border-radius: 3px;" + "	overflow: auto;" + "}" + "pre code {"
			+ "	color: var(--vscode-editor-foreground);" + "	tab-size: 4;" + "}" + "/** Theming */"
			+ ".vscode-light pre {" + "	background-color: rgba(220, 220, 220, 0.4);" + "}" + ".vscode-dark pre {"
			+ "	background-color: rgba(10, 10, 10, 0.4);" + "}" + ".vscode-high-contrast pre {"
			+ "	background-color: rgb(0, 0, 0);" + "}" + ".vscode-high-contrast h1 {" + "	border-color: rgb(0, 0, 0);"
			+ "}" + ".vscode-light table > thead > tr > th {" + "	border-color: rgba(0, 0, 0, 0.69);" + "}"
			+ ".vscode-dark table > thead > tr > th {" + "	border-color: rgba(255, 255, 255, 0.69);" + "}"
			+ ".vscode-light h1," + ".vscode-light hr," + ".vscode-light table > tbody > tr + tr > td {"
			+ "	border-color: rgba(0, 0, 0, 0.18);" + "}" + ".vscode-dark h1," + ".vscode-dark hr,"
			+ ".vscode-dark table > tbody > tr + tr > td {" + "	border-color: rgba(255, 255, 255, 0.18);" + "}"
			+ "</style>" + "<style>" + "/* Tomorrow Theme */"
			+ "/* http://jmblog.github.com/color-themes-for-google-code-highlightjs */"
			+ "/* Original theme - https://github.com/chriskempson/tomorrow-theme */" + "/* Tomorrow Comment */"
			+ ".hljs-comment," + ".hljs-quote {" + "	color: #8e908c;" + "}" + "/* Tomorrow Red */"
			+ ".hljs-variable," + ".hljs-template-variable," + ".hljs-tag," + ".hljs-name," + ".hljs-selector-id,"
			+ ".hljs-selector-class," + ".hljs-regexp," + ".hljs-deletion {" + "	color: #c82829;" + "}"
			+ "/* Tomorrow Orange */" + ".hljs-number," + ".hljs-built_in," + ".hljs-builtin-name," + ".hljs-literal,"
			+ ".hljs-type," + ".hljs-params," + ".hljs-meta," + ".hljs-link {" + "	color: #f5871f;" + "}"
			+ "/* Tomorrow Yellow */" + ".hljs-attribute {" + "	color: #eab700;" + "}" + "/* Tomorrow Green */"
			+ ".hljs-string," + ".hljs-symbol," + ".hljs-bullet," + ".hljs-addition {" + "	color: #718c00;" + "}"
			+ "/* Tomorrow Blue */" + ".hljs-title," + ".hljs-section {" + "	color: #4271ae;" + "}"
			+ "/* Tomorrow Purple */" + ".hljs-keyword," + ".hljs-selector-tag {" + "	color: #8959a8;" + "}"
			+ ".hljs {" + "	display: block;" + "	overflow-x: auto;" + "	color: #4d4d4c;" + "	padding: 0.5em;"
			+ "}" + ".hljs-emphasis {" + "	font-style: italic;" + "}" + ".hljs-strong {" + "	font-weight: bold;"
			+ "}" + "</style>" + "<style>" + "/*" + " * Markdown PDF CSS" + " */" + " body {"
			+ "	font-family: -apple-system, BlinkMacSystemFont, \"Segoe WPC\", \"Segoe UI\", \"Ubuntu\", \"Droid Sans\", sans-serif, \"Meiryo\";"
			+ "	padding: 0 12px;" + "}" + "pre {" + "	background-color: #f8f8f8;" + "	border: 1px solid #cccccc;"
			+ "	border-radius: 3px;" + "	overflow-x: auto;" + "	white-space: pre-wrap;"
			+ "	overflow-wrap: break-word;" + "}" + "pre:not(.hljs) {" + "	padding: 23px;" + "	line-height: 19px;"
			+ "}" + "blockquote {" + "	background: rgba(127, 127, 127, 0.1);"
			+ "	border-color: rgba(0, 122, 204, 0.5);" + "}" + ".emoji {" + "	height: 1.4em;" + "}" + "code {"
			+ "	font-size: 14px;" + "	line-height: 19px;" + "}" + "/* for inline code */"
			+ ":not(pre):not(.hljs) > code {"
			+ "	color: #C9AE75; /* Change the old color so it seems less like an error */" + "	font-size: inherit;"
			+ "}" + "/* Page Break : use <div class=\"page\"/> to insert page break"
			+ "-------------------------------------------------------- */" + ".page {" + "	page-break-after: always;"
			+ "}" + "</style>" + "<script src=\"https://unpkg.com/mermaid/dist/mermaid.min.js\"></script>" + "</head>"
			+ "<body>" + "  <script>" + "    mermaid.initialize({" + "      startOnLoad: true,"
			+ "      theme: document.body.classList.contains('vscode-dark') || document.body.classList.contains('vscode-high-contrast')"
			+ "          ? 'dark'" + "          : 'default'" + "    });" + "  </script>"
			+ "<h2 id=\"upload\">Geração de dados para prontuário</h2>" + "<hr>"
			+ "<p>Este recurso realiza a gravação de exames no prontuário do paciente</p>"
			+ "<h3 id=\"par%C3%A2metros-de-requisi%C3%A7%C3%A3o\">Parâmetros de requisição</h3>" + "<table>" + "<thead>"
			+ "<tr>" + "<th>Parâmetro</th>" + "<th>Descrição</th>" + "<th>Tipo</th>" + "<th>Obrigatório?</th>" + "</tr>"
			+ "</thead>" + "<tbody>" + "<tr>" + "<td>File</td>"
			+ "<td> Deve ser informado o caminho local onde está o arquivo que deverá ser gravado "
			+ "no prontuário do paciente.</strong></td>" + "<td>form</td>" + "<td>🛑</td>" + "</tr>" + "<tr>"
			+ "<td>C.P.F</td>" + "<td>Informar o C.P.F do paciente dono do exame,"
			+ " deverá ser usado o formato <strong>000.111.222-33</strong></td>" + "<td>Query</td>" + "<td>✅</td>"
			+ "</tr>"

			+ "</body>" + "</html>")
	@ApiResponse(code = 200, message = "Retorno obtido ao executar corretamente o recurso.")
	@ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<String> uploadFile(
			  @ApiParam(value = "File to be uploaded", required = true)
			  @RequestPart("file") MultipartFile file);

	/*
	 * -----------------------------------------------------------------------------
	 * -------------------------
	 */

}
