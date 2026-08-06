class RaceThread extends Thread {

    private static boolean raceOver = false;
    private String runner;

    RaceThread(String runner) {
        this.runner = runner;
        setName(runner);
    }

    public void run() {

        for (int i = 1; i <= 100 && !raceOver; i++) {

            System.out.println(getName() + " covered " + i + " meters");

            // Hare sleeps after 60 meters
            if (getName().equals("Hare") && i == 60) {
                try {
                    System.out.println("\nHare is sleeping for 1000 milliseconds...\n");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            if (i == 100 && !raceOver) {
                raceOver = true;
                System.out.println("\n***************");
                System.out.println(getName() + " Wins the Race!");
                System.out.println("***************");
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class HareTortoiseRace {

    public static void main(String[] args) {

        RaceThread hare = new RaceThread("Hare");
        RaceThread tortoise = new RaceThread("Tortoise");

        // Hare has higher priority
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Race Started...\n");

        hare.start();
        tortoise.start();
    }
}