package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;
import com.example.JGyNezok.Meccs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeccsRepository extends JpaRepository<Meccs, Long> {
}
