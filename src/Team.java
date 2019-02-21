import java.util.ArrayList;

public class Team {
	ArrayList<BaseballPlayers> majorLeague;
	ArrayList<BaseballPlayers> minorLeague;
	private StringBuilder stringBuilder,stringBuilder2,stringBuilder3;
	private int s = 0;
	public int test = 2;
	
	public Team() {

		majorLeague = new ArrayList<BaseballPlayers>();
		minorLeague = new ArrayList<BaseballPlayers>();
		stringBuilder = new StringBuilder();
		stringBuilder2 = new StringBuilder();
		stringBuilder3 = new StringBuilder();

	}

	public void addTeamPlayer( BaseballPlayers baseballPlayer ) {
		majorLeague.add(baseballPlayer);
	}

	public String getTeamPlayers() {

		System.out.println(s);
		int counter = 0;
		s++;
		for(int i = 0; i < majorLeague.size(); i++) {
		
			for(int j= 0; j < majorLeague.get(i).arraySize(); j++) {
				counter++;
				
				stringBuilder.append(counter + ". " + "Player:" + majorLeague.get(i).getName(j) + ", Age:"
						+ majorLeague.get(i).getAge(j)+" Team:" 
						+ majorLeague.get(i).getTeamName(j) + ", Number:" 
						+ majorLeague.get(i).getNumber(j) + "\n");
				stringBuilder3.append(stringBuilder);
//				if(stringBuilder.equals(stringBuilder3)) {
//					
//					stringBuilder.setLength(0);
//				}
			}

		}
		return stringBuilder.toString();
	}


	public String playersCounter() {
		int counter = 0;
		for(int i = 0; i < majorLeague.size(); i++) {

			for(int j= 0; j < majorLeague.get(i).arraySize(); j++) {
				counter++;
				stringBuilder2.setLength(0);
				stringBuilder2.append(counter +". " + majorLeague.get(i).getName(j) + " has been added to the "
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
