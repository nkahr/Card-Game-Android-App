package example.codeclan.com.cardgame;

/**
 * Created by user on 21/01/2017.
 */

public class Card {

    private Rank rank;
    private Suit suit;
    private String imgLink;
    private int points;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
//        this.imgLink = "";
    }

    public Card(Rank rank, Suit suit, String imgLink) {
        this.rank = rank;
        this.suit = suit;
        this.imgLink = imgLink;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getImgLink() {
        return this.imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
