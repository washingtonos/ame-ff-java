package com.fastforward.ameffjava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fastforward.ameffjava.controller.request.CardRequest;
import com.fastforward.ameffjava.exception.EntityNotFoundException;
import com.fastforward.ameffjava.model.CardOrigin;
import com.fastforward.ameffjava.repository.CardOriginRepository;
import com.fastforward.ameffjava.repository.CardRepository;
import com.fastforward.ameffjava.service.CardService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CardServiceTest {

  @Mock
  CardOriginRepository cardOriginRepository;

  @Mock
  CardRepository cardRepository;

  @InjectMocks
  CardService cardService;

  @BeforeEach
  void setup(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Retornar erro ao criar card sem origem")
  void shouldReturnErrorOnCreateCardWhenOriginNotFoud(){
    when(cardOriginRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> cardService.createCard(new CardRequest()));
    verify(cardRepository, never()).save(any());
  }

  @Test
  @DisplayName("Deve criar o card")
  void shouldSaveCardOnCreate(){
    var origin = new CardOrigin();
    origin.setId(1L);

    when(cardOriginRepository.findById(any())).thenReturn(Optional.of(origin));
    when(cardRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

    var cardRequest = new CardRequest();
    cardRequest.setName(cardRequest.getName());
    cardRequest.setDescription(cardRequest.getDescription());
    cardRequest.setImageUrl(cardRequest.getImageUrl());
    cardRequest.setStrength(cardRequest.getStrength());
    cardRequest.setGear(cardRequest.getGear());
    cardRequest.setSkill(cardRequest.getSkill());
    cardRequest.setSpeed(cardRequest.getSpeed());
    cardRequest.setIntellect(cardRequest.getIntellect());

    var card = cardService.createCard(cardRequest);

    assertEquals(card.getName(), cardRequest.getName());
    assertEquals(card.getDescription(), cardRequest.getDescription());
  }
}
