package com.monica.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author monica
 * @Date 2023/2/23 16:12
 * @description 单元测试
 */


public class ApiTest {

    @Test
    public void query_unanswered_question() throws IOException {
        // HttpClientBuilder 主要封装一些信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884841848258/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=716E19D5-20BF-3DBA-0F39-064C3F157261_BC535C9EFA7500B4; UM_distinctid=1862c5cb6d0a06-078613fb761c64-c447526-144000-1862c5cb6d1c02; sensorsdata2015jssdkcross={\"distinct_id\":\"581142414425154\",\"first_id\":\"184e00a80c8b5e-0624bb61d5b838c-c4a7526-1327104-184e00a80c9dce\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg0ZTAwYTgwYzhiNWUtMDYyNGJiNjFkNWI4MzhjLWM0YTc1MjYtMTMyNzEwNC0xODRlMDBhODBjOWRjZSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTE0MjQxNDQyNTE1NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"581142414425154\"},\"$device_id\":\"184e00a80c8b5e-0624bb61d5b838c-c4a7526-1327104-184e00a80c9dce\"}; zsxqsessionid=82e6fc0a9b48899531ee357ef5a87e8e; abtest_env=beta");

        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }



    }


    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("");
        post.addHeader("cookie","zsxq_access_token=716E19D5-20BF-3DBA-0F39-064C3F157261_BC535C9EFA7500B4; UM_distinctid=1862c5cb6d0a06-078613fb761c64-c447526-144000-1862c5cb6d1c02; sensorsdata2015jssdkcross={\"distinct_id\":\"581142414425154\",\"first_id\":\"184e00a80c8b5e-0624bb61d5b838c-c4a7526-1327104-184e00a80c9dce\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg0ZTAwYTgwYzhiNWUtMDYyNGJiNjFkNWI4MzhjLWM0YTc1MjYtMTMyNzEwNC0xODRlMDBhODBjOWRjZSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTE0MjQxNDQyNTE1NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"581142414425154\"},\"$device_id\":\"184e00a80c8b5e-0624bb61d5b838c-c4a7526-1327104-184e00a80c9dce\"}; zsxqsessionid=82e6fc0a9b48899531ee357ef5a87e8e; abtest_env=beta");

        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "    \"req_date\":{\n" +
                "        \"text\":\"一般般\",\n" +
                "        \"image_ids\":[],\n" +
                "        \"silenced\":true\n" +
                "    }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }



    }









}
