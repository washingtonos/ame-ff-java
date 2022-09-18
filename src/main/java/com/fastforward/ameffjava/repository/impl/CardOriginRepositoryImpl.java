package com.fastforward.ameffjava.repository.impl;

import com.fastforward.ameffjava.exception.InvalidEntityAttributeException;
import com.fastforward.ameffjava.model.CardOrigin;
import com.fastforward.ameffjava.repository.CardOriginRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CardOriginRepositoryImpl implements CardOriginRepository {

  private final List<CardOrigin> cardOrigins = new ArrayList<>();

  @Override
  public Optional<CardOrigin> findById(int id) {
    return cardOrigins.stream()
        .filter(storedCard -> storedCard.getId() == id)
        .findFirst();
  }

  @Override
  public CardOrigin save(CardOrigin cardOrigin) {

    var cardOriginFound = cardOrigins.stream()
        .filter(storedCard -> storedCard.getName().equalsIgnoreCase(cardOrigin.getName()))
        .findFirst();

    if(cardOriginFound.isPresent()){
      throw new InvalidEntityAttributeException("Card origin name [" + cardOrigin.getName() + " ] alredy stored");
    }

    cardOrigin.setId(cardOrigins.size() + 1);
    cardOrigins.add(cardOrigin);

    return cardOrigin;
  }
}
