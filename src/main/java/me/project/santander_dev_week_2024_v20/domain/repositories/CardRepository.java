package me.project.santander_dev_week_2024_v20.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.santander_dev_week_2024_v20.domain.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>  {

}
