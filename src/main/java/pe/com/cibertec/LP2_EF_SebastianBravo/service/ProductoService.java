package pe.com.cibertec.LP2_EF_SebastianBravo.service;

import pe.com.cibertec.LP2_EF_SebastianBravo.model.entity.ProductoEntity;

import java.util.List;

public interface ProductoService {
    List<ProductoEntity> buscarTodosProductos();
    ProductoEntity buscarProductoPorId(Integer id);
    void nuevoProducto(ProductoEntity producto);
    void actualizarProducto(Integer id, ProductoEntity producto);
}
