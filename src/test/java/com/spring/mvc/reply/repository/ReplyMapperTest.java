package com.spring.mvc.reply.repository;

import com.spring.mvc.reply.domain.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("댓글 100개를 정상적으로 삽입해야 한다.")
    void save() {
        for (int i = 1; i <= 100; i++) {
            Reply reply = new Reply();
            reply.setReplyText("테스트댓글이야~~" + i);
            reply.setReplyWriter("깍깍이" + i);
            reply.setBoardNo(344L);

            replyMapper.save(reply);
        }

    }

    @Test
    void update() {
        Reply reply = new Reply();
        reply.setReplyNo(1L);
        reply.setReplyText("수정한 댓글이야~~");
        replyMapper.update(reply);
    }

    @Test
    void delete() {
        replyMapper.delete(2L);
    }

    @Test
    void read() {
        Reply read = replyMapper.read(1L);
        System.out.println("\n==================================");
        System.out.println("read = " + read);
        System.out.println("==================================");
    }

    @Test
    void getList() {

        List<Reply> list = replyMapper.getList(344L);
        System.out.println("\n==========================================");
        for (Reply reply : list) {
            System.out.println("reply = " + reply);
        }
    }
}