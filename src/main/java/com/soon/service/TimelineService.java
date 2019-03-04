package com.soon.service;

import com.soon.domain.Timeline;
import com.soon.repository.TimelineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimelineService {

    private final TimelineRepository timelineRepository;

    public TimelineService(TimelineRepository timelineRepository){
        this.timelineRepository = timelineRepository;
    }

    public Timeline saveTimeline(Timeline timeline){
        return timelineRepository.save(timeline);
    }

    public List<Timeline> findTimelineList(){

        Sort sort = new Sort(Sort.Direction.DESC, "idx");

        return timelineRepository.findAll(sort);
    }

    public Page<Timeline> findTimelineList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize());

        return timelineRepository.findAll(pageable);
    }

    public Timeline findTimelineByIdx(Long idx){
        return timelineRepository.findById(idx).orElse(new Timeline());
        // orElse(T order) : Optional 객체에 값이 없다면 'order' 를 리턴
    }

    @Transactional
    public void deleteTimelineByIdx(Long idx){
        timelineRepository.deleteById(idx);
    }
}
