package com.example.inicial1.services;

import com.example.inicial1.entities.Base;

import java.io.Serializable;
import java.util.List;

//En esta interface se declaran las 4 operaciones principales
//CRUD
//Es de tipo generica
public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    public E findById(ID Id) throws Exception;
    public E save(E entity) throws Exception;
    public E update (ID Id, E entity) throws Exception;
    public boolean delete (ID Id) throws Exception;
}

//findAll - Devuelve todas las entidades en una List
//findByIf - obtiene entidades E segun el Id que pasemos
//save - guarda la entidad
//update - actualiza una entidad(PRVIAMENTE ACTUALIZADA) en funcion de su Id
//delete - elimina la entidad en funcion del ID que le pasemos

