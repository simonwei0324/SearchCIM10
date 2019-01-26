package ElasticCIM10.SearchCIM10;

import org.elasticsearch.action.search.SearchResponse;  
import org.elasticsearch.client.Client;  
import org.elasticsearch.index.query.MultiMatchQueryBuilder;  
import org.elasticsearch.index.query.QueryBuilders;  
import org.elasticsearch.search.SearchHit;  
import org.elasticsearch.search.SearchHits;  
    
  
public class SearchTest {  
    public static void main(String[] args) {  
        Client client = EsUtils.getTransportClient();  
        String keyWord = "Malignant neoplasm of ampulla of Vater";      
        //多个字段匹配  
        MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(keyWord, "libelle");  
          
        long b = System.currentTimeMillis();  
        SearchResponse response = client.prepareSearch("projet_inf203").setTypes("doc")  
                .setQuery(query)  
                .setFrom(0)  
                //前20个  
                .setSize(20)  
                .execute().actionGet();  
        long useTime = System.currentTimeMillis()-b;  
        System.out.println("search use time:" + useTime + " ms");  
          
        SearchHits shs = response.getHits();  
        for (SearchHit hit : shs) {  
            System.out.println("分数:"   
                    + hit.getScore()  
                    + ",ID:"  
                    + hit.getId()
                    +hit.getFields().values());
        }  
        client.close();  
    }  
}  
