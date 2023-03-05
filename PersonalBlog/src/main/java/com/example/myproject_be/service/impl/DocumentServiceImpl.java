package com.example.myproject_be.service.impl;

import com.example.myproject_be.entity.document.Document;
import com.example.myproject_be.repository.DocumentRepository;
import com.example.myproject_be.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> getDocument() {
        return documentRepository.getDocument();
    }

    @Override
    public void deleteDocument(String name) {
        documentRepository.deleteDocument(name);
    }

    @Override
    public void addDocument(String document_name, String document_writer, String description) {
        documentRepository.createDocument(document_name, document_writer, description, 1);
    }

    @Override
    public Document findDocumentByName(String name) {
        return documentRepository.findDocumentByName(name);
    }
}
