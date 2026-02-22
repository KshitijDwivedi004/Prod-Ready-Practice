package org.kshitij.prodreadyfeature.prodreadyfeature.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.kshitij.prodreadyfeature.prodreadyfeature.dto.PostDto;
import org.kshitij.prodreadyfeature.prodreadyfeature.entities.PostEntity;
import org.kshitij.prodreadyfeature.prodreadyfeature.exception.ResourceNotFoundException;
import org.kshitij.prodreadyfeature.prodreadyfeature.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity ->
                    modelMapper.map(postEntity,PostDto.class)
                ).toList();
    }

    @Override
    public PostDto createNewPost(PostDto input) {
        PostEntity map = modelMapper.map(input, PostEntity.class);
        PostEntity save = postRepository.save(map);
        return modelMapper.map(save,PostDto.class);
    }

    @Override
    public PostDto getPostById(Long id) {
        PostEntity postNotFound = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post Not Found with id : "+id));
        return modelMapper.map(postNotFound,PostDto.class);
    }

    @Override
    public PostDto updatePostById(long id, PostDto input) {
        PostEntity olderPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with ID : " + id));
        // Ensure the path ID is authoritative
        input.setId(olderPost.getId());
        // Map incoming values INTO the managed entity
        modelMapper.map(input, olderPost);
        // Persist changes
        PostEntity saved = postRepository.save(olderPost);
        // Return DTO
        return modelMapper.map(saved, PostDto.class);
    }
}
