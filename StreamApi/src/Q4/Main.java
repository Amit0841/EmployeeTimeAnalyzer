package Q4;
import java.util.*;
import java.util.function.Predicate;


public class Main {

	public static void main(String[] args) {
	
		
		List<Data> data= new ArrayList<>();
		
		data.add(new Data(5, 6.2f, "a"));
		data.add(new Data(6, 7.2f, "b"));
		data.add(new Data(7, 8.2f, "c"));
		data.add(new Data(8, 19.2f, "d"));
		data.add(new Data(9, 36.2f, "e"));
		data.add(new Data(12, 62.2f, "f"));
		data.add(new Data(52, 63.2f, "g"));
		data.add(new Data(59, 64.2f, "h"));
		data.add(new Data(52, 67.2f, "i"));
		data.add(new Data(58, 69.2f, "j"));
		
		Predicate<Integer> isprime= i-> {
			
			if(i<2){
				return false;
			}
			boolean prime=true;
			for(int a=2;a<i;a++) {
				if(i%a==0){
					prime=false;
					break;
				}
			}
			return prime;
		};
		
        System.out.println(data.stream().map(p -> p.getIntVar()).anyMatch(isprime)?"one or more element is prie":"No element is prime");

		System.out.println(data.stream().map(p -> p.getStringvar()).distinct().toList());
		
		System.out.println(data.stream().sorted((a,b)-> a.getFloatVar()>b.getFloatVar()?1:-1).skip(2).limit(5).toList());
		
		System.out.println(data.stream().mapToDouble(Data ::getFloatVar).average());
		
		System.out.println(data.stream().mapToInt(Data::getIntVar).reduce(0, Integer::sum));
	}

}
