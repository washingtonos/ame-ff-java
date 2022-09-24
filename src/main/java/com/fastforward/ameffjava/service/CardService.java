package com.fastforward.ameffjava.service;

import com.fastforward.ameffjava.controller.request.CardRequest;
import com.fastforward.ameffjava.exception.EntityNotFoundException;
import com.fastforward.ameffjava.model.Card;
import com.fastforward.ameffjava.repository.CardOriginRepository;
import com.fastforward.ameffjava.repository.CardRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

  private final CardRepository cardRepository;
  private final CardOriginRepository cardOriginRepository;

  @Autowired
  public CardService(CardRepository cardRepository, CardOriginRepository cardOriginRepository) {
    this.cardRepository = cardRepository;
    this.cardOriginRepository = cardOriginRepository;
  }

  public Card findById(long id){
    return this.cardRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Card id [" + id + " ] not found."));
  }

  public List<Card> listAll(){
    return this.cardRepository.findAll();
  }

  public Card createCard(CardRequest cardRequest){

    var cardOrigin = cardOriginRepository.findById(cardRequest.getOriginId())
        .orElseThrow(() -> new EntityNotFoundException("Card origin id ["+ cardRequest.getOriginId() + "] not found" ));

    var card = new Card();

    card.setName(cardRequest.getName());
    card.setDescription(cardRequest.getDescription());
    card.setImageUrl(cardRequest.getImageUrl());
    card.setStrength(cardRequest.getStrength());
    card.setGear(cardRequest.getGear());
    card.setSkill(cardRequest.getSkill());
    card.setSpeed(cardRequest.getSpeed());
    card.setIntellect(cardRequest.getIntellect());
    card.setOrigin(cardOrigin);
    card.setCreatedAt(LocalDateTime.now());
    card.setUpdateAt(LocalDateTime.now());

    return cardRepository.save(card);
  }

  public Card update(long id, CardRequest cardRequest){
    var card = this.findById(id);

    card.setName(cardRequest.getName());
    card.setDescription(cardRequest.getDescription());
    card.setImageUrl(cardRequest.getImageUrl());
    card.setStrength(cardRequest.getStrength());
    card.setGear(cardRequest.getGear());
    card.setSkill(cardRequest.getSkill());
    card.setSpeed(cardRequest.getSpeed());
    card.setIntellect(cardRequest.getIntellect());
    card.setUpdateAt(LocalDateTime.now());

    if(card.getOrigin() == null || card.getOrigin().getId() != cardRequest.getOriginId()){
      var origin = cardOriginRepository.findById(cardRequest.getOriginId())
          .orElseThrow(() -> new EntityNotFoundException("Card origin id [ "+ cardRequest.getOriginId() +" ] not found "));

      card.setOrigin(origin);
    }

    return cardRepository.save(card);
  }

  public void delete(long id){
    var card = this.findById(id);

    cardRepository.delete(card);
  }
}
