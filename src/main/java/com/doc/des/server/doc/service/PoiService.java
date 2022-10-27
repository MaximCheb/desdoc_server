package com.doc.des.server.doc.service;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;

@Service
public class PoiService {
public boolean createDocument() {
	//File file = new File("C:/username/document.docx");
//	FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//	XWPFDocument document = new XWPFDocument(fis); // Вот и объект описанного нами класса
//	String documentLine = document.getDocument().toString(); 
//	document.getParagraphs();
//	XWPFParagraph lastParagraph = document.createParagraph();
	return true;
}
}
