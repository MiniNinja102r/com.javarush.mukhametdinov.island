import config.Config;
import config.list.IslandConfig;
import config.list.SchedulerConfig;
import service.scheduler.Scheduler;

public class App {

    public static void main(String[] args) {
        Config.loadAll();

        Scheduler.startScheduleTask();
    }
}
