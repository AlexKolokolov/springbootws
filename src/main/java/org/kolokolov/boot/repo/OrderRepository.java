package org.kolokolov.boot.repo;

import org.kolokolov.boot.model.ShopOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ShopOrder,Integer> {}
