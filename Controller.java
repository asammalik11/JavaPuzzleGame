package eecs2030.lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller for a sliding puzzle game. The controller
 * is an aggregation of a model and a view.
 *
 */
public class Controller implements ActionListener {

	private Model model;
	private View view;

	/**
	 * Initializes the controller so that it has no model
	 * and no view.
	 */
	public Controller() {
		this.model = null;
		this.view = null;
	}

	/**
	 * Set the model and view for this controller.
	 * 
	 * @param model the model
	 * @param view the view
	 */
	public void set(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Respond to the user clicking a button or menu item in
	 * the view. See the Lab 7 document for details.
	 * 
	 * @param e the action event to respond to
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals(View.NEW_GAME)) {
			this.model.shuffle();
			for(int i = 0; i < this.model.rows(); i++){
				for(int n = 0; n < this.model.cols(); n++){
					if (this.model.getValue(new RowCol(i,n)) == 0) {
						this.view.setEmpty(new RowCol(i,n));
					}
					else {
						this.view.setLocation(new RowCol(i,n),"" + this.model.getValue(new RowCol(i,n)));
					}
				}
			}
		} 
		else if (action.equals(View.EXIT)) {
			// implemented for you
			this.view.dispose();
		} 
		else {
			RowCol a = this.model.getEmpty();
			RowCol b = this.view.getButtonLocation(action);
			String t;
			if (this.model.isEmpty(b)){
				t = "";
			} else {
				t = "" + this.model.getValue(b);
			}
			this.model.move(b);
			if (this.model.getValue(b) == 0 && a != b) {
				this.view.setEmpty(b);
				this.view.setLocation(a, t);
			}

		}
	}
}