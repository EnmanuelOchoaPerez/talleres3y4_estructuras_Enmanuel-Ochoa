class CursoRentable {

    private final String codigo;
    private final double ingreso;

    public CursoRentable(String codigo, int inscripciones, double precio) {
        this.codigo = codigo;
        this.ingreso = inscripciones * precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getIngreso() {
        return ingreso;
    }
}