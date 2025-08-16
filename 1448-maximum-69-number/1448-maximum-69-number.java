class Solution {
    public int maximum69Number (int num) {
        String s=String.valueOf(num);
        s=s.replaceFirst("6","9");
        int n=Integer.valueOf(s);
        return n;
    }
}