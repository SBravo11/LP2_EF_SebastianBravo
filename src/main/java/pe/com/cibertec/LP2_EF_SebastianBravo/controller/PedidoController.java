package pe.com.cibertec.LP2_EF_SebastianBravo.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.*;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.PedidoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@GetMapping("/guardar_factura")
	public String guardarFactura(HttpSession session) {
		String correoUsuario = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCorreo(correoUsuario);

		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setUsuarioEntity(usuarioEntity);

		List<DetallePedidoEntity>detallePedidoEntityList = new ArrayList<DetallePedidoEntity>();
		
		List<Pedido>productoSesion = null;
		if(session.getAttribute("carrito") == null) {
			productoSesion = new ArrayList<Pedido>();
		}else {
			productoSesion = (List<Pedido>)session.getAttribute("carrito");
		}
		for(Pedido ped: productoSesion) {
			DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setProductoId(ped.getProductoId());
			
			detallePedidoEntity.setProductoEntity(productoEntity);
			detallePedidoEntity.setCantidad(ped.getCantidad());
			detallePedidoEntity.setPedidoEntity(pedidoEntity);
			detallePedidoEntityList.add(detallePedidoEntity);
		}
		
		pedidoEntity.setDetallePedido(detallePedidoEntityList);
		pedidoService.crearPedido(pedidoEntity);
		session.removeAttribute("carrito");
		return "redirect:/menu";
		
	}
}
