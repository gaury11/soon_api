package com.soon.repository;

import com.soon.domain.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineRepository extends JpaRepository<Timeline, Long> {

}
