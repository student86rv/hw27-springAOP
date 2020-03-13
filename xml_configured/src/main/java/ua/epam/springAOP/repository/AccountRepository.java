package ua.epam.springAOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.epam.springAOP.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
