package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootTest
//must tell test to not replace datasource 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository catRepository;
	//all tests work but
	// this test only works when the other tests dont exist in the class, unsure why
	// search test
	@Test
	public void findByName() {
		List<Category> cat = catRepository.findByName("YA Fantasy");
		assertThat(cat).hasSize(1);
		assertThat(cat.get(0).getName()).isEqualTo("YA Fantasy");
	}

	// create test
	@Test
	public void createNewCategory() {
		Category category = new Category("Classic");
		catRepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}

	// delete test
	@Test
	public void deleteCategory() {
		List<Category> cats = catRepository.findByName("YA Fantasy");
		Category category = cats.get(0);
		catRepository.delete(category);
		List<Category> newCats = catRepository.findByName("YA Fantasy");
		assertThat(newCats).hasSize(0);
	}

}
