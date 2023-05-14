package Q5;

public class Applicant {
private String applid;
private String name;
private double Intmarks;




public Applicant(String applid, String name, double intmarks) {
	super();
	this.applid = applid;
	this.name = name;
	Intmarks = intmarks;
}
public String getApplid() {
	return applid;
}
public void setApplid(String applid) {
	this.applid = applid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getIntmarks() {
	return Intmarks;
}
public void setIntmarks(double intmarks) {
	Intmarks = intmarks;
}
@Override
public String toString() {
	return "Applicant [applid=" + applid + ", name=" + name + ", Intmarks=" + Intmarks + "]";
}



}
