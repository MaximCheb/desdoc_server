package com.doc.des.server.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.doc.des.server.file.entity.ProjectFileEntity;
import com.doc.des.server.file.entity.ProjectFileSingleEntity;
import com.doc.des.server.utils.ZipUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectFileService {
    
    public ProjectFileSingleEntity getFromArchive(File fileZip) {
        ProjectFileSingleEntity entity= new ProjectFileSingleEntity();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<File> inputFiles =  ZipUtils.unzipFiles(fileZip);
            for(File file : inputFiles) {
                
                if(!file.isFile()&&!file.getName().endsWith(".ddpf"))continue;
                var filename = file.getName();
                
                if (filename.equals("core.ddpf")) {
                    String content = Files.readString(file.toPath());
                    entity.changeData((ProjectFileSingleEntity) objectMapper
                            .readValue(content, ProjectFileEntity.class));
                }
                if (filename.equals("styles.ddpf")) {
                    String content = Files.readString(file.toPath());
                    entity.style.addAll(objectMapper.readValue(content, 
                            ProjectFileSingleEntity.class).style);
                }
                if (filename.endsWith(".ddpf")&&filename.startsWith("lines_")) {
                    String content = Files.readString(file.toPath());
                    entity.lines.addAll(objectMapper.readValue(content, 
                            ProjectFileSingleEntity.class).lines);
                }
            }            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ProjectFileSingleEntity getFromFile(File fileZip) {
        ProjectFileSingleEntity entity= new ProjectFileSingleEntity();
        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            List<File> inputFiles =  ZipUtils.unzipFiles(fileZip);
            for(File file : inputFiles) {
                
                if(!file.isFile()&&!file.getName().equals("projectfile.ddpf"))continue;
                               
                String content = Files.readString(file.toPath());
                entity = objectMapper.readValue(content, 
                        ProjectFileSingleEntity.class);
            }            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
