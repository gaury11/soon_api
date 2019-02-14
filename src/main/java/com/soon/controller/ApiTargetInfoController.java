package com.soon.controller;

import com.soon.service.ApiTargetInfoService;
import com.soon.domain.ApiTargetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        ResponseEntity<List<ApiTargetInfo>> entity = null;

        try{
            entity = new ResponseEntity<>(apiTargetInfoService.findApiTargetInfoList(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @PostMapping
    public String postApiTargetInfo(@RequestBody ApiTargetInfo apiTargetInfo){

        apiTargetInfo.setRegDateNow();

        apiTargetInfoService.saveApiTargetInfo(apiTargetInfo);

        return "";
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
