package com.fastforward.ameffjava.controller;

import com.fastforward.ameffjava.controller.request.CardOriginRequest;
import com.fastforward.ameffjava.model.CardOrigin;
import com.fastforward.ameffjava.service.CardOriginService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CardOrigin createCardOrigin(@RequestBody CardOriginRequest cardOriginRequest){
    LOG.info("Inserindo a origim : {}", cardOriginRequest);
    return cardOriginService.createOriginCard(cardOriginRequest);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("{id}")
  public CardOrigin findCardOriginById(@PathVariable("id") long id){
    LOG.info("Buscando origem com id : {}", id);
    return cardOriginService.findById(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public List<CardOrigin> findAllCardOrigin(){
    LOG.info("Buscando todas as origens de carta");
    return cardOriginService.listAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("{id}")
  public CardOrigin updateCardOrigin(@PathVariable("id") long id,
                                     @RequestBody CardOriginRequest cardOriginRequest){
    LOG.info("Atualizando card origin com id {}", id);
    return cardOriginService.update(id, cardOriginRequest);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("{id}")
  public void deleteCardOrigin(@PathVariable("id") long id){
    LOG.info("Deletando cardOrigin com id [{}]", id);
    cardOriginService.delete(id);
  }
}
