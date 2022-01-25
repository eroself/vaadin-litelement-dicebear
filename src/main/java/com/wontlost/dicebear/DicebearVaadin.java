package com.wontlost.dicebear;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Image;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Optional;
import java.util.Random;

import com.wontlost.dicebear.Constants.*;

@Tag("vaadin-dicebear")
@JsModule("./vaadin-dicebear.js")
@NpmPackage(value = "@dicebear/avatars", version = "4.10.0")
@NpmPackage(value = "@dicebear/adventurer", version = "4.10.0")
@NpmPackage(value = "@dicebear/adventurer-neutral", version = "4.10.0")
@NpmPackage(value = "@dicebear/big-ears", version = "4.10.0")
@NpmPackage(value = "@dicebear/big-ears-neutral", version = "4.10.0")
@NpmPackage(value = "@dicebear/big-smile", version = "4.10.0")
@NpmPackage(value = "@dicebear/croodles", version = "4.10.0")
@NpmPackage(value = "@dicebear/croodles-neutral", version = "4.10.0")
@NpmPackage(value = "@dicebear/micah", version = "4.10.0")
@NpmPackage(value = "@dicebear/miniavs", version = "4.10.0")
@NpmPackage(value = "@dicebear/open-peeps", version = "4.10.0")
@NpmPackage(value = "@dicebear/personas", version = "4.10.0")
@NpmPackage(value = "@dicebear/pixel-art", version = "4.10.0")
@NpmPackage(value = "@dicebear/pixel-art-neutral", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-avataaars-sprites", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-bottts-sprites", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-identicon-sprites", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-initials-sprites", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-jdenticon-sprites", version = "4.10.0")
@NpmPackage(value = "@dicebear/avatars-male-sprites", version = "4.10.0")
public class DicebearVaadin extends Component implements HasStyle, HasSize, ClickNotifier<DicebearVaadin> {

    private String id;

    public DicebearVaadin() {
        this(null, null);
    }

    public DicebearVaadin(String id, Options options) {
        setId(id);
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

    public void setOptions(Options options) {
        getElement().setPropertyJson("options", options!=null?options.getOptionJson():new Options().getOptionJson());
    }

    public void setStyle(Style style) {
        getElement().setProperty("avatarStyle", style!=null?style.name():Style.avataaars.name());
    }


    public Options getOptions() {
        String optionJson = getElement().getProperty("options");
        JsonObject jsonObject = Json.parse(optionJson);
        return new Options(jsonObject);
    }

}
