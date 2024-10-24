package pe.com.cibertec.LP2_EF_SebastianBravo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.PedidoEntity;
import pe.com.cibertec.LP2_EF_SebastianBravo.repository.PedidoRepository;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.PedidoService;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

	private final PedidoRepository pedidoRepository;
	
	@Override
	public void crearPedido(PedidoEntity pedidoEntity) {
		// TODO Auto-generated method stub
		pedidoRepository.save(pedidoEntity);
		
	}

}
