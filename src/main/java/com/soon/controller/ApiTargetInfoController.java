package com.soon.controller;

import com.soon.domain.ApiTargetInfo;
import com.soon.service.ApiTargetInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/apiTarget")
public class ApiTargetInfoController {



    /*
        왜 여기서는 의존성 주입을 하지???
        차이가 뭐여
     */

    @Autowired
    ApiTargetInfoService apiTargetInfoService;

    @GetMapping("")
    public ResponseEntity<List<ApiTargetInfo>> getApiTargetInfoList(){

        ResponseEntity<List<ApiTargetInfo>> response = null;

        try{
            response = new ResponseEntity<>(apiTargetInfoService.findApiTargetInfoList(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiTargetInfo> postApiTargetInfo(@RequestBody Map<String, Object> params){

        log.info("params : {}", params.toString());

        ResponseEntity<ApiTargetInfo> response = null;

        ApiTargetInfo apiTargetInfo = ApiTargetInfo.builder()
                .targetName(params.get("targetName").toString())
                .targetUrl(params.get("targetUrl").toString())
                .regDate(LocalDateTime.now())
                .build();

        log.info("apiTargetInfo - name : {} / url : {} / regDate : {}", apiTargetInfo.getTargetName(), apiTargetInfo.getTargetUrl(), apiTargetInfo.getRegDate());

        response = new ResponseEntity<>(apiTargetInfoService.saveApiTargetInfo(apiTargetInfo), HttpStatus.OK);

        log.info("result : {}", response.toString());

        return response;
    }

    @PutMapping("/{id}")
    public String putApiTargetInfo(@PathVariable("idx")Long id, @RequestBody ApiTargetInfo apiTargetInfo){
        apiTargetInfoService.updateApiTargetInfo(id, apiTargetInfo);

        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteApiTargetInfo(@PathVariable("idx")Long id){
        apiTargetInfoService.deleteApiTargetInfo(id);

        return "";
    }
}
