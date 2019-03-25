package wang.ismy.zbq.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wang.ismy.zbq.back.entity.back.AdminPermission;

@Repository
public interface AdminPermissionRepository extends JpaRepository<AdminPermission,Integer> {
}
