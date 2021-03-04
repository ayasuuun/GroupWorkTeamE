package lottery;

public class LotMain {

	public static void main(String[] args) {

		int[] lotNum3 = new int[3];
		int[] lotNum4 = new int[4];
		int[] lotNum5 = new int[5];

		lotNum3 = Numbers.getThreeRandom();
		lotNum4 = Numbers.getFourRandom();
		
//		lotNum5 = Numbers.getFiveRandom();

		Numbers.showResult(lotNum3);
		Numbers.showResult(lotNum4);
		
//		Numbers.showResult(lotNum5);

	}

}
