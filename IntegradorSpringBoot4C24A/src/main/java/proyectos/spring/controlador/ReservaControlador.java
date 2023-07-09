package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectos.spring.modelo.Reserva;
import proyectos.spring.servicio.ReservaServicio;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reservas")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Reserva>> obtenerTodasLasReservas() {
        List<Reserva> reservas = reservaServicio.obtenerTodasLasReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{reservaId}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long reservaId) {
        Reserva reserva = reservaServicio.obtenerReservaPorId(reservaId);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva) {
        Reserva reservaGuardada = reservaServicio.guardarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaGuardada);
    }

    @PutMapping("/{reservaId}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long reservaId, @RequestBody Reserva reserva) {
        Reserva reservaExistente = reservaServicio.obtenerReservaPorId(reservaId);
        if (reservaExistente != null) {
            reserva.setId(reservaId);
            Reserva reservaActualizada = reservaServicio.guardarReserva(reserva);
            return ResponseEntity.ok(reservaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{reservaId}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long reservaId) {
        reservaServicio.eliminarReserva(reservaId);
        return ResponseEntity.noContent().build();
    }
}

