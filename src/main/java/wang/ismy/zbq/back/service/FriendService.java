package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.FriendRepository;
import wang.ismy.zbq.back.entity.Friend;
import wang.ismy.zbq.back.enums.PermissionEnum;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Permission(PermissionEnum.FRIEND_VIEW)
    public List<Friend> findAll(Pageable pageable,String kw){
        return friendRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
}

