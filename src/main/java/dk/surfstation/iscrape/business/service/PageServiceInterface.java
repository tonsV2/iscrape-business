package dk.surfstation.iscrape.business.service;


import dk.surfstation.iscrape.business.domain.Page;

public interface PageServiceInterface {
	Page findOne(Long id);
	Page save(Page page);
	Iterable<Page> findAll();
}
