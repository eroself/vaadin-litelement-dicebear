package com.wontlost.dicebear;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Image;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Optional;
import java.util.Random;

import com.wontlost.dicebear.Constants.*;

@Tag("vaadin-dicebear")
@NpmPackage(value = "@dicebear/avatars", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-avataaars-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-bottts-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-female-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-gridy-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-human-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-identicon-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-initials-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-jdenticon-sprites", version = "^4.6.1")
@NpmPackage(value = "@dicebear/avatars-male-sprites", version = "^4.6.1")
@JsModule("./vaadin-dicebear.js")
public class DicebearVaadin extends CustomField<String> implements HasStyle, ClickNotifier<DicebearVaadin> {

    private String value;

    private String id;

    public DicebearVaadin() {
        this(null, "", null);
    }

    public DicebearVaadin(String value) {
        this(null, value, null);
    }

    public DicebearVaadin(String id, String value, Options options) {
        setId(id);
        setValue(value);
        setOptions(options);
    }

    public DicebearVaadin(Image image) {
        getElement().setProperty("image", image != null ? image.getSrc() : null);
        getElement().setProperty("alt", image != null ? image.getAlt().orElse("alt") : "alt image");
        getElement().setProperty("width", image != null ? image.getWidth() : "100");
        getElement().setProperty("height", image != null ? image.getHeight() : "100");
    }

    @Override
    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    @Override
    public void setId(String id) {
        this.id = id;
        getElement().setProperty("id", id==null || id.length()==0? "dicebear_"+Math.abs(new Random().nextInt()): id);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        this.value = value;
        getElement().setProperty("value", value);
    }

    public void setOptions(Options options) {
        getElement().setPropertyJson("options", options!=null?options.getOptionJson():new Options().getOptionJson());
    }

    public void setStyle(Style style) {
        getElement().setProperty("avatarStyle", style!=null?style.name():Style.human.name());
    }


    public Options getOptions() {
        String optionJson = getElement().getProperty("options");
        JsonObject jsonObject = Json.parse(optionJson);
        return new Options(jsonObject);
    }

    @Override
    protected String generateModelValue() {
        return value;
    }

    @Override
    protected void setPresentationValue(String s) {
        this.value = s;
    }

}
