package org.grostarin.springboot.demorest.repositories;

import java.util.Optional;
import org.grostarin.springboot.demorest.domain.BannedBook;
import org.springframework.data.repository.CrudRepository;

public interface BannedBookRepository extends CrudRepository<BannedBook, Long> {
    Optional<BannedBook> findByTitleAndAuthor(String title, String author);
}
