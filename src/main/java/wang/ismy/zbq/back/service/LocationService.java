package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.dao.LocationRepository;
import wang.ismy.zbq.back.entity.Location;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll(Integer page,Integer length,String kw){
        Pageable pageable = PageRequest.of(page,length);
        return locationRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
}
