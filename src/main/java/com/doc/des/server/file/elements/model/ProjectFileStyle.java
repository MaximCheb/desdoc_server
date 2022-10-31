package com.doc.des.server.file.elements.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class ProjectFileStyle {
    public String type;
    public String font;
    public String size;
    public String font_style;
    public String line_spacing;
    public String paragraf_spacing;
    public String font_color;
    public String underline_color;
    public String list_mark;
}
