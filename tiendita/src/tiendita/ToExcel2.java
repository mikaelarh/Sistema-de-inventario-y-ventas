package tiendita;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * este metodo es el encargado de transformar una jTable a su version en Excel
 * @author mikaela
 */
public class ToExcel2 {


    /* este metodo necesita para funcionar una lista de datos almacenados en la 
    jTable, y el numero de filas y extencion del archivo*/
 public static void Exportar() {

    JFileChooser save = new JFileChooser();
    save.setDialogTitle("Guardar Como...");
    save.setFileFilter(new FileNameExtensionFilter("xlsx","xlsm"));
    int choose = save.showSaveDialog(null);

    if(choose == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook NuevoLibro = new XSSFWorkbook();
        XSSFSheet sheet1 = NuevoLibro.createSheet("Reporte");        
            TableModel Modelo = Registros.TabEx.getModel();

            for(int i=0; i<Modelo.getRowCount(); i++) {
                XSSFRow newRow = sheet1.createRow(i);                
                for(int j=0; j<Modelo.getColumnCount(); j++) {
                    XSSFCell NuevaCelda = newRow.createCell((short) j);
                    if(i==0){
                        NuevaCelda.setCellValue(Modelo.getColumnName(j));                        
                    } else {
                    NuevaCelda.setCellValue(Modelo.getValueAt(i, j).toString());
                    
                    }
                }
            }
            AutoSize(NuevoLibro, save);
    }
}
 public static void AutoSize(XSSFWorkbook NuevoLibro, JFileChooser save) {
        int NumeroDeHojas = NuevoLibro.getNumberOfSheets();
        for (int i = 0; i < NumeroDeHojas; i++) {
            Sheet NuevaHoja = NuevoLibro.getSheetAt(i);
            if (NuevaHoja.getPhysicalNumberOfRows() > 0) {
                Row row = NuevaHoja.getRow(NuevaHoja.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    NuevaHoja.autoSizeColumn(columnIndex);
                    int currentColumnWidth = NuevaHoja.getColumnWidth(columnIndex);
                    NuevaHoja.setColumnWidth(columnIndex, (currentColumnWidth + 600));
                }
            }
        }
        try{
            FileOutputStream Salida = new FileOutputStream(save.getSelectedFile()+".xlsx");
            BufferedOutputStream Bufer = new BufferedOutputStream(Salida);
            NuevoLibro.write(Bufer);
            Bufer.close();
            Salida.close();

            JOptionPane.showMessageDialog(null, "Guardado con Exito");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
}

