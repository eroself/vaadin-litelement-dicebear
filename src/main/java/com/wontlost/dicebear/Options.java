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
        options.put(Option.backgroundColor, Json.create("transparent"));
        options.put(Option.margin, Json.create(0));
        options.put(Option.dataUri, Json.create(false));
        options.put(Option.radius, Json.create(0));
        options.put(Option.seed, Json.create(""));
        options.put(Option.translateX, Json.create(0));
        options.put(Option.translateY, Json.create(0));
        options.put(Option.flip, Json.create(false));
        options.put(Option.rotate, Json.create(0));
        options.put(Option.scale, Json.create(100));
        options.put(Option.size, Json.create(100));
    }

    public Options(JsonObject jsonObject) {
        options.put(Option.backgroundColor, jsonObject.get(Option.backgroundColor.name()));
        options.put(Option.margin, jsonObject.get(Option.margin.name()));
        options.put(Option.height, jsonObject.get(Option.height.name()));
        options.put(Option.width, jsonObject.get(Option.width.name()));
        options.put(Option.dataUri, jsonObject.get(Option.dataUri.name()));
        options.put(Option.radius, jsonObject.get(Option.radius.name()));
        options.put(Option.seed, jsonObject.get(Option.seed.name()));
        options.put(Option.translateX, jsonObject.get(Option.translateX.name()));
        options.put(Option.translateY, jsonObject.get(Option.translateY.name()));
        options.put(Option.flip, jsonObject.get(Option.flip.name()));
        options.put(Option.rotate, jsonObject.get(Option.rotate.name()));
        options.put(Option.scale, jsonObject.get(Option.scale.name()));
        options.put(Option.size, jsonObject.get(Option.size.name()));
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
        options.put(Option.backgroundColor, Json.create(background));
        return this;
    }

    public Options setValue(String value) {
        options.put(Option.seed, Json.create(value));
        return this;
    }

    public Options setSize(Integer size) {
        options.put(Option.size, Json.create(size));
        return this;
    }

    public Options setFlip(Boolean flip) {
        options.put(Option.flip, Json.create(flip));
        return this;
    }

    public Options setRotate(Integer rotate) {
        options.put(Option.rotate, Json.create(rotate));
        return this;
    }

    public Options setScale(Integer scale) {
        options.put(Option.scale, Json.create(scale));
        return this;
    }

    public Options setTranslateX(Integer translateX) {
        options.put(Option.translateX, Json.create(translateX));
        return this;
    }

    public Options setTranslateY(Integer translateY) {
        options.put(Option.translateY, Json.create(translateY));
        return this;
    }

}
