import java.util.ArrayList;
import java.util.Scanner;

public class BaseballPlayers {
	
	
	private ArrayList<String> name;
	private ArrayList<String> teamName;
	private ArrayList<Integer> number;
	private ArrayList<Integer> age;
	private Team team;

	private Scanner scanner;


	public BaseballPlayers() {
			name = new ArrayList<String>();
			teamName = new ArrayList<String>();
			number = new ArrayList<Integer>();
			age = new ArrayList<Integer>();
			scanner = new Scanner(System.in);
			
	}
	
	public void setTeam(Team team){
		this.team = team;
	}

	public void addPlayer(String name, String teamName, int number, int age) {
		
		if(teamName == "Yankees"){
		int yankeeRoster = 0;
		yankeeRoster++;
			if( yankeeRoster > 2) {
				team.checkTeamSize(yankeeRoster);
			}
		}
		int i = 0;
		
			this.number.add(number);
			this.name.add(name);
			this.teamName.add(teamName);
			this.age.add(age);
	}
	public void checkNumber() {
		boolean isValid = false;
		int number;
		for(int i = 0; i < this.number.size()-1; i++) {


			if(this.number.get(i) == this.number.get(i+1)) {
				do {
					System.out.println(this.name.get(i) 
							+ " has the same number as " 
							+ this.name.get(i+1)
							+ " please replace with a different number");
					number = scanner.nextInt();
					if(this.number.get(i) != number){
						this.number.add(i+1,number);
						isValid = true;
					}



				}while(isValid == false);
			}
		}
	}
	
	public ArrayList<Integer> cloneArray() {
		
		ArrayList<Integer> clone = this.number;
		
		return clone;
		
	}
	
	public String getName(int i) {
		
		return name.get(i);
	}

	public String getTeamName(int i) {
		return teamName.get(i);
	}

	
	public int getNumber(int i) {
		return number.get(i);
	}

	public int arraySize() {
		
		return this.name.size();
	}

	public int getAge(int i) {
		return age.get(i);
	}
	
}
