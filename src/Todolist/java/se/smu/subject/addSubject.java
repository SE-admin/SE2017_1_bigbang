package se.smu.subject;



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
	private JTextField subTextfield;
	private JTextField proTextfield;
	private JTextField daytextField;
	private JTextField timeTextfield;
	private JTextField yearTextfield;
	private JTextField semeTextfield;

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
		
		JLabel subLabel = new JLabel("과목 명 ");
		subLabel.setBounds(12, 10, 57, 15);
		contentPane.add(subLabel);
		
		subTextfield = new JTextField();
		subTextfield.setBounds(81, 7, 116, 21);
		contentPane.add(subTextfield);
		subTextfield.setColumns(10);
		
		JLabel proLabel = new JLabel("담당 교수");
		proLabel.setBounds(209, 10, 57, 15);
		contentPane.add(proLabel);
		
		proTextfield = new JTextField();
		proTextfield.setBounds(278, 7, 116, 21);
		contentPane.add(proTextfield);
		proTextfield.setColumns(10);
		
		JLabel dayLabel = new JLabel("강의 요일");
		dayLabel.setBounds(12, 38, 57, 15);
		contentPane.add(dayLabel);
		
		daytextField = new JTextField();
		daytextField.setColumns(10);
		daytextField.setBounds(81, 35, 116, 21);
		contentPane.add(daytextField);
		
		JLabel timeLabel = new JLabel("강의 시간");
		timeLabel.setBounds(209, 38, 57, 15);
		contentPane.add(timeLabel);
		
		timeTextfield = new JTextField();
		timeTextfield.setColumns(10);
		timeTextfield.setBounds(278, 35, 116, 21);
		contentPane.add(timeTextfield);
		
		JLabel yearLabel = new JLabel("수강 년도");
		yearLabel.setBounds(12, 66, 57, 15);
		contentPane.add(yearLabel);
		
		yearTextfield = new JTextField();
		yearTextfield.setColumns(10);
		yearTextfield.setBounds(81, 63, 116, 21);
		contentPane.add(yearTextfield);
		
		JLabel semeLabel = new JLabel("수강 학기");
		semeLabel.setBounds(209, 66, 57, 15);
		contentPane.add(semeLabel);
		
		semeTextfield = new JTextField();
		semeTextfield.setColumns(10);
		semeTextfield.setBounds(278, 63, 116, 21);
		contentPane.add(semeTextfield);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveBtn.setBounds(81, 96, 97, 23);
		contentPane.add(saveBtn);
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(278, 96, 97, 23);
		contentPane.add(cancelBtn);
	}
}
