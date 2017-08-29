import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by zhouhui on 2017/7/24.
 */
public class RetriveData {
    public static void main(String[] args) throws  Exception{

        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "master:2181");
        Connection connection = ConnectionFactory.createConnection(config);

        // Instantiating HTable class
        Table table = connection.getTable(TableName.valueOf("charenqi:emp"));

        // Instantiating Get class
        Get g = new Get(Bytes.toBytes("row1"));
        // Reading the data
        Result result = table.get(g);

        // Reading values from Result class object
        byte [] value = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("name"));

        byte [] value1 = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("city"));

        // Printing the values
        String name = Bytes.toString(value);
        String city = Bytes.toString(value1);

        System.out.println("name: " + name + " city: " + city);
    }
}
