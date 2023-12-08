package org.example.view;

import org.example.service.Session;

public class UIComponents implements UIComponent{

    private final UIComponent[] components;

    public UIComponents(UIComponent... components) {
        this.components = components;
    }

    @Override
    public Session render(Session session) {

        Session sessionFromComponent = session;

        for (UIComponent component : components){
            sessionFromComponent = component.render(sessionFromComponent);
        }
        return sessionFromComponent;
    }
}
