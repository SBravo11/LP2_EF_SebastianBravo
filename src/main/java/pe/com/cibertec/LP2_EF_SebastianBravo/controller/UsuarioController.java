package pe.com.cibertec.LP2_EF_SebastianBravo.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.UsuarioEntity;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.UsuarioService;

@Controller
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@GetMapping("/registrar_usuario")
	public String mostrarRegistrarUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "registrar_usuario";
	}
	
	@PostMapping("/registrar_usuario")
	public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario,
			Model model, @RequestParam("foto") MultipartFile foto) {
		
		usuarioService.crearUsuario(usuarioFormulario, foto);
		return "registrar_usuario";
	}
	
	@GetMapping("/")
	public String mostrarLogin(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";	
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario,
			Model model, HttpSession session) {
		boolean validarUsuario = usuarioService.validarUsuario(usuarioFormulario);
		if(validarUsuario) {
			session.setAttribute("usuario", usuarioFormulario.getCorreo());
			return "redirect:/menu";
		}
		model.addAttribute("loginInvalido", "El usuario no se encuentra registrado");
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
