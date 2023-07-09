package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectos.spring.modelo.Paciente;
import proyectos.spring.servicio.PacienteServicio;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pacientes")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Paciente>> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = pacienteServicio.obtenerTodosLosPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{pacienteId}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long pacienteId) {
        Paciente paciente = pacienteServicio.obtenerPacientePorId(pacienteId);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteServicio.guardarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteGuardado);
    }
    
    @PutMapping("/{pacienteId}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long pacienteId, @RequestBody Paciente paciente) {
        Paciente pacienteExistente = pacienteServicio.obtenerPacientePorId(pacienteId);
        if (pacienteExistente != null) {
            paciente.setId(pacienteId);
            Paciente pacienteActualizado = pacienteServicio.guardarPaciente(paciente);
            return ResponseEntity.ok(pacienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{pacienteId}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long pacienteId) {
        pacienteServicio.eliminarPaciente(pacienteId);
        return ResponseEntity.noContent().build();
    }
}
