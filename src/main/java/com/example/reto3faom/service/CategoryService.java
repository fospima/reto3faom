package com.example.reto3faom.service;


import com.example.reto3faom.model.Category;
import com.example.reto3faom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> e =categoryRepository.getCategory(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return categoryRepository.save(c);
            }
        }

    }
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> t =categoryRepository.getCategory(c.getId());
            /*if(!t.isEmpty()){*/
            if(t.isPresent()) {
                if (c.getId() != null) {
                    t.get().setId(c.getId());
                }
                if (c.getName() != null) {
                    t.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    t.get().setDescription(c.getDescription());
                }
                if(c.getMotorbikes()!=null) {
                    t.get().setMotorbikes(c.getMotorbikes());
                }
                categoryRepository.save(t.get());
                return t.get();

            }else{
                return c;
            }

        }else{
            return c;

        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>m=categoryRepository.getCategory(id);
        if(m.isPresent()){
            categoryRepository.delete(m.get());
            flag=true;
        }

        return flag;
    }

}
