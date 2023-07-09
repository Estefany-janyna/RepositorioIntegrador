package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectos.spring.modelo.Horario;
import proyectos.spring.servicio.HorarioServicio;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/horarios")
public class HorarioControlador {

    @Autowired
    private HorarioServicio horarioServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Horario>> obtenerTodosLosHorarios() {
        List<Horario> horarios = horarioServicio.obtenerTodosLosHorarios();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{horarioId}")
    public ResponseEntity<Horario> obtenerHorarioPorId(@PathVariable Long horarioId) {
        Horario horario = horarioServicio.obtenerHorarioPorId(horarioId);
        if (horario != null) {
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Horario> guardarHorario(@RequestBody Horario horario) {
        Horario horarioGuardado = horarioServicio.guardarHorario(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioGuardado);
    }

    @PutMapping("/{horarioId}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long horarioId, @RequestBody Horario horario) {
        Horario horarioExistente = horarioServicio.obtenerHorarioPorId(horarioId);
        if (horarioExistente != null) {
            horario.setId(horarioId);
            Horario horarioActualizado = horarioServicio.guardarHorario(horario);
            return ResponseEntity.ok(horarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{horarioId}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long horarioId) {
        horarioServicio.eliminarHorario(horarioId);
        return ResponseEntity.noContent().build();
    }
}

