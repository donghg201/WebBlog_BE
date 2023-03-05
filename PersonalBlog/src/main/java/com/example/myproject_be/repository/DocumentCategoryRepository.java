package com.example.myproject_be.repository;

import com.example.myproject_be.entity.document.Document;
import com.example.myproject_be.entity.document.DocumentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into `my_project`.`document_category` (`document_id` ,`category_id`,`delete_flag`) values (?1, ?2, ?3)", nativeQuery = true)
    void createDocumentCategory(Integer documentId, Integer categoryId, Integer deleteFlag);

    @Transactional
    @Modifying
    @Query(value = "update `my_project`.`document_category` as d set d.`delete_flag` = 0 where d.`document_category_id`=:id", nativeQuery = true)
    void deleteDocumentCategory(@Param("id") Integer id);

    @Query(value = "select * from `my_project`.`document_category` as d where d.`document_category_id` = :id and d.`delete_flag` = 1", nativeQuery = true)
    DocumentCategory findDocumentCategoryById(@Param("id") Integer id);
}
