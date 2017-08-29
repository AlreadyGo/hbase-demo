import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by zhouhui on 2017/7/24.
 */
public class UpdateData {
    public static void main(String[] args) throws Exception {

        // Instantiating Configuration class
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "master:2181");
        Connection connection = ConnectionFactory.createConnection(config);

        // Instantiating HTable class
        Table hTable = connection.getTable(TableName.valueOf("charenqi:emp"));

        // Instantiating Put class
        //accepts a row name
        Put p = new Put(Bytes.toBytes("row1"));

        // Updating a cell value
        p.addColumn(Bytes.toBytes("personal"),
                Bytes.toBytes("city"),Bytes.toBytes("Delih"));

        // Saving the put Instance to the HTable.
        hTable.put(p);
        System.out.println("data Updated");

        // closing HTable
        hTable.close();
    }
}
