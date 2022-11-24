package com.doc.des.server.file.entity;

public enum ProjectFileFontsEnum {
    ITALIC ("italic"),
    BOLD ("bold"),
   NORMAL ("normal"),
   ITALICBOLD ("italicbold");
   

    private String text;

    ProjectFileFontsEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static ProjectFileFontsEnum fromString(String text) {
        for (ProjectFileFontsEnum b : ProjectFileFontsEnum.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
