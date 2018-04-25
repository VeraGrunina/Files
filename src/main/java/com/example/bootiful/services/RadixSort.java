package com.example.bootiful.services;

import java.util.LinkedList;
import java.util.List;

public class RadixSort {
  public static void stringRadixSort(List<String> list, int letters) {
    if (list.size() <= 1) {
      return;
    }

    List<String>[] buckets = new List[letters];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<>();
    }
    int largestLength = -1;
    int secondLargestLength = 0;
    for (String s : list) {
      int length = s.length();
      if (length >= largestLength) {
        secondLargestLength = largestLength;
        largestLength = length;
      } else if (secondLargestLength < length) {
        secondLargestLength = length;
      }
    }

    if (largestLength > letters) {
      throw new IllegalArgumentException("one of the strings is too long");
    }

    for (int i = secondLargestLength == largestLength ? secondLargestLength-1 : secondLargestLength; i >= 0; i--) {
      for (String word : list) {
        int index = (word.length() <= i) ? 0 : word.charAt(i) - ('a' - 1);
        buckets[index].add(word);
      }

      list.clear();

      for (List<String> lst : buckets) {
        if (lst != null) {
          list.addAll(lst);
          lst.clear();
        }
      }
    }
  }

}
