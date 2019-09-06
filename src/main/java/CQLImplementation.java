import model.SensorData;
import model.SensorDataGenerator;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CQLImplementation {
    public static void main(String args[]) {
        try {
            SensorDataGenerator sensorDataGenerator = new SensorDataGenerator(3, 12, 28);
            Stream<SensorData> sensorDataStream = Stream.generate(sensorDataGenerator::generate);

            String query = "select [RANGE 150] sensor1, sensor2 from sensorDataStream where temperature > 25";
            CQLParser cqlParser = new CQLParser(query, sensorDataStream);

            Stream<SensorData> result = cqlParser.parse();
            result.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
