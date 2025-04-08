package shakespeare;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Runner2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("shakespeare.txt");
			Scanner scanner = new Scanner(file);
			//map's result must be 
			HashMap <String, HashMap<String, HashMap<String, word>>> map = new HashMap <String,HashMap<String,HashMap<String, word>>>();
			while(scanner.hasNext()) {
				//System.out.println(scanner.next());
				String[] temp = scanner.nextLine().split(" ");
				for(int i = 0; i<temp.length-2; i++) {
					String key = temp[i];
					String key2 = temp[i+1];
					String goalWord = temp[i+2];
					HashMap<String, HashMap<String, word>> result = new HashMap<String, HashMap<String, word>>();
					HashMap<String, word> result2 = new HashMap<String, word>();
					result2.put(goalWord, new word(goalWord));
					result.put(key2, result2);
					if(map.containsKey(key)) {

						if(map.get(key).containsKey(key2)) {
							if(map.get(key).get(key2).containsKey(goalWord)) {
								map.get(key).get(key2).get(goalWord).addCount();
							}else {
								map.get(key).get(key2).put(goalWord, new word(goalWord));
							}
						}else {
							map.get(key).put(key2, result2);
						}
					}else {
						map.put(key, result);
					}
				
				}
			}
			
			while(1!=0) {
				Scanner myScanner = new Scanner(System.in);
				System.out.println("what words?");
				String[] words = myScanner.nextLine().split(" ");
				if(map.containsKey(words[0])) {
					if(map.get(words[0]).containsKey(words[1])) {
						int high = 0;
						String highest = "";
						for(word i: map.get(words[0]).get(words[1]).values()) {
							if(high<i.getCount()){
								highest = i.getWord();
								high = i.getCount();
							}
						}
						System.out.println("prediction: "+ highest);
					}else {
						System.out.println("no data");
					}
				}else {
					System.out.println("no data");
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
		
	}




}
