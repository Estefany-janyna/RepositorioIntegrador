package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectos.spring.modelo.Medico;
import proyectos.spring.servicio.MedicoServicio;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/medicos")
public class MedicoControlador {

    @Autowired
    private MedicoServicio medicoServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Medico>> obtenerTodosLosMedicos() {
        List<Medico> medicos = medicoServicio.obtenerTodosLosMedicos();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{medicoId}")
    public ResponseEntity<Medico> obtenerMedicoPorId(@PathVariable Long medicoId) {
        Medico medico = medicoServicio.obtenerMedicoPorId(medicoId);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Medico> guardarMedico(@RequestBody Medico medico) {
        Medico medicoGuardado = medicoServicio.guardarMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoGuardado);
    }

    @PutMapping("/{medicoId}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable Long medicoId, @RequestBody Medico medico) {
        Medico medicoExistente = medicoServicio.obtenerMedicoPorId(medicoId);
        if (medicoExistente != null) {
            medico.setId(medicoId);
            Medico medicoActualizado = medicoServicio.guardarMedico(medico);
            return ResponseEntity.ok(medicoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{medicoId}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable Long medicoId) {
        medicoServicio.eliminarMedico(medicoId);
        return ResponseEntity.noContent().build();
    }
}

