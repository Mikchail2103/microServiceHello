package microServiceHello.repository;

import microServiceHello.model.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloEntityRepository extends JpaRepository<HelloEntity, Long> {
    @Query("SELECT h FROM HelloEntity h WHERE h.id = :id")
    HelloEntity getByIdName(String id);
}
