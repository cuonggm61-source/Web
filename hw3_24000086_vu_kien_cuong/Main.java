public class Main {
    

    public static void main(String[] args) {
        String text = "EM LAN XINH GAI GAI GAI";
        SimpleArrayList<WordCount> wordCounts = new SimpleArrayList<>();
        
        String[] words = text.toLowerCase().split(" ");
        
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            WordCount tempWord = new WordCount(word, 0);
            int index = wordCounts.indexOf(tempWord);   


            if (index != -1) {
                WordCount existingWord = wordCounts.get(index);
                existingWord.incrementCount();
                wordCounts.set(index, existingWord);

            } else {
                wordCounts.add(new WordCount(word));
            }
        }
        System.out.println("Kết quả đếm từ:");
        for (int i = 0; i < wordCounts.size(); i++) {
            WordCount wc = wordCounts.get(i);
            System.out.println(wc);
        }
    }

}