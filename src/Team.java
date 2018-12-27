import java.util.ArrayList;

public class Team {
	ArrayList<BaseballPlayers> majorLeague;
	ArrayList<BaseballPlayers> minorLeague;
	public Team() {
		
		majorLeague = new ArrayList<BaseballPlayers>();
		minorLeague = new ArrayList<BaseballPlayers>();
	
	}
	
	public void addTeamPlayer( BaseballPlayers baseballPlayer ) {
		majorLeague.add(baseballPlayer);
	}
	
	public void getTeamPlayers() {
		
		for(int i = 0; i < majorLeague.size(); i++) {
			
			for(int j= 0; j < majorLeague.get(i).arraySize(); j++)
			System.out.println("Player:" + majorLeague.get(i).getName(j) + ", Age:"
								+ majorLeague.get(i).getAge(j) + ", Number:"
								+ majorLeague.get(i).getNumber(j));
			
		}
	}
}
