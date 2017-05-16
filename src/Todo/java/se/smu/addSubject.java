package Todo;

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

public class addSubject extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSubject frame = new addSubject();
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
	public addSubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 178);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("°ú¸ñ ¸í  ");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(81, 7, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uB2F4\uB2F9 \uAD50\uC218");
		lblNewLabel_1.setBounds(209, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(278, 7, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\uAC15\uC758 \uC694\uC77C");
		label.setBounds(12, 38, 57, 15);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 35, 116, 21);
		contentPane.add(textField_2);
		
		JLabel label_1 = new JLabel("\uAC15\uC758 \uC2DC\uAC04");
		label_1.setBounds(209, 38, 57, 15);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(278, 35, 116, 21);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("\uC218\uAC15 \uB144\uB3C4");
		label_2.setBounds(12, 66, 57, 15);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(81, 63, 116, 21);
		contentPane.add(textField_4);
		
		JLabel label_3 = new JLabel("\uC218\uAC15 \uD559\uAE30");
		label_3.setBounds(209, 66, 57, 15);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(278, 63, 116, 21);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(154, 94, 97, 23);
		contentPane.add(btnNewButton);
	}
}
