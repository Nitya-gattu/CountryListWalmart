package com.example.walmartcodingofnitya.data.mapper

interface IMapper<E, D> {
    fun mapToDomain(type: E): D
    fun mapToEntity(type: D): E
}