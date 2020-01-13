package practice;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employer emp=new Employer(5);
		Employer emp1=new Employer(5);
		Integer int1=new Integer(1);
		Integer int2=new Integer(2);
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		map.put(int1, 10);
		map.put(int1, 10);
		System.out.println(map.size());
		Map<Employer,Integer> map2=new HashMap<Employer,Integer>();
		map2.put(emp, 10);
		map2.put(emp1, 10);
		System.out.println(map2.size());
	}	

}
