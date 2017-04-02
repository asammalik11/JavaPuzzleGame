package eecs2030.lab7;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * A view for the sliding puzzle game.
 *
 */
public class View extends JFrame {
	private int rows;
	private int cols;
	private JButton[][] buttons;
	
	/**
	 * The action command for a new game.
	 */
	public static final String NEW_GAME = "NEW";
	
	
	/**
	 * The action command to exit the application. 
	 */
	public static final String EXIT = "EXIT";

	/**
	 * Initializes the view for a sliding puzzle game played
	 * on a grid with the given number of rows and columns.
	 * 
	 * @param rows the number of rows in the sliding puzzle
	 * @param cols the number of columns in the sliding puzzle
	 * @param listener the action listener (controller)
	 */
	public View(int rows, int cols, ActionListener listener) {
		super("Lab 7");
		this.rows = rows;
		this.cols = cols;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.makeMenu(listener);
		this.getContentPane().setLayout(new GridLayout(this.rows, this.cols));
		this.makeButtons(listener);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Make the menu bar for the view. The menu bar has one menu
	 * named "Game", and that menu has two menu items named
	 * "New" and "Exit".
	 * 
	 * @param listener the controller to listen for the menu events
	 */
	private void makeMenu(ActionListener listener) {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		JMenuItem newGame = new JMenuItem("New");
		JMenuItem exit = new JMenuItem("Exit");
		newGame.setActionCommand(View.NEW_GAME);
		newGame.addActionListener(listener);
		exit.setActionCommand(View.EXIT);
		exit.addActionListener(listener);
		gameMenu.add(exit);
		gameMenu.add(newGame);
		this.setJMenuBar(menuBar);
	}
	
	/**
	 * Creates the buttons for the view. This method should
	 * create (this.rows * this.cols) buttons. See the Lab 7
	 * document for the button labels. The action command
	 * should be equal to the text of the button label.
	 *  
	 * @param listener the controller that listens for button press
	 * events
	 */
	private void makeButtons(ActionListener listener) {
		// You need to create the (this.rows * this.cols) buttons
		// and store them in this.buttons.
		// Consider using a pair of nested loops.
		this.buttons = new JButton[this.rows][this.cols];
		int count = 0;
		String text;
		for(int i = 0; i < this.rows; i++){
			for(int n = 0; n < this.cols; n++){
				if(i == (this.rows - 1) && n == (this.cols - 1)) {
					text = "";
				}
				else {
					text = "" + (count + 1);
				}
				JButton b = new JButton(text);
				b.setActionCommand(text);
				b.addActionListener(listener);
				this.buttons [i][n] = b;
				this.getContentPane().add(b);
				count ++;
			}	
		}
	}

	/**
	 * Returns the button location (row and column in the grid) having
	 * the given text as its label. The numbering of rows and columns
	 * begins with zero (i.e., the first row of the puzzle is row zero).
	 * 
	 * @param label the text to match to the button label
	 * @return the button location (row and column in the grid) having
	 * the given text as its label
	 */
	public RowCol getButtonLocation(String label) {
		// Loop over all of the buttons in this.buttons
		// to search for the button whose text is equal
		// to label.
		// Consider using a pair of nested loops.
		for(int i = 0; i < this.rows; i++){
			for(int n = 0; n < this.cols; n++){
				if(this.buttons [i][n].getText().equals(label)) {
					return new RowCol(i,n);
				}
			}	
		}
		return new RowCol(this.rows + 1, this.cols + 1);
	}
	
	/**
	 * Sets the button at the given location to the empty tile.
	 * The button text for the empty tile is the empty string.
	 * Also sets the action command string for the button to
	 * the empty string.
	 * 
	 * @param loc the row and column of the button to set as
	 * the empty tile
	 */
	public void setEmpty(RowCol loc) {
		String text = "";
		JButton b = this.buttons[loc.row()][loc.col()];
		b.setText(text);
		b.setActionCommand(text);
	}
	
	/**
	 * Sets the text of the button at the given location to the
	 * given text. Also sets the action command string for the
	 * button to the given text.
	 * 
	 * @param loc the row and column of the button to set the text of
	 * @param label the text for the button label
	 */
	public void setLocation(RowCol loc, String label) {
		JButton b = this.buttons[loc.row()][loc.col()];
		b.setText(label);
		b.setActionCommand(label);
	}
	
}