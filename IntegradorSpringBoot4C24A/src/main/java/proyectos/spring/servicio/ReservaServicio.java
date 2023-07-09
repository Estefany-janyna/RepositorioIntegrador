package proyectos.spring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Reserva;
import proyectos.spring.repositorio.ReservaRepository;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    
    private ReservaRepository reservaRepository;
    
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReservaPorId(Long reservaId) {
        return reservaRepository.findById(reservaId).orElse(null);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long reservaId) {
        reservaRepository.deleteById(reservaId);
    }
}
