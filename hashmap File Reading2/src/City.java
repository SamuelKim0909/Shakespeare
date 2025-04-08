
public class City {
	private String name;
	private String stateName;
	private int confirmed;
	private int deaths;
	private int recovered;
	private int active;
	public City(String name, String stateName, int confirmed, int deaths, int recovered, int active) {
		super();
		this.name = name;
		this.stateName = stateName;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "city [name=" + name + ", stateName=" + stateName + ", confirmed=" + confirmed + ", deaths=" + deaths
				+ ", recovered=" + recovered + ", active=" + active + "]";
	}
	
}
