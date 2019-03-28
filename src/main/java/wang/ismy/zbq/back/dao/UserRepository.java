package wang.ismy.zbq.back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.User;

import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,value = "SELECT COUNT(1) FROM user WHERE DATE(last_login) = DATE(NOW())")
    long countTodayLoginUser();

    @Query(nativeQuery = true,value = "SELECT * FROM user WHERE username LIKE '%' ? '%'")
    Page<User> findUserListByUsername(String username, Pageable pageable);
}
