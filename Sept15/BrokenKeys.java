public class BrokenKeys {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        String [] textList = text.split(" ");
        Set<Character> brokenKeys = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            brokenKeys.add(c);
        }
        for(String word : textList){
            for(char c: word.toCharArray()){
                if(brokenKeys.contains(c)){
                    ans++;
                    break;
                }
            }
        }
        return textList.length - ans;
    }
}