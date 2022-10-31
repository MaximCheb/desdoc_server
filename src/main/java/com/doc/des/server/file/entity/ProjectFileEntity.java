package com.doc.des.server.file.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ProjectFileEntity {
private String name;
private Long projectId;
private Long creatorId;
private Date date;
private String fileName;
}
