package org.springframework.social.bitly.api.impl.json.deserializers;

import java.io.IOException;
import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;

public class LinkInfoDeserializer extends DeserializerSupports<LinkInfoResponse> {

	@Override
	public LinkInfoResponse deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		return (LinkInfoResponse) parse(new LinkInfoResponse(), new TypeReference<List<Link>>() {}, jp, context, "info" );
	}
}
