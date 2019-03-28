package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.dao.AdminPermissionRepository;
import wang.ismy.zbq.back.entity.back.AdminPermission;


@Service
public class AdminPermissionService {

    @Autowired
    private AdminPermissionRepository adminPermissionRepository;

    @Autowired
    private AdminService adminService;

    public AdminPermission createNew(){
        AdminPermission adminPermission = new AdminPermission();
        adminPermission.setLogin(true);
        adminPermission.setCreateAdmin(false);
        return adminPermissionRepository.save(adminPermission);
    }

    public AdminPermission getCurrentAdminPermission(){
        return adminPermissionRepository.findById(adminService.getCurrentAdmin().getAdminPermission()).get();
    }



}
