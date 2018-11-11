package ru.slavaievlev.file_handlers.html.html_objects;

// Абстрактный класс, описывающий объект html-кода.
public abstract class HTMLObject {

    // Текст, содердащий html-код, определяющий тип объекта.
    protected String htmlText;

    // Делать ли дополнительный отступ после объекта.
    protected boolean isBeginBlock = false;

    // Уменьшать ли отступ перед объектом.
    protected boolean isEndBlock = false;

    // Ставить ли знак переноса строки после объекта.
    protected boolean isLineFeed = false;

    public boolean isLineFeed() {
        return isLineFeed;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public boolean isBeginBlock() {
        return isBeginBlock;
    }

    public boolean isEndBlock() {
        return isEndBlock;
    }
}
