package com.codewithdurgesh.blog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Comment;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.payloads.CommentDto;
import com.codewithdurgesh.blog.repositories.CommentRepo;
import com.codewithdurgesh.blog.repositories.PostRepo;
import com.codewithdurgesh.blog.services.CommentService;
import com.codewithdurgesh.blogexceptions.ResourceNotFoundException;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper; 

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Not Found for", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		//comment.setId(postId);
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
			
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comm = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "not found for", commentId));
	
	this.commentRepo.delete(comm);
	}

}
