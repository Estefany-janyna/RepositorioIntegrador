package proyectos.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyectos.spring.modelo.MedicoXHorario;

@Repository
public interface MedicoXHorarioRepository extends JpaRepository<MedicoXHorario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
