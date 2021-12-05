package com.ishmam.fileexporter.Controller;

import com.ishmam.fileexporter.Model.Contact;
import com.ishmam.fileexporter.Service.ExcelFileService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadExcelController {

  private ExcelFileService excelFileService;

  public DownloadExcelController(ExcelFileService excelFileService) {
    this.excelFileService = excelFileService;
  }

  @GetMapping("/idx")
  public String index() {
    return "index";
  }

  @GetMapping("/download-exce-file")
  public void downloadExcelFile(HttpServletResponse response) throws IOException {
    List<Contact> contacts = new Vector<>();
    contacts.add(new Contact(1L, "a", 12));
    contacts.add(new Contact(2L, "b", 12));
    contacts.add(new Contact(3L, "c", 12));
    ByteArrayInputStream byteArrayInputStream = excelFileService.export(contacts);
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=contacts.xlsx");
    IOUtils.copy(byteArrayInputStream, response.getOutputStream());
  }
  @GetMapping("/download-excel-file-multiple-sheet")
  public void downloadExcelFileMultipleSheet(HttpServletResponse response) throws IOException {
    List<Contact> contacts = new Vector<>();
    contacts.add(new Contact(1L, "a", 12));
    contacts.add(new Contact(2L, "b", 12));
    contacts.add(new Contact(3L, "c", 12));
    ByteArrayInputStream byteArrayInputStream = excelFileService.exportMultiSheet(contacts);
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=contacts.xlsx");
    IOUtils.copy(byteArrayInputStream, response.getOutputStream());
  }
}
