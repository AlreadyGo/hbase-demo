import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by zhouhui on 2017/7/24.
 */
public class DeleteData {
    public static void main(String[] args) throws Exception {

        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "master:2181");
        Connection connection = ConnectionFactory.createConnection(config);

        // Instantiating HTable class
        Table table = connection.getTable(TableName.valueOf("charenqi:emp"));

        // Instantiating Delete class
        Delete delete = new Delete(Bytes.toBytes("row1"));
        delete.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
        delete.addFamily(Bytes.toBytes("professional"));

        // deleting the data
        table.delete(delete);

        // closing the HTable object
        table.close();
        System.out.println("data deleted.....");
    }
}
