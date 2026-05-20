import java.util.Objects;

public class WordCount {
    
    private String word;
    private int Count;
    public WordCount(String word, int Count){
        this.Count = 1;
        this.word = word;
    }
    public WordCount(String word) {
    this.word = word;
    this.Count = 1;
    }
    public void incrementCount() {
        this.Count++;
    }

    public int getCount() {
        return Count;
    }
    public String getWord() {
        return word;
    }
    public void setCount(int Count) {
        this.Count = Count;
    }
    public void setWord(String word) {
        this.word = word;
    }
    @Override
    public boolean equals(Object o){
        if(this == o ) return true;
        
        if(o == null || getClass() != o.getClass()){
            return false;
        } 
        WordCount wordCount = (WordCount)o;
        return Objects.equals(word,wordCount.word);
    }
    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
    public String toString() {
        return  word + ";" + Count;
    }
}
