package com.soon.repository;

import com.soon.domain.ApiTargetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApiTargetInfoRepository extends JpaRepository<ApiTargetInfo, Long> {
    /*
        Repository
        역할 = 마이바티스에서의 dao와 같은 DB 접근자
        인터페이스 생성 후, JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동 생성됨

        1. 데이터의 흐름
        데이터의 흐름은 사용자의 요청 -> 컨트롤러(Controller) -> 서비스(Service) -> 리포지토리(Repository) -> DB 방향으로 Request(요청) 절차가 수행되고 이와 반대의 흐름으로 Response(응답) 절차를 수행하게 된다.

        2. Controller
        사용자의 요청과 응답을 직접적으로 처리하는 단계로 요청 내용을 정리하고 그에 맞는 응답을 할 수 있도록 서비스 메소드를 호출한다.

        3. Service
        컨트롤러에서 요청하는 데이터를 Repository의 메소드를 호출해 정제하고 정리해서 컨트롤러에 전달한다.
        이때 Transaction을 정의하고 DB 커넥션 풀을 적절하게 관리할 수 있도록 설정한다. Transaction을 적절하게 설정하게 되면 데이터 처리중 문제가 발생했을 때 RollBack을 할 수 있다.

        2. Repository
        우리는 JPA 라이브러리를 이용하고 있어서 인터페이스클래스안에 네이밍을 맞춰서 메소드를 선언해놓으면 Spring boot가 기동할때 자동으로 구현체를 만들어서 붙여준다. 구현체를 만드느라 시간 낭비할 필요없다. 클라이언트의 요구사항이 매우 난해하여 굳이 뭔가를 해야할 때는 나중에 QueryDSL이라는 것을 통해 포스팅을 하겠다.

     */

}
