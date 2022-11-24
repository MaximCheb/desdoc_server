package com.doc.des.server.file.entity;

import java.util.ArrayList;

import com.doc.des.server.file.elements.model.ProjectFileElements;
import com.doc.des.server.file.elements.model.ProjectFileStyle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class ProjectFileSingleEntity extends ProjectFileEntity{
    
    public ArrayList<ProjectFileStyle> style;
    public ArrayList<ProjectFileElements> lines;  
    
    public void changeData(ProjectFileSingleEntity newEntity) {
        this.fileName = newEntity.fileName;
        this.projectId = newEntity.projectId;
        this.id = newEntity.id;
        this.fileName = newEntity.fileName;
        this.format = newEntity.format;
        this.template = newEntity.template;
    }
}
