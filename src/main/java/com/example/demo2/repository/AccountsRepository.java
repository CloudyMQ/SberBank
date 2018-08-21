package com.example.demo2.repository;

import com.example.demo2.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

  Accounts getByAccount(String account);

  @Query ("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Accounts a WHERE a.account = :ACCOUNT")
  boolean existByAccount(@Param ("ACCOUNT") String account);
}
