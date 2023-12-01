// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        conexionBD.conectar();
        int totalRegistros = conexionBD.obtenerTotalRegistros();
        conexionBD.cargarRegistro();
        conexionBD.cerrar();


    }
}