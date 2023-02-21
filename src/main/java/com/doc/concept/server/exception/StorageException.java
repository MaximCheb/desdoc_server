package com.doc.concept.server.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
@RequiredArgsConstructor
@AllArgsConstructor
public class StorageException extends Exception{
    final private String failedToReadStoredFiles;
    private IOException e;
}
