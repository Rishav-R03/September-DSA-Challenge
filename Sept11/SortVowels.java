import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortVowels {
    public String sortVowels(String s) {
        char[] res = s.toCharArray();
        int[] countIdx = new int[128];
        char[] charMap = "AEIOUaeiou".toCharArray();
        int[] vowelCount = new int[11];

        for (int i = 0; i < charMap.length; i++) {
            countIdx[charMap[i]] = i + 1; // to get A = 1.... u 11, 0 for consonants
        }
        for (char c : res) {
            vowelCount[countIdx[c]]++;
        }

        int j = 1;
        int i = 0;
        while (j < vowelCount.length) {
            if (vowelCount[j] > 0) {
                while (i < res.length) {
                    if (countIdx[res[i]] == 0) {
                        i++;
                        continue; // if that vowel is not present
                    }
                    vowelCount[j]--;
                    res[i++] = charMap[j - 1]; // place at right pos
                    break;
                }
            } else {
                j++;
            }
        }
        return new String(res);
    }

    // method 2
    public String sortVowels2(String s) {
        Set<Character> vowels = new HashSet<>(List.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        List<Character> foundVowels = new ArrayList<>();
        char[] res = s.toCharArray();

        for (char c : res) {
            if (vowels.contains(c)) {
                foundVowels.add(c);
            }
        }
        Collections.sort(foundVowels);
        int vowelIdx = 0;
        for (int i = 0; i < res.length; i++) {
            if (vowels.contains(res[i])) {
                res[i] = foundVowels.get(vowelIdx++);
            }
        }
        return new String(res);
    }
}
