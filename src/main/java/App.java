import config.Config;
import config.list.IslandConfig;

public class App {

    public static void main(String[] args) {
        Config.loadAll();

        System.out.println(IslandConfig.Island.X_SIZE);
    }
}
