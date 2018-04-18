package de.gotthold;

import java.util.ArrayList;
import java.util.List;

public class MaxSubString {
    /**
     * Recursive solution for the problem of finding the longest substring of two given strings.
     */
    public String MaxSubStringRecursive(String z1, String z2) {
        if (z1.length() > z2.length()) {
            return MaxSubStringRecursive(z1, z2, 0, 1, "");
        } else {
            return MaxSubStringRecursive(z2, z1, 0, 1, "");
        }
    }

    /**
     * Recursive solution for the problem of finding the longest substring of two given strings.
     *
     * @param z1     The longer of the two given strings.
     * @param z2     The shorter of the two given strings.
     * @param i      Start-Index for splitting the string.
     * @param length This parameter contains the current length of the substring.
     * @param result This parameter contains the current longest string which is contained in both strings. If there are multiple longest strings it contains the first one.
     * @return The final result of the recursive algorithm.
     * @author Enno Gotthold
     */
    private String MaxSubStringRecursive(String z1, String z2, int i, int length, String result) {
        String substring;
        int j = i + length;

        if (length >= z2.length() && z1.contains(z2)) {
            return z2;
        } else if (length == z2.length()) {
            substring = z2.substring(i);
        } else if (length > z2.length()) {
            return result;
        } else {
            substring = z2.substring(i, j);
        }

        if (z1.contains(substring) && substring.length() > result.length()) {
            result = substring;
        }

        if (j == z2.length()) {
            return MaxSubStringRecursive(z1, z2, 0, ++length, result);
        } else {
            return MaxSubStringRecursive(z1, z2, ++i, length, result);
        }
    }

    /**
     * Iterative solution for the problem of finding the longest substring of two given strings.
     *
     * @param z1 The longer of the two given strings.
     * @param z2 The shorter of the two given strings.
     * @return The longest possible substrings which is contained in both strings z1 & z2.
     * @author Enno Gotthold
     */
    public String MaxSubStringIterative(String z1, String z2) {
        //Init for Variables
        List<String> result = new ArrayList<String>();
        List<String> z1result = new ArrayList<String>();
        List<String> z2result = new ArrayList<String>();
        String resultString;

        //Der einfachheit Variablen tauschen, falls z2 länger
        if (z1.length() < z2.length()) {
            String tmp = z1;
            z1 = z2;
            z2 = tmp;
        }

        //Alle möglichen Kombinationen berechnen, von beiden Strings
        z1result = GeneratePosibilitys(z1);
        z2result = GeneratePosibilitys(z2);

        //Alle Möglichkeiten, die in beiden vorkommen in Ergebnisliste schreiben
        for (String s : z1result) {
            if (z2result.contains(s)) {
                result.add(s);
            }
        }

        if (result.size() > 0) {
            //Längsten String der Ergebnis-Liste nehmen
            resultString = result.get(result.size() - 1);
            return resultString;
        } else {
            return "";
        }
    }

    /**
     * This method generates every possible combination of strings which are a subset of the given string.
     *
     * @param s The String that the combinations should be generated for.
     * @return The List with all possible combinations.
     * @author Enno Gotthold
     */
    private List<String> GeneratePosibilitys(String s) {
        List<String> resultList = new ArrayList<String>();
        int lenght = 1;
        int i = 0;
        int j = 0;

        while (lenght < s.length()) {
            while (j < s.length()) {
                j = i + lenght;
                String tmp;
                if (j > s.length()) {
                    tmp = s.substring(i);
                } else {
                    tmp = s.substring(i, j);
                }
                if (!resultList.contains(tmp)) {
                    resultList.add(tmp);
                }
                i++;
            }
            i = 0;
            j = 0;
            lenght++;
        }

        return resultList;
    }
}
