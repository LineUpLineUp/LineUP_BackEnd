package com.linerup.lineup_backend.domain.post;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : LineUP_BackEnd
 * @name : post
 * @date : 2023/09/03 6:43 PM
 * @modifyed : $
 **/
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //다른 필드들은 type 영향을 받아 달라질수 있지만
    //공통되는것들은 그냥 가지고 있는거지
    //content 추상클래스
    //장기 콘텐츠 extends contents
    //단기 콘텐트 extends contents

    //만약에 post 안에 그 장 단기 필드 자체는 다 있어
    //그걸 이제 enum type으로 장기 단기를 구분해
    //이제 이걸 fetch할때 null로 비어있는 값들을 장단기에 따라서 projection으로 없애버리고
    //front에서는 이제 type을 기준으로 화면 렌더링을 다르게 하는거지
    //쿼리가 오히려 짧아짐
    //project 내부쿼리가
    //select * from
    //select '' ,'' ,'' ,''from
}
