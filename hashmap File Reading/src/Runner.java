import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File covidFile = new File("covid417.csv");
			
			Scanner scanner = new Scanner(covidFile);
			scanner.nextLine();
			
			HashMap <String, HashMap<String,City> > states = new HashMap<String, HashMap<String, City>>();
			
			int counter = 0;
			while(scanner.hasNextLine()) {
				
				String[] row = scanner.nextLine().split(",");
				//data - add or update?
				//check to see if you have a hashmap for the state
				//if not - create it - add an entry
				//if you do - get the hashmap and update it with the entry;
				String state = row[1];
				if(states.containsKey(state)) {
					//grab the hashmap
					//push the new city data
					HashMap<String, City> result = states.get(state);
					String key = row[0];
					City value = new City(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
					
					result.put(key, value);

					states.put(row[1], result);
				}else {
					HashMap<String, City> result = new HashMap<String, City>();
					states.put(row[1], result);
					
					String key = row[0];
					City value = new City(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
					
					result.put(key, value);
					states.put(row[1], result);
				}
			}
			for(int i = 0; i<10; i++) {
				Scanner userScanner = new Scanner(System.in);
				System.out.println("type in the city");
				String city = userScanner.next();
				System.out.println("type in the state");
				String state = userScanner.next();
				
				if(states.containsKey(state)) {
					//grab the hashmap
					//push the new city data
					System.out.println(states.get(state).get(city).toString());
				
				
				}else {
					System.out.println("No data");
				}
				i--;
			}
			
		}catch(Exception e) {
			System.out.print("error error " + e);
		}
	}

}
