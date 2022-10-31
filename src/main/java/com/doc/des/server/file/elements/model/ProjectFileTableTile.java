package com.doc.des.server.file.elements.model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class ProjectFileTableTile {
    public String text;
    public String coordinate;
    public boolean bold;
    public String collapse;
    public String tileColor;
}
