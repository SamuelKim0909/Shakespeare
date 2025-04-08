
public class state {
	private String name;
	private int confirmed;
	private int deaths;
	private int recovered;
	private int active;
	public state(String name, int confirmed, int deaths, int recovered, int active) {
		super();
		this.name = name;
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
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed += confirmed;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths += deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered += recovered;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active += active;
	}
	
}
