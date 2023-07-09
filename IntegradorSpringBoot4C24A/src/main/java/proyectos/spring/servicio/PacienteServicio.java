package proyectos.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Paciente;
import proyectos.spring.repositorio.PacienteRepository;

import java.util.List;

@Service("Paciente")
public class PacienteServicio {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obtenerPacientePorId(Long pacienteId) {
        return pacienteRepository.findById(pacienteId).orElse(null);
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long pacienteId) {
        pacienteRepository.deleteById(pacienteId);
    }
}
