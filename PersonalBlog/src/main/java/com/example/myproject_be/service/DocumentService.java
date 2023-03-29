package com.example.myproject_be.service;

import com.example.myproject_be.entity.document.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam);

    //    ~~~ Get all Document
    Page<Document> getDocument(Pageable pageable);

    //    ~~~ Delete document with name
    void deleteDocument(String name);

    //    ~~~ Create document
    void addDocument(String name, String writer, String poster, String description);

    //    ~~~ Find document by name
    Document findDocumentByName(String name);
}
