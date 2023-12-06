/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cine.entities;

import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mx.itson.cine.persistence.MySQLConnection;

/**
 *
 * @author vagui
 */
public class Horario {

    private int id = 0;
    private Pelicula pelicula = new Pelicula();
    private Sala sala = new Sala();
    private Date fecha = new Date();
    private String hora = "";

    public Horario(int id, Pelicula pelicula, Sala sala, Date fecha, String hora) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Horario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    //Metodos
    public static List<Horario> getAll(String filtro) {
        List<Horario> horarios = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement(
                    "SELECT Horarios.id, Horarios.Pelicula_id, Peliculas.Titulo, Horarios.Sala_id, Salas.Tipo, Horarios.fecha, Horarios.hora "
                    + "FROM Horarios "
                    + "INNER JOIN Peliculas ON Horarios.Pelicula_id = Peliculas.id "
                    + "INNER JOIN Salas ON Horarios.Sala_id = Salas.id "
                    + "WHERE Peliculas.Titulo LIKE ?"
            );
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Horario h = new Horario();
                h.setId(resultSet.getInt("id"));

                Pelicula pelicula = new Pelicula();
                pelicula.setId(resultSet.getInt("Pelicula_id"));
                pelicula.setTitulo(resultSet.getString("Titulo"));
                h.setPelicula(pelicula);

                Sala sala = new Sala();
                sala.setId(resultSet.getInt("Sala_id"));
                sala.setTipo(resultSet.getString("Tipo"));
                h.setSala(sala);

                h.setFecha(resultSet.getDate("fecha"));
                h.setHora(resultSet.getString("hora"));

                horarios.add(h);
            }
        } catch (SQLException ex) {
            System.err.print("Error: " + ex);
        }
        return horarios;
    }

    public boolean save(Pelicula pelicula, Sala sala, Date fecha, String hora) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO Horarios(Pelicula_id, Sala_id, fecha, hora) VALUES (?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, pelicula.getId());
            statement.setInt(2, sala.getId());
            statement.setDate(3, new java.sql.Date(fecha.getTime()));
            statement.setString(4, hora);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public boolean update(int id, Pelicula pelicula, Sala sala, Date fecha, String hora) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE Horarios SET Pelicula_id=?, Sala_id=?, fecha=?, hora=? WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, pelicula.getId());
            statement.setInt(2, sala.getId());
            statement.setDate(3, new java.sql.Date(fecha.getTime()));
            statement.setString(4, hora);
            statement.setInt(5, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE FROM Horarios WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public static Horario getById(int id) {
        Horario horario = null;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "SELECT * FROM Horarios WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                horario = new Horario();
                horario.setId(resultSet.getInt("id"));

                Pelicula pelicula = Pelicula.getById(resultSet.getInt("Pelicula_id"));
                horario.setPelicula(pelicula);

                Sala sala = Sala.getById(resultSet.getInt("Sala_id"));
                horario.setSala(sala);

                horario.setFecha(resultSet.getDate("fecha"));
                horario.setHora(resultSet.getString("hora"));
            }
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return horario;
    }
}
