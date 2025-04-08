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
			HashMap <String, state> total = new HashMap <String,state>();
			int counter = 0;
			while(scanner.hasNextLine()) {
				
				String[] row = scanner.nextLine().split(",");
				//data - add or update?
				//check to see if you have a hashmap for the state
				//if not - create it - add an entry
				//if you do - get the hashmap and update it with the entry;
				String state = row[1];
				if(states.containsKey(state)&& total.containsKey(state)) {
					//grab the hashmap
					//push the new city data
					HashMap<String, City> result = states.get(state);
					String key = row[0];
					City value = new City(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
					result.put(key, value);
					states.put(row[1], result);
					
					state one = total.get(state);
					one.setConfirmed(Integer.parseInt(row[2]));
					one.setDeaths(Integer.parseInt(row[3]));
					one.setRecovered(Integer.parseInt(row[4]));
					one.setActive(Integer.parseInt(row[5]));

				}else {
					HashMap<String, City> result = new HashMap<String, City>();
					state two = new state(row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
					states.put(row[1], result);
					String key = row[0];
					City value = new City(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
					states.put(row[1], result);
					total.put(row[1], two);
				}
			}
			
			for(int i = 0; i<10; i++) {
				Scanner userScanner = new Scanner(System.in);
				System.out.println("type in the city");
				String city = userScanner.next();
				System.out.println("type in the state");
				String state = userScanner.next();
				
				if(total.containsKey(state)) {
					if(states.containsKey(city)) {
					//HashMap<String, Integer> myStat = total.get(state);
						System.out.println(states.get(state).get(city).toString());
					}
					System.out.println("state: " + state);
					System.out.println("confirmed: " + total.get(state).getConfirmed());
					System.out.println("deaths: " + total.get(state).getDeaths());
					System.out.println("recovered: " + total.get(state).getRecovered());
					System.out.println("active: " + total.get(state).getActive());

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
