public class Testing {
    public static void main(String[] args) {
        String s = "abc", str = "";
        char arr[] = s.toCharArray();
        int n = s.length(), j = 101;

        for(int i=0 ; i<n ; i++) {
            if((j&(1<<i))>0) {
                str = str + arr[i];
            }
        }

        System.out.println(str);
    }    
}
