package com.fastforward.ameffjava.repository;

import com.fastforward.ameffjava.model.CardOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardOriginRepository  extends JpaRepository<CardOrigin, Long> {
}
