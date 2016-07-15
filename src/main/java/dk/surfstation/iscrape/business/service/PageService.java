package dk.surfstation.iscrape.business.service;

import dk.surfstation.iscrape.business.domain.Page;
import dk.surfstation.iscrape.business.repository.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PageService implements PageServiceInterface {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PageRepository pageRepository;

	@Override
	public Page findOne(final Long id) {
		//		String slug = "dmi-5";
		String url = "http://www.dmi.dk/hav/udsigter/farvandsudsigter/femdoegnsudsigter/";
		String selector = "div#c3123.csc-default";

//		Page page = new Page(slug, url, selector, "<div>content</div>");
		return pageRepository.findOne(id);
	}

	@Override
	public Page save(final Page page) {
		pageRepository.save(page);
		return page;
	}

	@Override
	public Iterable<Page> findAll() {
		return pageRepository.findAll();
	}
}
