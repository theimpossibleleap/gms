package com.erickalovesadam.wedding.services;

import com.erickalovesadam.wedding.entities.Meal;
import com.erickalovesadam.wedding.repositories.MealRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal findMealById(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    public void saveMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void deleteMeal(Meal meal) {
        mealRepository.delete(meal);
    }

}
