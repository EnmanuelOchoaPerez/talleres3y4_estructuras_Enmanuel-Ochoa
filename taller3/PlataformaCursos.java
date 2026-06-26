import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PlataformaCursos {

    /**
     * Obtiene los n cursos con mayor ingreso.
     *
     * @param mapaInscripciones Mapa con el número de inscripciones por curso.
     * @param mapaPrecios Mapa con el precio de inscripción por curso.
     * @param n Cantidad de cursos a retornar.
     * @return Lista con los códigos de los cursos más rentables.
     */
    public static List<String> obtenerCursosMasRentables(
            Map<String, Integer> mapaInscripciones,
            Map<String, Double> mapaPrecios,
            int n) {

        List<String> resultado = new ArrayList<>();

        if (mapaInscripciones == null || mapaPrecios == null || n <= 0) {
            return resultado;
        }

        List<CursoRentable> cursos = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapaInscripciones.entrySet()) {
            String codigo = entry.getKey();

            if (mapaPrecios.containsKey(codigo)) {
                int inscripciones = entry.getValue();
                double precio = mapaPrecios.get(codigo);

                cursos.add(new CursoRentable(codigo, inscripciones, precio));
            }
        }

        cursos.sort(
                Comparator.comparingDouble(CursoRentable::getIngreso)
                        .reversed()
                        .thenComparing(CursoRentable::getCodigo)
        );

        int limite = Math.min(n, cursos.size());

        for (int i = 0; i < limite; i++) {
            resultado.add(cursos.get(i).getCodigo());
        }

        return resultado;
    }
}

