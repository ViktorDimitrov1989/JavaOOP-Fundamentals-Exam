package needForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();

        String line;
        while (!"Cops Are Here".equals(line = reader.readLine())){
            String[] tokens = line.trim().split("\\s+");
            String command = tokens[0];
            switch (command.toLowerCase()){
                case "register":
                    carManager.register(Integer.parseInt(tokens[1]),
                            tokens[2],
                            tokens[3],
                            tokens[4],
                            Integer.valueOf(tokens[5]),
                            Integer.valueOf(tokens[6]),
                            Integer.valueOf(tokens[7]),
                            Integer.valueOf(tokens[8]),
                            Integer.valueOf(tokens[9]));
                    break;
                case "open":
                    carManager.open(Integer.parseInt(tokens[1]),
                            tokens[2],
                            Integer.valueOf(tokens[3]),
                            tokens[4],
                            Integer.valueOf(tokens[5]));
                    break;
                case "participate":
                    carManager.participate(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
                    break;
                case "check":
                    System.out.print(carManager.check(Integer.valueOf(tokens[1])));
                    break;
                case "start":
                    System.out.print(carManager.start(Integer.valueOf(tokens[1])));
                    break;
                case "park":
                    carManager.park(Integer.valueOf(tokens[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.valueOf(tokens[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.valueOf(tokens[1]), tokens[2]);
                    break;
            }
        }
    }
}
