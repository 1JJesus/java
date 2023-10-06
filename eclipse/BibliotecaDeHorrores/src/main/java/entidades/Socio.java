package entidades;

public class Socio {

	private int IDSOCIO;
	private long EMAIL;
	private String NOMBRE;
	private long DIRECCION;
	private int VERSION;
	
	public Socio(int iDSOCIO, long eMAIL, String nOMBRE, long dIRECCION, int vERSION) {
		IDSOCIO = iDSOCIO;
		EMAIL = eMAIL;
		NOMBRE = nOMBRE;
		DIRECCION = dIRECCION;
		VERSION = vERSION;
	}
	
	public Socio() {
		
	}

	public int getIDSOCIO() {
		return IDSOCIO;
	}

	public void setIDSOCIO(int iDSOCIO) {
		IDSOCIO = iDSOCIO;
	}

	public long getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(long eMAIL) {
		EMAIL = eMAIL;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public long getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(long dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public int getVERSION() {
		return VERSION;
	}

	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	@Override
	public String toString() {
		return "Socio [IDSOCIO=" + IDSOCIO + ", EMAIL=" + EMAIL + ", NOMBRE=" + NOMBRE + ", DIRECCION=" + DIRECCION
				+ ", VERSION=" + VERSION + "]";
	}
	
	
	
}
