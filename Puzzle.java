package eecs2030.lab7;

/**
 * The sliding puzzle application.
 */
public class Puzzle {

	/**
	 * The main method should do the following in order:
	 * 
	 * <ol>
	 * <li>create a model with 3 rows and 3 columns
	 * <li>create a controller
	 * <li>create a view with 3 rows and 3 columns
	 * <li>set the model and view on the controller
	 * <li>make the view visible
	 * </ol>
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Model model = new Model(3, 3);
		Controller controller = new Controller();
		View view = new View(3, 3, controller);
		controller.set(model, view);
		view.setVisible(true);
	}
}