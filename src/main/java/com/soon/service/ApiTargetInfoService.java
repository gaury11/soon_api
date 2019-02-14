package com.soon.service;

import com.soon.repository.ApiTargetInfoRepository;
import com.soon.domain.ApiTargetInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApiTargetInfoService {

    Logger log = LoggerFactory.getLogger(ApiTargetInfoService.class);

    private final ApiTargetInfoRepository apiTargetInfoRepository;

    public ApiTargetInfoService(ApiTargetInfoRepository apiTargetInfoRepository){
        this.apiTargetInfoRepository = apiTargetInfoRepository;
    }

    public List<ApiTargetInfo> findApiTargetInfoList(){

        List<ApiTargetInfo> result = apiTargetInfoRepository.findAll();

        log.info("findApiTargetInfoList size : {} ", result.size());

        return result;
    }

    public ApiTargetInfo findApiTargetInfo(Long id){
        return apiTargetInfoRepository.findById(id).orElse(new ApiTargetInfo());
    }

    @Transactional
    public void saveApiTargetInfo(ApiTargetInfo apiTargetInfo){
        apiTargetInfoRepository.save(apiTargetInfo);
    }

    @Transactional
    public void updateApiTargetInfo(Long id, ApiTargetInfo apiTargetInfo){
        ApiTargetInfo persistApiTargetInfo = apiTargetInfoRepository.getOne(id);
        persistApiTargetInfo.update(apiTargetInfo);
        apiTargetInfoRepository.save(persistApiTargetInfo);
    }

    @Transactional
    public void deleteApiTargetInfo(Long id){
        apiTargetInfoRepository.deleteById(id);
    }

}
