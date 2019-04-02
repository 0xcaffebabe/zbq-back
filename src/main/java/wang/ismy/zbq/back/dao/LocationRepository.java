package wang.ismy.zbq.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
}
