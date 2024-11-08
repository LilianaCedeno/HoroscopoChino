package org.lc.dao;

import org.lc.modelo.Horoscopo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IHoroscopoDao {
    List<Horoscopo> mostrarHoroscopo();
    Optional<Horoscopo> obtenerHoroscopo(Date fechaNacimiento);

}
