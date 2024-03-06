package com.example.practice.demo.models

import jakarta.persistence.*

@Entity
@Table(name ="users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val userId: Long = 0,
        val userName: String = "",
        val userContactNumber: String = ""
)
