package dk.surfstation.iscrape.business.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Page {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String slug;
	private String url;
	private String selector;
	private String content;

	public Page() {
	}

	public Page(final Long id, final String slug, final String url, final String selector, final String content) {
		this.id = id;
		this.slug = slug;
		this.url = url;
		this.selector = selector;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(final String slug) {
		this.slug = slug;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(final String selector) {
		this.selector = selector;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}
}
