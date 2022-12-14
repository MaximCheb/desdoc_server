package com.doc.des.server.file.entity;

import java.util.ArrayList;

import com.doc.des.server.file.elements.model.ProjectFileElements;
import com.doc.des.server.file.elements.model.ProjectFileStyle;

public class ProjectArchiveFilesEntity {
    public int id;
    public int projectId;
    public String file;
    public String format;
    public String file_type;
    public ArrayList<ProjectFileStyle> style;
    public ArrayList<ProjectFileElements> lines; 
}
