package dk.surfstation.iscrape.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PageService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Page findOne(final String slug) {
		//		String slug = "dmi-5";
		String url = "http://www.dmi.dk/hav/udsigter/farvandsudsigter/femdoegnsudsigter/";
		String selector = "div#c3123.csc-default";

		return new Page(slug, url, selector, "<div>content</div>");
	}
}
