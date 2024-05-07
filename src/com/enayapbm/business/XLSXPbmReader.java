package com.enayapbm.business;

import com.enayapbm.business.EnayaPbmData.Gender;
import com.enayapbm.business.PbmDataOperations.FileType;
import com.enayapbm.business.Violation.MessageTemplate;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@FileReaderQualifier(FileType.XLSX)
@RequestScoped
public class XLSXPbmReader implements FileReader<EnayaPbmData> {
   DataFormatter dataformatter = new DataFormatter();
   DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

   public List<EnayaPbmData> readFile(InputStream in) throws IOException, ParseException {
      List<EnayaPbmData> enayaPbmDataList = new ArrayList();
      XSSFWorkbook wb = new XSSFWorkbook(in);
      XSSFSheet sheet = wb.getSheetAt(0);
      Iterator<Row> rows = sheet.rowIterator();
      XSSFRow row = (XSSFRow)rows.next();
      if (row.getCell(3) != null && !row.getCell(3).toString().isEmpty()) {
         if (row.getRowNum() != 0) {
            enayaPbmDataList.add(this.extractRowData(row));
         }

         while(rows.hasNext()) {
            row = (XSSFRow)rows.next();
            //if (row.getRowNum() != 1) {
               enayaPbmDataList.add(this.extractRowData(row));
            //}
         }

         wb.close();
         return enayaPbmDataList;
      } else {
         wb.close();
         throw (new Violation()).add(MessageTemplate.Error, new String[]{"errorMissingColumns"});
      }
   }

   private EnayaPbmData extractRowData(XSSFRow row) throws IOException, ParseException {
      if (row.getLastCellNum() < 27) {
         EnayaPbmData enayaPbmData = new EnayaPbmData();
         enayaPbmData.setRequestId(this.dataformatter.formatCellValue(row.getCell(0)));
         enayaPbmData.setInvoiceNumber(this.dataformatter.formatCellValue(row.getCell(1)));
         enayaPbmData.setPayerId("102_CLAIM");
         enayaPbmData.setPrescriberId(this.dataformatter.formatCellValue(row.getCell(3)));
         //enayaPbmData.setPrescriberId("104");
         enayaPbmData.setPhysicianName(this.dataformatter.formatCellValue(row.getCell(4)));
         enayaPbmData.setMemberId(this.dataformatter.formatCellValue(row.getCell(5)));
         enayaPbmData.setGender(this.checkGender(this.dataformatter.formatCellValue(row.getCell(6))));
         //enayaPbmData.setProviderId(this.dataformatter.formatCellValue(row.getCell(7)));
         enayaPbmData.setProviderId("104");
         enayaPbmData.setDateOfService(this.dateFormating(this.dataformatter.formatCellValue(row.getCell(8))));
         enayaPbmData.setDateOfBirth(this.dateFormating(this.dataformatter.formatCellValue(row.getCell(9))));
         enayaPbmData.setDiagnosisCode(this.dataformatter.formatCellValue(row.getCell(10)));
         enayaPbmData.setSfdaCode(this.dataformatter.formatCellValue(row.getCell(21)));
         enayaPbmData.setQuantity(this.dataformatter.formatCellValue(row.getCell(22)));
         enayaPbmData.setQuantityCode(this.dataformatter.formatCellValue(row.getCell(23)));
         enayaPbmData.setAmount(this.dataformatter.formatCellValue(row.getCell(24)));
         enayaPbmData.setDaysOfSupply(this.dataformatter.formatCellValue(row.getCell(25)));
         return enayaPbmData;
      } else {
    	  
         throw new IOException("Importing Excel Error");
      }
   }

   public Gender checkGender(String gender) {
      if (gender != null && !gender.equals("")) {
         System.out.println("Gender :" + gender);
         return Gender.valueOf(gender.trim().toUpperCase());
      } else {
         return null;
      }
   }

   public Date checkDate(String dateCell) {
      return dateCell != null && !dateCell.equals("") && !dateCell.equalsIgnoreCase("NULL") ? new Date(dateCell) : null;
   }

   public String dateFormating(String date) {
      SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yy");

      try {
         String reformattedStr = myFormat.format(fromUser.parse(date));
         return reformattedStr;
      } catch (ParseException var5) {
         var5.printStackTrace();
         return null;
      }
   }
}
