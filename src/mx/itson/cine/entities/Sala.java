/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cine.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.cine.persistence.MySQLConnection;

/**
 *
 * @author vagui
 */
public class Sala {

    private int id = 0;
    private String tipo = "";
    private String capacidad = "";

    public Sala(int id, String tipo, String capacidad) {
        this.id = id;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public Sala() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    //Metodos
    public static List<Sala> getAll(String filtro) {
        List<Sala> salas = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Salas WHERE Tipo LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Sala s = new Sala();
                s.setId(resultSet.getInt(1));
                s.setTipo(resultSet.getString(2));
                s.setCapacidad(resultSet.getString(3));

                salas.add(s);
            }
        } catch (SQLException ex) {
            System.err.print("Error: " + ex);
        }
        return salas;
    }

    public boolean save(String tipo, String capacidad) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO Salas(Tipo, Capacidad)VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, tipo);
            statement.setString(2, capacidad);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }

    public boolean update(int id, String tipo, String capacidad) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE Salas SET Tipo=?, Capacidad=? WHERE id=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, tipo);
            statement.setString(2, capacidad);
            statement.setInt(3, id);
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
            String query = "DELETE FROM Salas WHERE id= ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return result;
    }
    
    public static Sala getById(int id) {
        Sala sala = null;
        try {

            Connection conexion = MySQLConnection.get();
            String query = "SELECT * FROM Salas WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                sala = new Sala();
                sala.setId(resultSet.getInt("id"));
                sala.setTipo(resultSet.getString("tipo"));
                sala.setCapacidad(resultSet.getString("capacidad"));
            }
        } catch (Exception ex) {
            System.err.print("Error: " + ex);
        }
        return sala;
    }

}
