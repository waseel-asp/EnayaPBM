package com.enayapbm.business;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.enayapbm.business.EnayaPbmData.Gender;
import com.enayapbm.business.PbmDataOperations.FileType;
import com.enayapbm.business.Violation.MessageTemplate;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@FileReaderQualifier(FileType.XLS)
@RequestScoped
public class XLSPbmReader implements FileReader<EnayaPbmData> {

	@Override
	public List<EnayaPbmData> readFile(InputStream in) throws IOException, ParseException {
		List<EnayaPbmData> enayaPbmDataList = new ArrayList<EnayaPbmData>();

		Workbook w;
		try {
			w = Workbook.getWorkbook(in);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines
			if (sheet.getCell(0,3) == null) {
				throw new Violation().add(MessageTemplate.Error, Messages.MISSING_COLUMNS);
			}
			// Data
			
			
			

			for (int i = 0; i < sheet.getRows(); i++) {
				EnayaPbmData enayaPbmData = new EnayaPbmData();
				
				enayaPbmData.setRequestId(sheet.getCell(0, i).getContents());
				enayaPbmData.setPayerId(sheet.getCell(1, i).getContents());
				enayaPbmData.setPrescriberId(sheet.getCell(2, i).getContents());
				enayaPbmData.setPolicyNo(sheet.getCell(3, i).getContents());
				enayaPbmData.setMemberNo(sheet.getCell(4, i).getContents());
				enayaPbmData.setMemberId(sheet.getCell(5, i).getContents());
				enayaPbmData.setGender(Gender.valueOf(sheet.getCell(6, i).getContents()));
				enayaPbmData.setProviderId(sheet.getCell(7, i).getContents());
				enayaPbmData.setProviderName(sheet.getCell(8, i).getContents());
				enayaPbmData.setApprovalReceivedDate(new SimpleDateFormat("dd/MM/yyyy").parse(sheet.getCell(9, i).getContents()));
				enayaPbmData.setDateOfService(new SimpleDateFormat("dd/MM/yyyy").parse(sheet.getCell(10, i).getContents()));
				enayaPbmData.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(sheet.getCell(11, i).getContents()));
				enayaPbmData.setDiagnosisCode(sheet.getCell(12, i).getContents());
				enayaPbmData.setDiagnosisDesc(sheet.getCell(13, i).getContents());
				enayaPbmData.setSfdaCode(sheet.getCell(14, i).getContents());
				enayaPbmData.setDispensedQuantity(Integer.valueOf(sheet.getCell(15, i).getContents()));
				enayaPbmData.setAmount((Double.valueOf(sheet.getCell(16, i).getContents())));
				enayaPbmData.setDaysOfSupply(sheet.getCell(17, i).getContents());
				

				/*if (!(enayaPbmData.getCode().isEmpty() && pricelist.getDescription().isEmpty()
						&& pricelist.getPrice().isEmpty())) {*/
				enayaPbmDataList.add(enayaPbmData);
				//}

			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		
		enayaPbmDataList.remove(0);
		return enayaPbmDataList;
	}

}
