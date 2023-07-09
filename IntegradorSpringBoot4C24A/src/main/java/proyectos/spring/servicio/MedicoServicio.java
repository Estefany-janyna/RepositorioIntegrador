package proyectos.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Medico;
import proyectos.spring.repositorio.MedicoRepository;

import java.util.List;

@Service
public class MedicoServicio {
    
    @Autowired
    
    private MedicoRepository medicoRepository;


    public List<Medico> obtenerTodosLosMedicos() {
        return medicoRepository.findAll();
    }

    public Medico obtenerMedicoPorId(Long medicoId) {
        return medicoRepository.findById(medicoId).orElse(null);
    }

    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void eliminarMedico(Long medicoId) {
        medicoRepository.deleteById(medicoId);
    }
}
