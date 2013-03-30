import javax.swing.*;
import java.awt.event.*;

public class LayoutPanel extends JPanel{
	private JTextField inputField = new JTextField(10);
	private JButton clearButton = new JButton("clear");
	private JButton addButton = new JButton("addNode");
	private JButton deleteButton = new JButton("delete");
	private JButton findButton = new JButton("find");
	private JLabel outputLabel = new JLabel("Message output will be displayed here");
	public TreePanel treePanel;

	public LayoutPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel upPanel = new JPanel();
		upPanel.setLayout(new BoxLayout(upPanel, BoxLayout.Y_AXIS));
		JLabel inputLabel = new JLabel("Input: ");
		JPanel inputPanel = new JPanel();
		inputPanel.add(inputLabel);
		inputPanel.add(inputField);	
		upPanel.add(inputPanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(findButton);
		upPanel.add(buttonPanel);
		JPanel outputPanel = new JPanel();
		outputPanel.add(outputLabel);
		upPanel.add(outputPanel);
		add(upPanel);
		treePanel = new TreePanel();
		add(treePanel);
		addButton.addActionListener(new AddBtnListener());
		clearButton.addActionListener(new ClearBtnListener());
		deleteButton.addActionListener(new DeleteBtnListener());
		findButton.addActionListener(new FindBtnListener());
	}
	
	private class AddBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String st = inputField.getText().trim();
			if(st.length() < 1){
				outputLabel.setText("The input is empty, please re-enter an integer.");
				inputField.requestFocus();
			}
			else{
				try{
					int value = Integer.parseInt(st);
					treePanel.insertNode(value);
					treePanel.repaint();
				}
				catch(NumberFormatException ex){
					outputLabel.setText("The input is not an integer, please re-enter an integer.");
				}
			}
			inputField.setText("");
			inputField.requestFocus();
		}
	}
	
	private class ClearBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			inputField.setText("");
			outputLabel.setText("Cleared");
			treePanel.clear();
			treePanel.repaint();
			inputField.requestFocus();
		}
	}
	
	private class DeleteBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String st = inputField.getText().trim();
			if(st.length() < 1){
				outputLabel.setText("The input is empty, please re-enter an integer.");
				inputField.requestFocus();
			}
			else{
				try{
					int value = Integer.parseInt(st);
					if(treePanel.delete(value)) {
						outputLabel.setText(value + " is deleted.");
					}
					else{
						outputLabel.setText("Deletion failed.");
					}
					treePanel.repaint();
				}
				catch(NumberFormatException ex){
					outputLabel.setText("The input is not an integer, please re-enter an integer.");
				}
			}
			treePanel.repaint();
			inputField.requestFocus();
		}
	}
	
	private class FindBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String st = inputField.getText().trim();
			if(st.length() < 1){
				outputLabel.setText("The input is empty, please re-enter an integer.");
				inputField.requestFocus();
			}
			else{
				try{
					int value = Integer.parseInt(st);
					if(treePanel.find(value)) {
						outputLabel.setText("Value " + value + " is in the tree.");
					}
					else{
						outputLabel.setText("Value " + value + " is not in the tree.");
					}
				}
				catch(NumberFormatException ex){
					outputLabel.setText("The input is not an integer, please re-enter an integer.");
				}
			}
		}
	}
}
