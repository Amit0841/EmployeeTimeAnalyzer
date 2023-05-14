package Q4;

public class Data {
	

	private int intVar;
	private float floatVar;
	private String stringvar;
	
	
public Data(int intVar, float floatVar, String stringvar) {
		super();
		this.intVar = intVar;
		this.floatVar = floatVar;
		this.stringvar = stringvar;
	}


public int getIntVar() {
		return intVar;
	}


	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}


	public float getFloatVar() {
		return floatVar;
	}


	public void setFloatVar(float floatVar) {
		this.floatVar = floatVar;
	}


	public String getStringvar() {
		return stringvar;
	}


	public void setStringvar(String stringvar) {
		this.stringvar = stringvar;
	}

	@Override
	public String toString() {
		return "Data [intVar=" + intVar + ", floatVar=" + floatVar + ", stringvar=" + stringvar + "]";
	}


}
