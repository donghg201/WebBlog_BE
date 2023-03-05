package com.example.myproject_be.service;


import com.example.myproject_be.entity.document.Document;
import com.example.myproject_be.entity.document.DocumentCategory;

public interface DocumentCategoryService {
    //    Create document_category
    void createDocumentCategory(Integer documentId, Integer categoryId);

    //    Delete document_category by id
    void deleteDocumentCategory(Integer id);

    //    Find document_category by id
    DocumentCategory findDocumentCategoryById(Integer id);
}
