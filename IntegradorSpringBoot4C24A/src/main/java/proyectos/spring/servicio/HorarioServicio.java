package proyectos.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Horario;
import proyectos.spring.repositorio.HorarioRepository;

import java.util.List;

@Service
public class HorarioServicio {
    
    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> obtenerTodosLosHorarios() {
        return horarioRepository.findAll();
    }

    public Horario obtenerHorarioPorId(Long horarioId) {
        return horarioRepository.findById(horarioId).orElse(null);
    }

    public Horario guardarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void eliminarHorario(Long horarioId) {
        horarioRepository.deleteById(horarioId);
    }
}

