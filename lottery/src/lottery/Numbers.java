package lottery;

import java.util.Random;

public class Numbers {

	public static int[] getThreeRandom() {
		int[] num = new int[3];
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			num[i] = rand.nextInt(10);
		}
		return num;
	}

	public static int[] getFourRandom() {
		int[] num = new int[4];
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			num[i] = rand.nextInt(10);
		}
		return num;

	}

//	public static int[] getFiveRandom() {
//
//		int[] num = new int[5];
//		Random rand = new Random();
//		num[0] = rand.nextInt(10);
//		for(int i=1;i<5;i++) {
//				for(int j=0;j<i;j++) {
//					num[i] = rand.nextInt(10);
//					if(num[i]==num[j]) {
//
//					}else {
//						break;
//					}
//				}
//			}
//		}
//		return num;
//
//	}

	public static void showResult(int[] num) {
		System.out.print("くじの当選番号は、");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		System.out.println("");
	}
}
