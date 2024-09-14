package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Entity.CHITIEU;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InterfaceAddress;

public class MainFrame extends JFrame {
	String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLChiTieu;user=sa;password=123456";
	String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox ThangCombobox;
	
	ArrayList<CHITIEU> ChiTieuList = new ArrayList<CHITIEU>();
	private JTextField MaChiTieu;
	private JTextField VanDeChiTieu;
	private JTextField Ngay;
	private JTextField SoTien;
	private JTextField TruongAn;
	private JTextField TheAnh;
	private JTextField ChiDung;
	private JTextField HuuThang;
	private JTextField Nam;
	private JLabel TrangThai;
	private JLabel conthieuTA;
	private JLabel conthieuThA;
	private JLabel conthieuCD;
	private JLabel conthieuHT;
	private JLabel sotienTA;
	private JLabel sotienThA;
	private JLabel sotienCD;
	private JLabel sotienHT;
	private int index;
	private JButton DeleteButton;
	
	public DeletePanel deletepanel;
	private JButton InsertButton;
	private JButton UpdateButton;
	private JButton FindButton;
	private JButton RefreshButton;
	private JLabel lbltongtien;
	private JLabel TrangThaiThongKe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 66, 1100, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PANEL DELETE
		deletepanel = new DeletePanel();
		contentPane.add(deletepanel);
		deletepanel.setVisible(false);
		//NHÃN
		JLabel labelqlct = new JLabel("QUẢN LÝ CHI TIÊU");
		labelqlct.setBackground(new Color(72, 209, 204));
		labelqlct.setOpaque(true);
		labelqlct.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		labelqlct.setHorizontalAlignment(SwingConstants.CENTER);
		labelqlct.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelqlct.setBounds(10, 11, 191, 34);
		contentPane.add(labelqlct);

		JLabel lblNewLabel = new JLabel("THÁNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(697, 23, 62, 22);
		contentPane.add(lblNewLabel);
		

		JLabel lblNm = new JLabel("NĂM");
		lblNm.setForeground(Color.BLACK);
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNm.setBounds(847, 23, 46, 22);
		contentPane.add(lblNm);
		
		JLabel lblhuuthang = new JLabel("Hữu Thắng:");
		lblhuuthang.setForeground(Color.BLACK);
		lblhuuthang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblhuuthang.setBounds(10, 546, 100, 17);
		contentPane.add(lblhuuthang);
		
		JLabel lblmachitieu = new JLabel("Mã chi tiêu:");
		lblmachitieu.setForeground(Color.BLACK);
		lblmachitieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmachitieu.setBounds(10, 350, 100, 17);
		contentPane.add(lblmachitieu);
		
		JLabel lblvandechitieu = new JLabel("Vấn đề chi tiêu:");
		lblvandechitieu.setForeground(Color.BLACK);
		lblvandechitieu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblvandechitieu.setBounds(10, 378, 107, 17);
		contentPane.add(lblvandechitieu);
		
		JLabel lblngay = new JLabel("Ngày:");
		lblngay.setForeground(Color.BLACK);
		lblngay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblngay.setBounds(10, 406, 100, 17);
		contentPane.add(lblngay);
		
		JLabel lblsotien = new JLabel("Số tiền:");
		lblsotien.setForeground(Color.BLACK);
		lblsotien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblsotien.setBounds(10, 434, 100, 17);
		contentPane.add(lblsotien);
		
		JLabel lbltruongan = new JLabel("Trường An:");
		lbltruongan.setForeground(Color.BLACK);
		lbltruongan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltruongan.setBounds(10, 462, 100, 17);
		contentPane.add(lbltruongan);
		
		JLabel lbltheanh = new JLabel("Thế Anh:");
		lbltheanh.setForeground(Color.BLACK);
		lbltheanh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltheanh.setBounds(10, 490, 100, 17);
		contentPane.add(lbltheanh);
		
		JLabel lblchidung = new JLabel("Chí Dũng:");
		lblchidung.setForeground(Color.BLACK);
		lblchidung.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchidung.setBounds(10, 518, 100, 17);
		contentPane.add(lblchidung);
		
		JLabel daungancach = new JLabel("");
		daungancach.setBackground(Color.BLACK);
		daungancach.setOpaque(true);
		daungancach.setBounds(599, 339, 2, 235);
		contentPane.add(daungancach);
		
		JLabel lblTA = new JLabel("Trường An");
		lblTA.setHorizontalAlignment(SwingConstants.CENTER);
		lblTA.setForeground(Color.BLACK);
		lblTA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTA.setBounds(611, 350, 107, 17);
		contentPane.add(lblTA);
		
		JLabel lblThA = new JLabel("Thế Anh");
		lblThA.setHorizontalAlignment(SwingConstants.CENTER);
		lblThA.setForeground(Color.BLACK);
		lblThA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThA.setBounds(728, 350, 107, 17);
		contentPane.add(lblThA);
		
		JLabel lblCD = new JLabel("Chí Dũng");
		lblCD.setHorizontalAlignment(SwingConstants.CENTER);
		lblCD.setForeground(Color.BLACK);
		lblCD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCD.setBounds(845, 350, 107, 17);
		contentPane.add(lblCD);
		
		JLabel lblHT = new JLabel("Hữu Thắng");
		lblHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblHT.setForeground(Color.BLACK);
		lblHT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHT.setBounds(967, 350, 107, 17);
		contentPane.add(lblHT);
		
		//LABEL HIỂN THỊ TỔNG TIỀN
		lbltongtien = new JLabel("");
		lbltongtien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltongtien.setForeground(new Color(255, 51, 0));
		lbltongtien.setBounds(889, 406, 185, 16);
		contentPane.add(lbltongtien);
		
		TrangThai = new JLabel("");
		TrangThai.setBackground(new Color(220, 220, 220));
		TrangThai.setOpaque(true);
		TrangThai.setFont(new Font("Tahoma", Font.BOLD, 11));
		TrangThai.setForeground(Color.RED);
		TrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		TrangThai.setBounds(611, 548, 380, 14);
		contentPane.add(TrangThai);
		
		TrangThaiThongKe = new JLabel("");
		TrangThaiThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		TrangThaiThongKe.setForeground(Color.BLACK);
		TrangThaiThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		TrangThaiThongKe.setBounds(611, 456, 463, 14);
		contentPane.add(TrangThaiThongKe);
		
		//COMBOBOX
		ThangCombobox = new JComboBox();
		ThangCombobox.setFont(new Font("Tahoma", Font.BOLD, 14));
		ThangCombobox.setForeground(Color.BLACK);
		ThangCombobox.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		ThangCombobox.setBounds(758, 23, 79, 22);
		contentPane.add(ThangCombobox);

		Nam = new JTextField();
		Nam.setBackground(new Color(220, 220, 220));
		Nam.setFont(new Font("Tahoma", Font.BOLD, 14));
		Nam.setForeground(Color.BLACK);
		Nam.setBounds(889, 23, 89, 22);
		contentPane.add(Nam);
		Nam.setColumns(10);
		
		//TEXTFIELD
		MaChiTieu = new JTextField();
		MaChiTieu.setForeground(Color.BLACK);
		MaChiTieu.setBorder(new LineBorder(Color.BLACK));
		MaChiTieu.setBounds(120, 349, 370, 20);
		contentPane.add(MaChiTieu);
		MaChiTieu.setColumns(10);
		
		VanDeChiTieu = new JTextField();
		VanDeChiTieu.setForeground(Color.BLACK);
		VanDeChiTieu.setColumns(10);
		VanDeChiTieu.setBorder(new LineBorder(Color.BLACK));
		VanDeChiTieu.setBounds(120, 377, 370, 20);
		contentPane.add(VanDeChiTieu);
		
		Ngay = new JTextField();
		Ngay.setForeground(Color.BLACK);
		Ngay.setColumns(10);
		Ngay.setBorder(new LineBorder(Color.BLACK));
		Ngay.setBounds(120, 405, 370, 20);
		contentPane.add(Ngay);
		
		SoTien = new JTextField();
		SoTien.setForeground(Color.BLACK);
		SoTien.setColumns(10);
		SoTien.setBorder(new LineBorder(Color.BLACK));
		SoTien.setBounds(120, 433, 370, 20);
		contentPane.add(SoTien);
		
		TruongAn = new JTextField();
		TruongAn.setForeground(Color.BLACK);
		TruongAn.setColumns(10);
		TruongAn.setBorder(new LineBorder(Color.BLACK));
		TruongAn.setBounds(120, 461, 370, 20);
		contentPane.add(TruongAn);
		
		TheAnh = new JTextField();
		TheAnh.setForeground(Color.BLACK);
		TheAnh.setColumns(10);
		TheAnh.setBorder(new LineBorder(Color.BLACK));
		TheAnh.setBounds(120, 489, 370, 20);
		contentPane.add(TheAnh);
		
		ChiDung = new JTextField();
		ChiDung.setForeground(Color.BLACK);
		ChiDung.setColumns(10);
		ChiDung.setBorder(new LineBorder(Color.BLACK));
		ChiDung.setBounds(120, 517, 370, 20);
		contentPane.add(ChiDung);
		
		HuuThang = new JTextField();
		HuuThang.setForeground(Color.BLACK);
		HuuThang.setColumns(10);
		HuuThang.setBorder(new LineBorder(Color.BLACK));
		HuuThang.setBounds(120, 545, 370, 20);
		contentPane.add(HuuThang);
		
		//BUTTON
		InsertButton = new JButton("INSERT");
		InsertButton.setBackground(new Color(51, 255, 51));
		InsertButton.setForeground(Color.BLACK);
		InsertButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		InsertButton.setBounds(500, 350, 89, 34);
		contentPane.add(InsertButton);
		
		UpdateButton = new JButton("UPDATE");
		UpdateButton.setBackground(new Color(255, 255, 51));
		UpdateButton.setForeground(Color.BLACK);
		UpdateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		UpdateButton.setBounds(500, 397, 89, 34);
		contentPane.add(UpdateButton);
		
		FindButton = new JButton("FIND");
		FindButton.setBackground(new Color(0, 255, 255));
		FindButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		FindButton.setForeground(Color.BLACK);
		FindButton.setBounds(500, 445, 89, 34);
		contentPane.add(FindButton);
		
		RefreshButton = new JButton("REFRESH");
		RefreshButton.setBackground(new Color(255, 51, 255));
		RefreshButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		RefreshButton.setForeground(Color.BLACK);
		RefreshButton.setBounds(500, 490, 89, 34);
		contentPane.add(RefreshButton);
		
		JButton ExitButton = new JButton("EXIT");
		ExitButton.setBackground(new Color(255, 102, 0));
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ExitButton.setForeground(Color.BLACK);
		ExitButton.setBounds(1001, 535, 73, 28);
		contentPane.add(ExitButton);
		
		DeleteButton = new JButton("DELETE");
		DeleteButton.setForeground(Color.BLACK);
		DeleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		DeleteButton.setBackground(Color.RED);
		DeleteButton.setBounds(500, 535, 89, 28);
		contentPane.add(DeleteButton);
		

		//LABEL SỐ TIỀN
		sotienTA = new JLabel("");
		sotienTA.setBorder(new LineBorder(new Color(0, 0, 0)));
		sotienTA.setOpaque(true);
		sotienTA.setHorizontalAlignment(SwingConstants.CENTER);
		sotienTA.setForeground(Color.BLACK);
		sotienTA.setFont(new Font("Tahoma", Font.BOLD, 11));
		sotienTA.setBounds(611, 376, 107, 19);
		contentPane.add(sotienTA);
		
		sotienThA = new JLabel("");
		sotienThA.setOpaque(true);
		sotienThA.setHorizontalAlignment(SwingConstants.CENTER);
		sotienThA.setForeground(Color.BLACK);
		sotienThA.setFont(new Font("Tahoma", Font.BOLD, 11));
		sotienThA.setBorder(new LineBorder(new Color(0, 0, 0)));
		sotienThA.setBounds(728, 376, 107, 19);
		contentPane.add(sotienThA);
		
		sotienCD = new JLabel("");
		sotienCD.setOpaque(true);
		sotienCD.setHorizontalAlignment(SwingConstants.CENTER);
		sotienCD.setForeground(Color.BLACK);
		sotienCD.setFont(new Font("Tahoma", Font.BOLD, 11));
		sotienCD.setBorder(new LineBorder(new Color(0, 0, 0)));
		sotienCD.setBounds(845, 376, 107, 19);
		contentPane.add(sotienCD);
		
		sotienHT = new JLabel("");
		sotienHT.setOpaque(true);
		sotienHT.setHorizontalAlignment(SwingConstants.CENTER);
		sotienHT.setForeground(Color.BLACK);
		sotienHT.setFont(new Font("Tahoma", Font.BOLD, 11));
		sotienHT.setBorder(new LineBorder(new Color(0, 0, 0)));
		sotienHT.setBounds(967, 376, 107, 19);
		contentPane.add(sotienHT);
		
		JLabel lblNewLabel_1 = new JLabel(" SỐ TIỀN CÒN THIẾU CÁ NHÂN:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(611, 407, 224, 14);
		contentPane.add(lblNewLabel_1);
		
		conthieuTA = new JLabel("");
		conthieuTA.setOpaque(true);
		conthieuTA.setHorizontalAlignment(SwingConstants.CENTER);
		conthieuTA.setForeground(Color.BLACK);
		conthieuTA.setFont(new Font("Tahoma", Font.BOLD, 11));
		conthieuTA.setBorder(new LineBorder(new Color(0, 0, 0)));
		conthieuTA.setBounds(611, 436, 107, 19);
		contentPane.add(conthieuTA);
		
		conthieuThA = new JLabel("");
		conthieuThA.setOpaque(true);
		conthieuThA.setHorizontalAlignment(SwingConstants.CENTER);
		conthieuThA.setForeground(Color.BLACK);
		conthieuThA.setFont(new Font("Tahoma", Font.BOLD, 11));
		conthieuThA.setBorder(new LineBorder(new Color(0, 0, 0)));
		conthieuThA.setBounds(728, 436, 107, 19);
		contentPane.add(conthieuThA);
		
		conthieuCD = new JLabel("");
		conthieuCD.setOpaque(true);
		conthieuCD.setHorizontalAlignment(SwingConstants.CENTER);
		conthieuCD.setForeground(Color.BLACK);
		conthieuCD.setFont(new Font("Tahoma", Font.BOLD, 11));
		conthieuCD.setBorder(new LineBorder(new Color(0, 0, 0)));
		conthieuCD.setBounds(845, 436, 107, 19);
		contentPane.add(conthieuCD);
		
		conthieuHT = new JLabel("");
		conthieuHT.setOpaque(true);
		conthieuHT.setHorizontalAlignment(SwingConstants.CENTER);
		conthieuHT.setForeground(Color.BLACK);
		conthieuHT.setFont(new Font("Tahoma", Font.BOLD, 11));
		conthieuHT.setBorder(new LineBorder(new Color(0, 0, 0)));
		conthieuHT.setBounds(967, 436, 107, 19);
		contentPane.add(conthieuHT);
		
		JButton btnLoadtable = new JButton("VIEW");
		btnLoadtable.setForeground(Color.BLACK);
		btnLoadtable.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoadtable.setBackground(new Color(255, 51, 255));
		btnLoadtable.setBounds(998, 12, 76, 34);
		contentPane.add(btnLoadtable);
		
		//TABLE
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane.setBounds(10, 54, 1064, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
		
		//SỰ KIỆN CLICK VÀO BẢNG
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				MaChiTieu.setText(ChiTieuList.get(index).getMachitieu());
				VanDeChiTieu.setText(ChiTieuList.get(index).getVandechitieu());
				Ngay.setText(ChiTieuList.get(index).getNgay());
				SoTien.setText(ChiTieuList.get(index).getSotien());
				TruongAn.setText(ChiTieuList.get(index).getTruongan());
				TheAnh.setText(ChiTieuList.get(index).getTheanh());
				ChiDung.setText(ChiTieuList.get(index).getChidung());
				HuuThang.setText(ChiTieuList.get(index).getHuuthang());
				TrangThai.setText("Đã chọn hàng thông  có mã chi tiêu là \""+ ChiTieuList.get(index).getMachitieu() +"\"");
				deletepanel.setVisible(false);
				showButtonAndTextField();
			}
		});
		
		//SỰ KIỆN CLICK BUTTON
		InsertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertInfo();
			}
		});
		
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo(ChiTieuList.get(index).getMachitieu(), ChiTieuList.get(index).getVandechitieu(), ChiTieuList.get(index).getNgay(), 
						ChiTieuList.get(index).getSotien(), ChiTieuList.get(index).getTruongan(), ChiTieuList.get(index).getTheanh(), 
						ChiTieuList.get(index).getChidung(), ChiTieuList.get(index).getHuuthang());
			}
		});
		
		FindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findInfo();
			}
		});
		

		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAll();
			}
		});
		

		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEven();
			}
		});
		
		Interface.DeletePanel.btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletepanel.setVisible(false);
				showButtonAndTextField();
				TrangThai.setText("Đã hủy xóa");
			}
		});
		
		Interface.DeletePanel.btnXOa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Interface.DeletePanel.textFieldma.getText().equals(Interface.DeletePanel.labelma.getText()) != true) {
					TrangThai.setText("Mã nhập không khớp với mã đã cho!");
				}else {
					deleteInfo();
					deletepanel.setVisible(false);
					showButtonAndTextField();
					
				}
			}
		});
		
		btnLoadtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewData();
			}
		});
		

		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	//TẢI TOÀN BỘ DỮ LIỆU LÊN BẢNG
	public void loadData() {
		ThangCombobox.setSelectedIndex(0);
		Nam.setText("");
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(URL);
			
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM CHITIEU");
			
			ChiTieuList.clear();
			while(rs.next()) {
				CHITIEU chitieus = new CHITIEU(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				ChiTieuList.add(chitieus);
			}
			
			model = new DefaultTableModel();
			model.addColumn("MaChiTieu");
			model.addColumn("VanDeChiTieu");
			model.addColumn("Ngay");
			model.addColumn("SoTien");
			model.addColumn("TruongAn");
			model.addColumn("TheAnh");
			model.addColumn("ChiDung");
			model.addColumn("HuuThang");
			table.setModel(model);
			
			for(CHITIEU chitieu: ChiTieuList) {
				model.addRow(new Object[] {chitieu.getMachitieu(), chitieu.getVandechitieu(), chitieu.getNgay(), chitieu.getSotien(), chitieu.getTruongan(), chitieu.getTheanh(), chitieu.getChidung(), chitieu.getHuuthang()});
				table.setModel(model);
			}
			
			TrangThai.setText("Tải tất cả dữ liệu lên bảng thành công!");
			ThongKe();
			TrangThai.setText("Đã thống kê dựa theo toàn bộ dữ liệu");
			conn.close();
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TẢI DỮ LIỆU CHỌN LỌC THEO THÁNG + NĂM
	public void viewData() {
		if(ThangCombobox.getSelectedItem() == "" || Nam.getText().length() == 0) {
			TrangThai.setText("Không được bỏ trống Tháng và Năm!");
		}else {
			try {
				Class.forName(Driver);
				Connection conn = DriverManager.getConnection(URL);
				
				String sql = "SELECT * FROM CHITIEU WHERE MONTH(NGAY) = ? AND YEAR(NGAY) = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1,String.valueOf(ThangCombobox.getSelectedItem()));
				pstm.setString(2, Nam.getText());			
				
				ResultSet rs = pstm.executeQuery();
				
				ChiTieuList.clear();
				while(rs.next()) {
					CHITIEU chitieus = new CHITIEU(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					ChiTieuList.add(chitieus);
				}
				
				model = new DefaultTableModel();
				model.addColumn("MaChiTieu");
				model.addColumn("VanDeChiTieu");
				model.addColumn("Ngay");
				model.addColumn("SoTien");
				model.addColumn("TruongAn");
				model.addColumn("TheAnh");
				model.addColumn("ChiDung");
				model.addColumn("HuuThang");
				table.setModel(model);
				
				for(CHITIEU chitieu: ChiTieuList) {
					model.addRow(new Object[] {chitieu.getMachitieu(), chitieu.getVandechitieu(), chitieu.getNgay(), chitieu.getSotien(), chitieu.getTruongan(), chitieu.getTheanh(), chitieu.getChidung(), chitieu.getHuuthang()});
					table.setModel(model);
				}
				
				if(ChiTieuList.size() == 0) {
					TrangThaiThongKe.setText("Không có thông tin");
					TrangThai.setText("Không có thông tin");
					sotienCD.setText("");
					sotienTA.setText("");
					sotienThA.setText("");
					sotienHT.setText("");
					
					conthieuCD.setText("");
					conthieuTA.setText("");
					conthieuThA.setText("");
					conthieuHT.setText("");
				}else {
					TrangThai.setText("Tải dữ liệu của tháng \'"+ String.valueOf(ThangCombobox.getSelectedItem()) +"\' năm \'"+ Nam.getText() +"\'");
					ThongKe();
					TrangThaiThongKe.setText("Đã thống kê dựa theo dữ liệu tháng \'"+ String.valueOf(ThangCombobox.getSelectedItem()) + "\' năm \'"+ Nam.getText() +"\'");
				}
				conn.close();
			}catch (SQLException se) {
				se.printStackTrace();
				TrangThai.setText("Lỗi thông tin nhập!");
			}catch (Exception e) {
				e.printStackTrace();
				TrangThai.setText("Lỗi thông tin nhập!");
			}
		}
	}
	
	//CHỨC NĂNG LÀM MỚI CHƯƠNG TRÌNH
	public void refreshAll() {
		loadData();
		MaChiTieu.setText("");
		VanDeChiTieu.setText("");
		Ngay.setText("");
		SoTien.setText("");
		TruongAn.setText("");
		TheAnh.setText("");
		ChiDung.setText("");
		HuuThang.setText("");
		
		TrangThai.setText("Đã làm mới chương trình");
	}
	
	//CHỨC NĂNG THÊM THÔNG TIN
	public void insertInfo() {
		if(MaChiTieu.getText().length() == 0 || VanDeChiTieu.getText().length() == 0 || Ngay.getText().length() == 0 
				|| SoTien.getText().length() == 0 || TruongAn.getText().length() == 0 || TheAnh.getText().length() == 0 
				|| ChiDung.getText().length() == 0 || HuuThang.getText().length() == 0) {
			TrangThai.setText("Phải nhập đầy đủ thông tin!");
			return;
		}else {
			try {
				Class.forName(Driver);
				Connection conn = DriverManager.getConnection(URL);
				String sql = "INSERT INTO CHITIEU VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, MaChiTieu.getText());
				pstm.setString(2, VanDeChiTieu.getText());
				pstm.setString(3, Ngay.getText());
				pstm.setString(4, SoTien.getText());
				pstm.setString(5, TruongAn.getText());
				pstm.setString(6, TheAnh.getText());
				pstm.setString(7, ChiDung.getText());
				pstm.setString(8, HuuThang.getText());
				
				pstm.execute();
				loadData();
				TrangThai.setText("Đã thêm thông tin thành công");
				conn.close();
			}catch (SQLException se) {
				se.printStackTrace();
				TrangThai.setText("Không thể thêm thông tin!");
			}catch (Exception e) {
				e.printStackTrace();
				TrangThai.setText("Không thể thêm thông tin!");
			}
		}
	}
	
	//CHỨC NĂNG CẬP NHẬT THÔNG TIN
	public void updateInfo(String a, String b, String c, String d, String e, String f, String g, String h) {
		if(MaChiTieu.getText().length() == 0 || VanDeChiTieu.getText().length() == 0 || Ngay.getText().length() == 0 
				|| SoTien.getText().length() == 0 || TruongAn.getText().length() == 0 || TheAnh.getText().length() == 0 
				|| ChiDung.getText().length() == 0 || HuuThang.getText().length() == 0) {
			TrangThai.setText("Phải nhập đầy đủ thông tin!");
			return;
		}else {
			try {
				Class.forName(Driver);
				Connection conn = DriverManager.getConnection(URL);
				String sql = "UPDATE CHITIEU SET MACHITIEU = ?, VANDECHITIEU = ?, NGAY = ?, SOTIEN = ?, TRUONGAN = ?,"
						+ " THEANH = ?, CHIDUNG = ?, HUUTHANG = ? WHERE MACHITIEU = ? AND VANDECHITIEU = ? AND"
						+ " NGAY = ? AND SOTIEN = ? AND TRUONGAN = ? AND"
						+ " THEANH = ? AND CHIDUNG = ? AND HUUTHANG = ?";
				
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, MaChiTieu.getText());
				pstm.setString(2, VanDeChiTieu.getText());
				pstm.setString(3, Ngay.getText());
				pstm.setString(4, SoTien.getText());
				pstm.setString(5, TruongAn.getText());
				pstm.setString(6, TheAnh.getText());
				pstm.setString(7, ChiDung.getText());
				pstm.setString(8, HuuThang.getText());
				pstm.setString(9, a);
				pstm.setString(10, b);
				pstm.setString(11, c);
				pstm.setString(12, d);
				pstm.setString(13, e);
				pstm.setString(14, f);
				pstm.setString(15, g);
				pstm.setString(16, h);
				
				pstm.execute();
				loadData();
				TrangThai.setText("Đã cập nhật thông tin thành công");
				conn.close();
			}catch (SQLException se) {
				se.printStackTrace();
				TrangThai.setText("Không thể cập nhật thông tin!");
			}catch (Exception e1) {
				e1.printStackTrace();
				TrangThai.setText("Không thể cập nhật thông tin!");
			}
		}
	}
	
	//CHỨC NĂNG TÌM KIẾM THÔNG TIN
	public void findInfo() {
		if(MaChiTieu.getText().length() == 0 && VanDeChiTieu.getText().length() == 0 && Ngay.getText().length() == 0 
				&& SoTien.getText().length() == 0 && TruongAn.getText().length() == 0 && TheAnh.getText().length() == 0 
				&& ChiDung.getText().length() == 0 && HuuThang.getText().length() == 0) {
			TrangThai.setText("Cần nhập thông tin trước");
			return;
		}else {
			try {
				Class.forName(Driver);
				Connection conn = DriverManager.getConnection(URL);
				String sql = "SELECT * FROM CHITIEU WHERE ";
				
				if(MaChiTieu.getText().length() != 0) {
					sql += "MACHITIEU = '"+ MaChiTieu.getText()+ "' ";
				}
				if(VanDeChiTieu.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0) {
						sql += "and vandechitieu = N'"+ VanDeChiTieu.getText() +"' ";
					}else {
						sql += "vandechitieu = N'"+ VanDeChiTieu.getText() +"' ";
					}
				}
				if(Ngay.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0) {
						sql += "and ngay = '"+ Ngay.getText() +"' ";
					}else {
						sql += "ngay = '"+ Ngay.getText() +"' ";
					}
				}
				if(SoTien.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0 || Ngay.getText().length() != 0) {
						sql += "and sotien = '"+ SoTien.getText() +"' ";
					}else {
						sql += "sotien = '"+ SoTien.getText() +"' ";
					}
				}
				if(TruongAn.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0 || Ngay.getText().length() != 0 || SoTien.getText().length() != 0) {
						sql += "and truongan = '"+ TruongAn.getText() +"' ";
					}else {
						sql += "truongan = '"+ TruongAn.getText() +"' ";
					}
				}
				if(TheAnh.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0 || Ngay.getText().length() != 0 || SoTien.getText().length() != 0|| TruongAn.getText().length() != 0) {
						sql += "and theanh = '"+ TheAnh.getText() +"' ";
					}else {
						sql += "theanh = '"+ TheAnh.getText() +"' ";
					}
				}
				if(ChiDung.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0 || Ngay.getText().length() != 0 || SoTien.getText().length() != 0|| TruongAn.getText().length() != 0|| TheAnh.getText().length() != 0) {
						sql += "and chidung = '"+ ChiDung.getText() +"' ";
					}else {
						sql += "chidung = '"+ ChiDung.getText() +"' ";
					}
				}
				if(HuuThang.getText().length() != 0) {
					if(MaChiTieu.getText().length() != 0 || VanDeChiTieu.getText().length() != 0 || Ngay.getText().length() != 0 || SoTien.getText().length() != 0|| TruongAn.getText().length() != 0|| TheAnh.getText().length() != 0|| ChiDung.getText().length() != 0) {
						sql += "and huuthang = '"+ HuuThang.getText() +"' ";
					}else {
						sql += "huuthang = '"+ HuuThang.getText() +"' ";
					}
				}
		
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				ChiTieuList.clear();
				while(rs.next()) {
					CHITIEU chitieus = new CHITIEU(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					ChiTieuList.add(chitieus);
				}
				
				model = new DefaultTableModel();
				model.addColumn("MaChiTieu");
				model.addColumn("VanDeChiTieu");
				model.addColumn("Ngay");
				model.addColumn("SoTien");
				model.addColumn("TruongAn");
				model.addColumn("TheAnh");
				model.addColumn("ChiDung");
				model.addColumn("HuuThang");
				table.setModel(model);
				
				for(CHITIEU chitieu: ChiTieuList) {
					model.addRow(new Object[] {chitieu.getMachitieu(), chitieu.getVandechitieu(), chitieu.getNgay(), chitieu.getSotien(), chitieu.getTruongan(), chitieu.getTheanh(), chitieu.getChidung(), chitieu.getHuuthang()});
					table.setModel(model);
				}
					
				TrangThai.setText("Tìm kiếm thông tin thành công");
				if(ChiTieuList.size() == 0) {
					TrangThai.setText("Thông tin rỗng");
				}
				ThongKe();
				TrangThaiThongKe.setText("Đã thống kê dựa theo kết quả Tìm kiếm");
				conn.close();
			}catch (SQLException se) {
				se.printStackTrace();
				TrangThai.setText("Không thể tìm thông tin!");
			}catch (Exception e1) {
				e1.printStackTrace();
				TrangThai.setText("Không thể tìm thông tin!");
			}
		}
	}
	
	//SỰ KIỆN BẤM NÚT XÓA
	public void deleteEven() {
		if(MaChiTieu.getText().length() == 0 || VanDeChiTieu.getText().length() == 0 || Ngay.getText().length() == 0 
				|| SoTien.getText().length() == 0 || TruongAn.getText().length() == 0 || TheAnh.getText().length() == 0 
				|| ChiDung.getText().length() == 0 || HuuThang.getText().length() == 0) {
			TrangThai.setText("Phải nhập đầy đủ thông tin!");
			return;
		}else {
			hideButtonAndTextField();
			deletepanel.setVisible(true);
			Random r = new Random();
			Interface.DeletePanel.labelma.setText(String.valueOf(r.nextInt(899999) + 100000));
			TrangThai.setText("");
		}
	}
	
	//CHỨC NĂNG XÓA
	public void deleteInfo() {
		try {
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(URL);
			String sql = "DELETE CHITIEU WHERE MACHITIEU = ? AND VANDECHITIEU = ? AND NGAY = ? AND SOTIEN = ? AND TRUONGAN = ? AND THEANH = ? AND CHIDUNG = ? AND HUUTHANG = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, MaChiTieu.getText());
			pstm.setString(2, VanDeChiTieu.getText());
			pstm.setString(3, Ngay.getText());
			pstm.setString(4, SoTien.getText());
			pstm.setString(5, TruongAn.getText());
			pstm.setString(6, TheAnh.getText());
			pstm.setString(7, ChiDung.getText());
			pstm.setString(8, HuuThang.getText());
			
			pstm.execute();
			loadData();
			TrangThai.setText("Đã xóa thông tin thành công");
			conn.close();
		}catch (SQLException se) {
			se.printStackTrace();
			TrangThai.setText("Không thể xóa thông tin!");
		}catch (Exception e) {
			e.printStackTrace();
			TrangThai.setText("Không thể xóa thông tin!");
		}
	}
	
	//CHỨC NĂNG THỐNG KÊ TIỀN CHI TIÊU
	public void ThongKe() {
		long bigsum = 0, a = 0, b = 0, c = 0, d = 0, a1, b1, c1, d1;
		for(int i = 0; i < ChiTieuList.size(); i++) {
			bigsum += Long.valueOf(ChiTieuList.get(i).getSotien());
			a += Long.valueOf(ChiTieuList.get(i).getTruongan());
			b += Long.valueOf(ChiTieuList.get(i).getTheanh());
			c += Long.valueOf(ChiTieuList.get(i).getChidung());
			d += Long.valueOf(ChiTieuList.get(i).getHuuthang());
		}
		lbltongtien.setText("TỔNG TIỀN: "+ String.valueOf(bigsum));
		
		if(a == 0)
			sotienTA.setText("0");
		else
			sotienTA.setText(String.valueOf(a));
		if(b == 0)
			sotienThA.setText("0");
		else
			sotienThA.setText(String.valueOf(b));
		if(c == 0)
			sotienCD.setText("0");
		else
			sotienCD.setText(String.valueOf(c));
		if(d == 0)
			sotienHT.setText("0");
		else
			sotienHT.setText(String.valueOf(d));
		
		a1 = bigsum/4 - a;
		b1 = bigsum/4 - b;
		c1 = bigsum/4 - c;
		d1 = bigsum/4 - d;
		
		if(a1 > 0) {
			conthieuTA.setText("Thiếu "+ String.valueOf(a1));
		}else if(a1 < 0) {
			conthieuTA.setText("Thừa "+ String.valueOf(-a1));
		}else {
			conthieuTA.setText("Đã đủ");
		}
		if(b1 > 0) {
			conthieuThA.setText("Thiếu "+ String.valueOf(b1));
		}else if(b1 < 0) {
			conthieuThA.setText("Thừa "+ String.valueOf(-b1));
		}else {
			conthieuThA.setText("Đã đủ");
		}
		if(c1 > 0) {
			conthieuCD.setText("Thiếu "+ String.valueOf(c1));
		}else if(c1 < 0) {
			conthieuCD.setText("Thừa "+ String.valueOf(-c1));
		}else {
			conthieuCD.setText("Đã đủ");
		}
		if(d1 > 0) {
			conthieuHT.setText("Thiếu "+ String.valueOf(d1));
		}else if(d1 < 0) {
			conthieuHT.setText("Thừa "+ String.valueOf(-d1));
		}else {
			conthieuHT.setText("Đã đủ");
		}
	}
	
	
	// ẨN HIỆN CÁC BUTTON VÀ TEXTFIELD
	public void hideButtonAndTextField() {
		InsertButton.setVisible(false);
		UpdateButton.setVisible(false);
		FindButton.setVisible(false);
		RefreshButton.setVisible(false);
		DeleteButton.setVisible(false);
		
		MaChiTieu.setVisible(false);
		VanDeChiTieu.setVisible(false);
		Ngay.setVisible(false);
		SoTien.setVisible(false);
		TruongAn.setVisible(false);
		TheAnh.setVisible(false);
		ChiDung.setVisible(false);
		HuuThang.setVisible(false);
	}
	
	public void showButtonAndTextField() {
		InsertButton.setVisible(true);
		UpdateButton.setVisible(true);
		FindButton.setVisible(true);
		RefreshButton.setVisible(true);
		DeleteButton.setVisible(true);
		
		MaChiTieu.setVisible(true);
		VanDeChiTieu.setVisible(true);
		Ngay.setVisible(true);
		SoTien.setVisible(true);
		TruongAn.setVisible(true);
		TheAnh.setVisible(true);
		ChiDung.setVisible(true);
		HuuThang.setVisible(true);
	}
}
