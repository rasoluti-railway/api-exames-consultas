package br.com.exames.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "exame")
public class Exame {
	
	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "nome")
	    private String nome;
	    
	    @Column(name = "identificador_exame")
	    private String identificadorExame;
	    
	    @Column(name = "dt_realizacao_exame")
		private LocalDateTime dtRealizacaoExame;
	    
	    @Column(name = "crm_medico_examinador")
	    private String crmMedicoExaminador;
	    
	    @Column(name = "parte_corpo")
	    private String parteCorpo;
	    
	    @Column(name = "indicacao")
	    private String indicacao;
	    
	    @Column(name = "cpf_paciente")
	    private String cpfPaciente;
	    
	    @Column(name = "dt_criacao_registro")
		private LocalDateTime dtCriacaoRegistro;

		@Column(name = "dt_alteracao_registro")
		private LocalDateTime dtAlteracaoRegistro;
  
}