package com.doc.des.server.file.elements.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class ProjectFileElements {
    public String tag;
    public String text;
    public String url;
    public String size;
    public ArrayList<ProjectFileTableTile> tableTiles;
}
