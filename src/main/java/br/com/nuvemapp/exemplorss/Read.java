package br.com.nuvemapp.exemplorss;

import br.com.nuvemapp.exemplorss.model.Feed;
import br.com.nuvemapp.exemplorss.model.FeedMessage;
import br.com.nuvemapp.exemplorss.services.RSSFeedParser;

public class Read {

	public static void main(String[] args) {
		
		String url;
		
		//url = "http://news.yahoo.com/rss/sports";
		url = "http://g1.globo.com/dynamo/rss2.xml";
		
		RSSFeedParser parser = new RSSFeedParser(url);
		Feed feed = parser.readFeed();
		System.out.println(feed);
		for (FeedMessage message : feed.getMessages()) {
			
			System.out.println("Título: " + message.getTitle());
			System.out.println("Link: " + message.getLink());
			System.out.println("Autor: " + message.getAuthor());
			System.out.println("Descrição: " + message.getDescription());
			System.out.println("Categoria: " + message.getCategory());
			System.out.println("Data de publicação: " + message.getPubDate());
			System.out.println("Fonte: " + message.getSource());
			System.out.println("Guid: " + message.getGuid());
			System.out.println();

		}
	}

}
