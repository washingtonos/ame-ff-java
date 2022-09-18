package com.fastforward.ameffjava.controller;

import com.fastforward.ameffjava.controller.request.CreateCardOriginRequest;
import com.fastforward.ameffjava.model.CardOrigin;
import com.fastforward.ameffjava.service.CardOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-origin")
public class CardOriginController {

  private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

  private final CardOriginService cardOriginService;

  @Autowired
  public CardOriginController(CardOriginService cardOriginService) {
    this.cardOriginService = cardOriginService;
  }

  @PostMapping
  public CardOrigin createCardOrigin(@RequestBody CreateCardOriginRequest createCardOriginRequest){
    LOG.info("Inserindo a origim : {}", createCardOriginRequest);
    return cardOriginService.createOriginCard(createCardOriginRequest);
  }

  @GetMapping("{id}")
  public CardOrigin findCardOriginById(@PathVariable("id") int id){
    LOG.info("Buscando origem com id : {}", id);
    return cardOriginService.findById(id);
  }
}
