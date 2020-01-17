package demo;

public class multiple {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        long result = 0;
        for(int i1=0;i1<100;i1++){
            for(int i2=0;i2<100;i2++){
                for(int i3=0;i3<100;i3++){
                    for(int i4=0;i4<100;i4++){
                        for(int i5=0;i5<100;i5++){
                            for(int i6=0;i6<100;i6++){
//                                for(int i7=0;i7<100;i7++){
                                    result =result+1;
//                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(System.currentTimeMillis()-begin);
    }
}
