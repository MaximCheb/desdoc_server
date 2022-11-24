package com.doc.des.server.doc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.doc.des.server.file.entity.ProjectFileSingleEntity;

@Service
public class PoiService {
    @Value("${desdoc.app.storage}")
    private String storageLocation;
    private Path storageFolder;   
    
    public boolean createDocumentByFile(ProjectFileSingleEntity inputFileEntity) throws FileNotFoundException {
        storageFolder = Paths.get(storageLocation);
        File file = new File("tmp.doc");
        InputStream fis = new FileInputStream(file);
        XWPFDocument document = new XWPFDocument();         
    	return true;
    }
    
    public boolean createPresetationByFile(ProjectFileSingleEntity inputFileEntity) throws FileNotFoundException {
        storageFolder = Paths.get(storageLocation);
        File file = new File("tmp.ppt");
        InputStream fis = new FileInputStream(file);
        XWPFDocument document = new XWPFDocument();         
        return true;
    }

}
