package dk.surfstation.iscrape.business.service;


public class Page {
	private String slug;
	private String url;
	private String selector;
	private String content;

	public Page(final String slug, final String url, final String selector, final String content) {
		this.slug = slug;
		this.url = url;
		this.selector = selector;
		this.content = content;
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
