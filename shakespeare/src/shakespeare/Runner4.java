package shakespeare;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Runner4 {

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
				for(int i = 0; i<temp.length; i++) {//removing periods and commas
					if(temp[i].substring(temp[i].length()-1).equals(",")
							||temp[i].substring(temp[i].length()-1).equals(".")) {
						temp[i] = temp[i].substring(0,temp[i].length()-1);
					}
				}
				for(int i = 0; i<temp.length-1; i++) {
					String key = temp[i];
					String goalWord = temp[i+1];
					HashMap<String, word> result = new HashMap<String, word>();
					result.put(goalWord, new word(goalWord));
					if(map.containsKey(key)) {
						if(map.get(key).containsKey(goalWord)) {
							map.get(key).get(goalWord).addCount();
						}else {
							map.get(key).put(goalWord,new word(goalWord));
						}
					}else {
						map.put(key, result);
					}
				}
			}	
			//System.out.println(Auto("once upon a time, there was a", map)+"");
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
	}
	
	public static String Auto(String start, HashMap <String, HashMap<String, word>> map) {
		Scanner myScanner = new Scanner("shakespeare.txt");
		String[] list = myScanner.nextLine().split(" ");
		String keyWord = list[list.length-1];
		if(!map.containsKey(keyWord)) {
			return start;
		}else {
			int high = 0;
			String highest = "";
			for(word i: map.get(keyWord).values()) {
				if(high<i.getCount()){
					highest = i.getWord();
					high = i.getCount();
				}
			}
			start += highest;
			return Auto(start, map);
		}
	}

}
