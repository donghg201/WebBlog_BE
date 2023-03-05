package com.example.myproject_be.repository;

import com.example.myproject_be.entity.document.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //    ~~~ Get all Category
    @Query(value = "select * from `my_project`.`category`", nativeQuery = true)
    List<Category> getCategory();

    //    ~~~ Delete category with name
    @Modifying
    @Transactional
    @Query(value = "update `my_project`.`category` as c set c.`delete_flag` = 0 where c.`category_name` = :name", nativeQuery = true)
    void deleteCategory(@Param("name") String name);

    //    ~~~ Create category
    @Transactional
    @Modifying
    @Query(value = "insert into category(`category`.`category_name`, `category`.`delete_flag`) values (?1, ?2);", nativeQuery = true)
    void createCategory(String categoryName, Integer deleteFlag);

    //    ~~~ Find category by name
    @Query(value = "select * from `my_project`.`category` as c where c.`category_name` = :name and c.`delete_flag` = 1", nativeQuery = true)
    Category findCategoryByName(@Param("name") String name);
}
