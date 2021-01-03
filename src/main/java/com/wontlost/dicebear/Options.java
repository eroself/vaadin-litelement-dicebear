package com.wontlost.dicebear;

import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;
import elemental.json.impl.JreJsonFactory;

import java.util.HashMap;
import java.util.Map;
import com.wontlost.dicebear.Constants.*;

public class Options {

    Map<Option, JsonValue> options = new HashMap<>();

    public Options() {
        options.put(Option.background, Json.create("transparent"));
        options.put(Option.margin, Json.create(2));
        options.put(Option.height, Json.create(100));
        options.put(Option.width, Json.create(100));
        options.put(Option.dataUri, Json.create(false));
        options.put(Option.radius, Json.create(0));
    }

    public Options(JsonObject jsonObject) {
        options.put(Option.background, jsonObject.get(Option.background.name()));
        options.put(Option.margin, jsonObject.get(Option.margin.name()));
        options.put(Option.height, jsonObject.get(Option.height.name()));
        options.put(Option.width, jsonObject.get(Option.width.name()));
        options.put(Option.dataUri, jsonObject.get(Option.dataUri.name()));
        options.put(Option.radius, jsonObject.get(Option.radius.name()));
    }

    JsonObject getOptionJson() {
        JsonObject optionResult = new JreJsonFactory().createObject();
        options.forEach((option, optionJson) -> optionResult.put(option.name(), optionJson));
        return optionResult;
    }

    public Map<Option, JsonValue> getOptions() {
        return options;
    }

    public Options setRadius(Integer radius) {
        options.put(Option.radius, Json.create(radius!=null?radius:0));
        return this;
    }

    public Options setDataUri(Boolean dataUri) {
        options.put(Option.dataUri, Json.create(dataUri!=null?dataUri:false));
        return this;
    }

    public Options setWidth(Integer width) {
        options.put(Option.width, Json.create(width));
        return this;
    }

    public Options setHeight(Integer height) {
        options.put(Option.height, Json.create(height));
        return this;
    }

    public Options setMargin(Integer margin) {
        options.put(Option.margin, Json.create(margin!=null?margin:0));
        return this;
    }

    public Options setBackground(String background) {
        options.put(Option.background, Json.create(background));
        return this;
    }

}
