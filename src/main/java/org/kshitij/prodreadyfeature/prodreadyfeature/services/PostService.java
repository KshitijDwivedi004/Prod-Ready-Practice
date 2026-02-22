package org.kshitij.prodreadyfeature.prodreadyfeature.services;

import org.kshitij.prodreadyfeature.prodreadyfeature.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto input);

    PostDto getPostById(Long id);
}
