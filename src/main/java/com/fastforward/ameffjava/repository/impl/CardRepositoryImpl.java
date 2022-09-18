package com.fastforward.ameffjava.repository.impl;

import com.fastforward.ameffjava.exception.InvalidEntityAttributeException;
import com.fastforward.ameffjava.model.Card;
import com.fastforward.ameffjava.repository.CardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryImpl implements CardRepository {

  private final List<Card> cards = new ArrayList<>();

  @Override
  public Optional<Card> findById(int id) {
    return cards.stream()
        .filter(card -> card.getId() == id)
        .findFirst();
  }

  @Override
  public Card save(Card card) {
    var cardFound = cards.stream()
        .filter(storedCard -> storedCard.getName().equalsIgnoreCase(card.getName()))
        .findFirst();

    if (cardFound.isPresent()){
      throw new InvalidEntityAttributeException("Card name [" + card.getName() + " ] alredy stored");
    }

    card.setId(cards.size()+1);
    cards.add(card);

    return card;
  }
}
