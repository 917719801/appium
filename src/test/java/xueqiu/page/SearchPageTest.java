package xueqiu.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class SearchPageTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeall() {
        searchPage = new MainPage().toSearch();


    }
    @AfterAll
    static void  afterall(){
        searchPage.quit();
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



}