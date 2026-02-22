package org.kshitij.prodreadyfeature.prodreadyfeature.controllers;

import lombok.RequiredArgsConstructor;
import org.kshitij.prodreadyfeature.prodreadyfeature.dto.PostDto;
import org.kshitij.prodreadyfeature.prodreadyfeature.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }
    @PostMapping()
    public PostDto addPost(@RequestBody PostDto postDto){
        return postService.createNewPost(postDto);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id){
        return  postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostDto updateById(@RequestBody PostDto input,@PathVariable long id){
        return postService.updatePostById(id,input);
    }
}
