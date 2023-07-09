package proyectos.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectos.spring.modelo.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
