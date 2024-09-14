package Interface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeletePanel extends JPanel {
	public static JButton btnXOa;
	public static JButton btnHuy;
	public static JTextField textFieldma;
	public static JLabel labelma;

	public DeletePanel() {
		setBackground(Color.BLACK);
		setBorder(new LineBorder(Color.BLACK, 2));
		setBounds(10, 348, 579, 219);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VUI LÒNG NHẬP ĐÚNG MÃ SAU ĐỂ XÓA THÔNG TIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 32, 559, 31);
		add(lblNewLabel);
		
		labelma = new JLabel("XOA123");
		labelma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		labelma.setForeground(Color.CYAN);
		labelma.setHorizontalAlignment(SwingConstants.CENTER);
		labelma.setBounds(10, 74, 559, 14);
		add(labelma);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(100, 107, 71, 20);
		add(lblNewLabel_2);
		
		textFieldma = new JTextField();
		textFieldma.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textFieldma.setForeground(new Color(0, 51, 255));
		textFieldma.setBounds(181, 108, 215, 20);
		add(textFieldma);
		textFieldma.setColumns(10);
		
		btnHuy = new JButton("HỦY");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setBackground(Color.CYAN);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBounds(170, 157, 89, 31);
		add(btnHuy);
		
		btnXOa = new JButton("XÓA");
		btnXOa.setForeground(Color.BLACK);
		btnXOa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXOa.setBackground(Color.RED);
		btnXOa.setBounds(320, 157, 89, 31);
		add(btnXOa);
	}
	
	
}
