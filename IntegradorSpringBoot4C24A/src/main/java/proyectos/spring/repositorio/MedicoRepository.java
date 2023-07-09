package proyectos.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectos.spring.modelo.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
