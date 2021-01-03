package com.wontlost.dicebear;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.JsModule;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Optional;
import java.util.Random;

import com.wontlost.dicebear.Constants.*;

@Tag("vaadin-dicebear")
@JsModule("./vaadin-dicebear.js")
public class DicebearVaadin extends CustomField<String> implements ClickNotifier<DicebearVaadin> {

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
