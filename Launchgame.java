import java.util.Scanner;

class Guesser {
	int guessNum;

	public int guessNumber() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Guesser kindly guess the number");
		guessNum = scan.nextInt();
		return guessNum;

	}

}

class Player {
	int pguessNum;

	public int guessNumber(int n) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player " + n + " kindly guess the number");
		pguessNum = scan.nextInt();
		return pguessNum;
	}
}

class Umpire {

	int numFromGuesser;
	int numFromPlayer[];

	public void collectNumFromGuesser() {
		Guesser g = new Guesser();
		numFromGuesser = g.guessNumber();

	}

	public void collectNumFromPlayer(int n) {
		Player p[] = new Player[n];

		numFromPlayer = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = new Player();
			numFromPlayer[i] = p[i].guessNumber(i + 1);
		}
	}

	void compare() {
		int n = numFromPlayer.length;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (numFromPlayer[i] == numFromGuesser) {
				flag = true;
				System.out.println("Player " + (int) (i + 1) + " won!!");
			}
		}
		if (!flag) {
			System.out.println("No player won");

		}

	}

}

public class Launchgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of players to play the game");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Umpire u = new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayer(n);
		u.compare();

	}

}
