package pe.com.cibertec.LP2_EF_SebastianBravo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.UsuarioEntity;
import pe.com.cibertec.LP2_EF_SebastianBravo.repository.UsuarioRepository;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.UsuarioService;
import pe.com.cibertec.LP2_EF_SebastianBravo.utils.utils;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto) {
		String nombreFoto = utils.guardarImagen(foto);
		usuarioEntity.setUrlImagen(nombreFoto);

		String passwordHash = utils.extraerHash(usuarioEntity.getPassword());
		usuarioEntity.setPassword(passwordHash);

		usuarioRepository.save(usuarioEntity);
	}

	@Override
	public boolean validarUsuario(UsuarioEntity usuarioFormulario) {
			UsuarioEntity usuarioEncontrado = usuarioRepository
					.findByCorreo(usuarioFormulario.getCorreo());

			if(usuarioEncontrado == null) {
				return false;
			}
        return utils.checkPassword(usuarioFormulario.getPassword(),
                usuarioEncontrado.getPassword());
    }

	@Override
	public UsuarioEntity buscarUsuarioPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByCorreo(correo);
	}

}
