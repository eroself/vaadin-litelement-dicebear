import { html, LitElement } from "lit-element";
import { createAvatar } from '@dicebear/avatars';
import * as maleStyle  from '@dicebear/avatars-male-sprites';
import * as avataaarsStyle from '@dicebear/avatars-avataaars-sprites';
import * as botttsStyle    from '@dicebear/avatars-bottts-sprites';
import * as femaleStyle    from '@dicebear/avatars-female-sprites';
import * as gridyStyle     from '@dicebear/avatars-gridy-sprites';
import * as humanStyle     from '@dicebear/avatars-human-sprites';
import * as identiconStyle from '@dicebear/avatars-identicon-sprites';
import * as initialsStyle  from '@dicebear/avatars-initials-sprites';
import * as jdenticonStyle from '@dicebear/avatars-jdenticon-sprites';

class VaadinDicebear extends LitElement {

    constructor() {
        super();
        this.options = {};
        this.avatarStyle = 'humanStyle'; //default type
    }

    static get properties() {
        return { id: String,
                 avatarStyle: String,
                 value: String,
                 options: Object,
                 image: String, //customized image source
                 alt: String, //customized image alt
                 width: String, //customized image width
                 height: String //customized image height
                };
    }

    getSprites() {
        return this.avatarStyle==='male'?maleStyle:
               this.avatarStyle==='female'?femaleStyle:
               this.avatarStyle==='avataaars'?avataaarsStyle:
               this.avatarStyle==='bottts'?botttsStyle:
               this.avatarStyle==='gridy'?gridyStyle:
               this.avatarStyle==='identicon'?identiconStyle:
               this.avatarStyle==='initials'?initialsStyle:
               this.avatarStyle==='jdenticon'?jdenticonStyle:
               humanStyle;//default
    }

    createRenderRoot() {
        return this;
    }

    updated(changedProperties) {
        super.updated(changedProperties);
        if(this.image === undefined) {
            console.log("generated avatar.....");
            let avatars = createAvatar(this.getSprites(), Object.assign({ seed:this.value }, this.options));
            let placeholder = document.querySelector("#"+this.id);
            placeholder.innerHTML = avatars;
        }
    }

    render() {
        return html`<div id="${this.id}">${this.image !== undefined ? html`<img src="${this.image}" alt="${this.alt}" 
            width="${this.width}" height="${this.height}"/>` : html``}</div>`;
    }

}

customElements.get('vaadin-dicebear') || customElements.define('vaadin-dicebear', VaadinDicebear);
