package com.fastforward.ameffjava.service;

import com.fastforward.ameffjava.controller.request.CreateCardOriginRequest;
import com.fastforward.ameffjava.exception.EntityNotFoundException;
import com.fastforward.ameffjava.model.CardOrigin;
import com.fastforward.ameffjava.repository.CardOriginRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardOriginService {

  private final CardOriginRepository cardOriginRepository;

  @Autowired
  public CardOriginService(CardOriginRepository cardOriginRepository) {
    this.cardOriginRepository = cardOriginRepository;
  }

  public CardOrigin findById(int id){
    return this.cardOriginRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Card origin id [ "+id+" not found]"));
  }

  public CardOrigin createOriginCard(CreateCardOriginRequest cardOriginRequest){
    var cardOrigin = new CardOrigin();

    cardOrigin.setName(cardOriginRequest.getName());
    cardOrigin.setDescription(cardOriginRequest.getDescription());
    cardOrigin.setCreator(cardOriginRequest.getCreator());

    cardOrigin.setCreateAt(LocalDateTime.now());
    cardOrigin.setUpdateAt(LocalDateTime.now());

    return cardOriginRepository.save(cardOrigin);
  }

}
