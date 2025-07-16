package com.treecare.treecarebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 이 클래스가 API 요청을 처리하는 컨트롤러임을 나타냅니다.
public class TreeController {

    @Autowired // 스프링이 자동으로 TreeRepository 객체를 주입해줍니다.
    private TreeRepository treeRepository;

    @CrossOrigin(origins = "*") // 모든 외부 접속을 허용합니다 (CORS 문제 해결)
    @GetMapping("/api/trees") // http://localhost:8080/api/trees 요청을 처리합니다.
    public List<Tree> getAllTrees() {
        return treeRepository.findAll(); // DB에 있는 모든 Tree 정보를 반환합니다.
    }
}