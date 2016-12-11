package br.com.nuvemapp.exemplorss;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class MainRome {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://rss.news.yahoo.com/rss/sports");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		// Lendo o feed
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		@SuppressWarnings("unchecked")
		List<SyndEntry> entradas = feed.getEntries();
		Iterator<SyndEntry> rss = entradas.iterator();

		while (rss.hasNext()) {
			SyndEntry entrada = rss.next();
			System.out.println("Título: " + entrada.getTitle());
			System.out.println("Link: " + entrada.getLink());
			System.out.println("Autor: " + entrada.getAuthor());
			System.out.println("Data de publicação: " + entrada.getPublishedDate());
			System.out.println("Descrição: " + entrada.getDescription().getValue());
			System.out.println("Fonte: " + entrada.getSource());
			System.out.println();
		}
	}

}
