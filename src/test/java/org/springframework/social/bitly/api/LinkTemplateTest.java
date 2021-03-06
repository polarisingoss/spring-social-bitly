package org.springframework.social.bitly.api;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.social.bitly.api.impl.BitlyTemplate;
import org.springframework.social.bitly.api.impl.LinkTemplate;
import org.springframework.social.bitly.api.impl.json.LinkExpandResponse;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse;
import org.springframework.social.bitly.api.impl.json.LinkLookupResponse;
import org.springframework.util.Assert;

@RunWith( BlockJUnit4ClassRunner.class )
public class LinkTemplateTest {

	private static final String BIT_LINK = "http://bit.ly/vfK6Km";

	private static final String ACCESS_TOKEN = "4a3d07c72b77b1bd640f4f442ce021ac18a4978d";

	private BitlyTemplate bitlyTemplate;
	
	private LinkTemplate linkTemplate;
	
	@Before
	public void setUp(){
		bitlyTemplate = new BitlyTemplate( ACCESS_TOKEN );

		linkTemplate = new LinkTemplate( bitlyTemplate.getRestTemplate() );
	}
	
	@Test
	public void expand(){
		LinkExpandResponse expand = linkTemplate.expand( Arrays.asList( BIT_LINK ), Arrays.asList( "sQRdoJ" ) );
		List<Link> data = expand.getData();
		for (Link link : data) {
			Assert.notNull( link.getGlobalHash() );
		}
		Assert.notEmpty( data, "Links could not be empty!" );
	}
	
	
	@Test
	public void info(){
		LinkInfoResponse links = linkTemplate.info( Arrays.asList( BIT_LINK ), Arrays.asList( "sQRdoJ" ) );
		List<Link> data = links.getData();
		for (Link link : data) {
			Assert.notNull( link.getGlobalHash() );
		}
		Assert.notEmpty( data, "Links could not be empty!" );
	}
	
	@Test
	public void lookup(){
		LinkLookupResponse links = linkTemplate.lookup( Arrays.asList( "http://polarising.com/" ) );
		List<LinkLookup> data = links.getData();
		for (LinkLookup link : data) {
			Assert.notNull( link.getShortUrl() );
		}
		Assert.notEmpty( data, "Links could not be empty!" );
	}
}
