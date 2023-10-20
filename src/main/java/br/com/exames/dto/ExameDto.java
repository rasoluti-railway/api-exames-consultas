package br.com.exames.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExameDto {
	

	@JsonProperty("nome")
    private String nome;
    
	@JsonProperty("identificador_exame")
    private String identificadorExame;
   
	@JsonProperty("dt_realizacao_exame")
	private LocalDateTime dtRealizacaoExame;
 
	@JsonProperty("crm_medico_examinador")
    private String crmMedicoExaminador;
    
	@JsonProperty("parte_corpo")
    private String parteCorpo;
    
	@JsonProperty("indicacao")
    private String indicacao;
    
	@JsonProperty("cpf_paciente")
    private String cpfPaciente;
    
    
    

}
