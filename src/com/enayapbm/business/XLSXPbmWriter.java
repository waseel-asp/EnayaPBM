package com.enayapbm.business;

import com.enayapbm.business.EnayaPbmData.Gender;
import com.enayapbm.medimpact.model.Error;
import com.enayapbm.medimpact.model.MedImpactResponse;
import com.enayapbm.medimpact.model.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXPbmWriter {
   public void WriteToXSLSFile(List<EnayaPbmData> requestList, List<MedImpactResponse> responseList, String fileName) {
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet("PBMResponseData");
      CellStyle cellStyle = workbook.createCellStyle();
      CreationHelper createHelper = workbook.getCreationHelper();
      short dateFormat = createHelper.createDataFormat().getFormat("dd-MM-yyyy");
      cellStyle.setDataFormat(dateFormat);
      CellStyle cellHeading = workbook.createCellStyle();
      Font font = workbook.createFont();
      font.setBold(true);
      cellHeading.setFont(font);
      String[] headings = new String[]{"RequestId", "InvoiceNumber", "PayerId", "PhysicianId", "PhysicianName", "NationalID", "Member Gender", "Provider Id", "ServiceDate", "Date of Birth", "ICD10_CODE", "ICD Code 1", "ICD Code 2", "ICD Code 3", "ICD Code 4", "ICD Code 5", "ICD Code 6", "ICD Code 7", "ICD Code 8", "ICD Code 9", "ICD Code 10", "SFDA Code", "Quantity", "Quantity Code", "Amount", "DaysofSupply", "PBM Request Status", "Error Description", "PBM Service Status", "PBM Denial Message", "PBM Denial Code"};
      Row headingRow = sheet.createRow(0);
      int h = 0;
      String[] var17 = headings;
      int var16 = headings.length;

      for(int var15 = 0; var15 < var16; ++var15) {
         String heading = var17[var15];
         headingRow.createCell(h).setCellStyle(cellHeading);
         headingRow.getCell(h).setCellValue(heading);
         ++h;
      }

      Map<String, List<EnayaPbmData>> requestMap = (Map)requestList.stream().collect(Collectors.groupingBy(EnayaPbmData::getRequestId));
      Map<String, List<MedImpactResponse>> responseMap = (Map)responseList.stream().collect(Collectors.groupingBy(MedImpactResponse::getRequestId));
      Set<String> keys = responseMap.keySet();
      int rownum = 1;
      Iterator var19 = keys.iterator();

      while(true) {
         List value;
         List reqValue;
         do {
            do {
               String resFileName;
               if (!var19.hasNext()) {
                  try {
                     resFileName = "PBMResponce" + fileName;
                     System.out.println("File name on disk --> " + resFileName);
                     //FileOutputStream out = new FileOutputStream(new File("/home/mohammed.aleem/PBMToolResponse/" + resFileName));
                     FileOutputStream out = new FileOutputStream(new File("D://" + resFileName));
                     workbook.write(out);
                     out.close();
                     System.out.println(resFileName + "written successfully on disk.");
                  } catch (Exception var32) {
                     var32.printStackTrace();
                  }

                  return;
               }

               resFileName = (String)var19.next();
               value = (List)responseMap.get(resFileName);
               reqValue = (List)requestMap.get(resFileName);
            } while(reqValue == null);
         } while(reqValue.size() <= 0);

         for(int k = 0; k < reqValue.size(); ++k) {
            Row row = sheet.createRow(rownum++);
            new EnayaPbmData();
            EnayaPbmData req = (EnayaPbmData)reqValue.get(k);
            row.createCell(0).setCellValue(req.getRequestId());
            row.createCell(1).setCellValue(req.getInvoiceNumber());
            row.createCell(2).setCellValue(req.getPayerId());
            row.createCell(3).setCellValue(req.getPrescriberId());
            row.createCell(4).setCellValue(req.getPhysicianName());
            row.createCell(5).setCellValue(req.getMemberId());
            row.createCell(6).setCellValue(this.checkGender(req.getGender()));
            row.createCell(7).setCellValue(req.getProviderId());
            row.createCell(8).setCellStyle(cellStyle);
            row.getCell(8).setCellValue(req.getDateOfService());
            row.createCell(9).setCellStyle(cellStyle);
            row.getCell(9).setCellValue(req.getDateOfBirth());
            row.createCell(10).setCellValue(req.getDiagnosisCode());
            row.createCell(21).setCellValue(req.getSfdaCode());
            row.createCell(22).setCellValue(req.getQuantity());
            row.createCell(23).setCellValue(req.getQuantityCode());
            row.createCell(24).setCellValue(req.getAmount());
            row.createCell(25).setCellValue(req.getDaysOfSupply());
            MedImpactResponse res = (MedImpactResponse)value.get(0);
            row.createCell(26).setCellValue(res.getStatus());
            row.createCell(27).setCellValue(res.getHttpStatusDescription());
            Result result = new Result();
            if (res.getResults() != null && !res.getResults().isEmpty()) {
               Iterator var28 = res.getResults().iterator();

               while(var28.hasNext()) {
                  Result rslt = (Result)var28.next();
                  if (rslt.getNdcDrugCode() != null && rslt.getNdcDrugCode().equals(req.getSfdaCode())) {
                     result = rslt;
                  }
               }

               row.createCell(28).setCellValue(result.getStatus());
//               int j = true;
               if (result != null && result.getErrors() != null && !result.getErrors().isEmpty()) {
                  String errorDesc = "";
                  String errorCode = "";

                  Error error;
                  for(Iterator var31 = result.getErrors().iterator(); var31.hasNext(); errorCode = error.getCode()) {
                     error = (Error)var31.next();
                     if (errorDesc.equals("")) {
                        errorDesc = errorDesc + error.getDescription();
                     } else {
                        errorDesc = errorDesc + "," + error.getDescription();
                     }
                  }

                  row.createCell(29).setCellValue(errorDesc);
                  row.createCell(30).setCellValue(errorCode);
               }
            }
         }
      }
   }

   public String checkGender(Gender gender) {
      return gender != null && !gender.equals("") ? gender.name() : null;
   }

   public Result getStatusAndDesc(MedImpactResponse response, String ndcDrugCode) {
      List<Result> results = response.getResults();
      Iterator var5 = results.iterator();

      while(var5.hasNext()) {
         Result result = (Result)var5.next();
         if (result.equals(ndcDrugCode)) {
            return result;
         }
      }

      return null;
   }
}
