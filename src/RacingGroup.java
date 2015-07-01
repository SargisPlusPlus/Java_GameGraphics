import java.awt.Color;
import java.util.ArrayList;

public class RacingGroup implements RacingGroupInterface
{
	//creating racers in arraylist
	ArrayList<RacingSmiley> theRacers = new ArrayList<RacingSmiley>();

	RacingGroup(Color background){
		
		//each racer is created by creating animatedsmiley which is passed into racing smiley that sets name and name color 
		AnimatedSmiley s1 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley1 = new RacingSmiley(s1, "Racer1", Color.RED);
		
		AnimatedSmiley s2 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley2 = new RacingSmiley(s2, "Racer2", Color.GREEN);
		
		AnimatedSmiley s3 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley3 = new RacingSmiley(s3, "Racer3", Color.CYAN);
		
		AnimatedSmiley s4 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley4 = new RacingSmiley(s4, "Racer4", Color.DARK_GRAY);
		
		AnimatedSmiley s5 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley5 = new RacingSmiley(s5, "Racer5", Color.MAGENTA);
		
		AnimatedSmiley s6 = new AnimatedSmiley(10,0);
		RacingSmiley racingSmiley6 = new RacingSmiley(s6, "Racer6", Color.ORANGE);
		
		//sets all the attributes and adds it to the arraylist
		racingSmiley1.getFace().setAttributes(Color.CYAN, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley1.getLeftEye().setAttributes(racingSmiley1.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley1.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley1.getSmile().setAttributes(background,racingSmiley1.getRightEdge(), yMouth(racingSmiley1),30, 10); //sets values for smile
		theRacers.add(racingSmiley1);
				
		racingSmiley2.getFace().setAttributes(Color.YELLOW, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley2.getLeftEye().setAttributes(racingSmiley2.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley2.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley2.getSmile().setAttributes(background,racingSmiley2.getRightEdge(), yMouth(racingSmiley2),30, 10); //sets values for smile
		theRacers.add(racingSmiley2);		
		
		racingSmiley3.getFace().setAttributes(Color.WHITE, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley3.getLeftEye().setAttributes(racingSmiley3.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley3.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley3.getSmile().setAttributes(background,racingSmiley3.getRightEdge(), yMouth(racingSmiley3),30, 10); //sets values for smile
		theRacers.add(racingSmiley3);
		
		racingSmiley4.getFace().setAttributes(Color.GREEN, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley4.getLeftEye().setAttributes(racingSmiley4.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley4.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley4.getSmile().setAttributes(background,racingSmiley4.getRightEdge(), yMouth(racingSmiley4),30, 10); //sets values for smile
		theRacers.add(racingSmiley4);
		
		racingSmiley5.getFace().setAttributes(Color.lightGray, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley5.getLeftEye().setAttributes(racingSmiley5.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley5.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley5.getSmile().setAttributes(background,racingSmiley5.getRightEdge(), yMouth(racingSmiley5),30, 10); //sets values for smile
		theRacers.add(racingSmiley5);
		
		racingSmiley6.getFace().setAttributes(Color.RED, 150,150, 50, 50); //sets values such as color of face, center, height, and width coordinates.
		racingSmiley6.getLeftEye().setAttributes(racingSmiley6.getFace().getColor(), 140, 140, 7, 12); //sets same values for the left eye
		racingSmiley6.getRightEye().setAttributes(Color.BLUE, 160, 140, 7, 12); //sets values for the right eye
		racingSmiley6.getSmile().setAttributes(background,racingSmiley6.getRightEdge(), yMouth(racingSmiley5),30, 10); //sets values for smile
		theRacers.add(racingSmiley6);
		
		//puts racers in their spots
		placeRacers();
	}
	
	//returns the coordinate where mouth should be placed on the smiley.
	private int yMouth(RacingSmiley cntSmiley)
	{
		return cntSmiley.getFace().getCenterY()+(cntSmiley.getBottomEdge()-cntSmiley.getFace().getCenterY())/2;
		
	}

	//places each racer right underneath the previous racer by getting the previous racer's bottom edge.
	//it translates each racer underneath the other racers
	// translates by subtracting its left edge and subtracting the differentce of the previous racer's bottom edge and current racer's top edge.
	private void placeRacers()
	{
		if (!getRacers().isEmpty()){
			RacingSmiley prevRS=theRacers.get(0);
			theRacers.get(0).translate(-theRacers.get(0).getLeftEdge(), -theRacers.get(0).getTopEdge());
			for (int i = 1; i < theRacers.size();i++){
				RacingSmiley rs = theRacers.get(i);
				rs.translate(-rs.getLeftEdge(), -(rs.getTopEdge()-prevRS.getBottomEdge()));
				prevRS=rs;
			}
		}		
	}
	
	//return racers arraylist
	public ArrayList<RacingSmiley> getRacers(){		
		return theRacers;
	}

}
