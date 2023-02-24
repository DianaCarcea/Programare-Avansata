public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String languages[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int calcul;
        calcul=n*3+0b10101+0xFF;
        calcul*=6;
        System.out.println("The result is: "+ calcul);

        int result=calcul;
        int sum=0;
        while(result>=10)
        {
            sum+=calcul%10;
            calcul/=10;
            if(calcul==0)
            {
                result=sum;
                calcul=sum;
                sum=0;
            }
        }

        System.out.println("The sum of the digits is: " + result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}