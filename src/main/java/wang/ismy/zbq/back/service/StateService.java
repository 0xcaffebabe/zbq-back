package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.StateRepository;
import wang.ismy.zbq.back.entity.State;
import wang.ismy.zbq.back.enums.PermissionEnum;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Permission(PermissionEnum.STATE_VIEW)
    public List<State> findAll(Pageable pageable, String kw){
        Pageable nPageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),Sort.Direction.DESC,"createTime");
        return stateRepository.findAll(nPageable).stream().collect(Collectors.toList());
    }
}
