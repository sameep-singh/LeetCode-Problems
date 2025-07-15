class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        word=word.toLowerCase();
        int a=0;
        int v=0;int c=0;
        for(int i=0;i<word.length();i++){
            if(!Character.isLetterOrDigit(word.charAt(i))){
                return false;
            }
            if(Character.isLetter(word.charAt(i))){
                if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u') v++;
                else c++;
            }
        }
        if(v>0 && c>0) return true;
        return false;
        
    }
}