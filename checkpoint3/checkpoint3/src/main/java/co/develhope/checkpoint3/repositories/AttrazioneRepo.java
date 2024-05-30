package co.develhope.checkpoint3.repositories;

import co.develhope.checkpoint3.entities.Attrazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttrazioneRepo extends JpaRepository<Attrazione, Long> {
}
