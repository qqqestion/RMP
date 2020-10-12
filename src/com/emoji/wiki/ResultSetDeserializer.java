package com.emoji.wiki;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResultSetDeserializer implements JsonDeserializer<ResultSet> {
    @Override
    public ResultSet deserialize(JsonElement jsonElement,
                                 Type type,
                                 JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ResultSet searchResultSet = new ResultSet();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement query = jsonObject.get("query");
        JsonArray searchArray = (JsonArray) query.getAsJsonObject().get("search");
        for (JsonElement object : searchArray) {
            searchResultSet.addSearchResult(jsonDeserializationContext.deserialize(object, SearchResult.class));
        }
        return searchResultSet;
    }
}
