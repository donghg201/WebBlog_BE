package com.example.myproject_be.service;

import com.example.myproject_be.entity.document.Document;

import java.util.List;

public interface DocumentService {
    //    ~~~ Get all Document
    List<Document> getDocument();

    //    ~~~ Delete document with name
    void deleteDocument(String name);

    //    ~~~ Create document
    void addDocument(String document_name, String document_writer, String description);

    //    ~~~ Find document by name
    Document findDocumentByName(String name);
}
