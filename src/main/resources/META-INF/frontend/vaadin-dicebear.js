import { html, LitElement } from "lit-element";
import { createAvatar } from '@dicebear/avatars';
import * as adventurer from '@dicebear/adventurer';
import * as adventurer_neutral from '@dicebear/adventurer-neutral';
import * as avataaars from '@dicebear/avatars-avataaars-sprites';
import * as big_ears from '@dicebear/big-ears';
import * as big_ears_neutral from '@dicebear/big-ears-neutral';
import * as big_smile from '@dicebear/big-smile';
import * as bottts from '@dicebear/avatars-bottts-sprites';
import * as croodles from '@dicebear/croodles';
import * as croodles_neutral from '@dicebear/croodles-neutral';
import * as identicon from '@dicebear/avatars-identicon-sprites';
import * as initials from '@dicebear/avatars-initials-sprites';
import * as micah from '@dicebear/micah';
import * as miniavs from '@dicebear/miniavs';
import * as open_peeps from '@dicebear/open-peeps';
import * as personas from '@dicebear/personas';
import * as pixel_art from '@dicebear/pixel-art';
import * as pixel_art_neutral from '@dicebear/pixel-art-neutral';

class VaadinDicebear extends LitElement {

    constructor() {
        super();
        this.options = {};
        this.avatarStyle = 'avataaars'; //default type
    }

    static get properties() {
        return { id: String,
                 avatarStyle: String,
                 options: Object,
                 image: String, //customized image source
                 alt: String //customized image height
                };
    }

    getSprites() {
        return this.avatarStyle==='adventurer'?adventurer:
               this.avatarStyle==='adventurer_neutral'?adventurer_neutral:
               this.avatarStyle==='avataaars'?avataaars:
               this.avatarStyle==='big_ears'?big_ears:
               this.avatarStyle==='big_ears_neutral'?big_ears_neutral:
               this.avatarStyle==='big_smile'?big_smile:
               this.avatarStyle==='bottts'?bottts:
               this.avatarStyle==='croodles'?croodles:
               this.avatarStyle==='croodles_neutral'?croodles_neutral:
               this.avatarStyle==='identicon'?identicon:
               this.avatarStyle==='initials'?initials:
               this.avatarStyle==='micah'?micah:
               this.avatarStyle==='miniavs'?miniavs:
               this.avatarStyle==='open_peeps'?open_peeps:
               this.avatarStyle==='personas'?personas:
               this.avatarStyle==='pixel_art'?pixel_art:
               this.avatarStyle==='pixel_art_neutral'?pixel_art_neutral:
               avataaars;//default
    }

    createRenderRoot() {
        return this;
    }

    updated(changedProperties) {
        super.updated(changedProperties);
        if(this.image === undefined) {
            console.log("generated avatar.....");
            let avatars = createAvatar(this.getSprites(), this.options);
            let placeholder = document.querySelector("#"+this.id);
            placeholder.innerHTML = avatars;
        }
    }

    render() {
        return html`<div id="${this.id}">${this.image !== undefined ? html`<img src="${this.image}" alt="${this.alt}" />` : html``}</div>`;
    }

}

customElements.get('vaadin-dicebear') || customElements.define('vaadin-dicebear', VaadinDicebear);
