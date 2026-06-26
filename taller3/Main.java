import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> inscripciones = new HashMap<>();
        inscripciones.put("C001", 50);
        inscripciones.put("C002", 30);
        inscripciones.put("C003", 80);
        inscripciones.put("C004", 40);
        inscripciones.put("C005", 60);

        Map<String, Double> precios = new HashMap<>();
        precios.put("C001", 40.0);
        precios.put("C002", 55.0);
        precios.put("C003", 30.0);
        precios.put("C004", 35.0);
        precios.put("C005", 25.0);

        System.out.println(PlataformaCursos.obtenerCursosMasRentables(inscripciones, precios, 3));
    }
}
