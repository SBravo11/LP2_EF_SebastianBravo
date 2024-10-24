package pe.com.cibertec.LP2_EF_SebastianBravo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.ProductoEntity;
import pe.com.cibertec.LP2_EF_SebastianBravo.repository.ProductoRepository;
import pe.com.cibertec.LP2_EF_SebastianBravo.service.ProductoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> buscarTodosProductos() {
        return productoRepository.findAll();
    }


    @Override
    public ProductoEntity buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public void nuevoProducto(ProductoEntity producto) {
        productoRepository.save(producto);
    }

    @Override
    public void actualizarProducto(Integer id, ProductoEntity producto) {
        ProductoEntity productoEntity = productoRepository.findById(id).get();
        if(buscarProductoPorId(id) != null) {
            productoEntity.setNombre(producto.getNombre());
            productoEntity.setPrecio(producto.getPrecio());
            productoEntity.setStock(producto.getStock());
            productoEntity.setCategoria(producto.getCategoria());
            productoRepository.save(productoEntity);
        }
    }
}
