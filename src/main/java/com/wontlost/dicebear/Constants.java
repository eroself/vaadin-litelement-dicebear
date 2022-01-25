package com.wontlost.dicebear;

public class Constants {

    public enum Option {
        seed, //default undefined
        flip,  //default false
        rotate, //default 0, value from 0 to 360
        scale,  //default 100, value from 0 to 200
        radius, //default 0, value from 0 to 50, Avatar border radius
        dataUri, //default false, Return avatar as data uri instead of XML
        size, //default undefined, min is 1
        translateX, //default 0, value from -100 to 100
        translateY, //default 0, value from -100 to 100
        width, //default null, Fixed width
        height, //default null, Fixed height
        margin, //default 0, Avatar margin in percent
        backgroundColor //default null, Any valid color identifier
    }

    public enum Style {
        adventurer,
        adventurer_neutral,
        avataaars,
        big_ears,
        big_ears_neutral,
        big_smile,
        bottts,
        croodles,
        croodles_neutral,
        identicon,
        initials,
        micah,
        miniavs,
        open_peeps,
        personas,
        pixel_art,
        pixel_art_neutral
    }

}
