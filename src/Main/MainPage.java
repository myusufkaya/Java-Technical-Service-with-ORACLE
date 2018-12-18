package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.io.File.*;
import java.io.IOException;





public class MainPage extends JFrame {
	
	
	private JFrame frame;
	private JTextField txtMusAd;
	private JTextField txtMusSoyad;
	private JTextField txtTelefon;
	private JTextField txtTC;
	JTable table;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
					
					String girisYapan = args[0];
					if(girisYapan != null && girisYapan.equals("Admin")) {
						MainPage m = new MainPage();
								m.frame.setVisible(false);
					} else {
						MainPage m = new MainPage();		
								m.frame.setVisible(true);
					}
					
					//window.frame.getContentPane(0).setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField txtMusId;
	private JTable table_1;
	private JTextField txtAra;
	private JTable table_2;
	private JTextField txtUrunAd;
	private JTextField txtMarkaAd;
	private JTextField txtModel;
	private JTextField txtFiyat;
	private JTextField txtUID;
	private JTable table_3;
	private JTextField txtStokID;
	private JTextField txtUID2;
	private JTextField txtStok;
	private JTextField txtMusTC;
	private JTable table_5;
	private JTextField txtMusID;
	private JTextField txtAciklama;
	private JTextField txtBasTar;
	private JTextField txtTesTar;
	private JTextField txtKID;
	private JTable table_4;
	private JTextField txtKaID;
	private JTextField txtDurum;
	private JTextField txtUrID;
	private JTextField txtSID;
	private JTable table_6;

	/**
	 * Create the application.
	 */
	public MainPage() {
		connection = sqlConnection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 843, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 11, 782, 548);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		
		tabbedPane.addTab("M\u00FC\u015Fteri Kay\u0131t", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtMusAd = new JTextField();
		txtMusAd.setBounds(90, 35, 115, 20);
		panel_1.add(txtMusAd);
		txtMusAd.setColumns(10);
		
		txtMusSoyad = new JTextField();
		txtMusSoyad.setBounds(320, 35, 104, 20);
		panel_1.add(txtMusSoyad);
		txtMusSoyad.setColumns(10);
		
		JLabel lblMusAd = new JLabel("M\u00FC\u015Fteri Ad\u0131 : ");
		lblMusAd.setBounds(10, 38, 98, 14);
		panel_1.add(lblMusAd);
		
		JLabel lblMusSoyad = new JLabel("M\u00FC\u015Fteri Soyad :");
		lblMusSoyad.setBounds(215, 38, 91, 14);
		panel_1.add(lblMusSoyad);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(296, 63, 128, 20);
		panel_1.add(txtTelefon);
		txtTelefon.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon : ");
		lblTelefon.setBounds(215, 66, 81, 14);
		panel_1.add(lblTelefon);
		
		JLabel lblTc = new JLabel("TC Kimlik No : ");
		lblTc.setBounds(10, 69, 89, 14);
		panel_1.add(lblTc);
		
		JLabel lblAdres = new JLabel("Adres : ");
		lblAdres.setBounds(10, 112, 62, 14);
		panel_1.add(lblAdres);
		
		txtTC = new JTextField();
		txtTC.setBounds(90, 66, 115, 20);
		panel_1.add(txtTC);
		txtTC.setColumns(10);
		
		JTextPane txtAdres = new JTextPane();
		txtAdres.setBounds(80, 107, 344, 42);
		panel_1.add(txtAdres);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtTC.getText().length() == 11 && txtTelefon.getText().length() == 11 && txtMusAd.getText().length() > 2 && txtMusSoyad.getText().length() > 2 && txtAdres.getText().length() > 2 && txtMusId.getText().length() == 0) {
				
				try {
					String query = "insert into musteri (M_ID , M_AD , M_SOYAD , M_TC ,  M_TEL , M_ADRES) values (? , ? , ? , ? , ? , ?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, null); // oracle karar versin.
					pst.setString(2, txtMusAd.getText());
					pst.setString(3, txtMusSoyad.getText());
					pst.setString(4, txtTC.getText());
					pst.setString(5, txtTelefon.getText());
					pst.setString(6, txtAdres.getText());
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Kayýt tamamlandý !" , "Müþteri Kayýt" , 1);
					pst.close();

					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				}	// if here
				else {
					JOptionPane.showMessageDialog(null, "TC Kimlik No & Telefon 11 haneye eþit olmalýdýr !  Ad,Soyad ve Adres iki harften büyük olmalýdýr ! ID Alaný Boþ Býrakýlmalýdýr !" , " UYGUN OLMAYAN VERÝ GÝRÝÞÝ HATASI" , 1);					
					}
			}
		});
		btnKaydet.setBounds(467, 81, 89, 23);
		panel_1.add(btnKaydet);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 757, 296);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadTable = new JButton("Listele");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				try {
					String query = "select * from musteri";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
				
				
			}
		});
		btnLoadTable.setBounds(467, 34, 89, 23);
		panel_1.add(btnLoadTable);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "Update musteri set M_ID = '"+txtMusId.getText()+"',M_AD = '"+txtMusAd.getText()+"', M_SOYAD='"+txtMusSoyad.getText()+"' , M_TC='"+txtTC.getText()+"' , M_TEL='"+txtTelefon.getText()+"' , M_ADRES='"+txtAdres.getText()+"' where M_ID='"+txtMusId.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Veriniz Güncellendi", "Güncelleme Tamamlandý !", 1);
				} catch (Exception e2) {
				System.out.println(e2);
				}
				
			}
		});
		btnGuncelle.setBounds(323, 486, 89, 23);
		panel_1.add(btnGuncelle);
		
		JLabel lblMusId = new JLabel("M\u00FC\u015Fteri ID :");
		lblMusId.setBounds(32, 490, 64, 14);
		panel_1.add(lblMusId);
		
		txtMusId = new JTextField();
		txtMusId.setBounds(106, 489, 86, 20);
		panel_1.add(txtMusId);
		txtMusId.setColumns(10);
		
		JLabel lblgncellemeIin = new JLabel("(G\u00FCncelleme & Silme)");
		lblgncellemeIin.setHorizontalAlignment(SwingConstants.CENTER);
		lblgncellemeIin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblgncellemeIin.setBounds(39, 470, 153, 14);
		panel_1.add(lblgncellemeIin);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from musteri where M_Id = '"+txtMusId.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Veriniz Silindi", "Silme Tamamlandý !", 1);
				} 
				catch (Exception e3) {
				System.out.println(e3);
				}
			}
		});
		btnSil.setBounds(444, 486, 89, 23);
		panel_1.add(btnSil);
		
		JButton btnAra_1 = new JButton("Ara");
		btnAra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from musteri where M_ID = '"+txtMusId.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnAra_1.setBounds(202, 486, 89, 23);
		panel_1.add(btnAra_1);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Exporter exp=new Exporter();
					exp.exportTable(table,new File("C:\\Users\\yusuf\\Desktop\\Musteri.xls"));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		
		btnExcel.setBounds(632, 51, 89, 23);
		panel_1.add(btnExcel);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u00DCr\u00FCn \u0130\u015Femleri", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnUrunList = new JButton("\u00DCr\u00FCn Listele");
		btnUrunList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from urun";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
					
				}
			
		});
		btnUrunList.setBounds(397, 10, 121, 23);
		panel_4.add(btnUrunList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 129, 452, 177);
		panel_4.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		txtUrunAd = new JTextField();
		txtUrunAd.setBounds(66, 11, 86, 20);
		panel_4.add(txtUrunAd);
		txtUrunAd.setColumns(10);
		
		JLabel lblUrunAd = new JLabel("Urun Ad: ");
		lblUrunAd.setBounds(10, 14, 56, 14);
		panel_4.add(lblUrunAd);
		
		txtMarkaAd = new JTextField();
		txtMarkaAd.setBounds(66, 42, 86, 20);
		panel_4.add(txtMarkaAd);
		txtMarkaAd.setColumns(10);
		
		JLabel lblMarka = new JLabel("Marka :");
		lblMarka.setBounds(10, 45, 46, 14);
		panel_4.add(lblMarka);
		
		JLabel lblModel = new JLabel("Model :");
		lblModel.setBounds(209, 14, 46, 14);
		panel_4.add(lblModel);
		
		JLabel lblFiyat = new JLabel("Fiyat :");
		lblFiyat.setBounds(209, 40, 46, 14);
		panel_4.add(lblFiyat);
		
		txtModel = new JTextField();
		txtModel.setBounds(265, 11, 86, 20);
		panel_4.add(txtModel);
		txtModel.setColumns(10);
		
		txtFiyat = new JTextField();
		txtFiyat.setBounds(265, 42, 86, 20);
		panel_4.add(txtFiyat);
		txtFiyat.setColumns(10);
		
		JButton btnUrunEkle = new JButton("\u00DCr\u00FCn Ekle");
		btnUrunEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUrunAd.getText().length() > 2 && txtModel.getText().length() > 1 && txtMarkaAd.getText().length() > 1) {
					
				try {
					String query = "insert into urun (U_ID , U_AD , MARKA_AD , MODEL_AD , FIYAT) values (? , ? , ? , ? , ?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1 , null);
					pst.setString(2, txtUrunAd.getText());
					pst.setString(3, txtMarkaAd.getText());
					pst.setString(4, txtModel.getText());
					pst.setString(5, txtFiyat.getText());
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Kayýt tamamlandý !" , "Ürün Kayýt" , 1);
					pst.close();

					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {JOptionPane.showMessageDialog(null, "Lütfen Alanlarý Doðru Doldurunuz !", "Uyarý", 1);
				
			}}
		});
		btnUrunEkle.setBounds(397, 44, 121, 23);
		panel_4.add(btnUrunEkle);
		
		txtUID = new JTextField();
		txtUID.setBounds(621, 164, 86, 20);
		panel_4.add(txtUID);
		txtUID.setColumns(10);
		
		JButton btnUrunSil = new JButton("\u00DCr\u00FCn Sil");
		btnUrunSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from urun where U_Id = '"+txtUID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Ürün Silindi", "Silme Tamamlandý !", 1);

				} 
				catch (Exception e3) {
				System.out.println(e3);
				}
			}
		});
		btnUrunSil.setBounds(472, 195, 121, 23);
		panel_4.add(btnUrunSil);
		
		JLabel lblUrunId = new JLabel("Urun ID :");
		lblUrunId.setBounds(537, 167, 74, 14);
		panel_4.add(lblUrunId);
		
		JButton btnUrunGuncelle = new JButton("\u00DCr\u00FCn G\u00FCncelle");
		btnUrunGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "Update urun set U_ID = '"+txtUID.getText()+"',U_AD = '"+txtUrunAd.getText()+"', MARKA_AD ='"+txtMarkaAd.getText()+"' , MODEL_AD ='"+txtModel.getText()+"' , FIYAT ='"+txtFiyat.getText()+"'  where U_ID='"+txtUID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Ürün Güncellendi", "Güncelleme Tamamlandý !", 1);
				} catch (Exception e2) {
				System.out.println(e2);
				}
			}
		});
		btnUrunGuncelle.setBounds(472, 232, 121, 23);
		panel_4.add(btnUrunGuncelle);
		
		JButton btnUrunAra = new JButton("\u00DCr\u00FCn Ara (ID)");
		btnUrunAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from urun where U_ID = '"+txtUID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnUrunAra.setBounds(619, 195, 126, 23);
		panel_4.add(btnUrunAra);
		
		JButton btnUrunAra1 = new JButton("\u00DCr\u00FCn Ara (AD)");
		btnUrunAra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from urun where U_AD = '"+txtUrunAd.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnUrunAra1.setBounds(619, 232, 126, 23);
		panel_4.add(btnUrunAra1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 365, 452, 144);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JButton btnStokKontrol = new JButton("Stok Listele");
		btnStokKontrol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from stok";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnStokKontrol.setBounds(472, 362, 156, 23);
		panel_4.add(btnStokKontrol);
		
		JButton btnStokKontrol_1 = new JButton("Stok Kontrol (U_ID)");
		btnStokKontrol_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from stok where U_ID = '"+txtUID2.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnStokKontrol_1.setBounds(472, 424, 156, 23);
		panel_4.add(btnStokKontrol_1);
		
		JButton btnStokKontrol_2 = new JButton("Stok Kontrol (STK_ID)");
		btnStokKontrol_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from stok where STK_ID = '"+txtStokID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnStokKontrol_2.setBounds(621, 424, 146, 23);
		panel_4.add(btnStokKontrol_2);
		
		txtStokID = new JTextField();
		txtStokID.setBounds(528, 489, 86, 20);
		panel_4.add(txtStokID);
		txtStokID.setColumns(10);
		
		JLabel lblStokId = new JLabel("Stok ID :");
		lblStokId.setBounds(472, 492, 46, 14);
		panel_4.add(lblStokId);
		
		JLabel label = new JLabel("Urun ID :");
		label.setBounds(463, 399, 55, 14);
		panel_4.add(label);
		
		txtUID2 = new JTextField();
		txtUID2.setColumns(10);
		txtUID2.setBounds(512, 396, 86, 20);
		panel_4.add(txtUID2);
		
		JLabel lblStok = new JLabel("Stok Miktar\u0131 :");
		lblStok.setBounds(617, 399, 81, 14);
		panel_4.add(lblStok);
		
		txtStok = new JTextField();
		txtStok.setBounds(691, 396, 86, 20);
		panel_4.add(txtStok);
		txtStok.setColumns(10);
		
		JButton btnStokEkle = new JButton("Stok Ekle");
		btnStokEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into stok (STK_ID , MIKTAR , U_ID) values (? , ? , ?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1 , null);
					pst.setString(2, txtStok.getText());
					pst.setString(3, txtUID2.getText());
					

					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Stok Kayýt tamamlandý !" , "Stok Kayýt" , 1);
					pst.close();

					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStokEkle.setBounds(621, 362, 148, 23);
		panel_4.add(btnStokEkle);
		
		JButton btnStokSil = new JButton("Stok Sil");
		btnStokSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from stok where STK_ID = '"+txtStokID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Stok Silindi", "Silme Tamamlandý !", 1);

				} 
				catch (Exception e3) {
				System.out.println(e3);
				}
			}
		});
		btnStokSil.setBounds(631, 455, 136, 23);
		panel_4.add(btnStokSil);
		
		JButton btnStokGuncelle = new JButton("Stok G\u00FCncelle");
		btnStokGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "Update stok set  MIKTAR = '"+txtStok.getText()+"'  where U_ID='"+txtUID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Stok Güncellendi", "Güncelleme Tamamlandý !", 1);
				} catch (Exception e2) {
				System.out.println(e2);
				}
			}
		});
		btnStokGuncelle.setBounds(472, 455, 156, 23);
		panel_4.add(btnStokGuncelle);
		
		JLabel lblStokListesi = new JLabel("STOK L\u0130STES\u0130");
		lblStokListesi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStokListesi.setBounds(169, 340, 126, 14);
		panel_4.add(lblStokListesi);
		
		JLabel lblrnListesi = new JLabel("\u00DCR\u00DCN L\u0130STES\u0130");
		lblrnListesi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblrnListesi.setBounds(169, 95, 139, 14);
		panel_4.add(lblrnListesi);
		
		JButton btnExcel_1 = new JButton("Excel");
		btnExcel_1.setBounds(565, 126, 89, 23);
		panel_4.add(btnExcel_1);
		
		JButton btnExcel_2 = new JButton("Excel");
		btnExcel_2.setBounds(656, 486, 89, 23);
		panel_4.add(btnExcel_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Bak\u0131m/Servis", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(241, 27, 507, 232);
		panel_5.add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		
		JButton btnKayit = new JButton("Kay\u0131tlar\u0131 Listele");
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from KAYIT";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_5.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnKayit.setBounds(10, 11, 221, 23);
		panel_5.add(btnKayit);
		
		JButton btnKayitSil = new JButton("Kay\u0131t Sil");
		btnKayitSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from kayit where K_Id = '"+txtKID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Kayýt Silindi !", "Silme Tamamlandý !", 1);

				} 
				catch (Exception e3) {
				System.out.println(e3);
				}
			}
		});
		btnKayitSil.setBounds(139, 236, 92, 23);
		panel_5.add(btnKayitSil);
		
		JButton btnKayitGuncelle = new JButton("Kay\u0131t G\u00FCncelle");
		btnKayitGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
					String query = "Update kayit set K_ID = '"+txtKID.getText()+"',K_ACIKLAMA = '"+txtAciklama.getText()+"', M_ID ='"+txtMusID.getText()+"' , BAS_TAR ='"+txtBasTar.getText()+"' , TES_TAR ='"+txtTesTar.getText()+"'  where K_ID='"+txtKID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Bakým Kaydý Güncellendi", "Güncelleme Tamamlandý !", 1);
				} catch (Exception e2) {
				System.out.println(e2);
				}
			}
		});
		btnKayitGuncelle.setBounds(10, 236, 119, 23);
		panel_5.add(btnKayitGuncelle);
		
		JButton btnKayitEkle = new JButton("Kay\u0131t Ekle");
		btnKayitEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into kayit (K_ID , K_ACIKLAMA , M_ID , BAS_TAR ,  TES_TAR) values (? , ? , ? , ? , ? ) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1 , null);
					pst.setString(2, txtAciklama.getText());
					pst.setString(3, txtMusID.getText());
					pst.setString(4, txtBasTar.getText());
					pst.setString(5, txtTesTar.getText());

					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Bakým Kayýt tamamlandý !" , "Bakým Kayýt" , 1);
					pst.close();

					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnKayitEkle.setBounds(10, 171, 119, 23);
		panel_5.add(btnKayitEkle);
		
		JLabel lblMteriId_1 = new JLabel("M\u00FC\u015Fteri Id :");
		lblMteriId_1.setBounds(10, 72, 97, 14);
		panel_5.add(lblMteriId_1);
		
		txtMusID = new JTextField();
		txtMusID.setBounds(117, 66, 86, 20);
		panel_5.add(txtMusID);
		txtMusID.setColumns(10);
		
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama :");
		lblAklama.setBounds(10, 45, 86, 14);
		panel_5.add(lblAklama);
		
		txtAciklama = new JTextField();
		txtAciklama.setBounds(117, 38, 86, 20);
		panel_5.add(txtAciklama);
		txtAciklama.setColumns(10);
		
		txtBasTar = new JTextField();
		txtBasTar.setBounds(10, 121, 86, 20);
		panel_5.add(txtBasTar);
		txtBasTar.setColumns(10);
		
		txtTesTar = new JTextField();
		txtTesTar.setBounds(127, 121, 86, 20);
		panel_5.add(txtTesTar);
		txtTesTar.setColumns(10);
		
		JLabel lblGeliTarihi = new JLabel("Geli\u015F Tarihi");
		lblGeliTarihi.setBounds(10, 100, 73, 14);
		panel_5.add(lblGeliTarihi);
		
		JLabel lblTeslimTarihi = new JLabel("Teslim Tarihi");
		lblTeslimTarihi.setBounds(127, 100, 89, 14);
		panel_5.add(lblTeslimTarihi);
		
		JLabel lblTarihleriGgaaayyyyOlarak = new JLabel("Tarihleri gg-AAA-yyyy olarak giriniz !");
		lblTarihleriGgaaayyyyOlarak.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTarihleriGgaaayyyyOlarak.setBounds(10, 146, 221, 14);
		panel_5.add(lblTarihleriGgaaayyyyOlarak);
		
		txtKID = new JTextField();
		txtKID.setBounds(135, 205, 26, 20);
		panel_5.add(txtKID);
		txtKID.setColumns(10);
		
		JLabel lblKaytId = new JLabel("Kay\u0131t ID :");
		lblKaytId.setBounds(65, 211, 60, 14);
		panel_5.add(lblKaytId);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(241, 293, 507, 216);
		panel_5.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(20, 270, 727, 8);
		panel_5.add(separator);
		
		JButton btnServisDurumListesi = new JButton("Servis Durum Listesi");
		btnServisDurumListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from servis";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_4.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnServisDurumListesi.setBounds(10, 289, 206, 23);
		panel_5.add(btnServisDurumListesi);
		
		JLabel lblNewLabel = new JLabel("Durum :");
		lblNewLabel.setBounds(10, 323, 86, 14);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kay\u0131t ID :");
		lblNewLabel_1.setBounds(10, 348, 99, 14);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblUrunId_1 = new JLabel("Urun ID:");
		lblUrunId_1.setBounds(10, 373, 99, 14);
		panel_5.add(lblUrunId_1);
		
		txtKaID = new JTextField();
		txtKaID.setBounds(130, 342, 86, 20);
		panel_5.add(txtKaID);
		txtKaID.setColumns(10);
		
		txtDurum = new JTextField();
		txtDurum.setBounds(130, 317, 86, 20);
		panel_5.add(txtDurum);
		txtDurum.setColumns(10);
		
		txtUrID = new JTextField();
		txtUrID.setBounds(130, 367, 86, 20);
		panel_5.add(txtUrID);
		txtUrID.setColumns(10);
		
		JButton btnServisEkle = new JButton("Servis Ekle");
		btnServisEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into servis (S_ID , DURUM , K_ID , U_ID) values (? , ? , ? , ?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1 , null);
					pst.setString(2, txtDurum.getText());
					pst.setString(3, txtKaID.getText());
					pst.setString(4, txtUrID.getText());

					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Servis Kayýt tamamlandý !" , "Servis Kayýt" , 1);
					pst.close();

					
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnServisEkle.setBounds(7, 401, 97, 23);
		panel_5.add(btnServisEkle);
		
		txtSID = new JTextField();
		txtSID.setBounds(127, 435, 86, 20);
		panel_5.add(txtSID);
		txtSID.setColumns(10);
		
		JLabel lblServisId = new JLabel("Servis ID :");
		lblServisId.setBounds(10, 438, 87, 14);
		panel_5.add(lblServisId);
		
		JButton btnServisG = new JButton("Servis G\u00FCncelle");
		btnServisG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "Update servis set S_ID = '"+txtSID.getText()+"',DURUM = '"+txtDurum.getText()+"', K_ID ='"+txtKaID.getText()+"' , U_ID ='"+txtUrID.getText()+"'  where S_ID='"+txtSID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Servis Kaydý Güncellendi !", "Güncelleme Tamamlandý !", 1);
				} catch (Exception e2) {
				System.out.println(e2);
				}
			}
		});
		btnServisG.setBounds(7, 464, 206, 23);
		panel_5.add(btnServisG);
		
		JButton btnServisSil = new JButton("Servis Sil");
		btnServisSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from servis where S_ID = '"+txtSID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Bakým Silindi !", "Silme Tamamlandý !", 1);

				} 
				catch (Exception e3) {
				System.out.println(e3);
				}
			}
		});
		btnServisSil.setBounds(7, 486, 206, 23);
		panel_5.add(btnServisSil);
		
		JLabel lblBakmKayt = new JLabel("Bak\u0131m Kay\u0131t");
		lblBakmKayt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBakmKayt.setBounds(462, 0, 92, 23);
		panel_5.add(lblBakmKayt);
		
		JLabel lblServisKayt = new JLabel("Servis Kay\u0131t");
		lblServisKayt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServisKayt.setBounds(462, 270, 92, 23);
		panel_5.add(lblServisKayt);
		
		JButton btnExcel_3 = new JButton("Excel");
		btnExcel_3.setBounds(142, 171, 89, 23);
		panel_5.add(btnExcel_3);
		
		JButton btnExcel_4 = new JButton("Excel");
		btnExcel_4.setBounds(124, 401, 89, 23);
		panel_5.add(btnExcel_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Silinen M\u00FC\u015Fteri", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from silinen_must";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnListele.setBounds(350, 388, 89, 23);
		panel_2.add(btnListele);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 52, 757, 325);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnAra = new JButton("Ara (ID)");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from silinen_must where M_ID = '"+txtAra.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnAra.setBounds(308, 472, 83, 23);
		panel_2.add(btnAra);
		
		txtAra = new JTextField();
		txtAra.setBounds(401, 441, 86, 20);
		panel_2.add(txtAra);
		txtAra.setColumns(10);
		
		JLabel lblSilinenMteriler = new JLabel("S\u0130L\u0130NEN M\u00DC\u015ETER\u0130LER");
		lblSilinenMteriler.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSilinenMteriler.setBounds(297, 27, 201, 14);
		panel_2.add(lblSilinenMteriler);
		
		JLabel lblMteriId = new JLabel("M\u00FC\u015Fteri ID :");
		lblMteriId.setBounds(308, 444, 83, 14);
		panel_2.add(lblMteriId);
		
		JLabel lblMteriTc = new JLabel("M\u00FC\u015Fteri TC :");
		lblMteriTc.setBounds(308, 419, 72, 14);
		panel_2.add(lblMteriTc);
		
		txtMusTC = new JTextField();
		txtMusTC.setBounds(401, 416, 86, 20);
		panel_2.add(txtMusTC);
		txtMusTC.setColumns(10);
		
		JButton btnAratc = new JButton("Ara (TC)");
		btnAratc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from silinen_must where M_TC = '"+txtMusTC.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				
			}
			}
		});
		btnAratc.setBounds(398, 472, 89, 23);
		panel_2.add(btnAratc);
		
		JButton btnExcel_5 = new JButton("Excel");
		btnExcel_5.setBounds(658, 472, 89, 23);
		panel_2.add(btnExcel_5);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Servis \u0130ptal", null, panel, null);
		panel.setLayout(null);
		
		JButton btnServisIptal = new JButton("Servis \u0130ptal");
		btnServisIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from servis_iptal";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_6.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnServisIptal.setBounds(36, 46, 89, 23);
		panel.add(btnServisIptal);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(158, 50, 497, 337);
		panel.add(scrollPane_6);
		
		table_6 = new JTable();
		scrollPane_6.setViewportView(table_6);
		
		JButton btnExcel_6 = new JButton("Excel");
		btnExcel_6.setBounds(36, 80, 89, 23);
		panel.add(btnExcel_6);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Backup & Restore", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnImport = new JButton("RESTORE");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programda zaten veri tabaný var !", "Ýmport HATA !", 1);
			}
		});
		btnImport.setBounds(218, 220, 89, 23);
		panel_3.add(btnImport);
		
		JButton btnExport = new JButton("BACKUP");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dýþa aktarým tamamlandý !", "Export", 1);
			}
		});
		btnExport.setBounds(451, 220, 89, 23);
		panel_3.add(btnExport);
	}
}
