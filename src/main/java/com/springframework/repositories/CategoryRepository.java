package com.springframework.repositories;

import com.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nidhal on 06/06/2019.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
