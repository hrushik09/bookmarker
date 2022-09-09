package com.hrushik09.bookmarker;

import com.hrushik09.bookmarker.domain.Bookmark;
import com.hrushik09.bookmarker.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Bookmark(null, "GitHub", "https://github.com/", Instant.now()));
        repository.save(new Bookmark(null, "JetBrains Academy", "https://hyperskill.org/study-plan", Instant.now()));
        repository.save(new Bookmark(null, "freeCodeCamp", "https://www.freecodecamp.org/learn", Instant.now()));
        repository.save(new Bookmark(null, "Spring Initializr", "https://start.spring.io/", Instant.now()));
        repository.save(new Bookmark(null, "Thymeleaf", "https://www.thymeleaf.org/", Instant.now()));
        repository.save(new Bookmark(null, "Docker Hub", "https://hub.docker.com/", Instant.now()));
        repository.save(new Bookmark(null, "Coursera", "https://www.coursera.org/", Instant.now()));
        repository.save(new Bookmark(null, "MIT OpenCourseWare", "https://ocw.mit.edu/", Instant.now()));
        repository.save(new Bookmark(null, "LeetCode", "https://leetcode.com/", Instant.now()));
        repository.save(new Bookmark(null, "Medium", "https://medium.com/", Instant.now()));
        repository.save(new Bookmark(null, "MDN Web Docs", "https://developer.mozilla.org/en-US/", Instant.now()));
        repository.save(new Bookmark(null, "Git Book", "https://git-scm.com/book/en/v2", Instant.now()));
        repository.save(new Bookmark(null, "Graph Editor", "https://csacademy.com/app/graph_editor/", Instant.now()));
        repository.save(new Bookmark(null, "java Visualizer", "https://cscircles.cemc.uwaterloo.ca/java_visualize/", Instant.now()));
        repository.save(new Bookmark(null, "regex101", "https://regex101.com/", Instant.now()));
    }
}
