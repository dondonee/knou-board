package com.knou.board.repository.mybatis;

import com.knou.board.domain.post.Post;
import com.knou.board.domain.post.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    void insert(Post post);
    Post selectById(Long id);

    List<Post> selectAll();
    List<Post> selectByTopics(Topic[] topics);
    void update(Post post);
    void updateViewCount(Long id);
    void delete(Long id);
}
