package com.guo.practice.codepractice.problems.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

public class BlackjackGame {

  // Cards:  two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace.
  // Output: below , above or blackjack (21)
  //	1. If(point == 21) ---> blackjack
  //	2. If(point > 21) ---> highest card
  //		a. If(ace) ---> ace == 1
  //	3. If(point < 21) ---> highest card
  // Order:  jack, queen, then king.

  // Example:
  // ["four","seven", "ten"] => blackjack ten
  // ["two","three","ace","king"] = 2 + 3 + 1 + 14 =  19   => output: below king
  // ["four","ten","king"] => 4 + 10 + 14 = 28 => output: above king

  public String blackJackHighest(String[] strArr) {
    String output = "";
    int total = 0;
    boolean hasAce = false;
    boolean aceUsed = false;

    // create cards from strArr
    List<Card> cards = new ArrayList<>();

    for (int i = 0; i < strArr.length; i++) {
      cards.add(new Card(strArr[i]));
    }

    // sort cards for random order
    Collections.sort(cards);

    // loop cards to get highest cards
    for (Card card : cards) {
      // check ace
      if (card.rating == 14) {
        hasAce = true;
      }

      // set ace value if total > 21
      if (total + card.topVal > 21) {
        total += card.lowVal;
      } else {
        if (card.rating == 14) {
          aceUsed = true;
        }
        total += card.topVal;
      }
    }

    // get last element for sorted list
    Card highest = cards.get(cards.size() - 1);
    // if ace == 1 get 2nd highest
    if (hasAce && !aceUsed) {
      highest = cards.get(cards.size() - 2);
    }

    // output
    if (total < 21) {
      output = "below " + highest.repr;
    } else if (total == 21) {
      output = "blackjack " + highest.repr;
    } else {
      output = "above " + highest.repr;
    }
    return output;
  }

  // define cards:

  class Card implements Comparable<Card> {
    int lowVal = 0, topVal = 0, rating = 0;
    String repr;

    Card(String card) {
      card = card.toLowerCase();
      repr = card;

      if (card.equals("two")) {
        lowVal = 2;
        topVal = 2;
        rating = 2;
      } else if (card.equals("three")) {
        lowVal = 3;
        topVal = 3;
        rating = 3;
      } else if (card.equals("four")) {
        lowVal = 4;
        topVal = 4;
        rating = 4;
      } else if (card.equals("five")) {
        lowVal = 5;
        topVal = 5;
        rating = 5;
      } else if (card.equals("six")) {
        lowVal = 6;
        topVal = 6;
        rating = 6;
      } else if (card.equals("seven")) {
        lowVal = 7;
        topVal = 7;
        rating = 7;
      } else if (card.equals("eight")) {
        lowVal = 8;
        topVal = 8;
        rating = 8;
      } else if (card.equals("nine")) {
        lowVal = 9;
        topVal = 9;
        rating = 9;
      } else if (card.equals("ten")) {
        lowVal = 10;
        topVal = 10;
        rating = 10;
      } else if (card.equals("jack")) {
        lowVal = 10;
        topVal = 10;
        rating = 11;
      } else if (card.equals("queen")) {
        lowVal = 10;
        topVal = 10;
        rating = 12;
      } else if (card.equals("king")) {
        lowVal = 10;
        topVal = 10;
        rating = 13;
      } else if (card.equals("ace")) {
        lowVal = 1;
        topVal = 11;
        rating = 14;
      }
    }

    @Override
    public int compareTo(Card card) {
      if (this.rating > card.rating) {
        return 1;
      } else if (this.rating < card.rating) {
        return -1;
      }
      return 0;
    }
  }

  @Test
  public void testGame(){
    BlackjackGame game = new BlackjackGame();
    System.out.print(game.blackJackHighest(new String[] {"four","seven", "ten"}));
//        System.out.print(game.blackJackHighest(new String[] {"jack","ace"}));
//        System.out.print(game.blackJackHighest(new String[] {"two","three","ace","king"}));
//        System.out.print(game.blackJackHighest(new String[] { "jack", "queen", "king"}));
//        System.out.print(game.blackJackHighest(new String[] {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"}));
  }


}
