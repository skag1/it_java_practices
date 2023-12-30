public class CharIntPair implements Comparable<CharIntPair>{
    public Integer key;
    public Character value;

    public CharIntPair(Integer newKey, Character newValue){
        this.key = newKey;
        this.value = newValue;
    }

    @Override
    public int compareTo(CharIntPair obj){
        return this.key - obj.key;
    }
}