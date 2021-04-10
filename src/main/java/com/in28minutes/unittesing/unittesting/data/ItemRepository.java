package com.in28minutes.unittesing.unittesting.data;

import com.in28minutes.unittesing.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
