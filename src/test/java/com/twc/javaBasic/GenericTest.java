package com.twc.javaBasic;

import com.twc.javaBasic.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTest {
  @Test
  void should_auto_resolve_generic_method() {
    final String[] words = {"Hello", "Good", "Morning"};

    // TODO:
    //  The getMiddle method is a generic method. Now, please call getMiddle method for string
    //  type.
    // <--start
    final String middle = getMiddle(words);
    // --end-->

    assertEquals("Good", middle);
  }

  @Test
  void should_specify_a_type_restriction_on_typed_parameters() {
    // Hint: please implement the min() method in this class.
    int minimumInteger = min(new Integer[] {1, 2, 3});
    double minimumReal = min(new Double[] {1.2, 2.2, -1d});

    assertEquals(1, minimumInteger);
    assertEquals(-1d, minimumReal, 1.0E-05);
  }

  @Test
  void should_swap() {
    Pair<String> pair = new Pair<>("Hello", "World");

    // Hint: please implement swap() method in this class.
    swap(pair);

    assertEquals("World", pair.getFirst());
    assertEquals("Hello", pair.getSecond());
  }

  private static <T> T getMiddle(T[] args) {
    return args[args.length / 2];
  }

  // TODO:
  //  please implement the following code to pass the test. It should be generic
  //  after all. The method should only accept `Number` and the number should
  //  implement `Comparable<T>`.
  //  You should not change the signature of the function. But you can change
  //  the declaration of the generic type parameter.
  // <--start
  private static <T extends Comparable<T>> T min(T [] values) {
    T minNumber = values[0];

    for (int i = 1; i<values.length; i++) {
      if (values[i].compareTo(minNumber) < 0) {
        minNumber = values[i];
      }
    }

    return minNumber;
  }
  // --end-->

  // TODO:
  //  please implement following method to pass the test. The method should be able
  //  to swap fields in a pair. But you cannot change the signature of the function.
  //
  // Hint:
  //  A wildcard is not a type variable, so we can’t write code that uses ? as a type.
  // <--start
  private static void swap(Pair<String> pair) {
    String temp = pair.getFirst();
    pair.setFirst(pair.getSecond());
    pair.setSecond(temp);
  }

  // TODO: You can add additional method within the range if you like

  // --end-->
}
