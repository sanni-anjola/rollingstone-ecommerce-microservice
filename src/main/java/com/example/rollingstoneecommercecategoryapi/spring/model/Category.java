package com.example.rollingstoneecommercecategoryapi.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rollingstone_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;
    @Column(name = "CATEGORY_DESCRIPTION", nullable = false)
    private String categoryDescription;
}
