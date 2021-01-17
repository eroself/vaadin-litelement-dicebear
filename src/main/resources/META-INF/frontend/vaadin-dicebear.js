import { html, LitElement } from "lit-element";
import Avatars from '@dicebear/avatars';
import male      from '@dicebear/avatars-male-sprites';
import avataaars from '@dicebear/avatars-avataaars-sprites';
import bottts    from '@dicebear/avatars-bottts-sprites';
import female    from '@dicebear/avatars-female-sprites';
import gridy     from '@dicebear/avatars-gridy-sprites';
import human     from '@dicebear/avatars-human-sprites';
import identicon from '@dicebear/avatars-identicon-sprites';
import initials  from '@dicebear/avatars-initials-sprites';
import jdenticon from '@dicebear/avatars-jdenticon-sprites';

class VaadinDicebear extends LitElement {

    constructor() {
        super();
        this.options = {};
        this.avatarStyle = 'human'; //default type
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
        return this.avatarStyle==='male'?male:
               this.avatarStyle==='female'?female:
               this.avatarStyle==='avataaars'?avataaars:
               this.avatarStyle==='bottts'?bottts:
               this.avatarStyle==='gridy'?gridy:
               this.avatarStyle==='identicon'?identicon:
               this.avatarStyle==='initials'?initials:
               this.avatarStyle==='jdenticon'?jdenticon:
               human;//default
    }

    createRenderRoot() {
        return this;
    }

    updated(changedProperties) {
        super.updated(changedProperties);
        if(this.image === undefined) {
            console.log("generated avatar.....");
            let avatars = new Avatars(this.getSprites(), this.options);
            let placeholder = document.querySelector("#"+this.id);
            placeholder.innerHTML = avatars.create(this.value);;
        }
    }

    render() {
        return html`<div id="${this.id}">${this.image !== undefined ? html`<img src="${this.image}" alt="${this.alt}" 
            width="${this.width}" height="${this.height}"/>` : html``}</div>`;
    }

}

customElements.get('vaadin-dicebear') || customElements.define('vaadin-dicebear', VaadinDicebear);
