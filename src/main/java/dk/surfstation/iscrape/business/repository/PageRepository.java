package dk.surfstation.iscrape.business.repository;

import dk.surfstation.iscrape.business.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends CrudRepository<Page, Long> {
}
