package com.emoji.wiki;

import com.google.gson.*;

import java.lang.reflect.Type;

public class SearchResultDeserializer implements JsonDeserializer<SearchResult> {
    @Override
    public SearchResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        SearchResult searchResult = new SearchResult();

        searchResult.setTitle(jsonObject.get("title").getAsString());
        searchResult.setPageId(jsonObject.get("pageid").getAsInt());
        searchResult.setWordCount(jsonObject.get("wordcount").getAsInt());
        searchResult.setSnippet(jsonObject.get("snippet").getAsString());
        return searchResult;
    }
}
