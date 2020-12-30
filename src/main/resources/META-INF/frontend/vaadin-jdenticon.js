import { html, LitElement } from "lit-element";
import { toSvg } from "jdenticon";


class VaadinJdenticon extends LitElement {

    constructor() {
        super();
    }

    static get properties() {
        return { id: String,
                 value: String,
                 size: Number //icon size, it's a square
                };
    }

    createRenderRoot() {
        return this;
    }

    updated(changedProperties) {
        super.updated(changedProperties);
        let placeholder = document.querySelector("#"+this.id);
        placeholder.innerHTML = toSvg(this.value, this.size);
    }

    render() {
        return html`<div id="${this.id}"/>`;
    }

}

customElements.get('vaadin-jdenticon') || customElements.define('vaadin-jdenticon', VaadinJdenticon);
