/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cine.entities;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.cine.persistence.MySQLConnection;

/**
 *
 * @author vagui
 */
public class Pelicula {

    private int id = 0;
    private String titulo = "";
    private String duracion = "";
    private String genero = "";
    private String sinopsis = "";

    public Pelicula(int id, String titulo, String duracion, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Pelicula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    //Metodos
    public static List<Pelicula> getAll(String filtro) {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Peliculas WHERE Titulo LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pelicula p = new Pelicula();
                p.setId(resultSet.getInt(1));
                p.setTitulo(resultSet.getString(2));
                p.setDuracion(resultSet.getString(3));
                p.setGenero(resultSet.getString(4));
                p.setSinopsis(resultSet.getString(5));
                peliculas.add(p);
            }
        } catch (SQLException ex) {
            System.err.print("Error: " + ex);
        }
        return peliculas;
    }

    public boolean save(String titulo, String duracion, String genero, String sinopsis) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO Peliculas(Titulo,Duracion, Genero,Sinopsis)VALUES (?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, duracion);
            statement.setString(3, genero);
            statement.setString(4, sinopsis);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public boolean update(int id, String titulo, String duracion, String genero, String sinopsis) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE Peliculas SET titulo=?, duracion=?, genero=?, sinopsis=? WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, duracion);
            statement.setString(3, genero);
            statement.setString(4, sinopsis);
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
            String query = "DELETE FROM Peliculas WHERE id= ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public static Pelicula getById(int id) {
        Pelicula pelicula = null;
        try {

            Connection conexion = MySQLConnection.get();
            String query = "SELECT * FROM Peliculas WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                pelicula = new Pelicula();
                pelicula.setId(resultSet.getInt("id"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                pelicula.setGenero(resultSet.getString("genero"));
                pelicula.setDuracion(resultSet.getString("duracion"));
                pelicula.setSinopsis(resultSet.getString("sinopsis"));
            }
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return pelicula;
    }

}
