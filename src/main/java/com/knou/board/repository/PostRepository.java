package com.knou.board.repository;

import com.knou.board.domain.post.Criteria;
import com.knou.board.domain.post.Post;
import com.knou.board.domain.post.Topic;

import java.util.List;

public interface PostRepository {

    Post insert(Post post);
    Post selectById(Long id);
    List<Post> selectAll();
    List<Post> selectByUserNo(Long userNo, Criteria criteria);
    List<Post> selectByTopics(Topic[] topics, Criteria criteria);
    long countTotalSelectedByUserNo(Long userNo);
    long countTotalSelectedByTopics(Topic[] topics);
    Post update(Post post);
    void updateViewCount(Long id);
    void delete(Long id);
}
