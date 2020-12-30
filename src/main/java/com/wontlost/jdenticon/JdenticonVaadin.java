package com.wontlost.jdenticon;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.JsModule;

import java.util.Optional;
import java.util.Random;

@Tag("vaadin-jdenticon")
@JsModule("./vaadin-jdenticon.js")
public class JdenticonVaadin extends CustomField<String> implements ClickNotifier<JdenticonVaadin> {

    private String value;

    private int size;

    private String id;

    public JdenticonVaadin() {
        this(null, "", 100);
    }

    public JdenticonVaadin(String value, int size) {
        this(null, value, size);
    }

    public JdenticonVaadin(String id, String value, int size) {
        setId(id);
        setValue(value);
        setSize(size);
    }

    @Override
    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    @Override
    public void setId(String id) {
        this.id = id;
        getElement().setProperty("id", id==null || id.length()==0? "identicon_"+Math.abs(new Random().nextInt()): id);
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

    public void setSize(int size) {
        getElement().setProperty("size", size);
    }

    public int getSize() {
        return this.size;
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
