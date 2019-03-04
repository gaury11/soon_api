package com.soon.controller;

import com.soon.domain.Timeline;
import com.soon.domain.enums.TimelineType;
import com.soon.service.TimelineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @GetMapping("")
    public ResponseEntity<List<Timeline>> getTimeline(){

        ResponseEntity<List<Timeline>> response = null;

        try{
            response = new ResponseEntity<>(timelineService.findTimelineList(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<Timeline> saveTimeline(@RequestBody Map<String, Object> params){

        log.info("params : {}", params.toString());

        ResponseEntity<Timeline> response = null;

        Timeline timeline = Timeline.builder()
                .title(params.get("title").toString())
                .timelineType(params.get("timelineType").toString())
                .content(params.get("content").toString())
                .regDate(LocalDateTime.now())
                .regId("soon")
                .build();

        log.info("timeline : {}", timeline.toString());

        response = new ResponseEntity<>(timelineService.saveTimeline(timeline), HttpStatus.OK);

        log.info("result : {}", response.toString());

        return response;
    }


    @DeleteMapping("/{idx}")
    public ResponseEntity<String> deleteTimeline(@PathVariable("idx")Long idx){

        log.info("idx : {}", idx);

        ResponseEntity<String> response = null;

        timelineService.deleteTimelineByIdx(idx);

        response = new ResponseEntity<>("DELETE SUCCESS", HttpStatus.OK);

        return response;
    }


}
