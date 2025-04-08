package shakespeare;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("shakespeare.txt");
			Scanner scanner = new Scanner(file);
			//map's result must be 
			HashMap <String, HashMap<String, word>> map = new HashMap <String,HashMap<String, word>>();
			while(scanner.hasNext()) {
				//System.out.println(scanner.next());
				String[] temp = scanner.nextLine().split(" ");
				for(int i = 0; i<temp.length-1; i++) {//
					String key = temp[i];
					HashMap<String, word> result = new HashMap<String, word>();
					result.put(temp[i+1], new word(temp[i+1]));
					if(map.containsKey(key)) {
						if(map.get(key).containsKey(temp[i+1])) {
							map.get(key).get(temp[i+1]).addCount();
						}else {
							map.get(key).put(temp[i+1],new word(temp[i+1]));
						}
					}else {
						map.put(key, result);
					}
				}
			}
			
			Scanner myScanner = new Scanner(System.in);
			System.out.println("what word?");
			String keyWord = myScanner.next();
			
			if(map.containsKey(keyWord)) {
				int high = 0;
				String highest = "";
				for(word i: map.get(keyWord).values()) {
					if(high<i.getCount()){
						highest = i.getWord();
						high = i.getCount();
					}
				}
				System.out.println("prediction: "+ highest);
			}else {
				System.out.println("no data");
			}
			
			
			
			}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
	}

}
