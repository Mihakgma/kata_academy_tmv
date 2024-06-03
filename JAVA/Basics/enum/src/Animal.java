public enum Animal {
    DOG("собака"), FROG("лягушка"), CAT("кошка");

    private String translation;

    Animal(String translation) {
        this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }

    public String toString() {
        return "Перевод слова <"+this.name()+"> на русский язык: "+translation;
    }
}
