package com.example.myproject_be.repository;

import com.example.myproject_be.entity.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    //    ~~~ Get all document
    @Query(value = "select * from `my_project`.`document`", nativeQuery = true)
    List<Document> getDocument();

    //    ~~~ Delete document with name
    @Modifying
    @Transactional
    @Query(value = "update `my_project`.`document` as d set d.`delete_flag` = 0 where d.`document_name` = :name", nativeQuery = true)
    void deleteDocument(@Param("name") String name);

    //    ~~~ Create document
    @Transactional
    @Modifying
    @Query(value = "insert into `my_project`.`document`(`document`.`document_name`,`document`.`document_writer`,`document`.`description`,`document`.`delete_flag`) values (?1, ?2, ?3, ?4);", nativeQuery = true)
    void createDocument(String documentName, String documentWriter, String description, Integer deleteFlag);

    //    ~~~ Find document by name
    @Query(value = "select * from `my_project`.`document` as d where d.`document_name` = :name and d.`delete_flag` = 1", nativeQuery = true)
    Document findDocumentByName(@Param("name") String name);
}
