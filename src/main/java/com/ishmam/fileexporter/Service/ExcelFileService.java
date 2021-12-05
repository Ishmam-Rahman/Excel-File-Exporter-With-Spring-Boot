package com.ishmam.fileexporter.Service;

import com.ishmam.fileexporter.Model.Contact;
import java.io.ByteArrayInputStream;
import java.util.List;

public interface ExcelFileService {
  ByteArrayInputStream export(List<Contact> contacts);

  ByteArrayInputStream exportMultiSheet(List<Contact> contacts);
}
