package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository <E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }


    @Override
    @Transactional
    public List<E> findAll() {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener la lista de Entidades", e);
        }
    }


    @Override
    @Transactional
    public E findById(ID Id) throws Exception {
        try {
            Optional<E> entitiyOptional = baseRepository.findById(Id);
            return entitiyOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            E persona = entityOptional.get();
            persona = baseRepository.save(entity);
            return persona;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID Id) throws Exception {
        try {
            if (baseRepository.existsById(Id)) {
                baseRepository.deleteById(Id);
                return true;
            } else {
                throw new Exception();
            }

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

