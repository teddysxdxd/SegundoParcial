/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admonteatro_examen;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author USUARIO
 */
public class EntradaTarde implements BoletosFactoryMethod {

    @Override
    public double CalcularPrecioEntrada(double precio) {
     double pEntrada = 100;
    double  jornada;
    jornada = precio*pEntrada;
    
    return jornada;  }

    @Override
    public boolean Registrarcompra(String compra) {
       Boolean esValido = false; 
    return esValido;
    }

    @Override
    public String RegistrarHorario(String horario) {
   try {
            // Convertimos el string recibido a un objeto LocalTime usando un formateador
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = LocalTime.parse(horario, formatter);

            // Llamamos al método Factory para determinar la franja horaria
            return obtenerPeriodoDelDia(hora);

        } catch (DateTimeParseException e) {
            // En caso de que el formato de la hora sea incorrecto
            return "Formato de hora no válido. Use HH:mm (por ejemplo, 14:30).";
        }
    }

    // Método Factory para determinar el periodo del día
    public String obtenerPeriodoDelDia(LocalTime hora) {
        if (hora.isAfter(LocalTime.of(5, 59)) && hora.isBefore(LocalTime.of(12, 0))) {
            return "Mañana";
        } else if (hora.isAfter(LocalTime.of(11, 59)) && hora.isBefore(LocalTime.of(18, 0))) {
            return "Tarde";
        } else {
            return "Noche";
        }
        
    }
}
    
    
