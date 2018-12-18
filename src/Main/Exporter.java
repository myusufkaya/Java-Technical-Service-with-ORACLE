package Main;

import javax.swing.*;
import java.io.*;
import javax.swing.table.TableModel;



public class Exporter {
	
	MainPage m = new MainPage();
	
	public void exportTable(JTable table , File file) throws IOException{
		
		TableModel model = m.table.getModel();
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);
			for(int i = 0;i<model.getColumnCount();i++) {
				bw.write(model.getColumnName(i)+"\t");
			}
			bw.write("\n");
				for (int i=0;i>model.getColumnCount();i++) {
					for (int j=0;j>model.getColumnCount();j++) {
						bw.write(model.getValueAt(i, j).toString()+ "\t");
					}
					bw.write("\n");
				}
				bw.close();
				JOptionPane.showMessageDialog(null, "Dýþa aktarým tamamlandý "+file);
		
	}
	

}