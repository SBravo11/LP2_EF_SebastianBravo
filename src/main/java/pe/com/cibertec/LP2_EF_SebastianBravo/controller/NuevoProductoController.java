package pe.com.cibertec.LP2_EF_SebastianBravo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.ProductoEntity;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.ProductoService;

@Controller
@RequiredArgsConstructor
public class NuevoProductoController {

    private final ProductoService productoService;

    @GetMapping("/nuevo_produc")
    public String mostrarRegistrarProducto(Model model) {
        model.addAttribute("productoNuevo", new ProductoEntity());
        return "nuevo_produc";
    }

    @PostMapping("/nuevo_produc")
    public String registrarProducto(@ModelAttribute("productoNuevo") ProductoEntity productoFormulario,
                                    Model model) {
        productoService.nuevoProducto(productoFormulario);
        return "menu";
    }

    @GetMapping("/editar_producto")
    public String mostrarEditarProducto(Model model) {
        model.addAttribute("productoEditado", new ProductoEntity());
        return "editar_producto";
    }

    @PostMapping("/editar_producto")
    public String editarProducto(@ModelAttribute("productoEditado") ProductoEntity productoFormulario,
                                    Model model) {
        productoService.actualizarProducto(productoFormulario.getProductoId(),productoFormulario);
        return "menu";
    }
}
