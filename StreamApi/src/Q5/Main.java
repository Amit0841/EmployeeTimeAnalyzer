package Q5;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
public class Main {
public static void main(String[] args) {
	
	List<Applicant> applicantlist=new ArrayList<>();
	
	applicantlist.add(new Applicant("R1", "a", 85));
	applicantlist.add(new Applicant("R2", "b", 65));
	applicantlist.add(new Applicant("R3", "c", 45));
	applicantlist.add(new Applicant("R4", "d", 75));
	applicantlist.add(new Applicant("R5", "e", 95));
	

   List<Employee> list=applicantlist.stream().map(a -> {
	  
	   String Emplid=a.getApplid();
	   String name=a.getName();
	   double  intervimarks=a.getIntmarks();
	   String desig;
	   double salary;
	   
	   if(intervimarks>=85){
	   
		   desig="Manager";
		   salary=60000+(50*intervimarks);
	   }
	   else if(intervimarks>=65){
	   
		   desig="Clerk";
		   salary=35000+(30*intervimarks);
	   }
	   else if(intervimarks>=50){
	   
		   desig="Junior clerk";
		   salary=25000+(20*intervimarks);
	   }else {
	   
		   desig=null;
		   salary=0;
	   }
	   
	   
	   if(desig!=null) {
		   return new Employee(Emplid, name, desig, salary);
	   }else{
	   		   return null;
	   }
   }).filter(Objects::nonNull).toList();
   
   list.forEach(a->System.out.println(a));
   
   
   List<String> desig=new ArrayList<>();
   Comparator<Employee> sortby =(e1,e2) ->{
	   if(e1.getSalary()-e2.getSalary()>1) {
		   return -1;
	   }else if(e1.getSalary()-e2.getSalary()<1) {
		   return -1;
	   }else{
	   return 0;
}
   };
   
   
   Consumer<Employee> c=emp ->{
   
	  if(!desig.contains(emp.getDesignation())) {
		  System.out.println(emp.getName());
		  desig.add(emp.getDesignation());
	  }
   };
   
  list.stream().sorted(sortby).forEachOrdered(c);
  
  System.out.println();
  List<String> empid=list.stream().map(emp -> emp.getEmplid()).collect(Collectors.toList());
  
  Consumer<Applicant> b=app ->{
	  if(!empid.contains(app.getApplid())) {
		  System.out.println(app.getApplid());
	  }
  };
    
    
   applicantlist.forEach(b);
	
}
}
