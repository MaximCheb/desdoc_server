package com.doc.des.server.file.entity;

public enum ProjectFileElementsEnum {
    HEADLINE1 ("headline1"),
    HEADLINE2 ("headline2"),
    HEADLINE3 ("headline3"),
    LISTNUMBER("list_number"),
    LISTMARK("list_symbol"),
    TEXT("text"),
    LINK("link"),
    TABLE("table"),
    IMAGE("image"),
    TABLETILE("table_tile"),
    SLIDE("slide_container");

    private String text;

    ProjectFileElementsEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static ProjectFileElementsEnum fromString(String text) {
        for (ProjectFileElementsEnum b : ProjectFileElementsEnum.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
