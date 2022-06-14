package wang.ismy.zbq.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.back.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUsername(String username);

    Admin findByUsernameAndPassword(String username,String password);
}
