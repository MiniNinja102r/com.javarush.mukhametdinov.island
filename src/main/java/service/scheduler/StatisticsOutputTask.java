package service.scheduler;

public final class StatisticsOutputTask implements Runnable {

    @Override
    public void run() {
        System.out.println(getPopulation());
    }

    private String getPopulation() {
        return "NOT INIT";
    }
}
