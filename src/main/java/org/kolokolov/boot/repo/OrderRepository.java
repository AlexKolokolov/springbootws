package org.kolokolov.boot.repo;

import org.kolokolov.boot.model.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ShopOrder,Integer> {}