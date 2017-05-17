package se.smu.todo;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class addTodo extends JFrame {

	private JPanel contentPane;
	private JTextField subTextField;
	private JTextField endTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTodo frame = new addTodo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addTodo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 274);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel subLabel = new JLabel("과목 명");
		subLabel.setBounds(12, 10, 57, 15);
		contentPane.add(subLabel);
		
		subTextField = new JTextField();
		subTextField.setBounds(81, 7, 116, 21);
		contentPane.add(subTextField);
		subTextField.setColumns(10);
		
		JLabel endLabel = new JLabel("\uB9C8\uAC10 \uAE30\uD55C");
		endLabel.setBounds(209, 10, 57, 15);
		contentPane.add(endLabel);
		
		endTextfield = new JTextField();
		endTextfield.setColumns(10);
		endTextfield.setBounds(278, 7, 116, 21);
		contentPane.add(endTextfield);
		
		JLabel contentLabel = new JLabel("\uB0B4\uC6A9");
		contentLabel.setBounds(12, 35, 57, 15);
		contentPane.add(contentLabel);
		
		JTextArea contentTextarea = new JTextArea();
		contentTextarea.setBounds(81, 34, 314, 125);
		contentPane.add(contentTextarea);
		
		JLabel impLabel = new JLabel("\uC911\uC694\uB3C4 \uC5EC\uBD80");
		impLabel.setBounds(12, 172, 70, 15);
		contentPane.add(impLabel);
		
		JComboBox impCombobox = new JComboBox();
		impCombobox.setModel(new DefaultComboBoxModel(new String[] {"★", "★★", "★★★"}));
		impCombobox.setMaximumRowCount(3);
		impCombobox.setBounds(81, 169, 116, 21);
		contentPane.add(impCombobox);
		
		JButton saveBtn = new JButton("저장 ");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveBtn.setBounds(81, 197, 97, 23);
		contentPane.add(saveBtn);
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(297, 197, 97, 23);
		contentPane.add(cancelBtn);
	}
}