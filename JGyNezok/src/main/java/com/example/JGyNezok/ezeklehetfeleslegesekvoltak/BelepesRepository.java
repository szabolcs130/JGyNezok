package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;
import com.example.JGyNezok.Belepes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelepesRepository extends JpaRepository<Belepes, Long> {
}
