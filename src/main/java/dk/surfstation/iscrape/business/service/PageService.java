package dk.surfstation.iscrape.business.service;

import dk.surfstation.iscrape.business.domain.Page;
import dk.surfstation.iscrape.business.repository.PageRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;


@Service
public class PageService implements PageServiceInterface {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PageRepository pageRepository;

	@Override
	public Page findOne(final Long id) {
		log.info("findOne({})", id);
//		String slug = "dmi-5";
//		String url = "http://www.dmi.dk/hav/udsigter/farvandsudsigter/femdoegnsudsigter/";
//		String selector = "div#c3123.csc-default";

//		Page page = new Page(slug, url, selector, "<div>content</div>");
		Page page = pageRepository.findOne(id);
		assert page != null;
		try {
			final Document document = Jsoup.parse(new URL(page.getUrl()), 5 * 1000);
			Elements elements = document.select(page.getSelector());
			Element element = elements.first();
			page.setContent(element.html());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Page save(final Page page) {
		log.info("save()");
		pageRepository.save(page);
		return page;
	}

	@Override
	public Iterable<Page> findAll() {
		log.info("findAll()");
		return pageRepository.findAll();
	}
}
