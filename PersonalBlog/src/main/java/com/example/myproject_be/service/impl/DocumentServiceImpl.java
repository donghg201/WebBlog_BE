package com.example.myproject_be.service.impl;

import com.example.myproject_be.entity.document.Document;
import com.example.myproject_be.repository.DocumentRepository;
import com.example.myproject_be.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 3;

    @Autowired
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Override
    public Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam) {
        int page = DEFAULT_PAGE;
        int pageSize = DEFAULT_PAGE_SIZE;

        if (pageParam.isPresent() && !pageParam.get().trim().equals("")) {
            page = Integer.parseInt(pageParam.get().trim());
        }
        if (pageSizeParam.isPresent() && !pageSizeParam.get().trim().equals("")) {
            pageSize = Integer.parseInt(pageSizeParam.get().trim());
        }
        return PageRequest.of(page, pageSize);
    }

    @Override
    public Page<Document> getDocument(Pageable pageable) {
        return documentRepository.getDocument(pageable);
    }

    @Override
    public void deleteDocument(String name) {
        documentRepository.deleteDocument(name);
    }

    @Override
    public void addDocument(String name, String writer, String poster, String description) {
        documentRepository.createDocument(name, writer, poster, String.valueOf(java.time.LocalDate.now()), description, 1);
    }

    @Override
    public Document findDocumentByName(String name) {
        return documentRepository.findDocumentByName(name);
    }
}
