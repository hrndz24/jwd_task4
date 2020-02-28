package entity;

import java.util.Objects;

public class Card {

    private String theme;
    private CardType type;
    private String country;
    private int year;
    private String author;
    private CardValue value;

    public Card() {}

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return year == card.year &&
                Objects.equals(theme, card.theme) &&
                type == card.type &&
                Objects.equals(country, card.country) &&
                Objects.equals(author, card.author) &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(theme, type, country, year, author, value);
    }

    @Override
    public String toString() {
        return "Card{" +
                "theme='" + theme + '\'' +
                ", type=" + type +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", value=" + value +
                '}';
    }
}
