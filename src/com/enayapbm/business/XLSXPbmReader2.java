package com.enayapbm.business;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.enayapbm.business.EnayaPbmData.Gender;
import com.enayapbm.business.PbmDataOperations.FileType;
import com.enayapbm.business.Violation.MessageTemplate;

@FileReaderQualifier(FileType.XLSX)
@RequestScoped
public class XLSXPbmReader2 implements FileReader<EnayaPbmData> {
	
	DataFormatter dataformatter = new DataFormatter();
	

	@Override
	public List<EnayaPbmData> readFile(InputStream in) throws IOException, ParseException {
		List<EnayaPbmData> enayaPbmDataList = new ArrayList<EnayaPbmData>();

		XSSFWorkbook wb = new XSSFWorkbook(in);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;

		Iterator<Row> rows = sheet.rowIterator();
		row = (XSSFRow) rows.next();
		if (row.getCell(3) == null || row.getCell(3).toString().isEmpty()) {
			wb.close();
			throw new Violation().add(MessageTemplate.Error, Messages.MISSING_COLUMNS);
		} else if(row.getRowNum() != 0){
			enayaPbmDataList.add(extractRowData(row));
		}
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			enayaPbmDataList.add(extractRowData(row));
		}
		wb.close();

		//enayaPbmDataList.remove(0);
		return enayaPbmDataList;
	}

	private EnayaPbmData extractRowData(XSSFRow row) throws IOException, ParseException {
		if (row.getLastCellNum() < 100) {
			
			EnayaPbmData enayaPbmData = new EnayaPbmData();
			enayaPbmData.setRequestId(dataformatter.formatCellValue(row.getCell(0)));
			enayaPbmData.setPayerId(dataformatter.formatCellValue(row.getCell(1)));
			enayaPbmData.setPrescriberId(dataformatter.formatCellValue(row.getCell(2)));
			enayaPbmData.setPolicyNo(dataformatter.formatCellValue(row.getCell(3)));
			enayaPbmData.setMemberNo(dataformatter.formatCellValue(row.getCell(4)));
			enayaPbmData.setMemberId(dataformatter.formatCellValue(row.getCell(5)));
			enayaPbmData.setGender(Gender.valueOf(row.getCell(6).toString().trim()));
			enayaPbmData.setProviderId(dataformatter.formatCellValue(row.getCell(7)));
			enayaPbmData.setProviderName(row.getCell(8).toString().trim());
			enayaPbmData.setApprovalReceivedDate(row.getCell(9).getDateCellValue());
			enayaPbmData.setDateOfService(row.getCell(10).getDateCellValue());
			enayaPbmData.setDateOfBirth(row.getCell(11).getDateCellValue());
			enayaPbmData.setDiagnosisCode(row.getCell(12).toString().trim());
			enayaPbmData.setDiagnosisDesc(row.getCell(13).toString().trim());
			enayaPbmData.setSfdaCode(dataformatter.formatCellValue(row.getCell(14)));
			enayaPbmData.setDispensedQuantity(new Integer((int) row.getCell(15).getNumericCellValue()));
			enayaPbmData.setAmount((Double.valueOf(row.getCell(16).getNumericCellValue())));
			enayaPbmData.setDaysOfSupply(dataformatter.formatCellValue(row.getCell(17)));
			return enayaPbmData;
		} else {
			throw new IOException("Importing Excel Error");
			// throw new IOException(messages.getValueFromKey("ImportExcelError"));
		}

		/*
		 * if (!(pricelist.getCode().isEmpty() && pricelist.getDescription().isEmpty()
		 * && pricelist.getPrice().isEmpty())) { return pricelist; } else { return null;
		 * }
		 */
	}

}
