package com.mywebpage.mywebpage.comment.boardcomment.entity;

import com.mywebpage.mywebpage.common.BaseTimeEntity;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board_comment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="bcno", callSuper = false)
@Builder
public class Bcomment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bcno;
    private String content;

//    댓글이 달린 게시물
//    단방향 조회 : Board 쪽에서는 댓글 수가 필요할 때만 BcommentRepository에서 조회
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_bno", nullable = false)
    private Board board;

//    댓글 작성자
//    👉 기본값 = EAGER (N:1, ex. 댓글 → 부모, 댓글 → 유저)
//      연관된 부모 엔티티 모두 가져옴
//      즉시로딩이라 지연로딩 명시 필요
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", referencedColumnName="name", nullable = false)
    private User writer;

//    대댓글용
//    자기 참조 객체
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_bcno")
    private Bcomment parent;

//    TODO: mappedBy = "parent" : parent 필드에 의해 양방향 매핑됨.
//                                하나의 필드는 여러 개의 대댓글(자식)을 가질 수 있음
//          cascade = CascadeType.ALL : 부모 댓글 저장/삭제 시, 연관된 자식 댓글도 같이 적용
//          orphanRemoval = true : 자식 엔티티가 부모랑 관계 끊어지면 자동으로 삭제
//                                 예) DB에서 parent_id = null
    @OneToMany(mappedBy = "parent",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
//    👉 기본값 = LAZY
//     기본값이 지연로딩이라 명시 필요X
    private List<Bcomment> children = new ArrayList<>();
}
