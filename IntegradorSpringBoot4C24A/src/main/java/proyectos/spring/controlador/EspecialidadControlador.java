package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectos.spring.modelo.Especialidad;
import proyectos.spring.servicio.EspecialidadServicio;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/especialidades")
public class EspecialidadControlador {
    
    @Autowired
    private  EspecialidadServicio especialidadServicio;

    @GetMapping("lista/{especialidadId}")
    public ResponseEntity<List<Especialidad>> obtenerTodasLasEspecialidades() {
        List<Especialidad> especialidades = especialidadServicio.obtenerTodasLasEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{especialidadId}")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@PathVariable Long especialidadId) {
        Especialidad especialidad = especialidadServicio.obtenerEspecialidadPorId(especialidadId);
        if (especialidad != null) {
            return ResponseEntity.ok(especialidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Especialidad> guardarEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad especialidadGuardada = especialidadServicio.guardarEspecialidad(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadGuardada);
    }

    @DeleteMapping("/eliminar/{especialidadId}")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable Long especialidadId) {
        especialidadServicio.eliminarEspecialidad(especialidadId);
        return ResponseEntity.noContent().build();
    }
}

