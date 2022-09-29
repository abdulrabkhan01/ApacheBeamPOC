package com.ark.beam.ex1;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private static final List<Integer> data = new ArrayList<Integer>();

    static {
        for (int i = 0; i < 20; i++)
            data.add(i);
    }

    public static List<Integer> getData() {
        return data;
    }

}
