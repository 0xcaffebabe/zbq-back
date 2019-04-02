package wang.ismy.zbq.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Integer> {
}
