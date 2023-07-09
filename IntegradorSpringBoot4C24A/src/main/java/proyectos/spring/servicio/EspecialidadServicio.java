package proyectos.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Especialidad;
import proyectos.spring.repositorio.EspecialidadRepository;

import java.util.List;

@Service
public class EspecialidadServicio {
  
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad obtenerEspecialidadPorId(Long especialidadId) {
        return especialidadRepository.findById(especialidadId).orElse(null);
    }

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(Long especialidadId) {
        especialidadRepository.deleteById(especialidadId);
    }
}

