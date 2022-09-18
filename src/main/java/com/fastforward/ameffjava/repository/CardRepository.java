package com.fastforward.ameffjava.repository;

import com.fastforward.ameffjava.model.Card;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository {

  Optional<Card> findById(int id);

  Card save(Card card);

}
