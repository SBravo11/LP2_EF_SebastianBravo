package pe.com.cibertec.LP2_EF_SebastianBravo.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class utils {
	
	public static String guardarImagen(MultipartFile foto) {
		try {
			
			byte[] fotoBytes = foto.getBytes();
			Path pathImagen = Paths.get("src/main/resources/static/usuario_foto/" + 
						foto.getOriginalFilename());
			
			Files.write(pathImagen, fotoBytes);
			return foto.getOriginalFilename();
			
		} catch (IOException e) {
			System.out.print("Ocurrió un error:: " + e.getMessage());
			return null;
		}
	}
	
	public static String extraerHash (String passwordFormulario) {
		return BCrypt.hashpw(passwordFormulario, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String passwordFormulario,
			String hashPassword) {
		return BCrypt.checkpw(passwordFormulario, hashPassword);
	}
}
