import java.util.ArrayList;
import java.util.Random;

public class RacingAnimation implements RacingAnimationInterface
{
	// For each tick until all theRacers have completed all of their laps, animate()
	// moves the theRacers forward the distance they should go in that tick,
	// based on their current speeds.  In  more detail, animate() follows this
	// logic:
	//
	//     Until all theRacers have finished the race...
	//     Each time through the loop is one 'tick' of the race clock
	//     {   For each racer in the list of theRacers...
	//            If the racer has not yet finished the race...
	//                Move the racer forward one clock tick
	//         Repaint the screen to show the movement made this tick
	//         Pause to slow the animation to a visible speed
	//     }
	//     Race done!  Compute the statistics
	//
	
	//The arrayList of all the RacingSmileys
	ArrayList<RacingSmiley> theRacers;
	private RacingDisplay display; //display 
	private Random generator; //Random generator to generate speeds

	//Initializes display, gets the racers from racing group into the Racers and creates a new Random generator
	RacingAnimation(RacingGroup g, RacingDisplay d){
		display = d; 
		theRacers = g.getRacers();
		generator = new Random();
	}
	
	//checks if arraylist is not empty. 
	//calls function to assign random speeds to each racer.
	//while the number of finished racers does not equal the number of racers in the race,
	//each unfinished racer will race for one tick
	//if racer has finished, the number of finished racers increments
	// repaint the display and pause
	// once the the number of finished racers is equal to the number of racers, break from loop
	public void animate()
	{
		if (!getRacers().isEmpty()){
			assignSpeeds();
			boolean allFinished = false;
			while(!allFinished)
			{
				int FinishedRacers = 0;
				for(RacingSmiley rs : getRacers()){
					if(!rs.finishedRace()){
						rs.raceForOneTick();
					}
					else
						FinishedRacers++;
					display.repaint();
					pause(1);
				}
				if (FinishedRacers == getRacers().size())
					allFinished = true;
			}
		}
	}

	
	//creates a random int for each smiley that will represent its speed change
	//also call adjust speed, which gives that smiley its new speed change so the smileys will starts out with different speeds.
	private void assignSpeeds()
	{
		for (RacingSmiley rs : theRacers){
			int randomInt = generator.nextInt(7);
			randomInt -= 3; //speed from -3 to 3
			rs.setSpeed(randomInt);
			rs.adjustSpeed();
		}
	}
	
	//pause was copied and pasted from previous lab
	private void pause(int millisecs)
	{
		try
		{
			Thread.sleep(millisecs);
		}
		catch (InterruptedException e)
		{
		}
	}
	
	
	// getRacers() returns all the theRacers (with their information).
	public ArrayList<RacingSmiley> getRacers(){
		return theRacers;
	}

	
	// getStatisticsTitle() returns the title that should be shown in the
	// statistics area of the window.
	// Just return empty string
	public String getStatisticsTitle()
	{
		String title="";
		return title;
	}

	
	// getAverageTicks() returns the average time, in ticks, that each
	// smiley spent completing the race.
	public double getAverageTicks()
	{
		double averageTime=0.0;
		if (!theRacers.isEmpty()){ //making sure the arraylist is not empty
			for (RacingSmiley rs : theRacers){
				averageTime  += rs.getTicks();
			}
			averageTime = averageTime/theRacers.size();
		}
		return averageTime;
	}

	// getFewestTicks() returns the number of ticks spent by the fastest
	// smiley in completing the race.
	public int getFewestTicks()
	{
		int fewest;
		if (!theRacers.isEmpty()){ //making sure the arraylist is not empty
			// gets first racer and compares it to the rest and return the racer with fewest ticks
			fewest = theRacers.get(0).getTicks();
			for (RacingSmiley rs : theRacers){
				if (rs.getTicks()<fewest){
					fewest = rs.getTicks();
				}
			}
		}
		else fewest = 0;
		return fewest;
	}

	// getMostTicks() returns the number of ticks spent by the slowest
	// smiley in completing the race.
	public int getMostTicks()
	{
		int most;
		if (!theRacers.isEmpty()){ //making sure the arraylist is not empty
			// gets first racer and compares it to the rest and return the racer with most ticks
			most = theRacers.get(0).getTicks();
			for (RacingSmiley rs : theRacers){
				if (rs.getTicks()>most)
					most = rs.getTicks();
			}
		}
		else most = 0;
		return most;
	}

	// getFastestSmileyName() returns the name of the fastest smiley.
	public String getFastestSmileyName()
	{
		if (!theRacers.isEmpty()){ //making sure the arraylist is not empty
			int fewestTicks = getFewestTicks();
			// checks each smile and returns smiley with fewest ticks
			for (RacingSmiley rs : theRacers){
				if (rs.getTicks() == fewestTicks){
					return rs.getSmileyName();
				}
			}
		} 
		return null;
	}

	// getSlowestSmileyName() returns the name of the slowest smiley.
	public String getSlowestSmileyName()
	{
		if (!theRacers.isEmpty()){
			int mostTicks = getMostTicks();
			// checks each smile and returns smiley with most ticks
			for (RacingSmiley rs : theRacers){
				if (rs.getTicks() == mostTicks)
					return rs.getSmileyName();
			}
		} 
		return null;
	}

}
