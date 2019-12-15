package com.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.dto.APIResponse;
import com.manager.dto.PostForLikeDTO;
import com.manager.dto.PostImageDTO;
import com.manager.entity.PostImage;
import com.manager.service.PostImageService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PostImageControllerAPI {

    final String FOLDER_PATH = "src/main/resources/images";
    final String JPEG = "JPEG";
    final String PNG = "PNG";
    final String GIF = "GIF";

    @Autowired
    PostImageService postImageService;

    @GetMapping("/postImages/posts/{postId}")
    public List<PostImageDTO> getPostImageByPostId(@PathVariable(value = "postId") long postId) {
        List<PostImage> listPostImages = postImageService.getPostImageByPostId(postId);
        List<PostImageDTO> imageDTOs = new ArrayList<>();
        for (PostImage postImage : listPostImages) {
        	PostImageDTO postImageDTO = new PostImageDTO();
        	postImageDTO.setPostImageId(postImage.getPostImageId());
        	postImageDTO.setUrl(postImage.getUrl());
        	postImageDTO.setCreatedDate(postImage.getCreatedDate());
        	PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(postImage.getPost().getPostId());
			post.setBody(postImage.getPost().getBody());
			post.setCreatedDate(postImage.getPost().getCreateDate());
			postImageDTO.setPost(post);
        	imageDTOs.add(postImageDTO);
		}
        return imageDTOs;
    }
    
    @GetMapping("/postImages")
    public List<PostImageDTO> getAllPostImage(){
    	List<PostImage> listPostImages = postImageService.getAllPostImage();
        List<PostImageDTO> imageDTOs = new ArrayList<>();
        for (PostImage postImage : listPostImages) {
        	PostImageDTO postImageDTO = new PostImageDTO();
        	postImageDTO.setPostImageId(postImage.getPostImageId());
        	postImageDTO.setUrl(postImage.getUrl());
        	postImageDTO.setCreatedDate(postImage.getCreatedDate());
        	PostForLikeDTO post = new PostForLikeDTO();
			post.setPostId(postImage.getPost().getPostId());
			post.setBody(postImage.getPost().getBody());
			post.setCreatedDate(postImage.getPost().getCreateDate());
			postImageDTO.setPost(post);
        	imageDTOs.add(postImageDTO);
		}
        return imageDTOs;
    }
    
    @PostMapping("/postImages")
    public ResponseEntity<?> savePostImage(@Valid @RequestBody PostImage postImage){
    	boolean flag = postImageService.savePostImage(postImage);
		if (flag == false) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Save failed!"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Save successful!"), HttpStatus.OK);
		}
    }

    @GetMapping("/postImages/imagesall")
    public HashMap<String, List<String>> getImage() throws Exception {
        List<String> listFile = new ArrayList<>();
        File folder = new File(FOLDER_PATH);
        for (File file : folder.listFiles()) {
            listFile.add(file.getName());
        }
        HashMap<String, List<String>> json = new HashMap<>();
        json.put("path", listFile);
        return json;
    }

    @GetMapping("/postImages/image/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable(value = "name") String name) throws Exception {
        File img = new File(FOLDER_PATH + "/" + name);
        String[] extension = name.split("\\.");
        switch (extension[extension.length - 1].toUpperCase()) {
            case GIF:
                return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
                        .body(java.nio.file.Files.readAllBytes(img.toPath()));
            case PNG:
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                        .body(java.nio.file.Files.readAllBytes(img.toPath()));
            case JPEG:
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(java.nio.file.Files.readAllBytes(img.toPath()));
            default:
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                        .body(java.nio.file.Files.readAllBytes(img.toPath()));
        }
    }

    @PostMapping("/postImages/images")
    public void uploadFileToServer(@RequestParam(name = "upload") MultipartFile[] file) {
        File uploadRootDir = new File(FOLDER_PATH);
        for (MultipartFile data : file) {
            String nameFile = data.getOriginalFilename();
            try {
                File serverFile = new File(uploadRootDir.getAbsolutePath() + "/" + nameFile);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverFile));
                bos.write(data.getBytes());
                bos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
