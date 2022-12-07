import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import env.EnvironmentVariables;

import java.util.List;


public class DDBDemo {
    public static void main(String[] args){

        AmazonDynamoDB ddbClient = AmazonDynamoDBClientBuilder.standard()
   //             .withCredentials("default")
                .withRegion(Regions.EU_WEST_1)
                .build();

        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        load(mapper);
        //save(mapper);

    }

    private static void load(DynamoDBMapper mapper){
        //Single lookup on 1 item, so if there is an SK, we need to specify it
        Transaction t = new Transaction();
        t.setTransactionId("t1");
        t.setDate("2022-04-02");

        Transaction result = mapper.load(t);
        System.out.println(result);
    }
    private static void save(DynamoDBMapper mapper){}
    private static void query(DynamoDBMapper mapper){}
    private static void delete(DynamoDBMapper mapper){}
}
