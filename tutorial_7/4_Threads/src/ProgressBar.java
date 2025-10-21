public class ProgressBar implements Runnable{
    @Override
    public void run() {
        int numbersRead = DataProcessingApplication.getNumbersRead();
        int TOTAL_NUMBERS = DataProcessingApplication.getTOTAL_NUMBERS();

        while (numbersRead < TOTAL_NUMBERS) {
            numbersRead = DataProcessingApplication.getNumbersRead();
            TOTAL_NUMBERS = DataProcessingApplication.getTOTAL_NUMBERS();
            int progress = (int) Math.round(
                    ((50.0 *
                            numbersRead)
                            / TOTAL_NUMBERS));
            for (int i = 0; i < progress; i++) System.out.print("█");
            for (int i = progress; i < 50; i++) System.out.print("░");
            System.out.print("\r");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
