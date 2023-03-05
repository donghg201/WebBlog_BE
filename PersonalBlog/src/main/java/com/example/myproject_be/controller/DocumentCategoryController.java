package com.example.myproject_be.controller;

import com.example.myproject_be.entity.document.DocumentCategory;
import com.example.myproject_be.service.DocumentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/document-category")
public class DocumentCategoryController {
    @Autowired
    DocumentCategoryService documentCategoryService;

    @PostMapping("/create")
    public ResponseEntity<Void> addDocumentCategory(@RequestParam("documentId") Integer documentId, @RequestParam("categoryId") Integer categoryId) {
        try {
            documentCategoryService.createDocumentCategory(documentId, categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") Integer id) {
        try {
            DocumentCategory documentCategory = documentCategoryService.findDocumentCategoryById(id);
            if (documentCategory == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            documentCategoryService.deleteDocumentCategory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
