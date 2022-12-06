package src.main.java.com.metehanmengen.example2.creational_design_patterns.builder;

public class Alert {
    public static void main(String[] args)
    {
        new Alert.Builder()
                .setText("Kaydetmeden çıkmak istediğinize emin misiniz?")
                .setType(ButtonType.YES)
                .setIcon(IconType.QUESTION)
                .build()
                .show();
    }

    private String title;
    private String text;
    private ButtonType buttonType;
    private IconType iconType;

    private Alert(String title, String text, ButtonType buttonType, IconType iconType) {
        this.title = title;
        this.text = text;
        this.buttonType = buttonType;
        this.iconType = iconType;
    }

    public static class Builder {
        private final Alert alert = new Alert("Alarm1", "Wake Up", ButtonType.OK, IconType.WARNING);
        //Bu kısma default değerler atanabilir. Değiştirilmesi(set edilmesi ) zorunlu değil.

        public Builder setTitle(String title)
        {
            alert.title = title;
            return this; //Fluent Pattern
        }

        public Builder setText(String text)
        {
            alert.text = text;
            return this;
        }
        public Builder setType(ButtonType type)
        {
            alert.buttonType = type;
            return this;
        }
        public Builder setIcon(IconType icon)
        {
            alert.iconType = icon;
            return this;
        }

        public Alert build()
        {
            return alert;
        }
    }

    public void show()
    {
        if (title.isEmpty())
            System.out.printf("Title:%s ", title);

        if (text.isEmpty())
            System.out.printf("Text:%s ", text);

        if (buttonType != ButtonType.NONE)
            System.out.printf("Buttons:%s ", buttonType);

        if (iconType != IconType.NONE)
            System.out.printf("Icon:%s ", iconType);
    }

}

enum IconType {
    NONE, INFORMATION, YES, QUESTION, WARNING;
}

enum ButtonType {
    NONE, OK, YES, NO
}
