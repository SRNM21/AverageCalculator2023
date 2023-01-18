package project;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AverageCalculatorGUI {

	private Panel layout;
	private JFrame form;
	private JLabel[] label = new JLabel[11];
	private JTextField[] grade_input = new JTextField[9];
	private JTextField[] result = new JTextField[9];

/* 	version 1	
 * 	@Gregorio,NG:  June, 2, 2022
 * 
 * 	refined
 * 	@Greggy Boi: January 18, 2023
 * 	
 */
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AverageCalculatorGUI window = new AverageCalculatorGUI();
					window.form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create the application.
	public AverageCalculatorGUI() {
		initialize();
	}
	
	// Calculate the average of users input grades
	public void calculateAverage() {

		double grade = 0;
		double average = 0;
		boolean empty = false;
		boolean invalid = false;
		boolean failed = false;
		
		for (int i = 0; i < 8; i++) {
			
			if (!grade_input[i].getText().isBlank()) {
				grade = Double.parseDouble(grade_input[i].getText());
			}

			// Identify each subject grades status
			if (grade_input[i].getText().isBlank()) {
				result[i].setText("EMPTY");
				result[i].setBorder(new LineBorder(Color.red,2));
				result[i].setForeground(Color.BLACK);
				
				empty = true;
				
			} else if (grade > 100) {
				result[i].setText("INVALID");
				result[i].setForeground(Color.BLACK);
				
				invalid = true;
				
			} else if (grade < 75) {
				result[i].setText("FAILED");
				result[i].setForeground(Color.RED);
				result[i].setBorder(new LineBorder(Color.red,2));
				grade_input[i].setBorder(new LineBorder(Color.red,2));
				
				failed = true;
				
			} else if (grade >= 75) {
				result[i].setText("PASSED");
				result[i].setForeground(Color.GREEN);
			}

			average += grade;
		}
		
		// Check if the input is invalid or not
		if (empty) {
			result[8].setText("INCOMPLETE INPUT");
			result[8].setForeground(Color.BLACK);
			result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
			label[10].setToolTipText("lagay ka grades boi");
			label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Invalid.png")));
			
		} else if (invalid) {
			result[8].setText("INVALID");
			result[8].setForeground(Color.BLACK);
			label[10].setToolTipText("ayusin mo lagay boi");
			label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Invalid.png")));
			
		} else if (average < 75 || failed){
			result[8].setText("FAILED");
			result[8].setForeground(Color.RED);
			result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
			label[10].setToolTipText("bawi sa susunod boi");
			label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Failed.png")));

		} else {
			// Calculate average
			average /= 8;
			
			// Identify Average status
			if (average >= 98) {
				result[8].setText("WITH HIGHEST HONORS!");
				result[8].setForeground(Color.BLACK);
				result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
				label[10].setToolTipText("naol highest honor");
				label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Passed.png")));
				
			} else if (average >= 95) {
				result[8].setText("WITH HIGH HONOR!");
				result[8].setForeground(Color.BLACK);
				result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
				label[10].setToolTipText("naol high honor");
				label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Passed.png")));
				
			} else if (average >= 90) {
				result[8].setText("WITH HONOR!");
				result[8].setForeground(Color.BLACK);
				result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
				label[10].setToolTipText("naks, with honor");
				label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Passed.png")));
				
			} else if (average >= 75) {
				result[8].setText("PASSED");
				result[8].setForeground(Color.GREEN);
				result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
				label[10].setToolTipText("yun oh, pasado");
				label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/Passed.png")));
				
			}
				
			String gen_average = String.valueOf(average);  
			grade_input[8].setText(gen_average); 
		}

	}
	
	
	// Initialize the contents of the frame.
	private void initialize() {
		form = new JFrame();
		form.setResizable(false);
		form.setType(Type.POPUP);
		form.setBounds(100, 100, 313, 613);
		form.getContentPane().setLayout(null);
		form.getContentPane().setBackground(new Color(222, 184, 135));
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setIconImage(Toolkit.getDefaultToolkit().getImage(AverageCalculatorGUI.class.getResource("/Images/Average_Calculator_Icon.png")));
		
		// Header
		Panel header = new Panel();
		header.setBackground(new Color(205, 133, 63));
		header.setBounds(0, 0, 299, 58);
		header.setLayout(null);
		form.getContentPane().add(header);
		
		// Title 
		label[9] = new JLabel("AVERAGE CALCULATOR");
		label[9].setBounds(11, 19, 221, 22);
		label[9].setFont(new Font("SimSun", Font.BOLD, 18));
		header.add(label[9]);
		
		// Cat Icon
		label[10] = new JLabel("");
		label[10].setBounds(237, 5, 50, 50);
		label[10].setToolTipText("hi lods");
		label[10].setIcon(new ImageIcon(AverageCalculatorGUI.class.getResource("/Images/ok.png")));
		header.add(label[10]);
		
		// Layout
		layout = new Panel();
		layout.setBackground(new Color(222, 184, 135));
		layout.setBounds(0, 56, 299, 520);
		layout.setLayout(null);
		form.getContentPane().add(layout);
		
		int[] bounds = { 
			10, 57, 104, 151, 198, 245, 292, 339 
		};
		
		String[] subjects = { 
			"Filipino: ", "English: ", "Math: ", "Science: ", "P.E.: ", "A.P.: ", "T.L..E.: ", "E.S.P.: "
		};
		
		// Add Components
		for (int i = 0; i < 8; i++) {
			
			// Labels
			label[i] = new JLabel(subjects[i]);
			label[i].setFont(new Font("Lucida Sans", Font.BOLD, 16));
			label[i].setBounds(10, bounds[i], 81, 37);
			
			// TextFields with input limitations
			int index = i;
			grade_input[i] = new JTextField();
			grade_input[i].setBorder(null);
			grade_input[i].setBounds(95, bounds[i], 37, 37);
			grade_input[i].setToolTipText("Enter Grades");
			grade_input[i].setBackground(new Color(245, 222, 179));
			grade_input[i].setHorizontalAlignment(SwingConstants.CENTER);
			grade_input[i].setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			grade_input[i].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
			grade_input[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
				    char c = e.getKeyChar();
		            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
		           		 || (grade_input[index].getText().length() >= 3)){
		                 e.consume();    	
		            }
				}
			});
			
			// Result TextFields
			result[i] = new JTextField();
			result[i].setColumns(10);
			result[i].setBorder(null);
			result[i].setEditable(false);
			result[i].setForeground(Color.BLACK);
			result[i].setBounds(147, bounds[i], 136, 37);
			result[i].setBackground(new Color(245, 222, 179));
			result[i].setHorizontalAlignment(SwingConstants.CENTER);
			result[i].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
			
			layout.add(label[i]);
			layout.add(grade_input[i]);
			layout.add(result[i]);
		}

		// Average Label
		label[8] = new JLabel("AVERAGE :");
		label[8].setBounds(17, 416, 105, 37);
		label[8].setFont(new Font("SimSun", Font.BOLD, 16));
		layout.add(label[8]);
		
		// Average TextField
		grade_input[8] = new JTextField();
		grade_input[8].setColumns(10);
		grade_input[8].setBorder(null);
		grade_input[8].setEditable(false);
		grade_input[8].setBounds(10, 451, 61, 61);
		grade_input[8].setBackground(new Color(245, 222, 179));
		grade_input[8].setHorizontalAlignment(SwingConstants.CENTER);
		grade_input[8].setFont(new Font("Lucida Sans", Font.BOLD, 16));
		layout.add(grade_input[8]);
		
		// Average Result
		result[8] = new JTextField();
		result[8].setColumns(10);
		result[8].setBorder(null);
		result[8].setEditable(false);
		result[8].setBounds(70, 451, 213, 61);
		result[8].setBackground(new Color(245, 222, 179));
		result[8].setHorizontalAlignment(SwingConstants.CENTER);
		result[8].setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		layout.add(result[8]);

		// Clear Button
		JButton ClearButton = new JButton("Clear");
		ClearButton.setBorder(null);
		ClearButton.setBounds(157, 387, 126, 30);
		ClearButton.setBackground(new Color(205, 133, 63));
		ClearButton.setFont(new Font("SimSun", Font.BOLD, 16));
		ClearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i = 0; i < 9; i++) {
					grade_input[i].setText("");
					grade_input[i].setBorder(null);
					result[i].setText("");
					result[i].setBorder(null);
				}
				
				label[10].setIcon(new ImageIcon(AverageCalculatorGUI.
						class.getResource("/Images/ok.png")));
				label[10].setToolTipText("hi lods");
			}
		});
		layout.add(ClearButton);
		
		// Enter Button
		JButton EnterButton = new JButton("Enter");
		EnterButton.setBorder(null);
		EnterButton.setBounds(20, 387, 115, 30);
		EnterButton.setBackground(new Color(205, 133, 63));
		EnterButton.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		EnterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateAverage();
			}
		});
		layout.add(EnterButton);
	}
}