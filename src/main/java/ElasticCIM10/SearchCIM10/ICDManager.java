package ElasticCIM10.SearchCIM10;

import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

import ElasticCIM10.SearchCIM10.DBConnection;
  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.ArrayList;  



  
  


public class ICDManager {
	public static void main(String[] argvs){  
        ICDManager manager = new ICDManager();  
        manager.indexDataDirect();  
    }  
    /** 
     * 直接将数据初始化到ES中 
     * 不创建mapping 
     */  
    private void indexDataDirect() {  
        List<ICD_TS> icdList = getIcdListFromDB();     
        System.out.println(" get icd from db finish,size:" + icdList.size());  
        bulkIndex(icdList);  
    }  
      
    private void bulkIndex(List<ICD_TS> icdList) {  
        Client client = EsUtils.getTransportClient();  
        BulkRequestBuilder bulkRequest = client.prepareBulk();  
        long b = System.currentTimeMillis();  
        for(int i=0,l=icdList.size();i<l;i++){  
            //业务对象  
            ICD_TS icd = icdList.get(i);  
            String json = EsUtils.toJson(icd);  
            IndexRequestBuilder indexRequest = client.prepareIndex("projet_inf203","doc")  
            .setSource(json).setId(String.valueOf(icd.getId()));  
            //添加到builder中  
            bulkRequest.add(indexRequest);  
        }  
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();  
        if (bulkResponse.hasFailures()) {  
            System.out.println(bulkResponse.buildFailureMessage());  
        }  
        long useTime = System.currentTimeMillis()-b;  
        System.out.println("useTime:" + useTime);  
    }  
    private List<ICD_TS> getIcdListFromDB() {  
    	Connection conn = DBConnection.getConnection();  
        String sql = "select * from transcodage_cimo3_cim10_vf";  
        PreparedStatement st = null;  
        ResultSet rs = null;  
        List<ICD_TS> list = new ArrayList<ICD_TS>();  
        try{  
            st = conn.prepareStatement(sql);  
            rs = st.executeQuery();  
            while(rs.next()){  
            	int id = rs.getInt("id");  
                String CIMO3_CUI_UMLS = rs.getString("CIMO3_CUI_UMLS");  
                String libelle_en = rs.getString("libelle");  
                String libelle_fr = rs.getString("libelle_fr");  
                String CIM10 = rs.getString("CIM10");   
                  
                list.add(new ICD_TS(id,CIMO3_CUI_UMLS,libelle_en,CIM10,libelle_fr));  
            }  
              
            return list;  
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            try{  
            if(rs!= null){  
                rs.close();  
            }  
            if(st!= null){  
                st.close();  
            }  
            conn.close();  
            }  
            catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
        return null;  
    } 

}
