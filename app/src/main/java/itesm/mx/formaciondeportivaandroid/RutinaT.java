package itesm.mx.formaciondeportivaandroid;

/**
 * Created by armando on 23/10/2016.
 */
public class RutinaT {
    private String sTipo;
    private int idFotoRT;

    public RutinaT(String sTipo, int idFotoRT) {
        this.sTipo = sTipo;
        this.idFotoRT = idFotoRT;
    }

    public String getsTipo() {
        return sTipo;
    }

    public void setsTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public int getIdFotoRT() {
        return idFotoRT;
    }

    public void setIdFotoRT(int idFoto) {
        this.idFotoRT = idFoto;
    }
}
