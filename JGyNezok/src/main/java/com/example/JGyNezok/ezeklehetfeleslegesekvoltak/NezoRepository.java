package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;
import com.example.JGyNezok.Nezo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NezoRepository extends JpaRepository<Nezo, Long> {
}
