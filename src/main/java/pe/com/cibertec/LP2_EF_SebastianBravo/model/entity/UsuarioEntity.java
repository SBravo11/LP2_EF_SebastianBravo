package pe.com.cibertec.LP2_EF_SebastianBravo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

	@Id
	@Column(name = "correo", nullable = false, length = 60)
	private String correo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 100)
	private String apellido;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "url_imagen")
	private String urlImagen;
}
