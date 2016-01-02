//Vinit Shah
//January 14, 2013
//Purpose: Match two cards with the same picture in order to gain points to win the game. Achieve required points in minimal amount of moves

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;


public class matchingcards extends Applet implements ActionListener
{
    Panel p_card; //to hold all of the screens
    Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;  //all of the screens                                                                                     //all the screens
    CardLayout cdLayout = new CardLayout ();

    JButton bballarray[] = new JButton [6]; // the array for the basketball buttons
    Panel bballarray1 = new Panel (new GridLayout (2, 3)); //the layout for the basketball images

    JButton footballarray[] = new JButton [8]; //the array for the football buttons
    Panel footballarray1 = new Panel (new GridLayout (2, 4)); // the layout for the football buttons

    JButton hockeyarray[] = new JButton [12]; //the array for the hockey buttons
    Panel hockeyarray1 = new Panel (new GridLayout (3, 4)); //the layout for the hockey buttons

    String bballans[] = {"kobe.jpg", "lebron.jpg", "rose.jpg", "kobe.jpg", "lebron.jpg", "rose.jpg"}; //the basketball imgs
    //sources for imgs provided in criteria b
    int prev = -1; //variable set when the first card of the two is clicked (basketball level)

    String footballans[] = {"brady.jpg", "eli.jpg", "luck.jpg", "peyton.jpg", "brady.jpg",
	"eli.jpg", "luck.jpg", "peyton.jpg"}; //the football imgs
    //sources for imgs provided in criteria b
    int prev2 = -1; //variable set when the first card of the two is clicked (football level)

    String hockeyans[] = {"crosby.jpg", "malkin.jpg", "nash.jpg", "oshi.jpg", "ovi.jpg", "stamkos.jpg",
	"crosby.jpg", "malkin.jpg", "nash.jpg", "oshi.jpg", "ovi.jpg", "stamkos.jpg"}; //the hockey imgs
    //sources for imgs provided in criteria b
    int prev3 = -1; //variable set when the first card of the two is clicked (hockey level)

    int counter1 = 0; //counts the number of moves made in the basketball level
    JLabel score1; //shows the user the number of moves made
    int pointscounter1 = 0; //counts the number of points the user has
    JLabel points1; //shows the user the number of points they have

    int counter2 = 0; //counts the number of moves made in the footballl level
    JLabel score2; //shows the user the number of moves made
    int pointscounter2 = 0; //counts the number of points the user has
    JLabel points2; //shows the user the number of points they have

    int counter3 = 0; //counts the number of moves made in the hockey level
    JLabel score3; //shows the user the number of moves made
    int pointscounter3 = 0; //counts the number of points the user has
    JLabel points3; //shows the user the number of points they have

    int level = 1; //indicates which theme is selected



    public void reset ()  //resets the bball screen
    {
	for (int i = 0 ; i < 500 ; i++)
	{
	    int x = (int) (Math.random () * bballans.length);
	    int y = (int) (Math.random () * bballans.length);
	    String temp = bballans [x];
	    bballans [x] = bballans [y];
	    bballans [y] = temp;
	}
	for (int i = 0 ; i < bballarray.length ; i++)
	{
	    bballarray [i].setIcon (createImageIcon ("nbalogo.gif"));
	    bballarray [i].setEnabled (true);
	}
	prev = -1;
	counter1 = 0; //resets moves
	pointscounter1 = 0; //resets points
	score1.setText ("Moves: 00");
	points1.setText ("Points: 00");
    }


    public void reset2 ()  //resets the football screen
    {
	for (int i = 0 ; i < 500 ; i++)
	{
	    int x = (int) (Math.random () * footballans.length);
	    int y = (int) (Math.random () * footballans.length);
	    String temp = footballans [x];
	    footballans [x] = footballans [y];
	    footballans [y] = temp;
	}
	for (int i = 0 ; i < footballarray.length ; i++)
	{
	    footballarray [i].setIcon (createImageIcon ("nfllogo.jpg"));
	    footballarray [i].setEnabled (true);
	}
	prev2 = -1;
	counter2 = 0; //resets moves
	pointscounter2 = 0; //resets points
	score2.setText ("Moves: 00");
	points2.setText ("Points: 00");
    }


    public void reset3 ()  //resets the hockey screen
    {
	for (int i = 0 ; i < 500 ; i++)
	{
	    int x = (int) (Math.random () * hockeyans.length);
	    int y = (int) (Math.random () * hockeyans.length);
	    String temp = hockeyans [x];
	    hockeyans [x] = hockeyans [y];
	    hockeyans [y] = temp;
	}
	for (int i = 0 ; i < hockeyarray.length ; i++)
	{
	    hockeyarray [i].setIcon (createImageIcon ("nhlogo.gif"));
	    hockeyarray [i].setEnabled (true);
	}
	prev3 = -1;
	counter3 = 0; //resets moves
	pointscounter3 = 0; //resets points
	score3.setText ("Moves: 00");
	points3.setText ("Points: 00");
    }


    public void init ()  //sets up all the screens
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	screen6 ();
	bballwin ();
	bballlose ();
	footballwin ();
	footballlose ();
	hockeywin ();
	hockeylose ();
	resize (850, 695);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    { //main menu
	card1 = new Panel ();
	card1.setBackground (Color.gray);
	JLabel title = new JLabel ("Card Match!");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	Panel p1 = new Panel ();
	JButton play = new JButton ("Play");
	play.setActionCommand ("s3");
	play.addActionListener (this);
	JButton instructions = new JButton ("How to Play");
	instructions.setActionCommand ("s2");
	instructions.addActionListener (this);
	JLabel stars = new JLabel (createImageIcon ("gold.jpg"));
	//picture taken from: http://espn.go.com/nfl/playoffs/2011/matchup/_/teams/ravens-patriots
	p1.add (play);
	p1.add (instructions);
	card1.add (title);
	card1.add (p1);
	card1.add (stars);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //gives the user instructions
	card2 = new Panel ();
	card2.setBackground (Color.gray);
	JLabel title = new JLabel ("How To Play");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	Panel p2 = new Panel (); //holds the buttons together
	JButton play = new JButton ("Play");
	play.setActionCommand ("s3");
	play.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	p2.add (play);
	p2.add (main);
	Panel howto = new Panel (new GridLayout (4, 1));
	JLabel instructions = new JLabel ("The objective of this game is to match pairs of cards by turning over matched pairs.");
	instructions.setFont (new Font ("Arial", Font.BOLD, 13));
	JLabel instructions2 = new JLabel ("Click on a card to flip it over. If the next card you flip over matches the first card, they disappear from the pool and you get a point.");
	instructions2.setFont (new Font ("Arial", Font.BOLD, 13));
	JLabel instructions3 = new JLabel ("Your objective is to clear the board and get the required points with as little tries as possible.");
	instructions3.setFont (new Font ("Arial", Font.BOLD, 13));
	JLabel instructions4 = new JLabel ("One move is when you click two cards, regardless of whether or not they match.");
	instructions4.setFont (new Font ("Arial", Font.BOLD, 13));
	howto.add (instructions);
	howto.add (instructions2);
	howto.add (instructions3);
	howto.add (instructions4);
	JLabel howtoplay = new JLabel (createImageIcon ("help.jpg"));
	howtoplay.setPreferredSize (new Dimension (865, 500));
	//picture taken from: http://decodivadebi.blogspot.ca/2010/01/help-me-help-you.html
	card2.add (title);
	card2.add (p2);
	card2.add (howto);
	card2.add (howtoplay);
	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //user selects level and theme
	card3 = new Panel ();
	card3.setBackground (Color.gray);
	JLabel title = new JLabel ("Pick Your Theme and Difficulty");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	Panel p3 = new Panel ();
	JButton bball = new JButton ("Basketball (easy)");
	bball.setActionCommand ("s4");
	bball.addActionListener (this);
	JButton football = new JButton ("Football (normal)");
	football.setActionCommand ("s5");
	football.addActionListener (this);
	JButton hockey = new JButton ("Hockey (hard)");
	hockey.setActionCommand ("s6");
	hockey.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	JLabel afcgame = new JLabel (createImageIcon ("afcgame.jpg"));
	//img taken from http://www.nytimes.com/2012/01/23/sports/football/patriots-defeat-ravens-to-advance-to-super-bowl.html?_r=0
	p3.add (bball);
	p3.add (football);
	p3.add (hockey);
	p3.add (main);
	card3.add (title);
	card3.add (p3);
	card3.add (afcgame);
	p_card.add ("3", card3);
    }


    public void screen4 ()
    { //basketball screen
	level = 1;
	card4 = new Panel ();
	card4.setBackground (Color.gray);
	JLabel title = new JLabel ("                                   Basketball                                      ");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	JLabel towin = new JLabel ("                                                          Score 3 points in 6 or less moves to win.                                                 ");
	Panel a1 = new Panel ();
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton resetbutton = new JButton ("Reset");
	resetbutton.setActionCommand ("s7");
	resetbutton.addActionListener (this);
	score1 = new JLabel ("Moves: 0");
	points1 = new JLabel ("Points: 0");
	a1.add (main);
	a1.add (newtheme);
	a1.add (resetbutton);
	a1.add (score1);
	a1.add (points1);
	for (int i = 0 ; i < bballarray.length ; i++)
	{
	    bballarray [i] = new JButton (createImageIcon ("nbalogo.gif"));
	    bballarray [i].setPreferredSize (new Dimension (200, 200));
	    bballarray [i].addActionListener (this);
	    bballarray [i].setActionCommand ("" + (i) + "");
	    bballarray [i].setBackground (Color.white);
	    bballarray1.add (bballarray [i]);
	}
	card4.add (title);
	card4.add (towin);
	card4.add (a1);
	card4.add (bballarray1);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //football screen
	level = 2;
	card5 = new Panel ();
	card5.setBackground (Color.gray);
	JLabel title = new JLabel ("                                   Football                                      ");
	JLabel towin = new JLabel ("                                                          Score 4 points in 8 or less moves to win.                                                 ");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	Panel b1 = new Panel ();
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton resetbutton = new JButton ("Reset");
	resetbutton.setActionCommand ("s8");
	resetbutton.addActionListener (this);
	score2 = new JLabel ("Moves: 0");
	points2 = new JLabel ("Points: 0");
	b1.add (main);
	b1.add (newtheme);
	b1.add (resetbutton);
	b1.add (score2);
	b1.add (points2);
	for (int i = 0 ; i < footballarray.length ; i++)
	{
	    footballarray [i] = new JButton (createImageIcon ("nfllogo.jpg"));
	    footballarray [i].setPreferredSize (new Dimension (200, 200));
	    footballarray [i].addActionListener (this);
	    footballarray [i].setActionCommand ("" + (i) + "");
	    footballarray [i].setBackground (Color.white);
	    footballarray1.add (footballarray [i]);
	}
	card5.add (title);
	card5.add (towin);
	card5.add (b1);
	card5.add (footballarray1);
	p_card.add ("5", card5);
    }


    public void screen6 ()
    { //hockey screen level
	level = 3;
	card6 = new Panel ();
	card6.setBackground (Color.gray);
	JLabel title = new JLabel ("                                   Hockey                                      ");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.black);
	JLabel towin = new JLabel ("                                                          Score 6 points in 12 or less moves to win.                                                 ");
	towin.setFont (new Font ("Arial", Font.PLAIN, 14));
	Panel c1 = new Panel ();
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton resetbutton = new JButton ("Reset");
	resetbutton.setActionCommand ("s9");
	resetbutton.addActionListener (this);
	score3 = new JLabel ("Moves: 000000");
	points3 = new JLabel ("Points: 0");
	c1.add (main);
	c1.add (newtheme);
	c1.add (resetbutton);
	c1.add (score3);
	c1.add (points3);
	for (int i = 0 ; i < hockeyarray.length ; i++)
	{
	    hockeyarray [i] = new JButton (createImageIcon ("nhlogo.gif"));
	    hockeyarray [i].setPreferredSize (new Dimension (200, 200));
	    hockeyarray [i].addActionListener (this);
	    hockeyarray [i].setActionCommand ("" + (i));
	    hockeyarray [i].setBackground (Color.white);
	    hockeyarray1.add (hockeyarray [i]);
	}
	card6.add (title);
	card6.add (towin);
	card6.add (c1);
	card6.add (hockeyarray1);
	p_card.add ("6", card6);
    }


    public void bballwin ()  //screen that pops up if the player wins the basketball level
    {
	card7 = new Panel ();
	card7.setBackground (Color.gray);
	JLabel win = new JLabel ("You Win!");
	win.setFont (new Font ("Arial", Font.BOLD, 40));
	win.setForeground (Color.black);
	Panel w1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s4");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	w1.add (again);
	w1.add (newtheme);
	w1.add (main);
	JLabel champs = new JLabel (createImageIcon ("nbachamps.jpg"));
	//img taken from johngarretson.wordpress.com/2011/04/05/from-huskies-to-lakers-comparing-the-2011-ncaa-champions-to-the-2009-10-nba-title-winning-team/
	card7.add (win);
	card7.add (w1);
	card7.add (champs);
	p_card.add ("7", card7);
    }


    public void bballlose ()  //screen that pops up if the player loses the basketball level
    {
	card8 = new Panel ();
	card8.setBackground (Color.gray);
	JLabel lose = new JLabel ("You Lose");
	lose.setFont (new Font ("Arial", Font.BOLD, 40));
	lose.setForeground (Color.black);
	Panel l1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s4");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	l1.add (again);
	l1.add (newtheme);
	l1.add (main);
	JLabel loser = new JLabel (createImageIcon ("nbalosers.jpg"));
	//http://cosbysweaters.com/2012/05/03/kinesiologist-derrick-rose-will-get-injured-again-within-18-months/
	JLabel stepup = new JLabel ("STEP YOUR GAME UP!");
	stepup.setFont (new Font ("Arial", Font.BOLD, 40));
	stepup.setForeground (Color.red);
	card8.add (lose);
	card8.add (l1);
	card8.add (loser);
	card8.add (stepup);
	p_card.add ("8", card8);
    }


    public void footballwin ()  //screen that pops up if the player wins the football level
    {
	card9 = new Panel ();
	card9.setBackground (Color.gray);
	JLabel win = new JLabel ("You Win!");
	win.setFont (new Font ("Arial", Font.BOLD, 40));
	win.setForeground (Color.black);
	Panel w1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s5");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	w1.add (again);
	w1.add (newtheme);
	w1.add (main);
	JLabel champs = new JLabel (createImageIcon ("superbowlchamps.jpg"));
	//http://www.reuters.com/news/pictures/slideshow?articleId=USRTR2XDYR
	card9.add (win);
	card9.add (w1);
	card9.add (champs);
	p_card.add ("9", card9);
    }


    public void footballlose ()  //screen that pops up if the player loses the football level
    {
	card10 = new Panel ();
	card10.setBackground (Color.gray);
	JLabel lose = new JLabel ("You Lose");
	lose.setFont (new Font ("Arial", Font.BOLD, 40));
	lose.setForeground (Color.black);
	Panel l1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s5");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	l1.add (again);
	l1.add (newtheme);
	l1.add (main);
	JLabel loser = new JLabel (createImageIcon ("superbowllosers.jpg"));
	//sports.espn.go.com/nfl/columns/story
	JLabel stepup = new JLabel ("STEP YOUR GAME UP!");
	stepup.setFont (new Font ("Arial", Font.BOLD, 40));
	stepup.setForeground (Color.red);
	card10.add (lose);
	card10.add (l1);
	card10.add (loser);
	card10.add (stepup);
	p_card.add ("10", card10);
    }


    public void hockeywin ()  //screen that pops up if the player wins the hockey level
    {
	card11 = new Panel ();
	card11.setBackground (Color.gray);
	JLabel win = new JLabel ("You Win!");
	win.setFont (new Font ("Arial", Font.BOLD, 40));
	win.setForeground (Color.black);
	Panel w1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s6");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	w1.add (again);
	w1.add (newtheme);
	w1.add (main);
	JLabel champs = new JLabel (createImageIcon ("stanleycupchamps.jpg"));
	//http://www.nytimes.com/slideshow/2009/06/13/sports/hockey/20090613-Stanleycup_index.html
	card11.add (win);
	card11.add (w1);
	card11.add (champs);
	p_card.add ("11", card11);
    }


    public void hockeylose ()  //screen that pops up if the player loses the hockey level
    {
	card12 = new Panel ();
	card12.setBackground (Color.gray);
	JLabel lose = new JLabel ("You Lose");
	lose.setFont (new Font ("Arial", Font.BOLD, 40));
	lose.setForeground (Color.black);
	Panel l1 = new Panel (new GridLayout (1, 3));
	JButton again = new JButton ("Play Again");
	again.setActionCommand ("s6");
	again.addActionListener (this);
	JButton newtheme = new JButton ("New Theme");
	newtheme.setActionCommand ("s3");
	newtheme.addActionListener (this);
	JButton main = new JButton ("Main Menu");
	main.setActionCommand ("s1");
	main.addActionListener (this);
	l1.add (again);
	l1.add (newtheme);
	l1.add (main);
	JLabel loser = new JLabel (createImageIcon ("stanleycuplosers.jpg"));
	//http://blog.mlive.com/redwings_impact/2009/06/large_1redwings12.jpg
	JLabel stepup = new JLabel ("STEP YOUR GAME UP!");
	stepup.setFont (new Font ("Arial", Font.BOLD, 40));
	stepup.setForeground (Color.red);
	card12.add (lose);
	card12.add (l1);
	card12.add (loser);
	card12.add (stepup);
	p_card.add ("12", card12);
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1")) //main menu
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2")) //how to play screen
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3")) //picking a theme screen
	{
	    cdLayout.show (p_card, "3");
	    reset ();
	    reset2 ();
	    reset3 ();

	}
	else if (e.getActionCommand ().equals ("s4")) //basketball screen
	{
	    cdLayout.show (p_card, "4");
	    level = 1;
	    reset ();
	}
	else if (e.getActionCommand ().equals ("s5")) //football screen
	{
	    cdLayout.show (p_card, "5");
	    level = 2;
	    reset2 ();
	}
	else if (e.getActionCommand ().equals ("s6")) //hockey screen
	{
	    cdLayout.show (p_card, "6");
	    level = 3;
	    reset3 ();
	}
	else if (e.getActionCommand ().equals ("s7")) //reset the basketball array
	{
	    reset ();
	}
	else if (e.getActionCommand ().equals ("s8")) //reset the football array
	{
	    reset2 ();
	}
	else if (e.getActionCommand ().equals ("s9")) //reset the hockey array
	{
	    reset3 ();
	}

	else
	{
	    int i = Integer.parseInt (e.getActionCommand ());
	    if (level == 1) //bball array
	    {

		if (prev == -1) //first card clicked
		{
		    prev = i;
		    bballarray [i].setIcon (createImageIcon (bballans [i]));
		    // bballarray [i].setEnabled (false);
		}
		else //second card clicked
		{
		    bballarray [i].setIcon (createImageIcon (bballans [i]));
		    if (bballans [i].equals (bballans [prev]) && prev != -1 && prev != i)
		    { //dialog. match.
			JOptionPane.showMessageDialog (null, "They match!");
			bballarray [i].setEnabled (false);
			bballarray [prev].setEnabled (false);
			pointscounter1++; //points increases
		    }
		    else if (!(bballans [i]).equals (bballans [prev]) && prev != -1 && prev != i)
		    { //dialog. no match
			JOptionPane.showMessageDialog (null, "Sorry, they don't match.");
			bballarray [i].setIcon (createImageIcon ("nbalogo.gif"));
			bballarray [i].setEnabled (true);
			bballarray [prev].setIcon (createImageIcon ("nbalogo.gif"));
			bballarray [prev].setEnabled (true);

		    }
		    else //same piece
		    {
			JOptionPane.showMessageDialog (null, "Click TWO different cards! Still counts as a move!");
			bballarray [i].setIcon (createImageIcon ("nbalogo.gif"));
			bballarray [i].setEnabled (true);
		    }
		    prev = -1; //reset to first card clicked
		    counter1++; //moves made increases
		    score1.setText ("Moves: " + counter1);
		    points1.setText ("Points: " + pointscounter1);
		    if (pointscounter1 == 3 && counter1 < 7) //win the basketball level
		    {
			JOptionPane.showMessageDialog (null, "You win! Good Job!");
			cdLayout.show (p_card, "7");
		    }
		    else if (pointscounter1 == 3 && counter1 >= 7) //lose the basketball level
		    {
			JOptionPane.showMessageDialog (null, "You lose! Too many moves!");
			cdLayout.show (p_card, "8");
		    }
		}

	    }

	    else if (level == 2) //football array
	    {
		if (prev2 == -1) //first card clicked
		{
		    prev2 = i;
		    footballarray [i].setIcon (createImageIcon (footballans [i]));
		    // footballarray [i].setEnabled (false);

		}
		else //second button clicked
		{
		    footballarray [i].setIcon (createImageIcon (footballans [i]));
		    if (footballans [i].equals (footballans [prev2]) && prev2 != -1 && prev2 != i)
		    { //dialog. match.
			JOptionPane.showMessageDialog (null, "They match!");
			footballarray [i].setEnabled (false);
			footballarray [prev2].setEnabled (false);
			pointscounter2++; //points increases
		    }
		    else if (!(footballans [i].equals (footballans [prev2]) && prev2 != -1) && prev2 != i)
		    { //dialog. no match
			JOptionPane.showMessageDialog (null, "Sorry, they don't match.");
			footballarray [i].setIcon (createImageIcon ("nfllogo.jpg"));
			footballarray [i].setEnabled (true);
			footballarray [prev2].setIcon (createImageIcon ("nfllogo.jpg"));
			footballarray [prev2].setEnabled (true);
		    }
		    else //same piece
		    {
			JOptionPane.showMessageDialog (null, "Click TWO different cards! Still counts as a move!");
			footballarray [i].setIcon (createImageIcon ("nfllogo.jpg"));
			footballarray [i].setEnabled (true);
		    }
		    prev2 = -1; // reset to first card clicked
		    counter2++; //moves made increases
		    score2.setText ("Moves: " + counter2);
		    points2.setText ("Points: " + pointscounter2);
		    if (pointscounter2 == 4 && counter2 < 9) //win the football level
		    {
			JOptionPane.showMessageDialog (null, "You win! Good Job!");
			cdLayout.show (p_card, "9");
		    }
		    else if (pointscounter2 == 4 && counter2 >= 9) //lose the football level
		    {
			JOptionPane.showMessageDialog (null, "You lose! Too many moves!");
			cdLayout.show (p_card, "10");
		    }
		}
	    }
	    else if (level == 3) //hockey array
	    {
		if (prev3 == -1) //first card clicked
		{
		    prev3 = i;
		    hockeyarray [i].setIcon (createImageIcon (hockeyans [i]));
		    //hockeyarray [i].setEnabled (false);
		}

		else //second card clicked
		{
		    hockeyarray [i].setIcon (createImageIcon (hockeyans [i]));
		    if (hockeyans [i].equals (hockeyans [prev3]) && prev3 != -1 && prev3 != i)
		    { //dialog. match.
			JOptionPane.showMessageDialog (null, "They match!");
			hockeyarray [i].setEnabled (false);
			hockeyarray [prev3].setEnabled (false);
			pointscounter3++; //points increases
		    }
		    else if (!(hockeyans [i].equals (hockeyans [prev3]) && prev3 != -1) && prev3 != i)
		    { //dialog. no match
			JOptionPane.showMessageDialog (null, "Sorry, they don't match.");
			hockeyarray [i].setIcon (createImageIcon ("nhlogo.gif"));
			hockeyarray [i].setEnabled (true);
			hockeyarray [prev3].setIcon (createImageIcon ("nhlogo.gif"));
			hockeyarray [prev3].setEnabled (true);
		    }
		    else //same piece
		    {
			JOptionPane.showMessageDialog (null, "Click TWO different cards! Still counts as a move!");
			hockeyarray [i].setIcon (createImageIcon ("nhlogo.gif"));
			hockeyarray [i].setEnabled (true);
		    }
		    prev3 = -1; //reset to first card clicked
		    counter3++; //moves made increases
		    score3.setText ("Moves: " + counter3);
		    points3.setText ("Points: " + pointscounter3);
		    if (pointscounter3 == 6 && counter3 < 13) //win the hockey level
		    {
			JOptionPane.showMessageDialog (null, "You win! Good Job!");
			cdLayout.show (p_card, "11");
		    }
		    else if (pointscounter3 == 6 && counter3 >= 13) //lose the hockey level
		    {
			JOptionPane.showMessageDialog (null, "You lose! Too many moves!");
			cdLayout.show (p_card, "12");
		    }
		}
	    }

	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = matchingcards.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}


	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
