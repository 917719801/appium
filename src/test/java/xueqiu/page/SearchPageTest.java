package xueqiu.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class SearchPageTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeall() {
        searchPage = new MainPage().toSearch();


    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,   阿里巴巴",
            "jd,     京东"

    })
    void search(String keyword, String name) {
        assertEquals(searchPage.search(keyword).getSearchList().get(0), name);

    }

    @Test
    void getPrice() {
        assertTrue(searchPage.search("alibaba").getPrice() > 200);
    }


    @AfterAll
    static void afterall(){
        mainPage.tearDown();

    }
}