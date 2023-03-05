package com.example.myproject_be.entity.document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "document_name", columnDefinition = "varchar(255)")
    @NotNull
    private String documentName;

    @Column(name = "document_writer", columnDefinition = "varchar(50)")
    private String documentWriter;

    @NotNull
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "`delete_flag`", columnDefinition = "bit(1)")
    private Boolean deleteFlag;

    @OneToMany(mappedBy = "document")
    @JsonManagedReference
    private Set<DocumentCategory> documentCategorySet;
}
