import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by zhouhui on 2017/7/24.
 */
public class InsertData {
    public static void main(String[] args) throws Exception {

        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "master:2181");
        Connection connection = ConnectionFactory.createConnection(config);

        // Instantiating HTable class
        Table hTable = connection.getTable(TableName.valueOf("charenqi:emp"));

        // Instantiating Put class
        // accepts a row name.
        Put p = new Put(Bytes.toBytes("row1"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        p.addColumn(Bytes.toBytes("personal"),
                Bytes.toBytes("name"),Bytes.toBytes("raju1"));

        p.addColumn(Bytes.toBytes("personal"),
                Bytes.toBytes("city"),Bytes.toBytes("hyderaba"));

        p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("designation"),
                Bytes.toBytes("manage"));

        p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("salary"),
                Bytes.toBytes("50001"));

        // Saving the put Instance to the HTable.
        hTable.put(p);
        System.out.println("data inserted");

        // closing HTable
        hTable.close();
    }
}
