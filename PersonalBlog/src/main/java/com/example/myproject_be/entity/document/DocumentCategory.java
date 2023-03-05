package com.example.myproject_be.entity.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document_category",
        uniqueConstraints = {
                @UniqueConstraint(name = "CATEGORY_DOC", columnNames = {"category_id", "document_id"})
        })
public class DocumentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_category_id")
    private Integer documentCategoryId;

    @Column(name = "`delete_flag`", columnDefinition = "bit(1)")
    private Boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "document_id")
    @JsonBackReference
    private Document document;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
