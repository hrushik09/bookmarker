package com.hrushik09.bookmarker.api;

import com.hrushik09.bookmarker.domain.Bookmark;
import com.hrushik09.bookmarker.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAllInBatch();
        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark(null, "GitHub", "https://github.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "JetBrains Academy", "https://hyperskill.org/study-plan", Instant.now()));
        bookmarks.add(new Bookmark(null, "freeCodeCamp", "https://www.freecodecamp.org/learn", Instant.now()));
        bookmarks.add(new Bookmark(null, "Spring Initializr", "https://start.spring.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Thymeleaf", "https://www.thymeleaf.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Docker Hub", "https://hub.docker.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Coursera", "https://www.coursera.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "MIT OpenCourseWare", "https://ocw.mit.edu/", Instant.now()));
        bookmarks.add(new Bookmark(null, "LeetCode", "https://leetcode.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Medium", "https://medium.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "MDN Web Docs", "https://developer.mozilla.org/en-US/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Git Book", "https://git-scm.com/book/en/v2", Instant.now()));
        bookmarks.add(new Bookmark(null, "Graph Editor", "https://csacademy.com/app/graph_editor/", Instant.now()));
        bookmarks.add(new Bookmark(null, "java Visualizer", "https://cscircles.cemc.uwaterloo.ca/java_visualize/", Instant.now()));
        bookmarks.add(new Bookmark(null, "regex101", "https://regex101.com/", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 15, 2, 1, true, false, true, false",
            "2, 15, 2, 2, false, true, false, true"
    })
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages,
                            int currentPage, boolean isFirst, boolean isLast,
                            boolean hasNext, boolean hasPrevious) throws Exception {

        mvc.perform(get("/api/bookmarks?page=" + pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
    }
}