package com.example.retrofit2test.model;

import android.media.MediaDrm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Response;

public class CovidResponse {
    @SerializedName("response")
    public Response response;

    public class Response{
        @SerializedName("header")
        public Header header;

        @SerializedName("body")
        public Body body;
    }
    public class Header{
        @SerializedName("resultCode")
        public String resultCode;

        @SerializedName("resultMsg")
        public String resultMsg;
    }
    public class Body{
        @SerializedName("items")
        public Items items;

        @SerializedName("totalCount")
        public String totalCount;
        @SerializedName("pageNo")
        public String pageNo;
        @SerializedName("numOfRows")
        public String numOfRows;
    }
    public class Items{
        @SerializedName("item")
        public List<Item> item;

    }
    public class Item{
        //게시글번호
        @SerializedName("seq")
        public String seq;
        //기준일
        @SerializedName("stateDt")
        public String stateDt;
        //기준시간
        @SerializedName("statTime")
        public String stateTime;
        //확진자 수
        @SerializedName("decideCnt")
        public String decideCnt;
        //사망자 수
        @SerializedName("deathCnt")
        public String deathCnt;
        //누적 의심 신고 검사자
        @SerializedName("accExamCnt")
        public String accExamCnt;
        //누적 확진률
        @SerializedName("accDefRate")
        public String accDefRate;
        //등록일시
        @SerializedName("createDt")
        public String createDt;
        //수정일시
        @SerializedName("updateDt")
        public String updateDt;
    }
}
