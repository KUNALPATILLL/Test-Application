package TestApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener{

	JLabel label;
	JRadioButton radiobutton [] = new JRadioButton [5];
	JButton btnnext , btnBookmark;
	ButtonGroup bg;
	int count =0 , current =0, x=1, y=1 ,now =0;
	int m[] = new int[10];
	
	OnlineTest(String message) {
		super(message);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for(int i=0; i<5; i++) {
			radiobutton[i] = new JRadioButton();
			add(radiobutton[i]);
			bg.add(radiobutton[i]);
		}
		btnnext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnnext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnnext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radiobutton[0].setBounds(50, 80, 450, 20);
		radiobutton[1].setBounds(50, 110, 200, 20);
		radiobutton[2].setBounds(50, 140, 200, 20);
		radiobutton[3].setBounds(50, 170, 200, 20);
		btnnext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnnext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnnext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}
	
	void set() {
		radiobutton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Which of the following is not introduced with Java 8?");
			radiobutton[0].setText("Stream API");
			radiobutton[1].setText("Serialization");
			radiobutton[2].setText("Spliterator");
			radiobutton[3].setText("Lambda Expression");
		}
		if (current == 1) {
			label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
			radiobutton[0].setText("try catch finally");
			radiobutton[1].setText("IOException");
			radiobutton[2].setText("AutoCloseable");
			radiobutton[3].setText("Streams");
		}
		if (current == 2) {
			label.setText("Que3: SessionFactory is a thread-safe object.");
			radiobutton[0].setText("true");
			radiobutton[1].setText("false");
			radiobutton[2].setText("don't know");
			radiobutton[3].setText("false");
		}
		if (current == 3) {
			label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
			radiobutton[0].setText("for (String i : StringList)");
			radiobutton[1].setText("foreach (String i : StringList)");
			radiobutton[2].setText("StringList.forEach()");
			radiobutton[3].setText("List.for()");
		}
		if (current == 4) {
			label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
			radiobutton[0].setText(" Nashorn");
			radiobutton[1].setText("V8");
			radiobutton[2].setText("Inscript");
			radiobutton[3].setText("Narcissus");
		}
		if (current == 5) {
			label.setText("Que6: How to read entire file in one line using java 8?");
			radiobutton[0].setText("Files.readAllLines()");
			radiobutton[1].setText("Files.read()");
			radiobutton[2].setText("Files.readFile()");
			radiobutton[3].setText("Files.lines()");
		}
		if (current == 6) {
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radiobutton[0].setText("try catch finally");
			radiobutton[1].setText("IOException");
			radiobutton[2].setText("AutoCloseable");
			radiobutton[3].setText("Streams");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
			radiobutton[0].setText("Configuration");
			radiobutton[1].setText("Criteria");
			radiobutton[2].setText("SessionManagement");
			radiobutton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Que9: SessionFactory is a thread-safe object.");
			radiobutton[0].setText("true");
			radiobutton[1].setText("false");
			radiobutton[2].setText("don't know");
			radiobutton[3].setText("false");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radiobutton[0].setText("Attached()");
			radiobutton[1].setText("Detached()");
			radiobutton[2].setText("Persistent()");
			radiobutton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radiobutton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radiobutton[1].isSelected());
		if (current == 1)
			return (radiobutton[1].isSelected());
		if (current == 2)
			return (radiobutton[0].isSelected());
		if (current == 3)
			return (radiobutton[2].isSelected());
		if (current == 4)
			return (radiobutton[0].isSelected());
		if (current == 5)
			return (radiobutton[0].isSelected());
		if (current == 6)
			return (radiobutton[1].isSelected());
		if (current == 7)
			return (radiobutton[2].isSelected());
		if (current == 8)
			return (radiobutton[0].isSelected());
		if (current == 9)
			return (radiobutton[0].isSelected());
		return false;
	}
	
	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}
	}


