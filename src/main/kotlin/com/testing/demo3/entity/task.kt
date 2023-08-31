package com.testing.demo3.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import com.testing.demo3.entity.Category
import jakarta.persistence.CascadeType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany


@Entity
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val title: String,
    val description:String,
    var duedate: String,
    var completed: Boolean,

    @OneToMany
    @JoinColumn(name = "category")
    var category: List<Category>
){


    constructor() : this(null, "", "", "",false, listOf());
}