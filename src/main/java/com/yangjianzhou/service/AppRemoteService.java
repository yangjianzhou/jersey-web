package com.yangjianzhou.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.yangjianzhou.bean.ProductDTO;
import com.yangjianzhou.bean.ResultGson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

/**
 * Created by yangjianzhou on 16-4-17.
 */

@Service
public class AppRemoteService {

    public ResultGson<List<ProductDTO>> getAllProducts() throws Exception{

        Client client = Client.create();
        URI uri = new URI("http://localhost:6094/jersey-app/service/test/get-all");
        WebResource resource = client.resource(uri);
        ClientResponse  response = resource.get(ClientResponse.class);
         String result = response.getEntity(String.class);
        ResultGson<List<ProductDTO>>  resultGson = new Gson().fromJson(result , new TypeToken<ResultGson<List<ProductDTO>>>(){}.getType());
        return  resultGson ;
    }
}
