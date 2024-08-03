package com.nocompany.lists;

import java.util.List;

public class FindPatternHackerRank {

    public static void main(String[] args) {
        List<String> G = List.of(
                "1234567890",
                "0987654321",
                "1111111111",
                "1111111111",
                "2222222222"
        );
        List<String> P = List.of(
                "876543",
                "111111",
                "111111"
        );

        String result = gridSearch(G, P);

        System.out.println("Result: " + result);

    }

    public static String gridSearch(List<String> G, List<String> P) {
        if(G==null || P==null || G.size()==0 || P.size()==0 || G.size()< P.size()){
            return "NO";
        }

        int pIndex = 0;
        boolean found = false;

        for(int i=0; i<G.size();i++){
            while(pIndex!= P.size() && G.get(i).contains(P.get(pIndex))){
                i++;
                pIndex++;
            }
            if (pIndex==P.size()){
                found = true;
            } else {
                pIndex=0;
            }
        }

        return found ? "YES" : "NO";
    }
}
