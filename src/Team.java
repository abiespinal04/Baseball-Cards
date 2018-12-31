import java.util.ArrayList;

public class Team {
	ArrayList<BaseballPlayers> majorLeague;
	ArrayList<BaseballPlayers> minorLeague;
	private StringBuilder stringBuilder,stringBuilder2;
	public int test = 2;
	
	public Team() {

		majorLeague = new ArrayList<BaseballPlayers>();
		minorLeague = new ArrayList<BaseballPlayers>();
		stringBuilder = new StringBuilder();
		stringBuilder2 = new StringBuilder();

	}

	public void addTeamPlayer( BaseballPlayers baseballPlayer ) {
		majorLeague.add(baseballPlayer);
	}

	public String getTeamPlayers() {

		for(int i = 0; i < majorLeague.size(); i++) {

			for(int j= 0; j < majorLeague.get(i).arraySize(); j++) {


				stringBuilder.append("Player:" + majorLeague.get(i).getName(j) + ", Age:"
						+ majorLeague.get(i).getAge(j)+" Team:" 
						+ majorLeague.get(i).getTeamName(j) + ", Number:" 
						+ majorLeague.get(i).getNumber(j) + "\n");
			}

		}
		return stringBuilder.toString();
	}


	public String playersCounter() {
		for(int i = 0; i < majorLeague.size(); i++) {

			for(int j= 0; j < majorLeague.get(i).arraySize(); j++) {

				stringBuilder2.setLength(0);
				stringBuilder2.append(majorLeague.get(i).getName(j) + " has been added to the "
						+ majorLeague.get(i).getTeamName(j) + "\n");
			}
			
		}
		return stringBuilder2.toString();
	}

	public void checkTeamSize(int yankeeRoster) {
		
		stringBuilder2.setLength(0);
		stringBuilder2.append("Sorry can't add more players to this team, max is 25 players");
		
	}
}
