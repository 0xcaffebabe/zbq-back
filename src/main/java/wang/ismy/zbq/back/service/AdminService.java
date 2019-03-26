package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wang.ismy.zbq.back.AdminPermissionService;
import wang.ismy.zbq.back.dao.AdminPermissionRepository;
import wang.ismy.zbq.back.dao.AdminRepository;
import wang.ismy.zbq.back.dto.LoginDTO;
import wang.ismy.zbq.back.entity.User;
import wang.ismy.zbq.back.entity.back.Admin;
import wang.ismy.zbq.back.entity.back.AdminPermission;
import wang.ismy.zbq.back.uti.ErrorUtils;
import wang.ismy.zbq.back.uti.R;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class AdminService {

    @Autowired
    private AdminPermissionService adminPermissionService;

    @Autowired
    private AdminRepository adminRepository;

    private String salt = "sf45fds48ew84liul8756fsdregsdd45t5xzfv]['lkjhgf";

    @Transactional
    public Admin createNewAdmin(Admin admin) {
        if (adminRepository.findByUsername(admin.getUsername()) != null) {
            ErrorUtils.error(R.USERNAME_DUPLICATE);
        }

        // 为欲被创建的用户创建一条权限记录

        AdminPermission adminPermission = adminPermissionService.createNew();
        if (adminPermission.getPermissionId() == null) {
            ErrorUtils.error(R.UNKNOWN_ERROR);
        }
        admin.setAdminPermission(adminPermission.getPermissionId());

        admin.setCreateTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        // 加盐
        admin.setPassword(
                DigestUtils.md5DigestAsHex(
                        (admin.getPassword().toUpperCase() + salt).getBytes()
                ).toUpperCase());

        return adminRepository.save(admin);
    }

    public void login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword().toUpperCase();
        password = DigestUtils.md5DigestAsHex((password + salt).getBytes()).toUpperCase();
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if ( admin == null) {
            ErrorUtils.error(R.LOGIN_FAIL);
        }
        setCurrentAdmin(admin);
    }

    public void setCurrentAdmin(Admin admin) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("admin", admin);
    }

    public Admin findById(Integer id){
        return adminRepository.findById(id).get();
    }

    public Admin getCurrentAdmin() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object admin = request.getSession().getAttribute("admin");

        if (admin instanceof Admin) {
            if (admin != null) {
                return (Admin) admin;
            }
        }
        return null;
    }

    public boolean hasLogin() {
        return getCurrentAdmin() != null;
    }
}
