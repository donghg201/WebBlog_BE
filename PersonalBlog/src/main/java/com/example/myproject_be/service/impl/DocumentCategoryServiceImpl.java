package com.example.myproject_be.service.impl;

import com.example.myproject_be.entity.document.DocumentCategory;
import com.example.myproject_be.repository.DocumentCategoryRepository;
import com.example.myproject_be.service.DocumentCategoryService;
import org.springframework.stereotype.Service;

@Service
public class DocumentCategoryServiceImpl implements DocumentCategoryService {
    private final DocumentCategoryRepository documentCategoryRepository;

    public DocumentCategoryServiceImpl(DocumentCategoryRepository documentCategoryRepository) {
        this.documentCategoryRepository = documentCategoryRepository;
    }

    @Override
    public void createDocumentCategory(Integer documentId, Integer categoryId) {
        documentCategoryRepository.createDocumentCategory(documentId, categoryId, 1);
    }

    @Override
    public void deleteDocumentCategory(Integer id) {
        documentCategoryRepository.deleteDocumentCategory(id);
    }

    @Override
    public DocumentCategory findDocumentCategoryById(Integer id) {
        return documentCategoryRepository.findDocumentCategoryById(id);
    }
}
