import jakarta.servlet.http.HttpServletResponse;
import org.lc.dao.HoroscopoDaoImp;
import org.lc.modelo.Horoscopo;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;

public class HoroscopoTest {


        public static void main(String[] args) {
            // Crear una instancia del servicio de horóscopo
            HoroscopoDaoImp horoscopoServicio = new HoroscopoDaoImp();


            // Probar obtenerHoroscopo() para listar todos los horóscopos
            List<Horoscopo> listaHoroscopo = horoscopoServicio.mostrarHoroscopo();

            if (listaHoroscopo != null && !listaHoroscopo.isEmpty()) {
                System.out.println("Horóscopos recuperados de la base de datos:");
                for (Horoscopo horoscopo : listaHoroscopo) {
                    System.out.println("Animal: " + horoscopo.getAnimal());
                    System.out.println("Descripción: " + horoscopo.getDescripcion());
                    System.out.println("Fecha de inicio: " + horoscopo.getFechaInicio());
                    System.out.println("Fecha de fin: " + horoscopo.getFechaFin());
                    System.out.println("Lugar: " + horoscopo.getLugar());
                    System.out.println("------------------------------------");
                }
            } else {
                System.out.println("No se recuperaron horóscopos, la lista está vacía.");
            }
        }
    }
