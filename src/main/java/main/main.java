package main;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import subject.SubMainForm;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Subject List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject.SubMainForm main = new subject.SubMainForm();
				main.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 10, 202, 241);
		contentPane.add(button);
		
		JButton btnTodo = new JButton("ToDo List");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todo.ToDoMainForm main2 = new todo.ToDoMainForm();
				main2.setVisible(true);
				setVisible(false);
			}
		});
		btnTodo.setBounds(220, 10, 202, 241);
		contentPane.add(btnTodo);
	}
}
