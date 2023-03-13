package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.UserController;


@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
    private BookController bookcontroller;

    @Test
    public void bookControllerTest() throws Exception {
        assertThat(bookcontroller).isNotNull();
    }	

    @Autowired
    private UserController usercontroller;

    @Test
    public void userControllerTest() throws Exception {
        assertThat(usercontroller).isNotNull();
    }	

}
