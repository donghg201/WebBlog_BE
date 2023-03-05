package com.example.myproject_be.entity.document;

import com.sun.istack.NotNull;
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
@Table(name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "CATEGORY_DOC", columnNames = "category_id")
        })
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    @NotNull
    private String categoryName;

    @Column(name = "`delete_flag`", columnDefinition = "bit(1)")
    private Boolean deleteFlag;
}
