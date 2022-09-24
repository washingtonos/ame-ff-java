package com.fastforward.ameffjava.repository;

import com.fastforward.ameffjava.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository  extends JpaRepository<Card, Long> {

}
