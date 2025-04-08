package shakespeare;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class list{
	public static void main(String[] args) {
		try {
			File myFile = new File("list.txt");
			Scanner scanner = new Scanner(myFile);
			
			HashMap<Integer,Double> map = new HashMap<Integer, Double>();
			while(scanner.hasNext()){
				String[] temp = scanner.nextLine().split(", ");
				for(int i = 0; i<temp.length; i++) {
					int key = Integer.parseInt(temp[2]);
					double result = Double.parseDouble(temp[3]);
					map.put(key,result);
				}
			}
			
			Scanner myScanner = new Scanner(System.in);
			System.out.println("what ID?");
			int id = myScanner.nextInt();
			if(map.containsKey(id)){
				System.out.println(map.get(id));
			}else {
				System.out.println("no data");
			}
			myScanner.close();
			scanner.close();
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
}
