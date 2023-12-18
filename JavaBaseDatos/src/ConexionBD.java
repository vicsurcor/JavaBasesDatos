
import java.sql.*;
import java.util.ArrayList;

public class ConexionBD {
        private Connection conexion;
        public void conectar() {
            try {

                String url = "jdbc:mysql://localhost:3306/acda";
                String usuario = "root";
                String contrasena = "rootACDA";
                conexion = DriverManager.getConnection(url, usuario, contrasena);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public int obtenerTotalRegistros() {
            int total = 0;
            Statement stmt = null;
            try {
                stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM prueba1");
                while (rs.next()) {
                    total++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return total;
        }

        public ArrayList<String> obtenerRegistros(int inicio, int fin) {
            ArrayList<String> registros = new ArrayList<>();
            try {
                PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM prueba1 WHERE id BETWEEN ? AND ?");
                stmt.setInt(1, inicio);
                stmt.setInt(2, fin);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    registros.add(rs.getString("nombre"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return registros;
        }

        public void cargarRegistro(String campo1, int campo2, String campo3, int campo4) {

            try {
                PreparedStatement stmt = conexion.prepareStatement("INSERT INTO prueba1 (nombre, adquirido, fechaDeSalida, unidades) VALUES (?,?,?,?)");
                stmt.setString(1, campo1);
                stmt.setInt(2, campo2);
                stmt.setDate(3, Date.valueOf(campo3));
                stmt.setInt(4, campo4);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void cerrar() {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
