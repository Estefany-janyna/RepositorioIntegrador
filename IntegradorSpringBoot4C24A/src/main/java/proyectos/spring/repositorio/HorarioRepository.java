package proyectos.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectos.spring.modelo.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}

