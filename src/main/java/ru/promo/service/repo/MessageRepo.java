package ru.promo.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.promo.service.domain.Promo;

public interface MessageRepo extends JpaRepository<Promo, Long> {
}
