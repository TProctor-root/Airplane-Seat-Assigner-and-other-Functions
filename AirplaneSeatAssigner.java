import java.util.Scanner;

public class AirplaneSeatAssigner {
	private Scanner in;
	private Airplane plane;

	public AirplaneSeatAssigner() {
		in = new Scanner(System.in);
		plane = new Airplane();
	}

	public void run() {
		boolean done = false;
		while (!done) {
			System.out.print("A)dd  S)how  Q)uit: ");
			String command = in.nextLine().toUpperCase();

			if (command.equals("A")) {
				System.out.print("F)irst  E)conomy: ");
				String tclass = in.nextLine().toUpperCase();
				if (tclass.equals("F")) {
					System.out.print("Passengers? (1-2): ");
					int num = in.nextInt();
					in.nextLine(); // extra input
					String seat_pref = "A";
					if (num < 2) {
						System.out.print("A)isle  W)indow: ");
						seat_pref = in.nextLine().toUpperCase();
					}
					boolean success = false;
					if (seat_pref.equals("A")) {
						success = plane.addPassengers(Airplane.FIRST, num, SeatRow.AISLE);
					} else if (seat_pref.equals("W")) {
						success = plane.addPassengers(Airplane.FIRST, num, SeatRow.WINDOW);
					}
					if (!success) {
						System.out.println("Assignment did not succeed.");
					}
				} else if (tclass.equals("E")) {
					System.out.print("Passengers? (1-3): ");
					int num = in.nextInt();
					in.nextLine();
					String seat_pref = "A";
					if (num < 3) {
						System.out.print("A)isle  C)enter  W)indow: ");
						seat_pref = in.nextLine().toUpperCase();
					}
					boolean success = false;
					if (seat_pref.equals("A")) {
						success = plane.addPassengers(Airplane.ECONOMY, num, SeatRow.AISLE);
					} else if (seat_pref.equals("C")) {
						success = plane.addPassengers(Airplane.ECONOMY, num, SeatRow.CENTER);
					} else if (seat_pref.equals("W")) {
						success = plane.addPassengers(Airplane.ECONOMY, num, SeatRow.WINDOW);
					}
					if (!success) {
						System.out.println("Assignment did not succeed.");
					}
				}
			} else if (command.equals("S")) {
				System.out.print(plane.toString());
			} else if (command.equals("Q")) {
				done = true;
			}
		}
	}

	public static void main(String[] args) {
		new AirplaneSeatAssigner().run();
	}
}
