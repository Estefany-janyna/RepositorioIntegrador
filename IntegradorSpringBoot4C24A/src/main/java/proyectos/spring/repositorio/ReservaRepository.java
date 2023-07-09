package proyectos.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectos.spring.modelo.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
