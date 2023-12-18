// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        conexionBD.conectar();
        conexionBD.obtenerTotalRegistros();
        conexionBD.obtenerRegistros(2,4);
        conexionBD.cargarRegistro("MetalGear", 1, "1900-03-12", 300);
        conexionBD.cerrar();


    }
}