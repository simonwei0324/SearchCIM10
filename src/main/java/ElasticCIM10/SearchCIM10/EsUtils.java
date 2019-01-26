package ElasticCIM10.SearchCIM10;


import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;


//通过反射创建客户端工具类

@SuppressWarnings({ "resource", "unchecked" })
public class EsUtils {

    //编写elasticsearch操作核心实例。
    private static TransportClient client;
    static {
    	try {
    		Settings settings=Settings.builder().put("cluster.name","elasticsearch_weiliu").build();
    		client=new PreBuiltTransportClient(settings)
    				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }



	public static synchronized TransportClient getTransportClient() {

		return client;

	}



	public static String toJson(ICD_TS icd) {
		// TODO Auto-generated method stub
		return null;
	}

}
