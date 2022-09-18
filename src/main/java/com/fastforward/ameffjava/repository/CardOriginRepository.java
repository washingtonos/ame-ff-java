package com.fastforward.ameffjava.repository;

import com.fastforward.ameffjava.model.CardOrigin;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CardOriginRepository {

  CardOrigin save(CardOrigin cardOrigin);

  Optional<CardOrigin> findById(int id);
}
