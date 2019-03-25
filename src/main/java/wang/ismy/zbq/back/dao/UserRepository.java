package wang.ismy.zbq.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
