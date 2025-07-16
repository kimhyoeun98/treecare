package com.treecare.treecarebackend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class TreecareBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreecareBackendApplication.class, args);
	}

	// ★★★ 서버 시작 시 데이터를 DB에 저장하는 코드 (추가) ★★★
	@Bean
	CommandLineRunner runner(TreeRepository treeRepository) {
		return args -> {
			// DB가 비어있을 때만 데이터를 저장합니다.
			if (treeRepository.count() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				// resources 폴더의 trees.json 파일을 읽어옵니다.
				InputStream inputStream = TypeReference.class.getResourceAsStream("/trees.json");
				try {
					// JSON 데이터를 Tree 객체 리스트로 변환합니다.
					List<Tree> trees = mapper.readValue(inputStream, new TypeReference<List<Tree>>(){});
					// 모든 Tree 데이터를 DB에 저장합니다.
					treeRepository.saveAll(trees);
					System.out.println(">>>> Trees Saved to Database!");
				} catch (Exception e) {
					System.out.println(">>>> Unable to save trees: " + e.getMessage());
				}
			}
		};
	}
}
