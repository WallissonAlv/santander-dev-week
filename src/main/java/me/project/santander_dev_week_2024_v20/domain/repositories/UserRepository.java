package me.project.santander_dev_week_2024_v20.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.santander_dev_week_2024_v20.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
