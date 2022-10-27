package com.doc.des.server.doc.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class FileModel {
private String name;
private String authors; // as in document
private boolean official; 
private ArrayList<String> docElements;
private boolean full;
}
