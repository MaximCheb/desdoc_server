package com.doc.des.server.file.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ProjectFileEntity {
    public int id;
    public int projectId;
    public String fileName;
    public String format;
    public String fileType;
    public String template;
}
