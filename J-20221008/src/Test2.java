import java.util.Comparator;
import java.util.Objects;

/**
 * @Author 12629
 * @Description：
 */
class Card implements Comparable<Card>{
    public int rank;    // 数值
    public String suit;    // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public int compareTo(Card o) {
        return this.rank-o.rank;
    }
}
class RankComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.rank- o2.rank;
    }
}

public class Test2 {
    public static void main(String[] args) {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");

        System.out.println(c1.equals(c2));


        System.out.println(c1.compareTo(c2));

        RankComparator rankComparator = new RankComparator();
        System.out.println(rankComparator.compare(c1, c2));

    }
}
