package com.razahy.razahyeshop.utils;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtil {
    public static List<Integer> pages(long totalAmount, int productsPerPage) {
        List<Integer> pages = new ArrayList<>();
        int numberOfPages = (int) Math.ceil(totalAmount / (double) productsPerPage);
        for (int i = 1; i <= numberOfPages; i++) {
            pages.add(i);
        }
        return pages;
    }
}
