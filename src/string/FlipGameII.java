package string;

/**
 * Created by shuxuannie on 7/20/16.
 */
public class FlipGameII {

    public boolean canWin(String s) {
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+' && !canWin(s.substring(0,i)+"--" + s.substring(i+2))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "++";
        FlipGameII obj= new FlipGameII();
        System.out.println(obj.canWin(s));
    }
}
